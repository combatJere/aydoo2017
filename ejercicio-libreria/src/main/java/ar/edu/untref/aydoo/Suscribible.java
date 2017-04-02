package ar.edu.untref.aydoo;

public class Suscribible extends Producto {

	private int cantEjemplaresMensuales;

	public Suscribible(double precioPorUnidad, int cantEjemplaresMensuales) {
		super(precioPorUnidad);
		this.setCantEjemplaresMensuales(cantEjemplaresMensuales);
	}

	public int getCantEjemplaresMensuales() {
		return cantEjemplaresMensuales;
	}

	public void setCantEjemplaresMensuales(int cantEjemplaresMensuales) {
		this.cantEjemplaresMensuales = cantEjemplaresMensuales;
	}
}
