package com.example.repository;

import com.example.entity.Metrica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MetricaRepository extends JpaRepository<Metrica, String> {

	Optional<Metrica> findById(Long id);
	
}
