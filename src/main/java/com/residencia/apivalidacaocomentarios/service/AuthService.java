package com.residencia.apivalidacaocomentarios.service;

import com.residencia.apivalidacaocomentarios.dto.request.AuthResponse;
import com.residencia.apivalidacaocomentarios.dto.request.LoginRequest;
import com.residencia.apivalidacaocomentarios.dto.request.UsuarioRequestDTO;
import com.residencia.apivalidacaocomentarios.model.Usuario;
import com.residencia.apivalidacaocomentarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public void cadastrar(UsuarioRequestDTO request) {
        if (usuarioRepository.existsByNomeUsuario(request.nomeUsuario())) {
            throw new RuntimeException("Usuário já existe!");
        }

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(request.nomeUsuario());
        usuario.setSenha(passwordEncoder.encode(request.senha()));
        usuario.setRole(request.role());

        usuarioRepository.save(usuario);
    }

    public AuthResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByNomeUsuario(request.nomeUsuario())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        if (!passwordEncoder.matches(request.senha(), usuario.getSenha())) {
            throw new BadCredentialsException("Credenciais inválidas");
        }

        String token = jwtService.gerarToken(usuario);
        return new AuthResponse(token);
    }
}

