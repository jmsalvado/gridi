package com.example.gridi.service;

import com.example.gridi.entity.Metrica;
import com.example.gridi.repository.MetricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MetricaService {

    @Autowired
    private MetricaRepository metricaRepository;

    public List<Metrica> obtenerTodasLasMetricas() {
        return metricaRepository.findAll();
    }

    public Metrica obtenerMetricaPorId(Long id) {
        return metricaRepository.findById(id).get();
    }

    public Metrica crearMetrica(Metrica metrica) {
        return metricaRepository.save(metrica);
    }

    public Metrica actualizarMetrica(Metrica metrica) {
        return metricaRepository.save(metrica);
    }

    public void borrarMetrica(Metrica metrica) {
        metricaRepository.delete(metrica);
    }
}