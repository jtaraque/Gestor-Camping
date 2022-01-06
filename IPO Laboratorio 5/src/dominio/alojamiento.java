package dominio;

public class alojamiento {
	private double precio_noche;
	private String nombre;

	public alojamiento(String nombre, double precio_noche) {
		this.nombre=nombre;
		this.precio_noche = precio_noche;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio_noche() {
		return precio_noche;
	}

	public void setPrecio_noche(double precio_noche) {
		this.precio_noche = precio_noche;
	}
}
