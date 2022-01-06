package dominio;

import java.net.MalformedURLException;
import java.net.URL;

import presentacion.VentanaTabbed;

public class datosUsuario {
	
	private String nombre;
	public int esValido(String nombre, String contrasenia) {
		if(nombre.equals("angel")) {
			if(contrasenia.equals("123456aB"))
				return 0;
			else
				return 1;
		}
		else if(nombre.equals("juanto")) {
			if(contrasenia.equals("123456aB"))
				return 0;
			else
				return 1;
		}
		else
			return 2;
	}
	
	public datosUsuario() {
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
}
