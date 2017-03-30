package ar.edu.untref.aydoo.entities;

public class Entidad {
	
	private int id;
	private String nombre;

	public Entidad(int id, String nombre){
		this.id = id;
		this.setNombre(nombre);
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
