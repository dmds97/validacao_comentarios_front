package com.residencia.apivalidacaocomentarios.service;

import com.residencia.apivalidacaocomentarios.dto.ComentarioDTO;
import com.residencia.apivalidacaocomentarios.exception.ComentarioNotFoundException;
import com.residencia.apivalidacaocomentarios.model.Comentario;
import com.residencia.apivalidacaocomentarios.repository.ComentarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository repository;

    public ComentarioService(ComentarioRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Comentario criarComentario(ComentarioDTO dto) {
        validarDTO(dto);

        Comentario comentario = fromDTO(dto);
        return repository.save(comentario);
    }

    @Transactional(readOnly = true)
    public List<Comentario> listarComentarios() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Comentario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ComentarioNotFoundException(id));
    }

    @Transactional
    public Comentario atualizarComentario(Long id, ComentarioDTO dto) {
        validarDTO(dto);

        Comentario existente = buscarPorId(id);
        existente.setTexto(dto.texto());

        return repository.save(existente);
    }

    @Transactional
    public void deletarComentario(Long id) {
        Comentario existente = buscarPorId(id);
        repository.delete(existente);
    }

    private void validarDTO(ComentarioDTO dto) {
        if (dto.texto() == null || dto.texto().isBlank()) {
            throw new IllegalArgumentException("Texto do comentário não pode ser vazio");
        }
    }

    private Comentario fromDTO(ComentarioDTO dto) {
        Comentario comentario = new Comentario();
        comentario.setTexto(dto.texto());
        return comentario;
    }
}

