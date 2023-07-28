package com.example.gridi.entity;

import jakarta.persistence.*;

@Entity
public class Adjunto {

	@Id
	private int id;
    private String nombreArchivo;
    private String rutaArchivo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "incidencia", referencedColumnName = "id")
	private Incidencia incidencia;
    
	public Adjunto() {
    }
	
	public Adjunto(int id, String nombreArchivo, String rutaArchivo, Incidencia incidencia) {
        this.id = id;
        this.nombreArchivo = nombreArchivo;
        this.rutaArchivo = rutaArchivo;
		this.incidencia = incidencia;
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

	public Incidencia getIncidencia() { return incidencia; }

	public void setIncidencia(Incidencia incidencia) { this.incidencia = incidencia; }

}
