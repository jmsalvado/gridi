package com.example.gridi.service;

import com.example.gridi.entity.Proyecto;
import com.example.gridi.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<Proyecto> obtenerTodosLosProyectos() {
        return proyectoRepository.findAll();
    }

    public Proyecto obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id).get();
    }

    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public Proyecto actualizarProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public void borrarProyecto(Proyecto proyecto) {
        proyectoRepository.delete(proyecto);
    }
}
