package com.example.gridi.controller;

import com.example.gridi.entity.Metrica;
import com.example.gridi.service.MetricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MetricaController {

    @Autowired
    private MetricaService metricaService;

    @GetMapping("/metricas")
    public ResponseEntity<List<Metrica>> obtenerMetricas() {
        List<Metrica> metricas = metricaService.obtenerTodasLasMetricas();
        return ResponseEntity.ok(metricas);
    }

    @GetMapping("/obtenerMetricaPorId/{id}")
    public ResponseEntity<Metrica> obtenerMetricaPorId(@PathVariable Long id) {
        Metrica metrica = metricaService.obtenerMetricaPorId(id);
        if (metrica != null) {
            return ResponseEntity.ok(metrica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearMetrica")
    public ResponseEntity<Metrica> crearMetrica(@RequestBody Metrica metrica) {
        Metrica nuevaMetrica = metricaService.crearMetrica(metrica);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMetrica);
    }

    @PutMapping("/actualizarMetrica/{id}")
    public ResponseEntity<Metrica> actualizarMetrica(@PathVariable Long id, @RequestBody Metrica metrica) {
        Metrica metricaExistente = metricaService.obtenerMetricaPorId(id);
        if (metricaExistente != null) {
            Metrica metricaActualizada = metricaService.actualizarMetrica(metrica);
            return ResponseEntity.ok(metricaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminarMetrica/{id}")
    public ResponseEntity<Void> eliminarMetrica(@PathVariable Long id, @RequestBody Metrica metrica) {
        Metrica metricaExistente = metricaService.obtenerMetricaPorId(id);
        if (metricaExistente != null) {
            metricaService.borrarMetrica(metrica);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}