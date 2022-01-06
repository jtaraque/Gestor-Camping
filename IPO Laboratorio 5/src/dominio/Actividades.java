package dominio;

import java.util.ArrayList;

public class Actividades {
	private String Nombre;
	private int hora;
	private int cupo_minimo;
	private int cupo_maximo;
	private int monitor;
	private int destinatario;
	private int precio;
	private String descripcion;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getCupo_minimo() {
		return cupo_minimo;
	}
	public void setCupo_minimo(int cupo_minimo) {
		this.cupo_minimo = cupo_minimo;
	}
	public int getCupo_maximo() {
		return cupo_maximo;
	}
	public void setCupo_maximo(int cupo_maximo) {
		this.cupo_maximo = cupo_maximo;
	}
	public int getMonitor() {
		return monitor;
	}
	public void setMonitor(int monitor) {
		this.monitor = monitor;
	}
	public int getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(int destinatario) {
		this.destinatario = destinatario;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Actividades() {
		
	}
	public Actividades(String nombre, int hora, int cupo_minimo, int cupo_maximo, int monitor, int destinatario, int precio,
			String descripcion) {
		this.Nombre=nombre;
		this.hora = hora;
		this.cupo_minimo = cupo_minimo;
		this.cupo_maximo = cupo_maximo;
		this.monitor = monitor;
		this.destinatario = destinatario;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	public static ArrayList<Actividades> iniciarLista(){
		ArrayList<Actividades> miLista = new ArrayList<Actividades>();
		miLista.add(new Actividades("Futbol", 2, 3,12, 1, 1,0,"Un fútbol para descansar" ));
		miLista.add(new Actividades("Baloncesto", 3, 6,12, 1, 1,3,"Un baloncesto para competir" ));
		miLista.add(new Actividades("Campo", 2, 3,12, 1, 2,0,"Actividad por el campo" ));
		miLista.add(new Actividades("Esqui", 2, 3,12, 1, 2,10,"Esquiar" ));
		return miLista;
	}
	
}