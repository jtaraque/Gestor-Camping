package dominio;

public class Ruta {

	private String nombre;
	private String dia;
	private String hora_inicio;
	private String hora_fin;
	private String monitor;
	private String encuentro;
	private int personas;
	private String descripcion;
	private String mapa;
	public Ruta(String nombre, String dia, String hora_inicio, String hora_fin, String monitor,String encuentro, int personas,String descripcion,String mapa) {
		super();
		this.nombre = nombre;
		this.dia = dia;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.monitor = monitor;
		this.encuentro = encuentro;
		this.personas = personas;
		this.descripcion=descripcion;
		this.mapa = mapa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public String getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public int getPersonas() {
		return personas;
	}
	public void setPersonas(int personas) {
		this.personas = personas;
	}
	public String getEncuentro() {
		return encuentro;
	}
	public void setEncuentro(String encuentro) {
		this.encuentro = encuentro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMapa() {
		return mapa;
	}
	public void setMapa(String mapa) {
		this.mapa = mapa;
	}

}
