package com.example.gridi.controller;

import com.example.gridi.entity.Metrica;
import com.example.gridi.service.MetricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MetricaController {

    @Autowired
    private MetricaService metricaService;
    private int informeId;

    @GetMapping("/metricas")
    public String metricas(Model model, @PathVariable int id) {
        informeId = id;
        List<Metrica> metricas = metricaService.obtenerTodasLasMetricas().stream().filter(i -> i.getInforme().getId() == informeId).collect(Collectors.toList());
        model.addAttribute("metricas", metricas);
        return "metricas";
    }

    @GetMapping("/metrica")
    public String metrica(Model model) {
        model.addAttribute("metrica", new Metrica());
        return "metrica";
    }

    @GetMapping("/metrica/editar/{id}")
    public String editar(Model model, @PathVariable int id) {
        Metrica metrica = metricaService.obtenerMetricaPorId(id);
        model.addAttribute("metrica", metrica);
        return "metrica";
    }

    @PostMapping("/metrica/guardar")
    public String guardar(Model model, @ModelAttribute Metrica metrica) {
        metricaService.actualizarMetrica(metrica);
        List<Metrica> metricas = metricaService.obtenerTodasLasMetricas().stream().filter(i -> i.getInforme().getId() == informeId).collect(Collectors.toList());
        model.addAttribute("metricas", metricas);
        return "metricas";
    }

    @GetMapping("/metrica/borrar/{id}")
    public String borrar(Model model, @PathVariable int id) {
        Metrica metrica = metricaService.obtenerMetricaPorId(id);
        metricaService.borrarMetrica(metrica);
        List<Metrica> metricas = metricaService.obtenerTodasLasMetricas().stream().filter(i -> i.getInforme().getId() == informeId).collect(Collectors.toList());
        model.addAttribute("metricas", metricas);
        return "metricas";
    }
}