package com.example.gridi.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Informe {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private String descripcion;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaGeneracion = new Date();
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "autor", referencedColumnName = "id")
    private Usuario autor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "incidencia", referencedColumnName = "id")
	private Incidencia incidencia;
	@OneToMany(mappedBy = "informe", cascade = CascadeType.ALL)
	private List<Metrica> metricas = new ArrayList<>();
	@Transient
	private Metrica nuevaMetrica;
    
	public Informe() {
    }
	
	public Informe(int id, String titulo, String descripcion, Date fechaGeneracion, Usuario autor, Incidencia incidencia, List<Metrica> metricas) {
        this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
        this.fechaGeneracion = fechaGeneracion;
        this.autor = autor;
		this.incidencia = incidencia;
		this.metricas = metricas;
    }
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() { return titulo; }

	public void setTitulo(String titulo) { this.titulo = titulo; }
	public String getDescripcion() { return descripcion; }

	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	
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

	public List<Metrica> getMetricas() { return metricas; }

	public void setMetricas(List<Metrica> metricas) { this.metricas = metricas; }

	public void addMetricas(Metrica metrica) {
		metrica.setInforme(this);
		this.metricas.add(metrica);
	}

	public Metrica getNuevaMetrica() { return nuevaMetrica; }

	public void setNuevaMetrica(Metrica nuevaMetrica) { this.nuevaMetrica = nuevaMetrica; }

}
