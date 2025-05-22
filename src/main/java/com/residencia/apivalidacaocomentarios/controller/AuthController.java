package com.residencia.apivalidacaocomentarios.controller;

import com.residencia.apivalidacaocomentarios.dto.request.AuthResponse;
import com.residencia.apivalidacaocomentarios.dto.request.LoginRequest;
import com.residencia.apivalidacaocomentarios.dto.request.UsuarioRequestDTO;
import com.residencia.apivalidacaocomentarios.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid UsuarioRequestDTO request) {
        authService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
