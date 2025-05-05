package com.residencia.apivalidacaocomentarios.controller;

import com.residencia.apivalidacaocomentarios.dto.ComentarioDTO;
import com.residencia.apivalidacaocomentarios.model.Comentario;
import com.residencia.apivalidacaocomentarios.service.ComentarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
@Tag(name = "Comentario", description = "Gerenciamento de comentários")
public class ComentarioController {

    private final ComentarioService service;

    public ComentarioController(ComentarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Comentario> criar(@RequestBody ComentarioDTO dto) {
        Comentario criado = service.criarComentario(dto);
        return ResponseEntity.ok(criado);
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> listar() {
        return ResponseEntity.ok(service.listarComentarios());
    }
}

