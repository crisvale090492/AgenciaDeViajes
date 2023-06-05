package com.curso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Cristian Valencia
 *Clase Reserva la cual usamos de persistencia con la tabla reservas
 */
@Entity
@Table(name="reservas")
public class Reserva {
	@Id
	@Column(name="idreserva")
	private int idReserva;
	@Column(name="nombrecliente")
	private String nombreCliente;
	private String dni;
	@Column(name="idhotel")
	private int idHotel;
	@Column(name="idvuelo")
	private int idVuelo;
	@Column(name="totalpersonasreserva")
	private int totalPersonasReserva;
	
	public Reserva() {
		super();
	}

	public Reserva(int idReserva, String nombreCliente, String dni, int idHotel, int idVuelo, int totalPersonasReserva) {
		super();
		this.idReserva = idReserva;
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.idHotel = idHotel;
		this.idVuelo = idVuelo;
		this.totalPersonasReserva = totalPersonasReserva;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public int getTotalPersonasReserva() {
		return totalPersonasReserva;
	}

	public void setTotalPersonasReserva(int totalPersonasReserva) {
		this.totalPersonasReserva = totalPersonasReserva;
	}
	
	

}
