package com.residencia.apivalidacaocomentarios.controller;

import com.residencia.apivalidacaocomentarios.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TesteProtegidoController {

    @GetMapping("/protegido")
    public ResponseEntity<?> getDadosProtegidos(@AuthenticationPrincipal Usuario usuario) {
        return ResponseEntity.ok(Map.of(
                "mensagem", "Olá, " + usuario.getNomeUsuario() + ", você está autenticado!",
                "role", usuario.getRole()
        ));
    }
}
