package com.residencia.apivalidacaocomentarios;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(title = "Gerenciamento Clínicas Médicas", version = "1.0", description = "API para gerenciamento de clínicas médicas")
)
public class ApiValidacaoComentariosApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApiValidacaoComentariosApplication.class, args);
    }



}
