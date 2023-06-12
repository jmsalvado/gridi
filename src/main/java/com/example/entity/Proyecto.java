package com.example.entity;

import java.util.List;

public class Proyecto {
	
	private int id;
    private String nombre;
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
