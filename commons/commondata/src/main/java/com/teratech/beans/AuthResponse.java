package com.teratech.beans;

import java.io.Serializable;

public class AuthResponse implements Serializable {
    private String access_token;
    private String token_type="bearer";
    private String expires_in;
    private String lang;
    private String user;

    public String getAccess_token() {
        return access_token;
    }

    public AuthResponse setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getToken_type() {
        return token_type;
    }

    public AuthResponse setToken_type(String token_type) {
        this.token_type = token_type;
        return this;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public AuthResponse setExpires_in(String expires_in) {
        this.expires_in = expires_in;
        return this;
    }

    public String getLang() {
        return lang;
    }

    public AuthResponse setLang(String lang) {
        this.lang = lang;
        return this;
    }

    public String getUser() {
        return user;
    }

    public AuthResponse setUser(String user) {
        this.user = user;
        return this;
    }
}
