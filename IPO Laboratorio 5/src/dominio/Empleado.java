package dominio;

import java.net.URL;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import presentacion.TabEmpleados;

public class Empleado {
	
	private String nombre;
	private String apellidos;
	private String telefono;
	private String dni;
	private String email;
	private String formacion;
	private Icon imagen;
	public Empleado(String nombre, String apellidos, String telefono, String dni, String email, String formacion, Icon icon) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.dni = dni;
		this.email = email;
		this.formacion = formacion;
		this.imagen=icon;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFormacion() {
		return formacion;
	}
	public void setFormacion(String formacion) {
		this.formacion = formacion;
	}
	public Icon getImagen() {
		return imagen;
	}
	public void setImagen(Icon imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "Empleado [nombre="+ nombre + "apellidos=" + apellidos + "telefono=" + telefono + "dni=" + dni
				+ "email=" + email + "formacion=" + formacion + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
	
	public static ArrayList<Empleado> iniciarLista (){
		ArrayList<Empleado> miLista =new ArrayList<Empleado>();
		miLista.add(new Empleado("Angel","Gamero Corroto", "666555444", "12345678Z", "holasoyangel@gmail.com", "1 anio de experiencia",new ImageIcon(TabEmpleados.class.getResource("/presentacion/custo.png")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
		miLista.add(new Empleado("Juan Tomas","Araque Martin", "666555443", "12345677J", "holasoyjuanto@gmail.com", "2 anios de experiencia",new ImageIcon(TabEmpleados.class.getResource("/presentacion/juanto.png")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
		return miLista;
		
	}
}
