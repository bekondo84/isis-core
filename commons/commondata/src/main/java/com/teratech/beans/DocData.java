package com.teratech.beans;

import java.io.Serializable;

public class DocData implements Serializable {
    private String method;
    private String url;

    public DocData() {
    }

    public DocData(String method, String url) {
        this.method = method;
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
