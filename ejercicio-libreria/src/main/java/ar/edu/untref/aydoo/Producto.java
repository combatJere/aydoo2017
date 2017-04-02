package ar.edu.untref.aydoo;

public class Producto {

	protected double precioPorUnidad;

	public Producto(double precioPorUnidad) {
		this.precioPorUnidad = precioPorUnidad;
	}

	public double getPrecioPorUnidad() {
		return precioPorUnidad;
	}

	public void setPrecioPorUnidad(double precioPorUnidad) {
		this.precioPorUnidad = precioPorUnidad;
	}
}
