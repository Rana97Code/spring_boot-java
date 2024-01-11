package com.vat.bmitvat.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "BMIT-VAT-API",
                description = "Doing Crud Operation"
        ),
        servers = {
                @Server(
                        description = "dev",
                        url = "http://localhost:8080"
                )
        }
)

//For Authorization
@SecurityScheme(
        name = "authToken",
        scheme = "bearer",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER
)
public class SwaggerApiConfig {

}
