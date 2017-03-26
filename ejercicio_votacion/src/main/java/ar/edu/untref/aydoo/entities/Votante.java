package ar.edu.untref.aydoo.entities;

public class Votante extends Entity {
	
	private int idProvincia;

	public Votante(int id, String nombre) {
		super(id, nombre);
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
}
