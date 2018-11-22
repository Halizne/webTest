package com.css.crm.controller.annotation;

import com.css.crm.controller.validator.TelVaildator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 46597 on 2018/10/28.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=TelVaildator.class)
public @interface Tel {


    int min() default 0 ;

    String message() ;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
