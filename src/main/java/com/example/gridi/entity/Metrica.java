package com.example.gridi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Metrica {

	@Id
	private int id;
    private String nombre;
    private double valor;
	
	public Metrica() {
    }
	
	public Metrica(int id, String nombre, double valor) {
        this.setId(id);
        this.setNombre(nombre);
        this.setValor(valor);
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
