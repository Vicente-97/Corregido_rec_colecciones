package Model;

import java.time.LocalDate;

public class Cliente {

	private static final int MAYOR_EDAD = 18;
	private Integer id;
	private String nombre;
	private String apellidos;
	private String email;
	private String dni;
	private LocalDate fechaNacimiento;
	private Genero genero;
	
	public Cliente () {
		
	}

	public Cliente(Integer id, String nombre, String apellidos, String email, String dni, LocalDate fechaNacimiento,
			Genero genero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}
	
	public boolean esMayorDeEdad () {
		boolean resultado=false;
		
		if (LocalDate.now().getYear()-this.getFechaNacimiento().getYear()>=MAYOR_EDAD) {
			resultado=true;
		}
		
		return resultado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", dni="
				+ dni + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + "]";
	}
	
	
}
