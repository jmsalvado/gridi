package com.example.gridi.entity;

public class Desarrollador extends Usuario {
	
    public Desarrollador() {
        super();
    }
    
    public Desarrollador(int id, String nombre, String correoElectronico, String contraseña) {
        super(id, nombre, correoElectronico, contraseña, Rol.DESARROLLADOR.toString());
    }
}
