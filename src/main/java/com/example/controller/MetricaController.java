package com.example.controller;

import com.example.entity.Metrica;
import com.example.service.MetricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metricas")
public class MetricaController {

    @Autowired
    private MetricaService metricaService;

    @GetMapping
    public ResponseEntity<List<Metrica>> obtenerMetricas() {
        List<Metrica> metricas = metricaService.obtenerTodasLasMetricas();
        return ResponseEntity.ok(metricas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Metrica> obtenerMetricaPorId(@PathVariable Long id) {
        Metrica metrica = metricaService.obtenerMetricaPorId(id);
        if (metrica != null) {
            return ResponseEntity.ok(metrica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Metrica> crearMetrica(@RequestBody Metrica metrica) {
        Metrica nuevaMetrica = metricaService.crearMetrica(metrica);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMetrica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Metrica> actualizarMetrica(@PathVariable Long id, @RequestBody Metrica metrica) {
        Metrica metricaExistente = metricaService.obtenerMetricaPorId(id);
        if (metricaExistente != null) {
            Metrica metricaActualizada = metricaService.actualizarMetrica(metrica);
            return ResponseEntity.ok(metricaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
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