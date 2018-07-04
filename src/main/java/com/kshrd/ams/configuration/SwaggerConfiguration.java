package com.kshrd.ams.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()                                  
					.apis(RequestHandlerSelectors.basePackage("com.kshrd.ams.controller.rest"))           
					.paths(PathSelectors.any())
					.build()
					.apiInfo(apiInfo());  
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfo(
				"KPS AMS-API Documentation",
				"Article Management System API",
			      "1.0",
			      "https://www.chhaileng.com",
			      "Chhaileng Peng",
			      "https://www.chhaileng.com",
			      "https://www.chhaileng.com");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/swagger").setViewName("swagger-ui/index");
	}
	
}















