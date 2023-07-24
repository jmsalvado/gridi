package com.example.gridi.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Proyecto {

	@Id
	private int id;
    private String nombre;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "incidencias", referencedColumnName = "id")
    private List<Incidencia> incidencias;
    
    public Proyecto() {
    }
    
    public Proyecto(int id, String nombre, List<Incidencia> incidencias) {
        this.id = id;
        this.nombre = nombre;
        this.incidencias = incidencias;
    }
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Incidencia> getIncidencias() {
		return incidencias;
	}
	
	public void setIncidencias(List<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

}
