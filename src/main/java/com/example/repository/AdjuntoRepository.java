package com.example.repository;

import com.example.entity.Adjunto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdjuntoRepository extends JpaRepository<Adjunto, String> {

	Optional<Adjunto> findById(Long id);
	
}
