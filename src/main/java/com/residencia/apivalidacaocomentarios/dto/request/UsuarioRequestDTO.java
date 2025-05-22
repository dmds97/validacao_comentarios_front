package com.residencia.apivalidacaocomentarios.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(
        @NotBlank(message = "Digite seu nome")
        String nomeUsuario,

        @NotBlank(message = "Digite sua senha")
        @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
        String senha,

        @NotBlank(message = "Informe o perfil do usuário (ex: ROLE_USER)")
        String role
) {}

