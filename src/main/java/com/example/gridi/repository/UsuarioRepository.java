package com.example.gridi.repository;

import java.util.Optional;

import com.example.gridi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	Optional<Usuario> findById(String id);
	
}
