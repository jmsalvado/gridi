package com.example.gridi.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Incidencia {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String descripcion;
	private String prioridad;
	private String categoria;
	private String estado;
	private  int tiempoImputado;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaCreacion = new Date();
	@OneToMany(mappedBy = "incidencia", cascade = CascadeType.ALL)
	private List<Comentario> comentarios = new ArrayList<>();
	@OneToMany(mappedBy = "incidencia", cascade = CascadeType.ALL)
	private List<Adjunto> adjuntos = new ArrayList<>();
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario", referencedColumnName = "id")
	private Usuario usuario;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proyecto", referencedColumnName = "id")
	private Proyecto proyecto;
	@Transient
	private Comentario nuevoComentario;
	@Transient
	private Adjunto nuevoAdjunto;
	
    public Incidencia() {
	}
    
    public Incidencia(int id, String descripcion, String prioridad, String categoria, String estado, int tiempoImputado,
            Date fechaCreacion, List<Comentario> comentarios, List<Adjunto> adjuntos, Usuario usuario, Proyecto proyecto) {
    	this.id = id;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
		this.categoria = categoria;
		this.estado = estado;
		this.tiempoImputado = tiempoImputado;
		this.fechaCreacion = fechaCreacion;
		this.comentarios = comentarios;
		this.adjuntos = adjuntos;
		this.usuario = usuario;
		this.proyecto = proyecto;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getPrioridad() {
		return prioridad;
	}
	
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getTiempoImputado() { return tiempoImputado; }

	public void setTiempoImputado(int tiempoImputado) { this.tiempoImputado = tiempoImputado; }
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public void addComentarios(Comentario comentario) {
		comentario.setIncidencia(this);
		this.comentarios.add(comentario);
	}
	
	public List<Adjunto> getAdjuntos() {
		return adjuntos;
	}
	
	public void setAdjuntos(List<Adjunto> adjuntos) {
		this.adjuntos = adjuntos;
	}

	public void addAdjuntos(Adjunto adjunto) {
		adjunto.setIncidencia(this);
		this.adjuntos.add(adjunto);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Proyecto getProyecto() { return proyecto; }

	public void setProyecto(Proyecto proyecto) { this.proyecto = proyecto; }

	public Comentario getNuevoComentario() { return nuevoComentario; }

	public void setNuevoComentario(Comentario nuevoComentario) { this.nuevoComentario = nuevoComentario; }

	public Adjunto getNuevoAdjunto() { return nuevoAdjunto; }

	public void setNuevoAdjunto(Adjunto nuevoAdjunto) { this.nuevoAdjunto = nuevoAdjunto; }

}
