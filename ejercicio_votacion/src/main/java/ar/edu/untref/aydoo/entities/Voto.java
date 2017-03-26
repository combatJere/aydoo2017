package ar.edu.untref.aydoo.entities;

public class Voto {

	private int idVotante;
	private int idcandidato;

	public Voto(int idVotante, int idCandidato) {
		this.setIdVotante(idVotante);
		this.setIdcandidato(idCandidato);
	}

	public int getIdVotante() {
		return idVotante;
	}

	public void setIdVotante(int idVotante) {
		this.idVotante = idVotante;
	}

	public int getIdcandidato() {
		return idcandidato;
	}

	public void setIdcandidato(int idcandidato) {
		this.idcandidato = idcandidato;
	}

}
