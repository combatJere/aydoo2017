package ar.edu.untref.aydoo;

import java.util.Date;
import java.util.LinkedList;

public class Libreria {
	private LinkedList<Cliente> listaClientes;

	public Libreria() {
		this.listaClientes = new LinkedList<Cliente>();
	}

	public void agragarCliente(int id, String telefono, String direccion) {
		Cliente cliente = new Cliente(id, telefono, direccion);
		listaClientes.add(cliente);
	}

	public void venderProducto(int idCliente, Date fecha, Producto producto) {
		Cliente cliente = this.obtenerCliente(idCliente);
		cliente.agregarCompra(fecha, producto);
	}

	public void venderSuscripcion(int idCliente, Date fechaInicio, Date fechaFin, Suscribible suscribible,
			boolean esAnual) {
		Cliente cliente = this.obtenerCliente(idCliente);
		cliente.agregarSuscripcion(suscribible, fechaInicio, fechaFin, esAnual);
	}

	public double calcularMontoACobrar(Date mes, int idCliente) {
		double montoMensual = 0;
		Cliente cliente = this.obtenerCliente(idCliente);
		LinkedList<Compra> comprasParaElMes = cliente.getComprasDelMes(mes);
		LinkedList<Suscripcion> suscripcionesParaElMes = cliente.getSuscripcionesDelMes(mes);
		
		for (Compra compra : comprasParaElMes) {
			montoMensual = montoMensual + compra.getProducto().getPrecioPorUnidad();
		}
		
		for (Suscripcion suscripcion : suscripcionesParaElMes) {
			montoMensual = montoMensual + suscripcion.getPrecioMensual();
		}

		return montoMensual;
	}

	private Cliente obtenerCliente(int idCliente) {
		Cliente clienteADevolver = null;

		for (Cliente cliente : listaClientes) {
			if (cliente.getId() == idCliente) {
				clienteADevolver = cliente;
				break;
			}
		}

		return clienteADevolver;
	}
}
