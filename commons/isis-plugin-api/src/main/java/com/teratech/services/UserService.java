package com.teratech.services;

import com.teratech.exceptions.ApplicationException;
import com.teratech.model.security.UserModel;
import org.springframework.security.core.context.SecurityContext;

public interface UserService {

    /**
     *
     * @return
     */
    UserModel getCurrentUser () throws ApplicationException;

    UserModel getUserForCode(String code) throws ApplicationException;

    UserModel getAnonymousUser();

    SecurityContext getCurrentUserSecurityContext();
}
