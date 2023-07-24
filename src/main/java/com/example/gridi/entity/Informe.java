package com.example.gridi.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
public class Informe {

	@Id
	private int id;
    private Date fechaGeneracion;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "metricas", referencedColumnName = "id")
    private List<Metrica> metricas;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "autor", referencedColumnName = "nombre")
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
