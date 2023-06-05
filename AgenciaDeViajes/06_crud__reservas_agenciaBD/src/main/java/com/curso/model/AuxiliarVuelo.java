package com.curso.model;

import java.util.Date;

/**
 * 
 * @author Cristian Valencia
 *Clase AuxiliarVuelo la cual usamos para obtener los datos de la consulta template sobre los servicios de vuelo
 */
public class AuxiliarVuelo {
	
	private int idVuelo;
	private String compania;
	private Date fechaVuelo;
	private double precio;
	private int plazasDisponibles;
	
	public AuxiliarVuelo() {
		super();
	}

	public AuxiliarVuelo(int idVuelo, String compania, Date fechaVuelo, double precio, int plazasDisponibles) {
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
