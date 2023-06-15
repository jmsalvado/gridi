package com.example.service;

import com.example.entity.Incidencia;
import com.example.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    public List<Incidencia> obtenerTodasLasIncidencias() {
        return incidenciaRepository.findAll();
    }

    public Incidencia obtenerIncidenciaPorId(Long id) {
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
}