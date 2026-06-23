package com.teratech.actions.annotations;

import com.teratech.model.cms.ActionType;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface ActionMethod {
    String value() ;
    ActionType scope() default ActionType.GET;
}
