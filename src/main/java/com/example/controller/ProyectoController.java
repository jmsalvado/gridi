package com.example.controller;

import com.example.entity.Proyecto;
import com.example.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public String proyectos(Model model) {
        //List<Proyecto> proyectos = proyectoService.obtenerTodosLosProyectos();
        //model.addAttribute("proyectos", proyectos);
        return "proyectos.html";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerProyectoPorId(@PathVariable Long id) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(id);
        if (proyecto != null) {
            return ResponseEntity.ok(proyecto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto) {
        Proyecto nuevoProyecto = proyectoService.crearProyecto(proyecto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProyecto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        Proyecto proyectoExistente = proyectoService.obtenerProyectoPorId(id);
        if (proyectoExistente != null) {
            Proyecto proyectoActualizado = proyectoService.actualizarProyecto(proyecto);
            return ResponseEntity.ok(proyectoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        Proyecto proyectoExistente = proyectoService.obtenerProyectoPorId(id);
        if (proyectoExistente != null) {
            proyectoService.borrarProyecto(proyecto);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}