package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.HotelesDao;
import com.curso.model.Hotel;


/**
 * 
 * @author Cristian Valencia
 *
 */
@Service
public class HotelesServiceImpl implements HotelesService {
	/**
	 * Interfaz dao que nos implementa el CRUD
	 */
	@Autowired
	HotelesDao dao;
	/**
	 * metodo que devuelve todos los hoteles
	 */
	@Override
	public List<Hotel> hoteles() {
		return dao.findAll();
	}
	/**
	 * metodo que recibe por parametro un String y obtienes el vuelo que tenga este nombre
	 */
	@Override
	public Hotel buscarHotel(String nombre) {
		List<Hotel> hoteles = dao.findAll();
		Hotel hotel = new Hotel();
		for (Hotel Hotel:hoteles) {
			if (Hotel.getNombre().equalsIgnoreCase(nombre)) {
				hotel = Hotel;
			}
		}
		return hotel;
	}
	/*
	 * metodo que nos permite crear un nuevo hotel, mediante un JSON
	 */
	@Override
	public List<Hotel> nuevoHotel(Hotel hotel) {
		dao.save(hotel);
		return dao.findAll();
	}
	/*
	 * metodo que nos permite actualizar un hotel, mediante un JSON.
	 */
	@Override
	public void actualizarHotel(Hotel hotel) {
		dao.save(hotel);
	}
	/**
	 * metodo que recibe un parametro de tipo int , que si es igual al identificador de un hotel lo elimina.
	 */
	@Override
	public List<Hotel> eliminarHotel(int idHotel) {
		dao.deleteById(idHotel);
		return dao.findAll();
	}

}
