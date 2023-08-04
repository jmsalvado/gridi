package com.example.gridi.entity;

import jakarta.persistence.*;

@Entity
public class Metrica {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
    private String nombre;
    private double valor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "informe", referencedColumnName = "id")
	private Informe informe;
	
	public Metrica() {
    }
	
	public Metrica(int id, String nombre, double valor, Informe informe) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
		this.informe = informe;
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

	public Informe getInforme() { return informe; }

	public void setInforme(Informe informe) { this.informe = informe; }

}
