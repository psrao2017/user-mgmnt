package com.codetest.usermgmnt;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ValidatorConfiguration  extends WebMvcConfigurerAdapter {
	
	@Bean
	  public MessageSource messageSource() {
	      ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
	      bean.setBasename("classpath:messages");
	      bean.setDefaultEncoding("UTF-8");
	      return bean;
	  }

	  @Bean
	  public LocalValidatorFactoryBean validator() {
	      LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	      bean.setValidationMessageSource(messageSource());
	      return bean;
	  }

	  @Override
	  public Validator getValidator() {
	      return validator();
	  }
	  
/*
	@Bean
	public Validator validator(MessageSource messageSource) {
		LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
		factory.setValidationMessageSource(messageSource);
		return factory;
	}
	
	//@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
		bean.setBasename("classpath:messages");
		bean.setDefaultEncoding("UTF-8");
		return bean;
	}
*/
}
