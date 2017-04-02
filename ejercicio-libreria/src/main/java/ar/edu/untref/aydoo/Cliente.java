package ar.edu.untref.aydoo;

import java.util.Date;
import java.util.LinkedList;

public class Cliente {

	private int id;
	private String telefono;
	private String direccion;
	private LinkedList<Compra> compras;
	private LinkedList<Suscripcion> suscripciones;
	
	public Cliente(int id, String telefono, String direccion){
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
	

	public LinkedList<Compra> getComprasDelMes(Date mes){
		//TODO
		return new LinkedList<Compra>();
	}
	
	public LinkedList<Suscripcion> getSuscripcionesDelMes(Date mes){
		//TODO
		return new LinkedList<Suscripcion>();
	}
	
}
