package ar.edu.untref.aydoo.repository;

import java.util.LinkedList;

import ar.edu.untref.aydoo.entities.Candidato;
import ar.edu.untref.aydoo.entities.Partido;
import ar.edu.untref.aydoo.entities.Provincia;
import ar.edu.untref.aydoo.entities.Votante;
import ar.edu.untref.aydoo.entities.Voto;
import gherkin.lexer.Id;

public class Repository {

	private static Repository repository;

	private LinkedList<Voto> votos;
	private LinkedList<Provincia> provincias;
	private LinkedList<Votante> votantes;
	private LinkedList<Candidato> candidatos;
	private LinkedList<Partido> partidos;

	private Repository() {

		this.votos = new LinkedList<Voto>();

		this.provincias = new LinkedList<Provincia>();
		this.provincias.add(new Provincia(1, "Buenos Aires"));
		this.provincias.add(new Provincia(2, "Cordoba"));
		this.provincias.add(new Provincia(3, "Misiones"));

		this.votantes = new LinkedList<Votante>();
		this.votantes.add(new Votante(1, "Jeremias", 1));
		this.votantes.add(new Votante(2, "Aldana", 1));
		this.votantes.add(new Votante(3, "Silvia", 1));
		this.votantes.add(new Votante(4, "Martin", 1));
		this.votantes.add(new Votante(5, "Juliana", 2));
		this.votantes.add(new Votante(6, "Victoria", 3));
		this.votantes.add(new Votante(7, "Lucia", 3));
		this.votantes.add(new Votante(8, "Soledad", 3));

		this.candidatos = new LinkedList<Candidato>();
		this.candidatos.add(new Candidato(1, "Macri", 2));
		this.candidatos.add(new Candidato(2, "Cristina", 1));
		this.candidatos.add(new Candidato(3, "Nestor", 1));

		this.partidos = new LinkedList<Partido>();
		this.partidos.add(new Partido(1, "FPV"));
		this.partidos.add(new Partido(2, "Cambiemos"));
	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	public LinkedList<Provincia> getProvincias() {
		return provincias;
	}

	// public void setProvincias(LinkedList<Provincia> provincias) {
	// this.provincias = provincias;
	// }

	public LinkedList<Votante> getVotantes() {
		return votantes;
	}

	// public void setVotantes(LinkedList<Votante> votantes) {
	// this.votantes = votantes;
	// }

	public LinkedList<Voto> getVotos() {
		return votos;
	}

	// public void setVotos(LinkedList<Voto> votos) {
	// this.votos = votos;
	// }

	public LinkedList<Candidato> getCandidatos() {
		return candidatos;
	}

	// public void setCandidatos(LinkedList<Candidato> candidatos) {
	// this.candidatos = candidatos;
	// }

	public LinkedList<Partido> getPartidos() {
		return partidos;
	}

	// public void setPartidos(LinkedList<Partido> partidos) {
	// this.partidos = partidos;
	// }

}
