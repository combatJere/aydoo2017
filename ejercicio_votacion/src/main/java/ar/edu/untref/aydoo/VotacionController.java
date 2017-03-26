package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.entities.Voto;
import ar.edu.untref.aydoo.repository.RepositoryService;

public class VotacionController {
	
	private RepositoryService repositoryService;
	
	public VotacionController(){
		repositoryService = new RepositoryService();
	}

	public void emitirVoto(int idVotante, int idCandidato){
		Voto voto = new Voto(idVotante, idCandidato);
		repositoryService.agregarVoto(voto);
	}
	
	public String getCandidatoConMasVotos(){
		int idCandidato =  repositoryService.getCandidatoConMasVotos();
		return repositoryService.getNombreCandidato(idCandidato);
	}
	
	public String getPartidoConMasVotosEnProvincia(int idProvincia){
		int idPartido = repositoryService.getPartidoConMasVotosEnProvincia(idProvincia);
		return repositoryService.getNombrePartido(idPartido);
	}
	
	public String getPartidoConMasVotosEnProvincia(String nombreProvincia){
		int idProvincia = repositoryService.getIdProvincia(nombreProvincia);
		return this.getPartidoConMasVotosEnProvincia(idProvincia);
	}
}
