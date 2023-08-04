package com.example.gridi.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
    private String contenido;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fecha = new Date();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "incidencia", referencedColumnName = "id")
	private Incidencia incidencia;
    
	public Comentario() {
    }
	
	public Comentario(int id, String contenido, Date fecha, Incidencia incidencia) {
        this.id = id;
        this.contenido = contenido;
        this.fecha = fecha;
		this.incidencia = incidencia;
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

	public Incidencia getIncidencia() { return incidencia; }

	public void setIncidencia(Incidencia incidencia) { this.incidencia = incidencia; }

}
