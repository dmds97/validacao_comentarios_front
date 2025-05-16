package com.residencia.apivalidacaocomentarios.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO (
        @NotBlank(message = "Digite seu nome")
        String nomeUsuario) {
}
