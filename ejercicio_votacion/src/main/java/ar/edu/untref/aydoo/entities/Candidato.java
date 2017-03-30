package ar.edu.untref.aydoo.entities;

public class Candidato extends Entidad {

	private int idPartido;
	
	public Candidato(int id, String nombre, int idPartido) {
		super(id, nombre);
		this.idPartido = idPartido;
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idProvincia) {
		this.idPartido = idProvincia;
	}

}
