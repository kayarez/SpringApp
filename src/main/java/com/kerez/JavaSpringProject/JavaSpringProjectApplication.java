package com.kerez.JavaSpringProject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "My application"))
@SpringBootApplication
public class JavaSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringProjectApplication.class, args);
	}

}
