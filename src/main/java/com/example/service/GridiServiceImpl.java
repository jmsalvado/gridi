package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gridi.entity.Incidencia;
import gridi.entity.Usuario;
import gridi.repository.IncidenciaRepository;
import gridi.repository.UsuarioRepository;

@Service
public class GridiServiceImpl implements GridiService {
	
	@Autowired
	IncidenciaRepository incidenciaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Incidencia> incidenciaFindAll() {
		return incidenciaRepository.findAll();
	}
	
	@Override
	public Optional<Incidencia> incidenciaFindById(String codigoId) {
		return incidenciaRepository.findById(codigoId);
	}
	
	@Override
	public Incidencia incidenciaSave(Incidencia incidencia) {
		return incidenciaRepository.save(incidencia);
	}
	
	@Override
	public void incidenciaDelete(Incidencia incidencia) {
		incidenciaRepository.delete(incidencia);
	}
	
	@Override
	public List<Usuario> usuarioFindAll() {
		return usuarioRepository.findAll();
	}
	
	@Override
	public Optional<Usuario> usuarioFindById(String codigoId) {
		return usuarioRepository.findById(codigoId);
	}
	
	@Override
	public Usuario usuarioSave(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public void usuarioDelete(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

}
