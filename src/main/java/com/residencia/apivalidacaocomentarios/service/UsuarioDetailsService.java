package com.residencia.apivalidacaocomentarios.service;

import com.residencia.apivalidacaocomentarios.model.Usuario;
import org.springframework.stereotype.Service;
import com.residencia.apivalidacaocomentarios.repository.UsuarioRepository;


@Service
public class UsuarioDetailsService{

//    private final UsuarioRepository repository;
//
//    public UsuarioDetailsService(UsuarioRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Usuario usuario = repository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
//
//        return User.withUsername(usuario.getUsername())
//                .password(usuario.getPassword()) // Deve estar criptografada!
//                .roles(usuario.getRole()) // Ex: "USERS", "MANAGERS"
//                .build();
//    }
}
