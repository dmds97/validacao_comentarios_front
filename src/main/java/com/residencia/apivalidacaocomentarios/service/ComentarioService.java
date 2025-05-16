package com.residencia.apivalidacaocomentarios.service;

import com.residencia.apivalidacaocomentarios.dto.request.ComentarioRequestDTO;
import com.residencia.apivalidacaocomentarios.dto.response.ComentarioResponseDTO;
import com.residencia.apivalidacaocomentarios.exception.ComentarioNotFoundException;
import com.residencia.apivalidacaocomentarios.model.Comentario;
import com.residencia.apivalidacaocomentarios.model.Usuario;
import com.residencia.apivalidacaocomentarios.repository.ComentarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final UsuarioService usuarioService;

    public ComentarioService(ComentarioRepository comentarioRepository, UsuarioService usuarioService) {
        this.comentarioRepository = comentarioRepository;
        this.usuarioService = usuarioService;
    }

    @Transactional
    public ComentarioResponseDTO salvarComentario(ComentarioRequestDTO dto) {
        Usuario usuario = usuarioService.buscarOuCriarUsuario(dto.nomeUsuario());

        Comentario comentario = new Comentario();
        comentario.setComentario(dto.comentario());
        comentario.setUsuario(usuario);
        comentarioRepository.save(comentario);

        return toResponseDTO(comentario);
    }

    @Transactional(readOnly = true)
    public List<ComentarioResponseDTO> listarComentarios() {
        return comentarioRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ComentarioResponseDTO buscarPorId(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new ComentarioNotFoundException("Comentário com ID " + id + " não encontrado."));
        return toResponseDTO(comentario);
    }

    @Transactional
    public ComentarioResponseDTO atualizarComentario(Long id, ComentarioRequestDTO dto) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new ComentarioNotFoundException("Comentário com ID " + id + " não encontrado."));

        Usuario usuario = usuarioService.buscarOuCriarUsuario(dto.nomeUsuario());

        comentario.setComentario(dto.comentario());
        comentario.setUsuario(usuario);

        return toResponseDTO(comentario);
    }

    @Transactional
    public void deletarComentario(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new ComentarioNotFoundException("Comentário com ID " + id + " não encontrado."));
        comentarioRepository.delete(comentario);
    }

    private ComentarioResponseDTO toResponseDTO(Comentario comentario) {
        return new ComentarioResponseDTO(
                comentario.getId(),
                comentario.getComentario(),
                comentario.getUsuario().getNomeUsuario(),
                comentario.getCriadoEm()
        );
    }
}
