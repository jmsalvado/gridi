package com.example.gridi.controller;

import com.example.gridi.entity.Proyecto;
import com.example.gridi.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("/proyectos")
    public String proyectos(Model model) {
        List<Proyecto> proyectos = proyectoService.obtenerTodosLosProyectos();
        model.addAttribute("proyectos", proyectos);
        return "proyectos";
    }

    @GetMapping("/proyecto")
    public String proyecto(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "proyecto";
    }

    @GetMapping("/proyecto/editar/{id}")
    public String editar(Model model, @PathVariable int id) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(id);
        model.addAttribute("proyecto", proyecto);
        return "proyecto";
    }

    @PostMapping("/proyecto/guardar")
    public String guardar(Model model, @ModelAttribute Proyecto proyecto) {
        proyectoService.actualizarProyecto(proyecto);
        List<Proyecto> proyectos = proyectoService.obtenerTodosLosProyectos();
        model.addAttribute("proyectos", proyectos);
        return "proyectos";
    }

    @GetMapping("/proyecto/borrar/{id}")
    public String borrar(Model model, @PathVariable int id) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(id);
        proyectoService.borrarProyecto(proyecto);
        List<Proyecto> proyectos = proyectoService.obtenerTodosLosProyectos();
        model.addAttribute("proyectos", proyectos);
        return "proyectos";
    }

}