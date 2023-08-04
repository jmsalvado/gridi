package com.example.gridi.repository;

import com.example.gridi.entity.Metrica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetricaRepository extends JpaRepository<Metrica, String> {

	Optional<Metrica> findById(int id);
	
}
