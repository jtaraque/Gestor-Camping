package dominio;

import java.net.URL;

public class usuario {
	private String nombre;
	private String foto;
	public usuario(String nombre, String foto) {
		this.nombre=nombre;
		this.foto= foto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public usuario() {
		
	}

}
