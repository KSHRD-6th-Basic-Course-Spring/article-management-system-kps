package com.kshrd.ams.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@PropertySource("classpath:ams.properties")
public class MultiLanguagesConfiguration extends WebMvcConfigurerAdapter {
	
	@Value("${language.basenames}")
	private String basenames[];
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("kh"));
		return resolver;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource src = new ResourceBundleMessageSource();
		src.setBasenames(basenames);
		src.setDefaultEncoding("UTF-8");
		return src;
	}
	
	
}
