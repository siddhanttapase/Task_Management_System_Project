package com.Task_Management_System.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "TASK_MANAGEMENT_SYSTEM",
								description = "This is Task Management System Project",
								contact = @Contact(name = "SIDDHANT_TAPASE",
													email = "siddhant.tapase44@gmail.com",
													url = "www.facebook.com"),
								license = @License(name = "SiddhantTapase_Licence"),
								termsOfService = "Term And Conditions Applied",
								version = "API/V1"),
servers = {@Server(url = "http://localhost:8080",description = "This is Test Environment"),
			@Server(url = "http://localhost:8080",description = "This is Development Environment")}
								
		)
public class SwaggerConfig {

}
