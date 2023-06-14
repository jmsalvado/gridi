package com.example.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Incidencia;

public interface IncidenciaRepository extends JpaRepository<Incidencia, String> {

	Optional<Incidencia> findById(String id);
	
}
