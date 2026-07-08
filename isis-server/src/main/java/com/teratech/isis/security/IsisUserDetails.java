package com.teratech.isis.security;

import com.teratech.model.security.UserModel;
import com.teratech.utils.ApplicationConstans;
import jakarta.annotation.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IsisUserDetails implements UserDetails {

    private String username;
    private String password;
    private UserModel user ;
    private List<GrantedAuthority> roles = new ArrayList<>();

    /**
     *
     * @param user
     */
    public IsisUserDetails(UserModel user) {
        this.username = user.getCode();
        this.password = user.getPassword();
        this.user = user;
    }

    /**
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority sga = new SimpleGrantedAuthority("ROLE_"+ApplicationConstans.Security.USER_APPLI_ROLE);
        return List.of(sga);
    }

    /**
     * @return
     */
    @Override
    public @Nullable String getPassword() {
        return password;
    }

    /**
     * @return
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return !user.isLocked();
    }

    /**
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isEnabled() {
        return user.isActive();
    }
}
