package com.curso.service;

import java.util.List;
import com.curso.model.Reserva;

public interface ReservasService {
	
	List<Reserva> reservas();
	Reserva buscarReserva(int idReserva);
	List<Reserva> nuevoReserva(Reserva reserva);
	void actualizarReserva(Reserva reserva);
	List<Reserva> eliminarReserva(int idReserva);
	List<Reserva> reservasTotalesPorNombreDeHotel(String nombre);

}
