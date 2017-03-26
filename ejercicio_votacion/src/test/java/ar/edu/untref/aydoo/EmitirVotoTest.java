package ar.edu.untref.aydoo;

import org.junit.Test;
import ar.edu.untref.aydoo.entities.Voto;
import ar.edu.untref.aydoo.repository.Repository;
import org.junit.Assert;

public class EmitirVotoTest {
	
	@Test
	public void EmitirVotoExito() {
		Repository.getInstance().getVotos().clear();
		
		int cantidadDeVotosAntes = Repository.getInstance().getVotos().size();
		
		VotacionController votacionController = new VotacionController();		
		votacionController.emitirVoto(2, 3);
		
		int cantidadDeVotosDespues = Repository.getInstance().getVotos().size();

		Voto votoAgregado = Repository.getInstance().getVotos().getFirst();
		
		Assert.assertEquals(0, cantidadDeVotosAntes);
		Assert.assertEquals(1, cantidadDeVotosDespues);
		Assert.assertEquals(2, votoAgregado.getIdVotante());
		Assert.assertEquals(3, votoAgregado.getIdcandidato());
	}
}