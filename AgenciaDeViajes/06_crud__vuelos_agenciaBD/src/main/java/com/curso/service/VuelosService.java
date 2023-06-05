package com.curso.service;

import java.util.List;


import com.curso.model.Vuelo;


public interface VuelosService {
	
	List<Vuelo> vuelos();
	Vuelo buscarVuelo(int idVuelo);
	List<Vuelo> nuevoVuelo(Vuelo vuelo);
	void actualizarVuelo(int idVuelo, int totalPersonasReserva );
	List<Vuelo> eliminarVuelo(int idVuelo);
	List<Vuelo> vuelosDisponibles(int totalPlazas);

}
