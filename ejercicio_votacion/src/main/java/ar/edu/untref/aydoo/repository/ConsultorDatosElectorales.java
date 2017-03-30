package ar.edu.untref.aydoo.repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
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

		HashMap<Integer,Integer> candidatoCantidadVotos = this.crearMapCandidatoConCantidadVotos();

		for (Voto voto : listaVotos) {
			int cantidadActualVotos = candidatoCantidadVotos.get(voto.getIdcandidato()) + 1;
			candidatoCantidadVotos.put(voto.getIdcandidato(), cantidadActualVotos++);
		}

		return this.obtenerIdDelMaximo(candidatoCantidadVotos);
	}

	public int getPartidoConMasVotosEnProvincia(int idProvincia) {
		LinkedList<Voto> listaVotos = DatosElectorales.getInstance().getVotos();

		HashMap<Integer,Integer> partidoCantidadVotos = this.crearMapPartidoConCantidadVotos();

		Iterator<Voto> itVotos = listaVotos.iterator();

		Voto voto;

		while (itVotos.hasNext()) {
			voto = itVotos.next();
			if (this.getProvinciaVotante(voto.getIdVotante()) == idProvincia) {
				int idPartidoCandidato = this.getPartidoCandidato(voto.getIdcandidato());
				int cantidadActualVotos = partidoCantidadVotos.get(idPartidoCandidato) + 1;
				partidoCantidadVotos.put(idPartidoCandidato, cantidadActualVotos++);
			}
		}

		return this.obtenerIdDelMaximo(partidoCantidadVotos);
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

	private HashMap<Integer,Integer> crearMapCandidatoConCantidadVotos(){
		LinkedList<Candidato> listaCandidatos = DatosElectorales.getInstance().getCandidatos();
		HashMap<Integer,Integer> candidatoCantidadVotos = new HashMap<>();
		
		for (Candidato candidato : listaCandidatos) {
			candidatoCantidadVotos.put(candidato.getId(), 0);
		}
		return candidatoCantidadVotos;
	}
	
	private HashMap<Integer,Integer> crearMapPartidoConCantidadVotos(){
		LinkedList<Partido> listaPartidos = DatosElectorales.getInstance().getPartidos();
		HashMap<Integer,Integer> partidoCantidadVotos = new HashMap<>();
		
		for (Partido partido : listaPartidos) {
			partidoCantidadVotos.put(partido.getId(), 0);
		}
		return partidoCantidadVotos;
	}
	
	private int obtenerIdDelMaximo(HashMap<Integer,Integer> idConvotos){
		Map.Entry<Integer, Integer> maxEntry = null;

		for (Map.Entry<Integer, Integer> entry : idConvotos.entrySet())
		{
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		    {
		        maxEntry = entry;
		    }
		}
		
		return maxEntry.getKey();
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
