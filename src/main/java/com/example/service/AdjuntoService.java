package com.example.service;

import com.example.entity.Adjunto;
import com.example.repository.AdjuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdjuntoService {

    @Autowired
    private AdjuntoRepository adjuntoRepository;

    public List<Adjunto> obtenerTodosLosAdjuntos() {
        return adjuntoRepository.findAll();
    }

    public Adjunto obtenerAdjuntoPorId(Long id) {
        return adjuntoRepository.findById(id).get();
    }

    public Adjunto crearAdjunto(Adjunto adjunto) {
        return adjuntoRepository.save(adjunto);
    }

    public Adjunto actualizarAdjunto(Adjunto adjunto) {
        return adjuntoRepository.save(adjunto);
    }

    public void borrarAdjunto(Adjunto adjunto) {
        adjuntoRepository.delete(adjunto);
    }
}