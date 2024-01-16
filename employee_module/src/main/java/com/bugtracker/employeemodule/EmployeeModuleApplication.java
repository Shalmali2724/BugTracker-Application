package com.bugtracker.employeemodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.bugtracker.employeemodule.util.LoggerUtil;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@ComponentScan(basePackages = "com.bugtracker.employeemodule")
public class EmployeeModuleApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeModuleApplication.class, args);
		LoggerUtil.logInfo("EmployeeModule Application Started");
	}

	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.bugtracker.employeemodule")).build();
	}
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

}
