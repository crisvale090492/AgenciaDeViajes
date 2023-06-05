package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.ReservasDao;
import com.curso.model.AuxiliarHotel;
import com.curso.model.AuxiliarVuelo;
import com.curso.model.Reserva;

/**
 * 
 * @author Cristian Valencia
 *
 */
@Service
public class ReservaServiceImpl implements ReservasService {
	/**
	 * Interfaz dao que nos implementa el CRUD
	 */
	@Autowired
	RestTemplate template;

	private String urlHoteles = "http://localhost:8500/";
	
	private String urlVuelos = "http://localhost:7000/";
	
	@Autowired
	ReservasDao dao;
	/**
	 * metodo que devuelve todas las reservas
	 */
	@Override
	public List<Reserva> reservas() {
		return dao.findAll();
	}
	/**
	 * metodo que devuelve todas las reservas, recibiendo por parametro un String el cual usamos para llamar al servicio de obtener hotel y con el resultado comparamos el identificador que sea igual y los mostramos.
	 */
	public List<Reserva> reservasTotalesPorNombreDeHotel(String nombreHotel) {
		
		List<Reserva> reservaCompleta = dao.findAll();
		
		List<Reserva> reservasaDevolver = new ArrayList<>();
		
		AuxiliarHotel hotel = new AuxiliarHotel();
		
		hotel = template.getForObject(urlHoteles + "hotel/"+ nombreHotel, AuxiliarHotel.class);
		
		for (Reserva reserva:reservaCompleta) {
			if (reserva.getIdHotel() == hotel.getIdHotel()) {
				reservasaDevolver.add(reserva);
			}
		}
		
		return reservasaDevolver;
	}
	/**
	 * metodo que recibe por parametro un String y obtienes la reserva que tenga este nombre
	 */
	@Override
	public Reserva buscarReserva(int idReserva) {
		return dao.findById(idReserva).orElse(null);
	}
	/*
	 * metodo que nos permite crear una nueva reserva, mediante un JSON
	 */
	@Override
	public List<Reserva> nuevoReserva(Reserva reserva) {
		boolean disponibleOk = false;
		boolean plazasDisponiblesOk = false;
		List<AuxiliarHotel> listaHotelesParaReserva = Arrays.asList(template.getForObject(urlHoteles + "hoteles", AuxiliarHotel[].class));
		
		List<AuxiliarVuelo> listaVuelosParaReserva = Arrays.asList(template.getForObject(urlVuelos + "vuelos", AuxiliarVuelo[].class));
		
		for (AuxiliarHotel hotel:listaHotelesParaReserva) {
			if (hotel.getIdHotel() == reserva.getIdHotel() && hotel.getDisponible().equals("si")) {
					reserva.setIdHotel(hotel.getIdHotel());
					disponibleOk = true;
				} 
			}
		
	
		for (AuxiliarVuelo vuelo:listaVuelosParaReserva) {
			if (vuelo.getIdVuelo() == reserva.getIdVuelo() && vuelo.getPlazasDisponibles() >= reserva.getTotalPersonasReserva()) {
					reserva.setIdVuelo(vuelo.getIdVuelo());
					plazasDisponiblesOk = true;
				} 
			}
		
		if(disponibleOk && plazasDisponiblesOk) {
			dao.save(reserva);
			template.put(urlVuelos + "vuelo/{idvuelo}/{totalpersonasreserva}",null,reserva.getIdVuelo(),reserva.getTotalPersonasReserva());
		}
		
		return dao.findAll();
	}
	/*
	 * metodo que nos permite actualizar una reserva, mediante un JSON.
	 */
	@Override
	public void actualizarReserva(Reserva reserva) {
		dao.save(reserva);
	}
	/**
	 * metodo que recibe un parametro de tipo int , que si es igual al identificador de una reserva la elimina.
	 */
	@Override
	public List<Reserva> eliminarReserva(int idReserva) {
		dao.deleteById(idReserva);
		return dao.findAll();
	}

}

