package com.residencia.apivalidacaocomentarios.controller;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "swagger.config", havingValue = "comentarios")
public class SwaggerConfig {
    @Bean
    public OpenAPI comentariosOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API Validação Comentários")
                        .description("Sistema de validação de comentários")
                        .version("v1.0"));
    }
}

