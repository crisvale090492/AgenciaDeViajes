package com.curso.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * @author Cristian Valencia
 *Clase vuelo la cual usamos de persistencia con la tabla vuelos
 */
@Entity
@Table(name="vuelos")
public class Vuelo {
	
	@Id
	@Column(name="idvuelo")
	private int idVuelo;
	private String compania;
	@Column(name="fechaVuelo")
	private Date fechaVuelo;
	private double precio;
	@Column(name="plazasDisponibles")
	private int plazasDisponibles;
	
	public Vuelo() {
		super();
	}

	public Vuelo(int idVuelo, String compania, Date fechaVuelo, double precio, int plazasDisponibles) {
		super();
		this.idVuelo = idVuelo;
		this.compania = compania;
		this.fechaVuelo = fechaVuelo;
		this.precio = precio;
		this.plazasDisponibles = plazasDisponibles;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public Date getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(Date fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPlazasDisponibles() {
		return plazasDisponibles;
	}

	public void setPlazasDisponibles(int plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}

}
