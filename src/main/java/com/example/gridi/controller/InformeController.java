package com.example.gridi.controller;

import com.example.gridi.entity.Incidencia;
import com.example.gridi.entity.Informe;
import com.example.gridi.entity.Usuario;
import com.example.gridi.service.IncidenciaService;
import com.example.gridi.service.InformeService;
import com.example.gridi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class InformeController {

    @Autowired
    private InformeService informeService;
    @Autowired
    private IncidenciaService incidenciaService;
    @Autowired
    private UsuarioService usuarioService;
    private int incidenciaId;
    private int proyectoId;

    @GetMapping("/informes/{id}")
    public String informes(Model model, @PathVariable int id) {
        incidenciaId = id;
        proyectoId = incidenciaService.obtenerIncidenciaPorId(incidenciaId).getProyecto().getId();
        List<Informe> informes = informeService.obtenerTodosLosInformes().stream().filter(i -> i.getIncidencia().getId() == incidenciaId).collect(Collectors.toList());
        model.addAttribute("informes", informes);
        model.addAttribute("proyectoId", proyectoId);
        return "informes";
    }

    @GetMapping("/informe")
    public String informe(Model model) {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        Informe informe = new Informe();
        informe.setIncidencia(incidenciaService.obtenerIncidenciaPorId(incidenciaId));
        model.addAttribute("informe", informe);
        model.addAttribute("usuarios", usuarios);
        return "informe";
    }

    @GetMapping("/informe/editar/{id}")
    public String editar(Model model, @PathVariable int id) {
        Informe informe = informeService.obtenerInformePorId(id);
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        model.addAttribute("informe", informe);
        model.addAttribute("usuarios", usuarios);
        return "informe";
    }

    @PostMapping("/informe/guardar")
    public String guardar(Model model, @ModelAttribute Informe informe) {
        if (!informe.getNuevaMetrica().getNombre().equals("")) {
            informe.addMetricas(informe.getNuevaMetrica());
        }
        informe.setIncidencia(incidenciaService.obtenerIncidenciaPorId(incidenciaId));
        informeService.actualizarInforme(informe);
        List<Informe> informes = informeService.obtenerTodosLosInformes().stream().filter(i -> i.getIncidencia().getId() == incidenciaId).collect(Collectors.toList());
        model.addAttribute("informes", informes);
        model.addAttribute("proyectoId", proyectoId);
        return "informes";
    }

    @GetMapping("/informe/borrar/{id}")
    public String borrar(Model model, @PathVariable int id) {
        Informe informe = informeService.obtenerInformePorId(id);
        informeService.borrarInforme(informe);
        List<Informe> informes = informeService.obtenerTodosLosInformes().stream().filter(i -> i.getIncidencia().getId() == incidenciaId).collect(Collectors.toList());
        model.addAttribute("informes", informes);
        model.addAttribute("proyectoId", proyectoId);
        return "informes";
    }
}