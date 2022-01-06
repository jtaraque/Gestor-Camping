package dominio;

public class parcela extends alojamiento {

	private int categoria;
	private int temporada;
	private int metros_cuadrados;
	private boolean[] cerca_de = new boolean[4];
	private boolean luz;
	
	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getTemporada() {
		return temporada;
	}

	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}

	public int getMetros_cuadrados() {
		return metros_cuadrados;
	}

	public void setMetros_cuadrados(int metros_cuadrados) {
		this.metros_cuadrados = metros_cuadrados;
	}

	public boolean[] getCerca_de() {
		return cerca_de;
	}

	public void setCerca_de(boolean[] cerca_de) {
		this.cerca_de = cerca_de;
	}
	
	public boolean getCerca0() {
		return cerca_de[0];
	}
	
	public void setCerca0(boolean valor) {
		this.cerca_de[0]= valor;
	}
	
	public boolean getCerca1() {
		return cerca_de[1];
	}
	
	public void setCerca1(boolean valor) {
		this.cerca_de[1]= valor;
	}
	
	public boolean getCerca2() {
		return cerca_de[2];
	}
	
	public void setCerca2(boolean valor) {
		this.cerca_de[2]= valor;
	}
	
	public boolean getCerca3() {
		return cerca_de[3];
	}
	
	public void setCerca3(boolean valor) {
		this.cerca_de[3]= valor;
	}
	
	public boolean isLuz() {
		return luz;
	}

	public void setLuz(boolean luz) {
		this.luz = luz;
	}

	public parcela(String nombre, double precio_noche, int categoria, int temporada, int metros_cuadrados, boolean[] cerca_de,
			boolean luz) {
		super(nombre, precio_noche);
		this.categoria = categoria;
		this.temporada = temporada;
		this.metros_cuadrados = metros_cuadrados;
		this.cerca_de = cerca_de;
		this.luz = luz;
	}
	
	
}
