package com.teratech.isis.security;

import com.teratech.dao.FlexibleSearch;
import com.teratech.model.security.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class IsisUserDetailsService implements UserDetailsService {

    private final FlexibleSearch flexibleSearch;

    /**
     *
     * @param flexibleSearch
     */
    public IsisUserDetailsService(FlexibleSearch flexibleSearch) {
        this.flexibleSearch = flexibleSearch;
    }

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public IsisUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return new IsisUserDetails(flexibleSearch.find(new UserModel(username)));
        } catch (IllegalAccessException | InstantiationException | NoSuchFieldException |InvocationTargetException | NoSuchMethodException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
