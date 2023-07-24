package com.example.gridi.service;

import com.example.gridi.entity.Informe;
import com.example.gridi.repository.InformeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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