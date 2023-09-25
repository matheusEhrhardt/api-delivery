package com.m4technology.m4foodapi.core.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {

    public LocalValidatorFactoryBean validator(MessageSource messageSource){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }
}
