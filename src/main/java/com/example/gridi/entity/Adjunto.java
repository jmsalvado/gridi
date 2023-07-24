package com.example.gridi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Adjunto {

	@Id
	private int id;
    private String nombreArchivo;
    private String rutaArchivo;
    
	public Adjunto() {
    }
	
	public Adjunto(int id, String nombreArchivo, String rutaArchivo) {
        this.id = id;
        this.nombreArchivo = nombreArchivo;
        this.rutaArchivo = rutaArchivo;
    }

	public void setId(int id) { this.id = id; }

	public int getId() { return id; }
	
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	public String getRutaArchivo() {
		return rutaArchivo;
	}
	
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

}
