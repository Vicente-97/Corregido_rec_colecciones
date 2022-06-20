package Main;

import java.time.LocalDate;

import Model.Catalogo;
import Model.Cliente;
import Model.Genero;
import Model.Linea;
import Model.Negocio;
import Model.Pedido;
import Model.Producto;
import Model.Status;

public class MainApp {

	public static void main(String[] args) {

		Producto p1 = new Producto(LocalDate.of(2022, 5, 5), null, "Tomate", 12, "Tomate cherry", 7.0);
		Producto p2 = new Producto(LocalDate.of(2022, 5, 5), LocalDate.of(2022, 6, 6) , "Tomate", 10, "Tomate cherry", 3.0);
		Producto p3 = new Producto(LocalDate.of(2022, 5, 5), null, "Queso", 15, "Queso asturias", 12.0);
		
		//System.out.println(p1.isActivo());//true
		//System.out.println(p2.isActivo());//false
		
		Linea linea1 = new Linea("01", p1, 5, 2.0);
		Linea linea2 = new Linea("02", p2, 16, 2.0);
		Linea linea3 = new Linea("03", p3, 60, 2.0);
		
		//System.out.println(linea1.toString());//Comprobacion si esta bien el importe.
		//System.out.println(linea1.addProducto(p2));//false ya que tiene fecha de baja.
		//System.out.println(linea1.addProducto(p1));//true
		//System.out.println(linea1.eliminarProducto(10));//10 corresponde al id del producto 1, por lo tanto true.
		//System.out.println(linea1.vaciarLinea());
		//System.out.println(linea1.toString());//linea vacia, arriba utilizo vaciar linea
		
		Cliente c1= new Cliente(1, "Vicente", "Villarreal Hinojo", "vicen@gmail.com", "47589966-K", LocalDate.of(1997, 6, 6), Genero.HOMBRE);
		Cliente c2= new Cliente(2, "rosa", "Rosarini", "rosa@gmail.com", "47589986-K", LocalDate.of(1999, 6, 6), Genero.MUJER);
		Cliente c3= new Cliente(3, "Manuel", "Manolito", "manolo@gmail.com", "47589766-K", LocalDate.of(1987, 6, 6), Genero.HOMBRE);
		//System.out.println(c1.esMayorDeEdad());//true, por que es mayor de edad, nacio en 1997.
		
		Pedido pedido1 = new Pedido("01", Status.ENVIADO, c1);
		pedido1.addLinea(linea2);
		
		
		Pedido pedido2 = new Pedido("02", Status.ENVIADO, c2);
		pedido2.addLinea(linea2);
		pedido2.addLinea(linea3);
		pedido2.addLinea(linea2);
		
		
		Pedido pedido3 = new Pedido("03", Status.ENVIADO, c3);
		pedido3.addLinea(linea1);
		
		
		Catalogo catalogo1 = new Catalogo();
		catalogo1.addProductoCatalogo(p1);
		catalogo1.addProductoCatalogo(p2);
		catalogo1.addProductoCatalogo(p3);
		
		//System.out.println(catalogo1.mostrarProductosActivos());//funciona
		//System.out.println(catalogo1.mostrarProductos()); funciona
		//System.out.println(pedido1.mostrarLineasPorPrecioDescendiente());//funciona
		//System.out.println(pedido1.mostrarLineasPorIdAscendiente());//funciona
		
		//System.out.println(pedido1.getCostePedido());//funciona
		//System.out.println(pedido1.obtenerProductos());//funciona
		//System.out.println(pedido1.getNumeroProductos());//funciona
		//System.out.println(pedido1.toString());
		
		Negocio n1 = new Negocio();
		
		n1.addCatalogo(catalogo1);
		n1.addCliente(c1);
		n1.addPedido(pedido1);
		n1.addPedido(pedido3);
		n1.addPedido(pedido2);
		//System.out.println(n1.mostrarPedidosYLineasPorId()); // 
		//System.out.println(n1.mostrarPedidosYLineasPorPrecio()); funciona
		//System.out.println(n1.pedidoConMayorCantidadTotalDeProductos()); funciona
		//System.out.println(n1.pedidoConPrecioUnitarioMasCaro());
		//System.out.println(n1.pedidoConProductoMasCaro()); funciona
		//System.out.println(n1.clienteConMayorNumeroDeProductosComprado());
		
		//System.out.println(n1.obtenerClienteVip());
		//System.out.println(n1.obtenerProductoEstrella());
	}

}
