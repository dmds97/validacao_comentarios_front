package com.residencia.apivalidacaocomentarios.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(hidden = true)
public record ComentarioDTO(@NotBlank String texto) {
}
