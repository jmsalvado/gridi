package com.example.gridi.controller;

import com.example.gridi.entity.Proyecto;
import com.example.gridi.entity.Usuario;
import com.example.gridi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    @GetMapping("/usuario")
    public String usuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario";
    }

    @GetMapping("/usuario/editar/{id}")
    public String editar(Model model, @PathVariable int id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        model.addAttribute("usuario", usuario);
        return "usuario";
    }

    @PostMapping("/usuario/guardar")
    public String guardar(Model model, @ModelAttribute Usuario usuario) {
        usuarioService.actualizarUsuario(usuario);
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    @GetMapping("/usuario/borrar/{id}")
    public String borrar(Model model, @PathVariable int id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        usuarioService.borrarUsuario(usuario);
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }
}