package com.residencia.apivalidacaocomentarios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome do usuário não pode ser nulo")
    @Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;

    @NotNull(message = "A senha não pode ser nula")
    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();

    @Schema(description = "O papel do usuário. Ex: ADMIN, USER")
    private String role;

    public Usuario(Long id, String nomeUsuario) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
    }
}

