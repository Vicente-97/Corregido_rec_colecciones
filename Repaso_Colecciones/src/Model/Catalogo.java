package Model;

import java.util.HashSet;
import java.util.Set;

public class Catalogo {
	
	//he elegido un set puesto que considero que en el catálogo no puede haber productos repetidos.

	private Set<Producto> listaProductos;
	
	public Catalogo() {
		this.listaProductos= new HashSet<>();
	}
	
	public void  addProductoCatalogo(Producto p1) {
		listaProductos.add(p1);
	}
	
	public String mostrarProductos() {
		StringBuilder sb = new StringBuilder();
		
		for(Producto p : listaProductos) {
			sb.append(p+System.lineSeparator());
		}
		
		return sb.toString();
	}
	
	public String mostrarProductosActivos() {
		StringBuilder sb = new StringBuilder();
		
		for(Producto p : listaProductos) {
			if (p.isActivo()) {
				sb.append(p+System.lineSeparator());
			}
		}
			
		return sb.toString();
	}

	@Override
	public String toString() {
		return "Catalogo [listaProductos=" + listaProductos + "]";
	}
	
}
