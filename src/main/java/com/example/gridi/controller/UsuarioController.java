package com.example.gridi.controller;

import com.example.gridi.entity.Usuario;
import com.example.gridi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String obtenerUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        return "usuarios";
    }

    @GetMapping("/obtenerUsuarioPorId/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable String id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearUsuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @PutMapping("/actualizarUsuario/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.obtenerUsuarioPorId(id);
        if (usuarioExistente != null) {
            Usuario usuarioActualizado = usuarioService.actualizarUsuario(usuario);
            return ResponseEntity.ok(usuarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.obtenerUsuarioPorId(id);
        if (usuarioExistente != null) {
            usuarioService.borrarUsuario(usuario);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}