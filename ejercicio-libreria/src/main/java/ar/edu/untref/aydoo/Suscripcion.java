package ar.edu.untref.aydoo;

import java.util.Date;

public class Suscripcion {

	private static final int descuentoAnual = 20;

	private boolean esAnual;
	private Date fechaInicio;
	private Date fechaFin;
	private Suscribible suscribible;
	private Cliente cliente;

	public Suscripcion(Suscribible suscribible, Cliente cliente, Date fechaInicio, Date fechaFin, boolean esAnual) {
		this.suscribible = suscribible;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.esAnual = esAnual;
		this.setCliente(cliente);
	}

	public boolean isEsAnual() {
		return esAnual;
	}

	public void setEsAnual(boolean esAnual) {
		this.esAnual = esAnual;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Suscribible getSuscribible() {
		return suscribible;
	}

	public void setSuscribible(Suscribible suscribible) {
		this.suscribible = suscribible;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getPrecioMensual() {
		double precioPorUnidadConDescuentosAplicados;

		if (esAnual) {
			precioPorUnidadConDescuentosAplicados = suscribible.getPrecioPorUnidad()
					- ((suscribible.getPrecioPorUnidad() * descuentoAnual) / 100);
		} else {
			precioPorUnidadConDescuentosAplicados = suscribible.getPrecioPorUnidad();
		}

		return precioPorUnidadConDescuentosAplicados;
	}
}
