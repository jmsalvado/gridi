package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gridi.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	Optional<Usuario> findById(String id);
	
}
