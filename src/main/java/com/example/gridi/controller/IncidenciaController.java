package com.example.gridi.controller;

import com.example.gridi.entity.Incidencia;
import com.example.gridi.entity.Proyecto;
import com.example.gridi.entity.Usuario;
import com.example.gridi.service.IncidenciaService;
import com.example.gridi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/incidencias/{id}")
    public String incidencias(Model model, @PathVariable int id) {
        List<Incidencia> incidencias = incidenciaService.obtenerTodasLasIncidencias().stream().filter(i -> i.getProyecto().getId() == id).collect(Collectors.toList());
        model.addAttribute("incidencias", incidencias);
        return "incidencias";
    }

    @GetMapping("/incidencia")
    public String incidencia(Model model) {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        model.addAttribute("incidencia", new Incidencia());
        model.addAttribute("usuarios", usuarios);
        return "incidencia";
    }

    @GetMapping("/incidencia/editar/{id}")
    public String editar(Model model, @PathVariable int id) {
        Incidencia incidencia = incidenciaService.obtenerIncidenciaPorId(id);
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        model.addAttribute("incidencia", incidencia);
        model.addAttribute("usuarios", usuarios);
        return "incidencia";
    }

    @PostMapping("/incidencia/guardar")
    public String guardar(Model model, @ModelAttribute Incidencia incidencia) {
        incidenciaService.actualizarIncidencia(incidencia);
        List<Incidencia> incidencias = incidenciaService.obtenerTodasLasIncidencias();
        model.addAttribute("incidencias", incidencias);
        return "incidencias";
    }

    @GetMapping("/incidencia/borrar/{id}")
    public String borrar(Model model, @PathVariable int id) {
        Incidencia incidencia = incidenciaService.obtenerIncidenciaPorId(id);
        incidenciaService.borrarIncidencia(incidencia);
        List<Incidencia> incidencias = incidenciaService.obtenerTodasLasIncidencias();
        model.addAttribute("incidencias", incidencias);
        return "incidencias";
    }

}