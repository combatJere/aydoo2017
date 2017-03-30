package ar.edu.untref.aydoo.entities;

public class Votante extends Entidad {
	
	private int idProvincia;

	public Votante(int id, String nombre, int idPRovincia) {
		super(id, nombre);
		this.idProvincia = idPRovincia;
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
}
