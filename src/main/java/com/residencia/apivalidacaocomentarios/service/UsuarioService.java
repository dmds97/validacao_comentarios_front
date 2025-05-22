package com.residencia.apivalidacaocomentarios.service;

import com.residencia.apivalidacaocomentarios.dto.response.UsuarioResponseDTO;
import com.residencia.apivalidacaocomentarios.exception.UsuarioNotFoundException;
import com.residencia.apivalidacaocomentarios.model.Usuario;
import com.residencia.apivalidacaocomentarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;



    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario buscarOuCriarUsuario(String username) {
        return usuarioRepository.findByNomeUsuario(username)
                .orElseGet(() -> usuarioRepository.save(new Usuario(null, username)));
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário com ID " + id + " não encontrado."));
        return toResponseDTO(usuario);
    }

    @Transactional
    public UsuarioResponseDTO atualizarUsuario(Long id, String novoNome) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário com ID " + id + " não encontrado."));

        usuario.setNomeUsuario(novoNome);
        return toResponseDTO(usuario);
    }

    @Transactional
    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário com ID " + id + " não encontrado."));
        usuarioRepository.delete(usuario);
    }

    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNomeUsuario(), usuario.getRole());
    }

    public Optional<Usuario> validateUser(String nomeUsuario, String senha) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByNomeUsuario(nomeUsuario);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

//            if (passwordEncoder.matches(senha, usuario.getSenha())) {
//                return Optional.of(usuario); // Login válido
//            }
        }

        return Optional.empty(); // Usuário não encontrado ou senha inválida
    }
}
