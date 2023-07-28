package com.example.gridi.repository;

import java.util.Optional;

import com.example.gridi.entity.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, String> {

	Optional<Incidencia> findById(int id);
	
}
