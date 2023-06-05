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

import com.curso.model.Hotel;
import com.curso.service.HotelesService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class HotelesController {
	
		
		@Autowired
		HotelesService service;
		
		//http://localhost:8500/hoteles
		@GetMapping(value="hoteles", produces=MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value="Metodo que se encarga de mostrar todos los hoteles existentes")
		public List<Hotel> hoteles() {
			return service.hoteles();
		}
		//http://localhost:8500/hotel/
		@GetMapping(value="hotel/{nombre}", produces=MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value="Metodo que se encarga de mostrar un hotel segun su nombre")
		public Hotel buscarHotel(@ApiParam(value="Cadena que nos indica el nombre del hotel a buscar")@PathVariable String nombre) {
			return service.buscarHotel(nombre);
		}
		//http://localhost:8500/hotel
		@PostMapping(value="hotel", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value="Metodo que se encarga de crear un nuevo hotel")
		public List<Hotel> nuevoHotel(@RequestBody Hotel hotel) {
			service.nuevoHotel(hotel);
			return service.hoteles();
		}
		//http://localhost:8500/hotel
		@PutMapping(value="hotel", produces=MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value="Metodo que se encarga de actualizar un hotel")
		void actualizarHotel(@RequestBody Hotel hotel) {
			service.actualizarHotel(hotel);
		}
		//http://localhost:8500/hotel/1
		@DeleteMapping(value="hotel/{idHotel}", produces=MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value="Metodo que se encarga de eliminar un hotel segun su identificador")
		public List<Hotel> eliminarHotel(@ApiParam(value="Numero que nos indica el identificador del hotel a eliminar")@PathVariable int idHotel) {
			service.eliminarHotel(idHotel);
			return service.hoteles();
		}

}
