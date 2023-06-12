package com.example.entity;

import java.util.Date;
import java.util.List;

public class Informe {
	
	private int id;
    private Date fechaGeneracion;
    private List<Metrica> metricas;
    private Usuario autor;
    
	public Informe() {
    }
	
	public Informe(int id, Date fechaGeneracion, List<Metrica> metricas, Usuario autor) {
        this.id = id;
        this.fechaGeneracion = fechaGeneracion;
        this.metricas = metricas;
        this.autor = autor;
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
	
	public List<Metrica> getMetricas() {
		return metricas;
	}
	
	public void setMetricas(List<Metrica> metricas) {
		this.metricas = metricas;
	}
	
	public Usuario getAutor() {
		return autor;
	}
	
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

}
