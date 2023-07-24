package com.example.gridi.repository;

import com.example.gridi.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, String> {

	Optional<Proyecto> findById(Long id);
	
}
