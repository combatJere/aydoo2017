package ar.edu.untref.aydoo.entities;

public class Candidato extends Entity {

	private int idPartido;
	
	public Candidato(int id, String nombre) {
		super(id, nombre);
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idProvincia) {
		this.idPartido = idProvincia;
	}

}
