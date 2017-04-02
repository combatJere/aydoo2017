package ar.edu.untref.aydoo;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class Cliente {

	private int id;
	private String telefono;
	private String direccion;
	private LinkedList<Compra> compras;
	private LinkedList<Suscripcion> suscripciones;

	public Cliente(int id, String telefono, String direccion) {
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.compras = new LinkedList<Compra>();
		this.suscripciones = new LinkedList<Suscripcion>();
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LinkedList<Compra> getCompras() {
		return compras;
	}

	public void agregarCompra(Date fecha, Producto producto) {
		Compra compra = new Compra(fecha, producto, this);
		compras.add(compra);
	}

	public LinkedList<Suscripcion> getSuscripciones() {
		return suscripciones;
	}

	public void agregarSuscripcion(Suscribible suscribible, Date fechaInicio, Date fechaFin, boolean esAnual) {
		Suscripcion suscripcion = new Suscripcion(suscribible, this, fechaInicio, fechaFin, esAnual);
		suscripciones.add(suscripcion);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LinkedList<Compra> getComprasDelMes(int anio, int mes) {
		LinkedList<Compra> listaComprasEnMes = new LinkedList<Compra>();

		for (Compra compra : compras) {
			if (this.fechaPerteneceAlMes(compra.getFecha(), anio, mes)) {
				listaComprasEnMes.add(compra);
			}
		}

		return listaComprasEnMes;
	}

	public LinkedList<Suscripcion> getSuscripcionesDelMes(int anio, int mes) {
		LinkedList<Suscripcion> listaSuscripcionesEnMes = new LinkedList<Suscripcion>();

		for (Suscripcion suscripcion : suscripciones) {
			if (this.fechaEstaEntre(suscripcion.getFechaInicio(), suscripcion.getFechaFin(), anio, mes)) {
				listaSuscripcionesEnMes.add(suscripcion);
			}
		}

		return listaSuscripcionesEnMes;
	}

	private boolean fechaPerteneceAlMes(Date fecha, int anio, int mes) {
		Calendar fechaCalendar = Calendar.getInstance();
		fechaCalendar.setTime(fecha);

		if (fechaCalendar.get(Calendar.YEAR) == anio && fechaCalendar.get(Calendar.MONTH) == mes) {
			return true;
		}

		return false;
	}

	private boolean fechaEstaEntre(Date fechaInicio, Date fechaFin, int anio, int mes) {
		Calendar fechaInicioCalendar = Calendar.getInstance();
		fechaInicioCalendar.setTime(fechaInicio);
		Calendar fechaFinCalendar = Calendar.getInstance();
		fechaFinCalendar.setTime(fechaFin);
		
		if (fechaInicioCalendar.get(Calendar.YEAR) < anio && fechaFinCalendar.get(Calendar.YEAR) > anio) {
			return true;
			
		}
		if(fechaInicioCalendar.get(Calendar.YEAR) == anio && fechaFinCalendar.get(Calendar.YEAR) > anio){
			if(fechaInicioCalendar.get(Calendar.MONTH) <= mes){
				return true;
			}
		}
		if(fechaInicioCalendar.get(Calendar.YEAR) < anio && fechaFinCalendar.get(Calendar.YEAR) == anio){
			if(fechaFinCalendar.get(Calendar.MONTH) >= mes){
				return true;
			}
		}
		if(fechaInicioCalendar.get(Calendar.YEAR) == anio && fechaFinCalendar.get(Calendar.YEAR) == anio){
			if(fechaInicioCalendar.get(Calendar.MONTH) <= mes && fechaFinCalendar.get(Calendar.MONTH) >= mes){
				return true;
			}
		}

		return false;
	}

}
