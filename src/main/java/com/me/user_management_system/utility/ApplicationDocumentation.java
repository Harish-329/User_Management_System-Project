package com.me.user_management_system.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDocumentation 
{
	Contact contact()
	{
		return new Contact().email("hpharish.329@gmail.com")
				.url("harish.in")
				.email("abc");
	}
	
	Info info()
	{
		return new Info()
				.title("User Managemnet System API")
				.version("1.0v")
				.description("user Management System is a RESTful API built using" + " Spring Boot and Mysql datatbase")
				.contact(contact());
	}
	
	@Bean
	OpenAPI openapi()
	{
		return new OpenAPI().info(info());
	}
}

