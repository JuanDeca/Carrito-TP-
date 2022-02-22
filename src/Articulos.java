
public class Articulos {
	
	private String nombre;
	private String descripcion;
	private int precio;
	private int codigo;
	
	public int getCantidadEnCarrito() {
		return cantidadEnCarrito;
	}

	public void setCantidadEnCarrito(int cantidadEnCarrito) {
		this.cantidadEnCarrito = cantidadEnCarrito;
	}
	
	private int stock;
	private int cantidadEnCarrito;
	
	public Articulos(String nombre, String descripcion, int precio, int codigo, int stock ) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.codigo = codigo;
		this.stock = stock;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

}
