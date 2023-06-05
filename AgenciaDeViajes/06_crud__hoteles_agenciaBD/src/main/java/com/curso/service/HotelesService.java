package com.curso.service;

import java.util.List;

import com.curso.model.Hotel;


public interface HotelesService {
	
	List<Hotel> hoteles();
	Hotel buscarHotel(String nombre);
	List<Hotel> nuevoHotel(Hotel hotel);
	void actualizarHotel(Hotel hotel);
	List<Hotel> eliminarHotel(int idHotel);

}
