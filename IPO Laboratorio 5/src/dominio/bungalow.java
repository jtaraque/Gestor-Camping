package dominio;

public class bungalow extends alojamiento {
	
	private int metros_cuadrados;
	private int tamanio;
	private int capacidad_maxima;
	private boolean [] caracteristicas =new boolean[4];
	
	
	public int getMetros_cuadrados() {
		return metros_cuadrados;
	}


	public void setMetros_cuadrados(int metros_cuadrados) {
		this.metros_cuadrados = metros_cuadrados;
	}


	public int gettamanio() {
		return tamanio;
	}


	public void settamanio(int tamanio) {
		this.tamanio = tamanio;
	}


	public int getCapacidad_maxima() {
		return capacidad_maxima;
	}


	public void setCapacidad_maxima(int capacidad_maxima) {
		this.capacidad_maxima = capacidad_maxima;
	}



	public boolean[] getCaracteristicas() {
		return caracteristicas;
	}


	public void setCaracteristicas(boolean[] caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	public boolean getCar0() {
		return caracteristicas[0];
	}
	
	public void setCar0(boolean value) {
		this.caracteristicas[0]=value;
	}
	public boolean getCar1() {
		return caracteristicas[1];
	}
	
	public void setCar1(boolean value) {
		this.caracteristicas[1]=value;
	}
	
	public boolean getCar2() {
		return caracteristicas[2];
	}
	
	public void setCar2(boolean value) {
		this.caracteristicas[2]=value;
	}
	
	public boolean getCar3() {
		return caracteristicas[3];
	}
	
	public void setCar3(boolean value) {
		this.caracteristicas[3]=value;
	}

	public bungalow(String nombre, double precio_noche,int metros_cuadrados, int tamanio, int capacidad_maxima,
			boolean[] caracteristicas) {
		super(nombre, precio_noche);
		this.metros_cuadrados = metros_cuadrados;
		this.tamanio = tamanio;
		this.capacidad_maxima = capacidad_maxima;
		this.caracteristicas = caracteristicas;
	}


	

}
