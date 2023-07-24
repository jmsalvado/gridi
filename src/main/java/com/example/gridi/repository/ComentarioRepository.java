package com.example.gridi.repository;

import com.example.gridi.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, String> {

	Optional<Comentario> findById(Long id);
	
}
