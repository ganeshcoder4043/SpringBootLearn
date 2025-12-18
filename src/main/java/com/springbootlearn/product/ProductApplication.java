package com.springbootlearn.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;



@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Category & Product Service REST APIs Documnetation",
				description = "Category & Product Service REST APIs",
				version = "v1",
				contact = @Contact(
						name = "Ganesh Kumar",
						email = "ganesha123@gmail,com"
						)
				),
		externalDocs = @ExternalDocumentation(
				description = "Sharepoint URL Product Service APIs",
				url="exmaple.com"
				)
		)
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
		System.out.println("In This project u lrn abt springboot");
	}

}
