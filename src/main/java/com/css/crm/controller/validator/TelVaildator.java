package com.css.crm.controller.validator;

import com.css.crm.controller.annotation.Tel;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by 46597 on 2018/10/28.
 */
public class TelVaildator implements ConstraintValidator<Tel,String> {

    @Resource
    private ResourceBundleMessageSource messageSource;

    private Tel tel ;

    @Override
    public void initialize(Tel tel) {
        this.tel = tel ;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        boolean  isValid ;

        if(value != null && value.length()>=tel.min()){
            isValid = true ;
        }else{
            isValid = false ;
        }

        if(!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(tel.message()).addConstraintViolation();
        }

        return isValid;
    }
}
