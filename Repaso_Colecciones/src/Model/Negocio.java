package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Negocio {

	private List<Catalogo> listaCatalogos;
	private List<Cliente> listaClientes;
	private List<Pedido> listaPedido;
	
	public Negocio() {
		this.listaCatalogos= new ArrayList<>();
		this.listaClientes= new ArrayList<>();
		this.listaPedido= new ArrayList<>();
	}
	
	public boolean addCliente(Cliente c1) {
		boolean resultado= false;
		if(listaClientes.contains(c1)) {
			resultado=false;
		}else if (!listaClientes.contains(c1)&&c1.esMayorDeEdad()) {
			listaClientes.add(c1);
			resultado=true;
		}
		
		return resultado;
	}
	
	public boolean eliminarCliente(String dni) {
		boolean resultado=false;
		
		for(Pedido p : listaPedido) {
			if(p.getCliente().getDni().equals(dni)) {
				resultado=false;
			}else {
				for(Cliente c: listaClientes) {
					if(c.getDni().equals(dni)) {
						listaClientes.remove(c);
						resultado=true;
					}
				}
			}
		}
		
		
		return resultado;
	}
	public String listarClientePorImporteVenta() {
		StringBuilder sb = new StringBuilder();
		listaPedido.sort(new Comparator<Pedido>() {

			@Override
			public int compare(Pedido o1, Pedido o2) {
				return o1.getCostePedido().compareTo(o2.getCostePedido());
			}
		});
		
		for(Pedido p : listaPedido) {
			sb.append(p.getCliente()+ System.lineSeparator());			
		}
		
		
		return sb.toString();
	}
	
	public String listarClientePorEdad() {
		StringBuilder sb = new StringBuilder();
		listaClientes.sort(new Comparator<Cliente>() {

			@Override
			public int compare(Cliente o1, Cliente o2) {
				return o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento());
			}
		});
		
		for(Cliente c : listaClientes) {
			sb.append(c+System.lineSeparator());
		}
		
		return sb.toString();
	}
	
	public String mostrarProductosPorCliente() {
		StringBuilder sb = new StringBuilder();
		
		for(Pedido p : listaPedido) {
			sb.append(p.getCliente());
			sb.append(p.getNumeroProductos());
			sb.append(System.lineSeparator());
		}
		
		
		return sb.toString();
	}
	public String mostrarPedidosYLineasPorId() {
		StringBuilder sb = new StringBuilder();
		listaPedido.sort(new Comparator<Pedido>() {

			@Override
			public int compare(Pedido o1, Pedido o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});
		
		for(Pedido p : listaPedido) {
			p.getListaLineas().sort(new Comparator<Linea>() {

				@Override
				public int compare(Linea o1, Linea o2) {
					return o1.getId().compareTo(o2.getId());
				}
			});
			sb.append(p);
			sb.append(System.lineSeparator());
		}
				
		
		return sb.toString();
	}
	
	public String mostrarPedidosYLineasPorPrecio() {
		StringBuilder sb = new StringBuilder();
		
		listaPedido.sort(new Comparator<Pedido>() {

			@Override
			public int compare(Pedido o1, Pedido o2) {
				return o1.getCostePedido().compareTo(o2.getCostePedido());
			}
		});
		
		for(Pedido p : listaPedido) {
			
			p.getListaLineas().sort(new Comparator<Linea>() {

				@Override
				public int compare(Linea o1, Linea o2) {
					return o1.getImporte().compareTo(o2.getImporte());
				}
			});
			sb.append(p);
			sb.append(System.lineSeparator());
		}
		
		
		return sb.toString();
	}
	
	public Pedido pedidoConMayorCantidadTotalDeProductos() {
		Pedido p1 = new Pedido();
		Integer cantidad=0;
		
		for(Pedido p : listaPedido) {
			if(p.getNumeroProductos()>cantidad) {
				cantidad=p.getNumeroProductos();
				p1=p;
			}
		}
		
		return p1;
	}
	
	public Pedido pedidoConPrecioUnitarioMasCaro() {
		Pedido p1= new Pedido();
		Double precioUnitario=0.0;
		
		for(Pedido p : listaPedido) {
			if ((p.getCostePedido()/p.getNumeroProductos())>precioUnitario) {
				precioUnitario=(p.getCostePedido()/p.getNumeroProductos());
				p1=p;
			}
		}
		
			
		return p1;
		
	}
	
	public Pedido pedidoConPrecioUnitarioMasBarato() {
		Pedido p1= new Pedido();
		Double precioUnitario=9999.9999;
		
		for(Pedido p : listaPedido) {
			if((p.getCostePedido()/p.getNumeroProductos())<precioUnitario) {
				precioUnitario=(p.getCostePedido()/p.getNumeroProductos());
				p1=p;
			}
		}
		
		return p1;
	}
	
	public Pedido pedidoConProductoMasCaro() {
		Pedido p1= new Pedido();
		double precio=0.0;
		
		for(Pedido p : listaPedido) {
			for(Linea l : p.getListaLineas()) {
				if(l.getProducto().getPrecioUnitario()>precio) {
					precio = l.getProducto().getPrecioUnitario();
					p1=p;
				}
			}
			
		}
		
		return p1;
	}
	
	public Pedido pedidoConProductoMasBarato() {
		Pedido p1= new Pedido();
		double precio=9999.9999;
		
		for(Pedido p : listaPedido) {
			for(Linea l : p.getListaLineas()) {
				if(l.getProducto().getPrecioUnitario()<precio) {
					precio=l.getProducto().getPrecioUnitario();
					p1=p;
				}
			}
		}
		
		
		return p1;
	}
	
	public Cliente clienteConMayorNumeroDeProductosComprado() {
		Pedido p1= new Pedido();
		Integer cantidad=0;
		for(Pedido p : listaPedido) {
			if(p.getNumeroProductos()>cantidad) {
				cantidad= p.getNumeroProductos();
				p1=p;
			}
		}
		return p1.getCliente();
	}
	
	public Map<Cliente, Double> obtenerMapaClienteVip(){
		Map<Cliente, Double> mapClienteVip= new HashMap<>();
		
		for(Pedido p:listaPedido) {
			if(!mapClienteVip.containsKey(p.getCliente())) {
				mapClienteVip.put(p.getCliente(), p.getCostePedido());
			}else {
				mapClienteVip.put(p.getCliente(), mapClienteVip.get(p.getCliente())+p.getCostePedido());
			}
		}
		
		return mapClienteVip;
	}
	
	public List<Cliente> obtenerClienteVip(){
		Map<Cliente, Double> mapaClientesVips= obtenerMapaClienteVip();
		List<Double> listaVips= new ArrayList<>(mapaClientesVips.values());
		List<Cliente> ListaDeClientesVips = new ArrayList<>();
		listaVips.sort(new Comparator<Double>() {

			@Override
			public int compare(Double o1, Double o2) {
				return o2.compareTo(o1);
			}
		});
		
		for(Cliente c: mapaClientesVips.keySet()) {
			if(listaVips.size()>1) {				
				if(mapaClientesVips.get(c).equals(listaVips.get(0))||mapaClientesVips.get(c).equals(listaVips.get(1))||mapaClientesVips.get(c).equals(listaVips.get(2))) {
					ListaDeClientesVips.add(c);
				}
			}
		}
		
		return ListaDeClientesVips;
	}
	
	public Map<Producto, Integer> obtenerMapaProductoEstrella(){
		Map<Producto, Integer> mapaDeProductos = new HashMap<>();
		
		for(Pedido p : listaPedido) {
			for(Linea l : p.getListaLineas()) {
				if(!mapaDeProductos.containsKey(l.getProducto())){
					mapaDeProductos.put(l.getProducto(), l.getCantidad());
				}else {
					mapaDeProductos.put(l.getProducto(), mapaDeProductos.get(l.getProducto())+l.getCantidad());
				}
			}
		}
		
		
		return mapaDeProductos;
	}
	
	
	public Producto obtenerProductoEstrella() {
		Map<Producto, Integer> mapaProducto= obtenerMapaProductoEstrella();
		List<Integer> listaDeCantidades= new ArrayList<>(mapaProducto.values());
		listaDeCantidades.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		Producto p1= new Producto();
		
		for(Producto p : mapaProducto.keySet()) {
			if(mapaProducto.get(p).equals(listaDeCantidades.get(0))) {
				p1=p;
			}
		}
		
		return p1;
	}
	
	public void addCatalogo(Catalogo c1) {
		listaCatalogos.add(c1);
	}
	
	public void addPedido(Pedido p1) {
		listaPedido.add(p1);
		
	}

	@Override
	public String toString() {
		return "Negocio [listaCatalogos=" + listaCatalogos + ", listaClientes=" + listaClientes + ", listaPedido="
				+ listaPedido + "]";
	}
	
}
