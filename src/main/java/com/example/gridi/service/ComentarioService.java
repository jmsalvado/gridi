package com.example.gridi.service;

import com.example.gridi.entity.Comentario;
import com.example.gridi.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> obtenerTodosLosComentarios() {
        return comentarioRepository.findAll();
    }

    public Comentario obtenerComentarioPorId(Long id) {
        return comentarioRepository.findById(id).get();
    }

    public Comentario crearComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Comentario actualizarComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public void borrarComentario(Comentario comentario) {
        comentarioRepository.delete(comentario);
    }
}