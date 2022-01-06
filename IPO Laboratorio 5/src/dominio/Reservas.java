package dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reservas {
	
	private alojamiento miAlojamiento;
	private Date entrada;
	private Date salida;
	private String cliente;
	private String telefono;
	private String emailString;
	private int ocupantes;
	private boolean[] solicitudes= new boolean[4];
	String Date_format ="dd/MM/yyyy";
	SimpleDateFormat sdf = new SimpleDateFormat(Date_format);
	
	public alojamiento getMiAlojamiento() {
		return miAlojamiento;
	}

	public void setMiAlojamiento(alojamiento miAlojamiento) {
		this.miAlojamiento = miAlojamiento;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSalida() {
		return salida;
	}

	public void setSalida(Date salida) {
		this.salida = salida;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public int getOcupantes() {
		return ocupantes;
	}

	public void setOcupantes(int ocupantes) {
		this.ocupantes = ocupantes;
	}

	public boolean[] getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(boolean[] solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	public boolean getSol0() {
		return solicitudes[0];
	}
	
	public void setSol0(boolean value) {
		this.solicitudes[0]=value;
	}
	
	public boolean getSol1() {
		return solicitudes[1];
	}
	
	public void setSol1(boolean value) {
		this.solicitudes[1]=value;
	}
	
	public boolean getSol2() {
		return solicitudes[2];
	}
	
	public void setSol2(boolean value) {
		this.solicitudes[2]=value;
	}
	
	public boolean getSol3() {
		return solicitudes[3];
	}
	
	public void setSol3(boolean value) {
		this.solicitudes[3]=value;
	}
	
	public static Date changeFormat(String sDate) {
		Date date1 = null;
		try {
			if (sDate != null && !sDate.isEmpty() && !sDate.equals("__/__/____")) {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date1;
	}
	
	public static boolean compararFormato(String fecha) {
		Pattern patron = Pattern.compile("dd/MM/yyyy");
		Matcher mat = patron.matcher(fecha);
		if(mat.matches()) {
			return true;
		}else {
			return false;
		}
	}
	
	public Reservas(alojamiento miAlojamiento, String entrada, String salida, String cliente,
			String telefono, String emailString, int ocupantes, boolean[] solicitudes) {
		this.miAlojamiento = miAlojamiento;
		this.entrada = changeFormat(entrada);
		this.salida = changeFormat(salida);
		this.cliente = cliente;
		this.telefono = telefono;
		this.emailString = emailString;
		this.ocupantes = ocupantes;
		this.solicitudes = solicitudes;
	}
	
	public static ArrayList<Reservas> iniciarReservas(){
		ArrayList<Reservas> listaReservas =new ArrayList<Reservas>();
		boolean[] arraybool = {false,true,true,true};
		boolean[] arraybool5 = {false,true,false,true};
		bungalow bun1 = new bungalow("bungalow 1", 70.0, 90,1,10,arraybool);
		listaReservas.add(new Reservas(bun1,"12/01/2021", "20/01/2021","Pepe", "600600600", "hola@gmail.com", 3,arraybool5 ));
		return listaReservas;
	}
	
	@Override
	public String toString() {
		return "Alojamiento: " + miAlojamiento.getNombre() + "\nFecha de entrada: " + sdf.format(entrada) + "\nFecha Salida=" + sdf.format(salida) +"\n";
	}
}
