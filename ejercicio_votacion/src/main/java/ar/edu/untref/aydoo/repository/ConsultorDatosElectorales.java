package ar.edu.untref.aydoo.repository;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.OptionalInt;
import ar.edu.untref.aydoo.entities.Candidato;
import ar.edu.untref.aydoo.entities.Partido;
import ar.edu.untref.aydoo.entities.Provincia;
import ar.edu.untref.aydoo.entities.Votante;
import ar.edu.untref.aydoo.entities.Voto;

public class ConsultorDatosElectorales {

	public void agregarVoto(Voto voto) {
		LinkedList<Voto> listaVotos = DatosElectorales.getInstance().getVotos();
		listaVotos.add(voto);
	}

	public int getCandidatoConMasVotos() {
		LinkedList<Voto> listaVotos = DatosElectorales.getInstance().getVotos();

		int[] votosPorCandidato = new int[this.getCantidadDeCandidatos() + 1];

		for (Voto voto : listaVotos) {
			votosPorCandidato[voto.getIdcandidato()]++;
		}

		return this.obtenerIdDelMaximo(votosPorCandidato);
	}

	public int getPartidoConMasVotosEnProvincia(int idProvincia) {
		LinkedList<Voto> listaVotos = DatosElectorales.getInstance().getVotos();

		int[] votosPorPartido = new int[this.getCantidadDePartidos() + 1];

		Iterator<Voto> itVotos = listaVotos.iterator();

		Voto voto;

		while (itVotos.hasNext()) {
			voto = itVotos.next();
			if (this.getProvinciaVotante(voto.getIdVotante()) == idProvincia) {
				int idPartidoCandidato = this.getPartidoCandidato(voto.getIdcandidato());
				votosPorPartido[idPartidoCandidato]++;
			}
		}

		return this.obtenerIdDelMaximo(votosPorPartido);
	}

	public String getNombreCandidato(int idCandidato) {
		LinkedList<Candidato> listaCandidatos = DatosElectorales.getInstance().getCandidatos();
		for (Candidato candidato : listaCandidatos) {
			if (candidato.getId() == idCandidato) {
				return candidato.getNombre();
			}
		}
		return "Candidato Inexistente";
	}

	public String getNombrePartido(int idPartido) {
		LinkedList<Partido> listaPartidos = DatosElectorales.getInstance().getPartidos();
		for (Partido partido : listaPartidos) {
			if (partido.getId() == idPartido) {
				return partido.getNombre();
			}
		}
		return "Partido Inexistente";
	}
	
	public int getIdProvincia(String nombreProvincia) {
		LinkedList<Provincia> listaProvincias = DatosElectorales.getInstance().getProvincias();
		for (Provincia provincia : listaProvincias) {
			if (provincia.getNombre() == nombreProvincia) {
				return provincia.getId();
			}
		}
		return 0;
	}

	private int getCantidadDeCandidatos() {
		return DatosElectorales.getInstance().getCandidatos().size();
	}

	private int getCantidadDePartidos() {
		return DatosElectorales.getInstance().getPartidos().size();
	}

	private int obtenerIdDelMaximo(int[] array) {
		OptionalInt maximoVotos = Arrays.stream(array).max();

		for (int idEntidad = 1; idEntidad < array.length; idEntidad++) {
			if (array[idEntidad] == maximoVotos.getAsInt()) {
				return idEntidad;
			}
		}

		return 0;
	}

	private int getProvinciaVotante(int idVotante) {
		LinkedList<Votante> listaVotantes = DatosElectorales.getInstance().getVotantes();
		for (Votante votante : listaVotantes) {
			if (votante.getId() == idVotante) {
				return votante.getIdProvincia();
			}
		}
		return 0;
	}

	private int getPartidoCandidato(int idCandidato) {
		LinkedList<Candidato> listaCandidatos = DatosElectorales.getInstance().getCandidatos();
		for (Candidato candidato : listaCandidatos) {
			if (candidato.getId() == idCandidato) {
				return candidato.getIdPartido();
			}
		}
		return 0;
	}

}
