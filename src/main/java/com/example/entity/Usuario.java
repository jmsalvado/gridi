package com.example.entity;

public class Usuario {

	private String nombre;
    private String correoElectronico;
    private String contraseña;
    private Rol rol;
    
    public Usuario() {
    }
    
    public Usuario(String nombre, String correoElectronico, String contraseña, Rol rol) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.rol = rol;
    }
    
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public Rol getRol() {
		return rol;
	}
	
	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
