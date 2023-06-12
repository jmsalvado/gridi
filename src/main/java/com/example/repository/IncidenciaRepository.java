package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gridi.entity.Incidencia;


public interface IncidenciaRepository extends JpaRepository<Incidencia, String> {

	Optional<Incidencia> findById(String id);
	
}
