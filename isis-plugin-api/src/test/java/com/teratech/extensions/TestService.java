package com.teratech.extensions;

import java.util.List;

public class TestService {

    public String testMethod(String name) {
        return name;
    }

    public void testVoidMethod(List data) {

        data.add("TEST");
    }
}
