package com.example.gridi.controller;

import com.example.gridi.entity.Incidencia;
import com.example.gridi.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping("/incidencias")
    public ResponseEntity<List<Incidencia>> obtenerIncidencias() {
        List<Incidencia> incidencias = incidenciaService.obtenerTodasLasIncidencias();
        return ResponseEntity.ok(incidencias);
    }

    @GetMapping("/obtenerIncidenciaPorId/{id}")
    public ResponseEntity<Incidencia> obtenerIncidenciaPorId(@PathVariable Long id) {
        Incidencia incidencia = incidenciaService.obtenerIncidenciaPorId(id);
        if (incidencia != null) {
            return ResponseEntity.ok(incidencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearIncidencia")
    public ResponseEntity<Incidencia> crearIncidencia(@RequestBody Incidencia incidencia) {
        Incidencia nuevaIncidencia = incidenciaService.crearIncidencia(incidencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaIncidencia);
    }

    @PutMapping("/actualizarIncidencia/{id}")
    public ResponseEntity<Incidencia> actualizarIncidencia(@PathVariable Long id, @RequestBody Incidencia incidencia) {
        Incidencia incidenciaExistente = incidenciaService.obtenerIncidenciaPorId(id);
        if (incidenciaExistente != null) {
            Incidencia incidenciaActualizada = incidenciaService.actualizarIncidencia(incidencia);
            return ResponseEntity.ok(incidenciaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminarIncidencia/{id}")
    public ResponseEntity<Void> eliminarIncidencia(@PathVariable Long id, @RequestBody Incidencia incidencia) {
        Incidencia incidenciaExistente = incidenciaService.obtenerIncidenciaPorId(id);
        if (incidenciaExistente != null) {
            incidenciaService.borrarIncidencia(incidencia);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}