package com.residencia.apivalidacaocomentarios.controller;

import com.residencia.apivalidacaocomentarios.dto.ComentarioDTO;
import com.residencia.apivalidacaocomentarios.model.Comentario;
import com.residencia.apivalidacaocomentarios.service.ComentarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    public ResponseEntity<Comentario> criar(@RequestBody @Valid ComentarioDTO dto) {
        Comentario criado = service.criarComentario(dto);
        URI location = URI.create("/comentarios/" + criado.getId());
        return ResponseEntity.created(location).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> listar() {
        return ResponseEntity.ok(service.listarComentarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> buscarPorId(@PathVariable Long id) {
        Comentario comentario = service.buscarPorId(id);
        return ResponseEntity.ok(comentario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> atualizar(@PathVariable Long id, @RequestBody @Valid ComentarioDTO dto) {
        Comentario atualizado = service.atualizarComentario(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarComentario(id);
        return ResponseEntity.noContent().build();
    }
}

