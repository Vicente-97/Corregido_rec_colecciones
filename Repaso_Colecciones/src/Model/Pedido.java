package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pedido {
	
	//He elejido un ArrayList por que el pedido puede tener varias lineas, puede comprar el mismo articulo dos veces.
	

	private Integer id=0;
	private String codigo;
	private Status status;
	private Cliente cliente;
	private List<Linea> listaLineas;
	private static Integer secuenciaPedidos=0;
	
	public Pedido() {
		this.cliente= new Cliente();
		this.listaLineas= new ArrayList<>();
		
	}
	
	public Pedido(String codigo, Status status, Cliente cliente) {
		this.id=secuenciaPedidos++;
		this.codigo=codigo;
		this.status=status;
		this.cliente=cliente;
		this.listaLineas= new ArrayList<>();
		this.id++;
	}
	
	public boolean addLinea(Linea linea1) {
		boolean resultado=false;
		if(!this.listaLineas.contains(linea1)) {
			this.listaLineas.add(linea1);
			resultado=true;
			
		}
		return resultado;
	}
	
	public void borrarLinea(Integer id) {
		if(this.status!=Status.ENVIADO) {
			for(Linea l : this.listaLineas) {
				if(l.getId()==id) {
					this.listaLineas.remove(l);
				}
			}
		}
	}
	
	public void vaciarPedido() {
		listaLineas.clear();
	}
	
	public Double getCostePedido() {
		Double resultado=0.0;
		
		for(Linea l: this.listaLineas) {
			resultado+=l.getImporte();
		}
		
		return resultado;
	}
	
	public Integer getNumeroProductos () {
		Integer resultado=0;
		
		for(Linea l : listaLineas) {
			resultado+=l.getCantidad();
		}
		
		return resultado;
	}
	
	public String mostrarLineasPorIdAscendiente () {
		StringBuilder sb = new StringBuilder();
		listaLineas.sort(new Comparator<Linea>() {

			@Override
			public int compare(Linea o1, Linea o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});
		
		for(Linea l: listaLineas) {
			sb.append(l+System.lineSeparator());
		}
		
		
		return sb.toString();
	}
	
	public String mostrarLineasPorPrecioDescendiente() {
		StringBuilder sb = new StringBuilder();
		
		listaLineas.sort(new Comparator<Linea>() {

			@Override
			public int compare(Linea o1, Linea o2) {
				return o1.getImporte().compareTo(o2.getImporte());
			}
		});
		
		for(Linea l : listaLineas) {
			sb.append(l+System.lineSeparator());
		}
		
		return sb.toString();
	}
	
	public String obtenerProductos() {
		StringBuilder sb = new StringBuilder();
		
		for(Linea l : listaLineas) {
			 sb.append(l.getProducto());
			 sb.append(System.lineSeparator());
			 
				
			}
				
		return sb.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Linea> getListaLineas() {
		return listaLineas;
	}

	public void setListaLineas(List<Linea> listaLineas) {
		this.listaLineas = listaLineas;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", codigo=" + codigo + ", status=" + status + ", cliente=" + cliente
				+ ", listaLineas=" + listaLineas + "]";
	}
	

}
