package com.example.entity;

public class Adjunto {
	
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
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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
