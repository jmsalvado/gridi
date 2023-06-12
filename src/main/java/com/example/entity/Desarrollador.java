package com.example.entity;

public class Desarrollador extends Usuario {
	
    public Desarrollador() {
        super();
    }
    
    public Desarrollador(String nombre, String correoElectronico, String contraseña) {
        super(nombre, correoElectronico, contraseña, Rol.DESARROLLADOR);
    }
}
