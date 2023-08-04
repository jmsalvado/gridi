package com.example.gridi.entity;

public class Administrador extends Usuario {
	
	public Administrador() {
        super();
    }
	
	public Administrador(int id, String nombre, String correoElectronico, String contraseña) {
        super(id, nombre, correoElectronico, contraseña, Rol.ADMINISTRADOR.toString());
    }
}
