package com.teratech.service.impl;

import com.teratech.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

   /**
     * @param name
     * @return
     */
    @Override
    public String sayHello(String name) {

        return String.format("Hello Mr %s, I hope you are well", name);
    }
}
