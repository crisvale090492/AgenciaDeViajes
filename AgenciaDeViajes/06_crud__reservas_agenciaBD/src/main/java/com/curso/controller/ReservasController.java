package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Reserva;
import com.curso.service.ReservasService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class ReservasController {
	
	@Autowired
	ReservasService service;
	
	//http://localhost:9000/reservas
	@GetMapping(value="reservas", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Metodo que se encarga de mostrar todas las reservas existentes")
	public List<Reserva> reservas() {
		return service.reservas();
	}
	//http://localhost:9000/reservastotales/hilton
	@GetMapping(value="reservas/{nombreHotel}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Metodo que se encarga de mostrar todas las reservas existentes segun el nombre del hotel")
	public List<Reserva> reservasTotalesPorNombreDeHotel(@ApiParam(value="Cadena que nos indica el nombre del hotel a obtener")@PathVariable String nombreHotel) {
		return service.reservasTotalesPorNombreDeHotel(nombreHotel);
	}
	//http://localhost:9000/reserva/1
	@GetMapping(value="reserva/{idReserva}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Metodo que se encarga de mostrar una reserva segun su identificador")
	public Reserva buscarReserva(@PathVariable int idReserva) {
		return service.buscarReserva(idReserva);
	}
	//http://localhost:9000/reserva
	@PostMapping(value="reserva", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Metodo que se encarga de mostrar crear una nueva reserva")
	public List<Reserva> nuevoReservas(@RequestBody Reserva reserva) {
		service.nuevoReserva(reserva);
		return service.reservas();
	}
	//http://localhost:9000/reserva
	@PutMapping(value="reserva", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Metodo que se encarga de hacer algun cambio en una reserva")
	void actualizarReserva(@RequestBody Reserva reserva) {
		service.actualizarReserva(reserva);
	}
	//http://localhost:9000/reserva/1
	@DeleteMapping(value="reserva/{idReserva}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Metodo que se encarga de eliminar una reserva segun su id")
	public List<Reserva> eliminarReserva(@ApiParam(value="Numero que nos indica el identificador de la reserva a eliminar")@PathVariable int idReserva) {
		service.eliminarReserva(idReserva);
		return service.reservas();
	}

}
