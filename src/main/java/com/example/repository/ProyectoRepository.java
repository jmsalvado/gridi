package com.example.repository;

import com.example.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProyectoRepository extends JpaRepository<Proyecto, String> {

	Optional<Proyecto> findById(Long id);
	
}
