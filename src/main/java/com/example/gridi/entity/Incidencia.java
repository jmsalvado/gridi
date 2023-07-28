package com.example.gridi.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
@Entity
public class Incidencia {

	@Id
	private int id;
	private String descripcion;
	private Prioridad prioridad;
	private Categoria categoria;
	private Estado estado;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaCreacion;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "comentarios", referencedColumnName = "id")
	private List<Comentario> comentarios;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "adjuntos", referencedColumnName = "id")
	private List<Adjunto> adjuntos;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario", referencedColumnName = "nombre")
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
    
    public Incidencia(int id, String descripcion, Prioridad prioridad, Categoria categoria, Estado estado, 
            Date fechaCreacion, List<Comentario> comentarios, List<Adjunto> adjuntos, Usuario usuario, Proyecto proyecto) {
    	this.id = id;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
		this.categoria = categoria;
		this.estado = estado;
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
	
	public Prioridad getPrioridad() {
		return prioridad;
	}
	
	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
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
	
	public List<Adjunto> getAdjuntos() {
		return adjuntos;
	}
	
	public void setAdjuntos(List<Adjunto> adjuntos) {
		this.adjuntos = adjuntos;
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
