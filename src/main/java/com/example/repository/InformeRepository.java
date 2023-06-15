package com.example.repository;

import com.example.entity.Informe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InformeRepository extends JpaRepository<Informe, String> {

	Optional<Informe> findById(Long id);
	
}
