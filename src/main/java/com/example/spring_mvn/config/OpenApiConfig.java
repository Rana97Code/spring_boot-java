package com.example.spring_mvn.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot API",
                description = "Doing Crud Operation"
        ),
        servers = {
                @Server(
                        description = "dev",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "test",
                        url = "http://localhost:8080"
                ),
        }
)
public class OpenApiConfig {
}


