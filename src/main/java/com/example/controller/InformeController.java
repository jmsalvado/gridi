package com.example.controller;

import com.example.entity.Informe;
import com.example.service.InformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/informes")
public class InformeController {

    @Autowired
    private InformeService informeService;

    @GetMapping
    public ResponseEntity<List<Informe>> obtenerInformes() {
        List<Informe> informes = informeService.obtenerTodosLosInformes();
        return ResponseEntity.ok(informes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Informe> obtenerInformePorId(@PathVariable Long id) {
        Informe informe = informeService.obtenerInformePorId(id);
        if (informe != null) {
            return ResponseEntity.ok(informe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Informe> crearInforme(@RequestBody Informe informe) {
        Informe nuevoInforme = informeService.crearInforme(informe);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoInforme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Informe> actualizarInforme(@PathVariable Long id, @RequestBody Informe informe) {
        Informe informeExistente = informeService.obtenerInformePorId(id);
        if (informeExistente != null) {
            Informe informeActualizado = informeService.actualizarInforme(informe);
            return ResponseEntity.ok(informeActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInforme(@PathVariable Long id, @RequestBody Informe informe) {
        Informe informeExistente = informeService.obtenerInformePorId(id);
        if (informeExistente != null) {
            informeService.borrarInforme(informe);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}