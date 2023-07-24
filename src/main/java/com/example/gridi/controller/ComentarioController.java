package com.example.gridi.controller;

import com.example.gridi.entity.Comentario;
import com.example.gridi.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/comentarios")
    public ResponseEntity<List<Comentario>> obtenerComentarios() {
        List<Comentario> comentarios = comentarioService.obtenerTodosLosComentarios();
        return ResponseEntity.ok(comentarios);
    }

    @GetMapping("/obtenerComentarioPorId/{id}")
    public ResponseEntity<Comentario> obtenerComentarioPorId(@PathVariable Long id) {
        Comentario comentario = comentarioService.obtenerComentarioPorId(id);
        if (comentario != null) {
            return ResponseEntity.ok(comentario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearComentario")
    public ResponseEntity<Comentario> crearComentario(@RequestBody Comentario comentario) {
        Comentario nuevoComentario = comentarioService.crearComentario(comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoComentario);
    }

    @PutMapping("/actualizarComentario/{id}")
    public ResponseEntity<Comentario> actualizarComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
        Comentario comentarioExistente = comentarioService.obtenerComentarioPorId(id);
        if (comentarioExistente != null) {
            Comentario comentarioActualizado = comentarioService.actualizarComentario(comentario);
            return ResponseEntity.ok(comentarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminarComentario/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
        Comentario comentarioExistente = comentarioService.obtenerComentarioPorId(id);
        if (comentarioExistente != null) {
            comentarioService.borrarComentario(comentario);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}