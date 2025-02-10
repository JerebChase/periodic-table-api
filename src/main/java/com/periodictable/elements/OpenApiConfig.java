package com.periodictable.elements;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
    info = @Info(title = "Periodic Table API", version = "1.0"),
    servers = {
        @Server(url = "${app.server-url}", description = "Endpoint for the periodic table API")
    }
)
public class OpenApiConfig {
}