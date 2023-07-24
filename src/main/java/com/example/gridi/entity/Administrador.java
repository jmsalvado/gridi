package com.example.gridi.entity;

public class Administrador extends Usuario {
	
	public Administrador() {
        super();
    }
	
	public Administrador(String nombre, String correoElectronico, String contraseña) {
        super(nombre, correoElectronico, contraseña, Rol.ADMINISTRADOR);
    }
}
