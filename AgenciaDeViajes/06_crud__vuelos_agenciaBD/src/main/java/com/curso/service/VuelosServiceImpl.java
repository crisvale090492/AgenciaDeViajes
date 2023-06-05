package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.VuelosDao;
import com.curso.model.Vuelo;

/**
 * 
 * @author Cristian Valencia
 *
 */
@Service
public class VuelosServiceImpl implements VuelosService {
	/**
	 * Interfaz dao que nos implementa el CRUD
	 */
	@Autowired
	VuelosDao dao;
	/**
	 * metodo que devuelve todos los vuelos
	 */
	@Override
	public List<Vuelo> vuelos() {
		return dao.findAll();
	}
	/**
	 * metodo que recibe por parametro un numero y obtienes el vuelo que tenga este numero como identificador
	 */
	@Override
	public Vuelo buscarVuelo(int idVuelo) {
		return dao.findById(idVuelo).orElse(null);
	}
	/*
	 * metodo que nos permite crear un nuevo vuelo, mediante un JSON
	 */
	@Override
	public List<Vuelo> nuevoVuelo(Vuelo vuelo) {
		dao.save(vuelo);
		return dao.findAll();
	}
	/*
	 * metodo que nos permite actualizar un vuelo, mediante su identificador, y un numero que nos indica el numero de personas que hacen una reserva para restar esta cantidad a la cantidad de puestos disponibles en el vuelo.
	 */
	@Override
	public void actualizarVuelo(int  idVuelo, int totalPersonasReserva) {
		Vuelo vuelo = dao.findById(idVuelo).orElse(null);
		if (vuelo.getPlazasDisponibles() >= totalPersonasReserva) {
		vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles()- totalPersonasReserva);
		}
		dao.save(vuelo);
	}
	/**
	 * metodo que recibe un parametro de tipo int , que si es igual al identificador de un vuelo lo elimina.
	 */
	@Override
	public List<Vuelo> eliminarVuelo(int idVuelo) {
		dao.deleteById(idVuelo);
		return dao.findAll();
	}
	/**
	 * metodo que recibe un parametro de tipo int que nos indica la cantidad de puestos disponibles en un vuelo, y con este dato devolvemos una lista de los vuelos que cumplan con esta cantidad de disponibilidad.
	 */
	public List<Vuelo> vuelosDisponibles(int totalPlazas) {
		List<Vuelo> vuelosTotales = dao.findAll();
		List<Vuelo> vuelosDisponibles = new ArrayList<Vuelo>();
		for (Vuelo vuelo:vuelosTotales) {
			Vuelo vueloAanadir = new Vuelo();
			if (vuelo.getPlazasDisponibles()>= totalPlazas) {
				vueloAanadir=vuelo;
				vuelosDisponibles.add(vueloAanadir);
			}
		}
		return vuelosDisponibles;
	}

}
