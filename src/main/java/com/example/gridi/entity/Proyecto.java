package com.example.gridi.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Proyecto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    private String nombre;
    
    public Proyecto() {
    }
    
    public Proyecto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

}
