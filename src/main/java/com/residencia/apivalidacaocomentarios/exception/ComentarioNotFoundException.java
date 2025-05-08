package com.residencia.apivalidacaocomentarios.exception;

public class ComentarioNotFoundException extends RuntimeException {
    public ComentarioNotFoundException(Long id) {
        super("Comentário não encontrado com o id: " + id);
    }
}
