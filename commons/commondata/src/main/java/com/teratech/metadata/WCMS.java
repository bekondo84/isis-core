package com.teratech.metadata;

import org.apache.commons.lang.StringUtils;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
public @interface WCMS {
    String template();
    String plugin() default StringUtils.EMPTY;
}
