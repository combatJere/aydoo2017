package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.entities.Voto;
import ar.edu.untref.aydoo.repository.ConsultorDatosElectorales;

public class Votaciones {
	
	private ConsultorDatosElectorales consultorDatos;
	
	public Votaciones(){
		consultorDatos = new ConsultorDatosElectorales();
	}

	public void emitirVoto(int idVotante, int idCandidato){
		Voto voto = new Voto(idVotante, idCandidato);
		consultorDatos.agregarVoto(voto);
	}
	
	public String getCandidatoConMasVotos(){
		int idCandidato =  consultorDatos.getCandidatoConMasVotos();
		return consultorDatos.getNombreCandidato(idCandidato);
	}
	
	public String getPartidoConMasVotosEnProvincia(int idProvincia){
		int idPartido = consultorDatos.getPartidoConMasVotosEnProvincia(idProvincia);
		return consultorDatos.getNombrePartido(idPartido);
	}
	
	public String getPartidoConMasVotosEnProvincia(String nombreProvincia){
		int idProvincia = consultorDatos.getIdProvincia(nombreProvincia);
		return this.getPartidoConMasVotosEnProvincia(idProvincia);
	}
}
