package com.residencia.apivalidacaocomentarios.service;

import com.residencia.apivalidacaocomentarios.dto.ComentarioDTO;
import com.residencia.apivalidacaocomentarios.model.Comentario;
import com.residencia.apivalidacaocomentarios.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository repository;

    public ComentarioService(ComentarioRepository repository) {
        this.repository = repository;
    }

    public Comentario criarComentario(ComentarioDTO dto) {
        Comentario comentario = new Comentario();
        comentario.setTexto(dto.texto());
        return repository.save(comentario);
    }

    public List<Comentario> listarComentarios() {
        return repository.findAll();
    }
}
