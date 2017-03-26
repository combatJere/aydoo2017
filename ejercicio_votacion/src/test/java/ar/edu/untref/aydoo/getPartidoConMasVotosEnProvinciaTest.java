package ar.edu.untref.aydoo;

import org.junit.Test;
import ar.edu.untref.aydoo.entities.Voto;
import ar.edu.untref.aydoo.repository.Repository;
import org.junit.Assert;

public class getPartidoConMasVotosEnProvinciaTest {
	
	@Test
	public void PartidoConMasVotosEnProvinciaTest() {
		VotacionController votacionController = new VotacionController();		
		votacionController.emitirVoto(1, 1);
		votacionController.emitirVoto(3, 2);
		votacionController.emitirVoto(4, 3);
		votacionController.emitirVoto(5, 1);
		votacionController.emitirVoto(6, 3);
		votacionController.emitirVoto(7, 3);
		votacionController.emitirVoto(8, 3);
		
		String candidatoMasVotado = votacionController.getPartidoConMasVotosEnProvincia("Buenos Aires");
		
		
		Assert.assertEquals("FPV", candidatoMasVotado);
	}
}