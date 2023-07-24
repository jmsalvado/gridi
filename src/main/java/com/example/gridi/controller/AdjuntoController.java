package com.example.gridi.controller;

import com.example.gridi.entity.Adjunto;
import com.example.gridi.service.AdjuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdjuntoController {

    @Autowired
    private AdjuntoService adjuntoService;

    @GetMapping("/adjuntos")
    public ResponseEntity<List<Adjunto>> obtenerAdjuntos() {
        List<Adjunto> adjuntos = adjuntoService.obtenerTodosLosAdjuntos();
        return ResponseEntity.ok(adjuntos);
    }

    @GetMapping("/obtenerAdjuntoPorId/{id}")
    public ResponseEntity<Adjunto> obtenerAdjuntoPorId(@PathVariable Long id) {
        Adjunto adjunto = adjuntoService.obtenerAdjuntoPorId(id);
        if (adjunto != null) {
            return ResponseEntity.ok(adjunto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearAdjunto")
    public ResponseEntity<Adjunto> crearAdjunto(@RequestBody Adjunto adjunto) {
        Adjunto nuevoAdjunto = adjuntoService.crearAdjunto(adjunto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAdjunto);
    }

    @PutMapping("/actualizarAdjunto/{id}")
    public ResponseEntity<Adjunto> actualizarAdjunto(@PathVariable Long id, @RequestBody Adjunto adjunto) {
        Adjunto adjuntoExistente = adjuntoService.obtenerAdjuntoPorId(id);
        if (adjuntoExistente != null) {
            Adjunto adjuntoActualizado = adjuntoService.actualizarAdjunto(adjunto);
            return ResponseEntity.ok(adjuntoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminarAdjunto/{id}")
    public ResponseEntity<Void> eliminarAdjunto(@PathVariable Long id, @RequestBody Adjunto adjunto) {
        Adjunto adjuntoExistente = adjuntoService.obtenerAdjuntoPorId(id);
        if (adjuntoExistente != null) {
            adjuntoService.borrarAdjunto(adjunto);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}