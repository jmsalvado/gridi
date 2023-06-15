package com.example.service;

import com.example.entity.Informe;
import com.example.repository.InformeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InformeService {

    @Autowired
    private InformeRepository informeRepository;

    public List<Informe> obtenerTodosLosInformes() {
        return informeRepository.findAll();
    }

    public Informe obtenerInformePorId(Long id) {
        return informeRepository.findById(id).get();
    }

    public Informe crearInforme(Informe informe) {
        return informeRepository.save(informe);
    }

    public Informe actualizarInforme(Informe informe) {
        return informeRepository.save(informe);
    }

    public void borrarInforme(Informe informe) {
        informeRepository.delete(informe);
    }
}