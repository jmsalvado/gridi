package com.example.gridi.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
public class Informe {

	@Id
	private int id;
    private Date fechaGeneracion;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "autor", referencedColumnName = "nombre")
    private Usuario autor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "incidencia", referencedColumnName = "id")
	private Incidencia incidencia;
    
	public Informe() {
    }
	
	public Informe(int id, Date fechaGeneracion, Usuario autor, Incidencia incidencia) {
        this.id = id;
        this.fechaGeneracion = fechaGeneracion;
        this.autor = autor;
		this.incidencia = incidencia;
    }
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}
	
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	
	public Usuario getAutor() {
		return autor;
	}
	
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Incidencia getIncidencia() { return incidencia; }

	public void setIncidencia(Incidencia incidencia) { this.incidencia = incidencia; }

}
