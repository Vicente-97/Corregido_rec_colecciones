package Model;

import java.time.LocalDate;

public class Producto {

	//Atributos de la clase Producto
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	private String nombre;
	private Integer id;
	private String descripcion;
	private Double precioUnitario;
	
	public Producto() {
		
	}
	
	
	public Producto (String nombre, String descripcion, Double precioUnitario) {
		this.nombre = nombre;
		this.descripcion= descripcion;
		this.precioUnitario= precioUnitario;
	}
	
	
	public Producto(LocalDate fechaAlta, LocalDate fechaBaja, String nombre, Integer id, String descripcion,
			Double precioUnitario) {
		super();
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.nombre = nombre;
		this.id = id;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}



	public boolean isActivo() {
		boolean resultado=false;
		if(this.fechaAlta!=null&&this.fechaBaja==null) {
			resultado=true;
		}
		return resultado;
	}


	public LocalDate getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public LocalDate getFechaBaja() {
		return fechaBaja;
	}


	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	@Override
	public String toString() {
		return " Producto: "+ this.nombre+" ," + " Descripcion: "+ this.descripcion+" ,"+" Id: "+this.id+" ,"+" Precio Unitario: "+ this.precioUnitario+" ,"+" Fecha de Alta : "+ this.fechaAlta+" ,"+" Fecha de Baja : "+this.fechaBaja+ " \n";
	}
	
	
}
