package com.teratech.metadata;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
public @interface Widget {
    String name() default "";
    boolean optional() default  true;
    boolean write() default true;
    boolean read() default true;
    boolean unique() default  false;
    boolean search() default  false;
    String pattern() default "";
    //Group to which given field a member
    String group() default  "";
    String depends() default "";
    int min() default -1 ;
    int max() default 0;
    String values() default "";
}
