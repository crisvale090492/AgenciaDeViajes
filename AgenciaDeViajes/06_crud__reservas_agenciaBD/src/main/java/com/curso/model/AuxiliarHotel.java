package com.curso.model;

/**
 * 
 * @author Cristian Valencia
 *Clase AuxiliarHotel la cual usamos para obtener los datos de la consulta template sobre los servicios de hotel
 */
public class AuxiliarHotel {
			
		private int idHotel;
		private String nombre;
		private int categoria;
		private double precio;
		private String disponible;
		
		public AuxiliarHotel() {
			super();
		}

		public AuxiliarHotel(int idHotel, String nombre, int categoria, double precio, String disponible) {
			super();
			this.idHotel = idHotel;
			this.nombre = nombre;
			this.categoria = categoria;
			this.precio = precio;
			this.disponible = disponible;
		}

		public int getIdHotel() {
			return idHotel;
		}

		public void setIdHotel(int idHotel) {
			this.idHotel = idHotel;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getCategoria() {
			return categoria;
		}

		public void setCategoria(int categoria) {
			this.categoria = categoria;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public String getDisponible() {
			return disponible;
		}

		public void setDisponible(String disponible) {
			this.disponible = disponible;
		}

}
