package com.example.gridi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	@Id
	@Column(name="nombre")
	private String nombre;
	@Column(name="correo_electronico")
    private String correoElectronico;
	@Column(name="contraseña")
    private String contraseña;
	@Column(name="rol")
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
