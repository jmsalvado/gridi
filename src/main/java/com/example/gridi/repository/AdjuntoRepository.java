package com.example.gridi.repository;

import com.example.gridi.entity.Adjunto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdjuntoRepository extends JpaRepository<Adjunto, String> {

	Optional<Adjunto> findById(Long id);
	
}
