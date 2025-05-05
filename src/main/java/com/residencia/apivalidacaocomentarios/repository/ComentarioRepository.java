package com.residencia.apivalidacaocomentarios.repository;


import com.residencia.apivalidacaocomentarios.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}

