package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {

	private double iva;
	
	public ArticuloDeLibreria(double precioPorUnidad, int iva) {
		super(precioPorUnidad);
		this.setIva(iva);
	}
	
	public double getPrecioPorUnidad(){
		return precioPorUnidad + ((precioPorUnidad * iva) / 100);
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

}
