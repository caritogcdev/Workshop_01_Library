package com.riwi.Workshop_01_book.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Api to manage a Library",
        version = "1.0",
        description = "Library"
))
public class OpenApiConfiguration {
}
