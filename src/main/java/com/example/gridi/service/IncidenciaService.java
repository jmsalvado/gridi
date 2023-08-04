package com.example.gridi.service;

import com.example.gridi.entity.Incidencia;
import com.example.gridi.repository.ComentarioRepository;
import com.example.gridi.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Incidencia> obtenerTodasLasIncidencias() {
        return incidenciaRepository.findAll();
    }

    public Incidencia obtenerIncidenciaPorId(int id) {
        return incidenciaRepository.findById(id).get();
    }

    public Incidencia crearIncidencia(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    public Incidencia actualizarIncidencia(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    public void borrarIncidencia(Incidencia incidencia) {
        incidenciaRepository.delete(incidencia);
    }

    public void borrarIncidenciaById(String id) {
        incidenciaRepository.deleteById(id);
    }
}