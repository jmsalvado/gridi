package com.example.repository;

import com.example.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComentarioRepository extends JpaRepository<Comentario, String> {

	Optional<Comentario> findById(Long id);
	
}
