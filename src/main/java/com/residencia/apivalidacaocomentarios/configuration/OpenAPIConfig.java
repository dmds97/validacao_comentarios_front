package com.residencia.apivalidacaocomentarios.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Comentários API",
                version = "1.0",
                description = "API para cadastro e listagem de comentários"
        )
)
@Configuration
public class OpenAPIConfig {
}