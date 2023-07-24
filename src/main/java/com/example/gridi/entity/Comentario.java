package com.example.gridi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Comentario {

	@Id
	private int id;
    private String contenido;
    private Date fecha;
    
	public Comentario() {
    }
	
	public Comentario(int id, String contenido, Date fecha) {
        this.id = id;
        this.contenido = contenido;
        this.fecha = fecha;
    }

	public void setId(int id) { this.id = id; }

	public int getId() { return id; }
	
	public String getContenido() {
		return contenido;
	}
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
