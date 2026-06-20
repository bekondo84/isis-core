package com.teratech.actions.annotations;

import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface ActionMethod {
    String value() ;
    RequestMethod scope() default RequestMethod.GET;
}
