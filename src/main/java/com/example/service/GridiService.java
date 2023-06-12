package com.example.service;

import java.util.List;
import java.util.Optional;

import gridi.entity.Incidencia;
import gridi.entity.Usuario;

public interface GridiService {

	List<Incidencia> incidenciaFindAll();
	Optional<Incidencia> incidenciaFindById(String codigoId);
	Incidencia incidenciaSave(Incidencia incidencia);
	void incidenciaDelete(Incidencia incidencia);
	List<Usuario> usuarioFindAll();
	Optional<Usuario> usuarioFindById(String codigoId);
	Usuario usuarioSave(Usuario usuario);
	void usuarioDelete(Usuario usuario);
	
}
