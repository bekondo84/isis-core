package com.teratech.isis.security;

import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.exceptions.ApplicationException;
import com.teratech.model.security.UserModel;
import com.teratech.services.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private FlexibleSearch flexibleSearch;
    @Autowired
    private PersistenceManager persistenceManager;


    /**
     * @return
     */
    @Override
    public UserModel getCurrentUser() throws ApplicationException {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String code = auth.getName();
        return getUserForCode(code);
    }

    /**
     * @param code
     * @return
     */
    @Override
    public UserModel getUserForCode(String code) throws ApplicationException {
        if (StringUtils.isBlank(code))
            throw new ApplicationException("User.code can't be null");
        try {
            return flexibleSearch.find(new UserModel(code));
        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }

    /**
     * @return
     */
    @Override
    public UserModel getAnonymousUser() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public SecurityContext getCurrentUserSecurityContext() {
        return SecurityContextHolder.getContext();
    }
}
