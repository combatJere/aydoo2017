package ar.edu.untref.aydoo;

import java.util.Date;

public class Compra {

	private Date fecha;
	private Producto producto;
	private Cliente cliente;
	
	public Compra (Date fecha, Producto producto, Cliente cliente) {
		this.setFecha(fecha);
		this.setProducto(producto);
		this.setCliente(cliente);
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
