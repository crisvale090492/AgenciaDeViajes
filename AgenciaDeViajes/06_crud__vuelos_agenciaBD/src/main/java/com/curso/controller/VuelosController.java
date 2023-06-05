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

import com.curso.model.Vuelo;
import com.curso.service.VuelosService;

import io.swagger.annotations.ApiOperation;

@RestController
public class VuelosController {
	
	@Autowired
	VuelosService service;
	
			//http://localhost:7000/vuelos
			@GetMapping(value="vuelos", produces=MediaType.APPLICATION_JSON_VALUE)
			@ApiOperation(value="Metodo que se encarga de mostrar todos los vuelos existentes")
			public List<Vuelo> vuelos() {
				return service.vuelos();
			}
			//http://localhost:7000/vuelo/1
			@GetMapping(value="vuelo/{idVuelo}", produces=MediaType.APPLICATION_JSON_VALUE)
			@ApiOperation(value="Metodo que se encarga de mostrar un vuelo mediante su identificador")
			public Vuelo buscarVuelo(@PathVariable int idVuelo) {
				return service.buscarVuelo(idVuelo);
			}
			//http://localhost:7000/vuelo
			@PostMapping(value="vuelo", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
			@ApiOperation(value="Metodo que se encarga de crear un nuevo vuelo")
			public List<Vuelo> nuevoVuelo(@RequestBody Vuelo vuelo) {
				service.nuevoVuelo(vuelo);
				return service.vuelos();
			}
			//http://localhost:7000/vuelo
			@PutMapping(value="vuelo/{idVuelo}/{totalPersonasReserva}", produces=MediaType.APPLICATION_JSON_VALUE)
			@ApiOperation(value="Metodo que se encarga de actualizar un vuelo, utilizando el identificador y el total de personas que lo reservan, y asi poder restarlo")
			void actualizarVuelo(@PathVariable int idVuelo, @PathVariable int totalPersonasReserva) {
				service.actualizarVuelo(idVuelo,totalPersonasReserva);
			}
			//http://localhost:7000/vuelo/1
			@DeleteMapping(value="vuelo/{idVuelo}", produces=MediaType.APPLICATION_JSON_VALUE)
			@ApiOperation(value="Metodo que se encarga de eliminar un vuelo mediante su identificador")
			public List<Vuelo> eliminarVuelo(@PathVariable int idVuelo) {
				service.eliminarVuelo(idVuelo);
				return service.vuelos();
			}
			
			//http://localhost:7000/vuelos/1
			@GetMapping(value="vuelos/{totalPlazas}", produces=MediaType.APPLICATION_JSON_VALUE)
			@ApiOperation(value="Metodo que se encarga de  mostrar los vuelos que tienen disponibilidad")
			public List<Vuelo> vuelosDisponibles(@PathVariable int totalPlazas) {
				return service.vuelosDisponibles(totalPlazas);
			}


}
