package com.example.entity;

import java.util.Date;
import java.util.List;

public class Incidencia {
	
	private int id;
	private String descripcion;
	private Prioridad prioridad;
	private Categoria categoria;
	private Estado estado;
	private Date fechaCreacion;
	private List<Comentario> comentarios;
	private List<Adjunto> adjuntos;
	private Usuario usuario;
	
    public Incidencia() {
	}
    
    public Incidencia(int id, String descripcion, Prioridad prioridad, Categoria categoria, Estado estado, 
            Date fechaCreacion, List<Comentario> comentarios, List<Adjunto> adjuntos, Usuario usuario) {
    	this.id = id;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
		this.categoria = categoria;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
		this.comentarios = comentarios;
		this.adjuntos = adjuntos;
		this.usuario = usuario;
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

}
