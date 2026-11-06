package com.teratech.isis.popultor;

import com.teratech.beans.CustomFilterData;
import com.teratech.dao.FlexibleSearch;
import com.teratech.model.security.UserModel;
import com.teratech.model.settings.FilterModel;
import com.teratech.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Objects;

@Component
public class CustomFilterPopulator implements Populator<CustomFilterData, FilterModel> {

    public static final String SEQ_ADM_FILTER = "seq_adm_filter";
    @Autowired
    private FlexibleSearch flexibleSearch;
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     *
     * @param source
     * @param target
     * @throws Exception
     */
    @Override
    public void populate(CustomFilterData source, FilterModel target) throws Exception {
           FilterModel filter = flexibleSearch.find(new FilterModel(source.getId()));

           if (Objects.nonNull(filter)) {
               target.setId(filter.getId());
               target.setType(filter.getType());
               target.setScope(filter.getScope());
               target.setTypeCode(filter.getTypeCode());
               target.setCreateDate(filter.getCreatedAt());
               target.setLastModif(filter.getLastModif());
           } else {
               target.setId(flexibleSearch.getSequence(SEQ_ADM_FILTER));
               target.setType("1");
               target.setScope("1");
               target.setTypeCode(source.getTypeCode());
           }
          // target.setId(id);
           target.setName(source.getName());
           target.setValue(objectMapper.writeValueAsString(source.getPredicates()));
           final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

           if (authentication != null && authentication.isAuthenticated() ) {
                 final UserModel user = flexibleSearch.find(new UserModel(authentication.getName()));
                 target.setUser(user);
           }
    }

    @Override
    public void reverse(FilterModel source, CustomFilterData target) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setType(source.getType());
        target.setScope(source.getScope());
        target.setTypeCode(source.getTypeCode());
        target.setCreationDate(source.getCreatedAt());
        List<CustomFilterData.PredicateData> predicates  = mapper.readValue(source.getValue(), new TypeReference<List<CustomFilterData.PredicateData>>() {
        });
        target.setPredicates(predicates);
    }
}
