package com.example.gridi.repository;

import com.example.gridi.entity.Informe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InformeRepository extends JpaRepository<Informe, String> {

	Optional<Informe> findById(Long id);
	
}
