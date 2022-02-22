import java.util.Collection;
import java.util.HashMap;

public class Carritos {
	
	private HashMap<Integer, Articulos> listaCarrito = new HashMap<Integer, Articulos>();
	
	public HashMap<Integer, Articulos> getListaCarrito() {
		return listaCarrito;
	}

	public void agregarArticulo(Articulos x) {
		listaCarrito.put(x.getCodigo(), x);
	}
	
	public int generarTotal() {
		
		int total = 0;
		
		Collection<Articulos> listaCar = listaCarrito.values();
		
		for ( Articulos artic : listaCar ) {
			
			total = total + artic.getPrecio() * artic.getCantidadEnCarrito();
			
		}
		
		return total;
		
	}
	
	public void generarFactura() {
		
		Collection<Articulos> listaCar = listaCarrito.values();
		
		System.out.println("---------------------------------------");
		System.out.println("              FACTURA                  ");
		System.out.println("");
		
		for ( Articulos artic : listaCar ) {
			
			System.out.println("Producto: " + artic.getNombre() + " || Precio por unidad: " + artic.getPrecio() + " || Cantidad de unidades: " + artic.getCantidadEnCarrito());
			
		}

		System.out.println("Precio Total: $" + generarTotal());
		System.out.println("Gracias por su compra!");
		System.out.println("");
		System.out.println("---------------------------------------");
		
	}

	
	public HashMap<Integer, Articulos> getListaCarrito2() {
		return listaCarrito;
	}

}
