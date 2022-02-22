import java.util.Scanner;
import java.util.Collection;
import java.util.HashMap;

public class Procesos {
	
	HashMap<String, Usuario> listaUsuarios = new HashMap<String, Usuario>();
	
	HashMap<Integer, Articulos> listaArticulos = new HashMap<Integer, Articulos>();

	HashMap<String, Carritos> listaCarritos = new HashMap<String, Carritos>();
	
	Usuario usuarioLogueado;

	Scanner sc = new Scanner(System.in);
	
	public void mostrarMenuInicio() {
			
		String v1;
			
		System.out.println("Bienvenido, seleccione una opcion");
		System.out.println("1 -  Iniciar sesion");
		System.out.println("2 -  Crear Cuenta");
		v1 = sc.next();
			
		if (v1.equals("1")) {
			iniciarSesion();
		} else if (v1.equals("2")) {
			crearCuenta();
		}
			
	}
	
	public void mostrarMenuCliente() {

		System.out.println("");
		System.out.println("Seleccione una opcion");
		System.out.println("1 - Ver articulos disponibles");
		System.out.println("2 - Ver mi carrito");
		System.out.println("3 - Agregar dinero");
		System.out.println("4 - Transferir dinero");
		System.out.println("5 - Retirar dinero");
		System.out.println("6 - Cerrar sesion");
		String v1 = sc.next();
		
		switch (v1) {
			case "1":
				verArticulos();
				break;
			case "2":
				verMiCarrito();
				break;
			case "3":
				agregarDinero();
				break;
			case "4":
				transferirDinero();
				break;
			case "5":
				retirarDinero();
				break;
			case "6":
				cerrarSesion();
				break;
			default:
				mostrarMenuCliente();
				break;
		}
		
	}
	
	public void mostrarMenuEmpleado() {

		System.out.println("");
		System.out.println("Seleccione una opcion");
		System.out.println("1 - Cargar nuevo articulo");
		System.out.println("2 - Editar articulo");
		System.out.println("3 - Eliminar articulo");
		System.out.println("4 - Cerrar sesion");
		
		String v1 = sc.next();
		
		switch (v1) {
			case "1":
				cargarArticulo();
				break;
			case "2":
				editarArticulo();
				break;
			case "3":
				eliminarArticulo();
				break;
			case "4":
				cerrarSesion();
				break;
			default:
				mostrarMenuEmpleado();
				break;
		}
		
	}
	
	public void iniciarSesion() {

		System.out.println("Ingrese su nombre de usuario");
		String v1 = sc.next();
		
		System.out.println("Ingrese su contraseña");
		String v2 = sc.next();
		
		if (listaUsuarios.get(v1) == null) {
			
			System.out.println("Error: El nombre de usuario no se encuentra en el sistema");
			mostrarMenuInicio();
			
		} else if (listaUsuarios.get(v1).getContraseña().equals(v2)) {
			
			System.out.println("Success");
			
			usuarioLogueado = listaUsuarios.get(v1);
			
			if (usuarioLogueado.getTipo()) {
				mostrarMenuCliente();
			} else {
				mostrarMenuEmpleado();
			}
			
		} else {
			
			System.out.println("Error: Contraseña incorrecta");
			
		}
		
	}
	
	public void crearCuenta() {
		
		System.out.println("Ingrese el nombre de usuario de su nueva cuenta");
		String v1 = sc.next();
		
		if (listaUsuarios.get(v1) != null) {
			System.out.println("Ese nombre de usuario ya esta en uso, por favor elija otro");
			crearCuenta();
		}
		
		System.out.println("Ingrese una contraseña");
		String v2 = sc.next();
		
		System.out.println("Elija su tipo de cuenta (escriba true o false dependiendo de su eleccion)");
		System.out.println("true - Para clientes");
		System.out.println("false - Para empleados");
		Boolean v3 = sc.nextBoolean();
		   
		Usuario u = new Usuario(v1, v2, v3);
		listaUsuarios.put(v1, u);
		
		Carritos c = new Carritos();
		listaCarritos.put(v1, c);
		
		usuarioLogueado = listaUsuarios.get(v1);
		
		if (usuarioLogueado.getTipo()) {
			mostrarMenuCliente();
		} else {
			mostrarMenuEmpleado();
		}
		
	}
	
	public void cargarArticulo() {
		
		System.out.println("Ingrese el nombre del nuevo articulo");
		String v1 = sc.next();
		
		System.out.println("Ingrese una breve descripcion");
		sc.nextLine();
		String v2 = sc.nextLine();
		
		System.out.println("Ingrese el precio del nuevo articulo");
		int v3 = sc.nextInt();
		
		System.out.println("Ingrese el codigo del articulo");
		int v4 = sc.nextInt();
		
		System.out.println("Ingrese la cantidad de stock del articulo");
		int v5 = sc.nextInt();
		
		Articulos a = new Articulos(v1, v2, v3, v4, v5);
		
		listaArticulos.put(v4, a);
		
		mostrarMenuEmpleado();
		
	}

	public void editarArticulo() {
		
		Collection<Articulos> listaAr = listaArticulos.values();
		
		for ( Articulos artic : listaAr ) {
			
			System.out.println(artic.getNombre() + ", Codigo: "+ artic.getCodigo() );
			System.out.println("------------------------------");
			
		}
		
		System.out.println("Ingrese el codigo del articulo que desea editar");
		int v1 = sc.nextInt();
		
		if (listaArticulos.get(v1) == null) {
			System.out.println("Ese codigo no pertenece a ningun articulo del sistema");
			mostrarMenuEmpleado();
		}
		
		System.out.println("Que atributo quiere editar?");
		System.out.println("1- Nombre: " + listaArticulos.get(v1).getNombre());
		System.out.println("2- Descripcion: " + listaArticulos.get(v1).getDescripcion());
		System.out.println("3- Precio: " + listaArticulos.get(v1).getPrecio());
		System.out.println("4- Codigo: " + listaArticulos.get(v1).getCodigo());
		System.out.println("5- Stock: " + listaArticulos.get(v1).getStock());
		int v2 = sc.nextInt();
		
		switch (v2) {
		
		 case 1:
			 System.out.println("Ingrese el nuevo nombre");
			 listaArticulos.get(v1).setNombre(sc.next());
			 break;
		 case 2:
			 System.out.println("Ingrese la nueva descripcion");
			 listaArticulos.get(v1).setDescripcion(sc.next());
			 break;
		 case 3:
			 System.out.println("Ingrese el nuevo precio");
			 listaArticulos.get(v1).setPrecio(sc.nextInt());
			 break;
		 case 4:
			 System.out.println("Ingrese el nuevo codigo");
			 listaArticulos.get(v1).setCodigo(sc.nextInt());
			 break;
		 case 5:
			 System.out.println("Ingrese el nuevo stock");
			 listaArticulos.get(v1).setStock(sc.nextInt());
			 break;
			 
		}
		
		mostrarMenuEmpleado();
		
	}
	
	public void eliminarArticulo() {
		
		Collection<Articulos> listaAr = listaArticulos.values();
		
		for ( Articulos artic : listaAr ) {
			
			System.out.println(artic.getNombre() + ", Codigo: "+ artic.getCodigo() );
			System.out.println("------------------------------");
			
		}

		System.out.println("Ingrese el codigo del articulo que desea eliminar");
		int v1 = sc.nextInt();
		
		listaArticulos.remove(v1);
		
		mostrarMenuEmpleado();
		
	}
	
	public void verArticulos() {
		
		Collection<Articulos> listaAr = listaArticulos.values();
		
		for ( Articulos artic : listaAr ) {
			
			System.out.println("------------------------------");
			System.out.println(artic.getNombre());
			System.out.println(artic.getDescripcion());
			System.out.println("Precio: $" + artic.getPrecio());
			System.out.println("Codigo: " + artic.getCodigo());
			System.out.println("------------------------------");
			
		}
		
		System.out.println("Ingrese el codigo del articulo que desea agregar al carrito");
		int v1 = sc.nextInt();
		
		if (listaArticulos.get(v1) == null) {
			
			System.out.println("Ese codigo no pertenece a ningun articulo del sistema");
			mostrarMenuCliente();
			
		} else {
			
			System.out.println("Ingrese la cantidad que desea agregar al carrito");
			int v2 = sc.nextInt();
			
			listaArticulos.get(v1).setCantidadEnCarrito(v2);
			
			listaCarritos.get(usuarioLogueado.getNombreUsuario()).agregarArticulo(listaArticulos.get(v1));
			
		}
		
		mostrarMenuCliente();
		
	}

	public void verMiCarrito() {
		
		Carritos carritoActual = listaCarritos.get(usuarioLogueado.getNombreUsuario());
		
		Collection<Articulos> listaCarr = carritoActual.getListaCarrito().values();
		
		for ( Articulos artic : listaCarr ) {
			
			System.out.println("------------------------------");
			System.out.println(artic.getNombre());
			System.out.println(artic.getDescripcion());
			System.out.println("Precio por unidad: $" + artic.getPrecio());
			System.out.println("Cantidad en el carrito: " + artic.getCantidadEnCarrito());
			System.out.println("Codigo: " + artic.getCodigo());
			System.out.println("------------------------------");
			
		}
		
		System.out.println("El precio total de los articulos en el carrito es: $" + carritoActual.generarTotal());
		System.out.println("------------------------------");
		System.out.println("Que desea hacer?");
		System.out.println("1 - Realizar compra");
		System.out.println("2 - Volver al menu principal");
		int v1 = sc.nextInt();
		
		if (v1 == 1) {
			
			usuarioLogueado.setDinero(usuarioLogueado.getDinero() - carritoActual.generarTotal());

			carritoActual.generarFactura();
			
			for ( Articulos artic : listaCarr ) {
				
				artic.setStock(artic.getStock() - artic.getCantidadEnCarrito());
				
				artic.setCantidadEnCarrito(0);
				
			}
			
			carritoActual.getListaCarrito().clear();

			System.out.println("Dinero actual en cuenta: $" + usuarioLogueado.getDinero());
			
			mostrarMenuCliente();
			
		} else if (v1 == 2) {
			
			mostrarMenuCliente();
			
		} else {
			
			System.out.println("Opcion incorrecta");
			verMiCarrito();
			
		}
		
	}

	public void agregarDinero() {

		System.out.println("Ingrese la cantidad de dinero que desea ingresar");
		int v1 = sc.nextInt();
		
		usuarioLogueado.setDinero(usuarioLogueado.getDinero() + v1);
		
		System.out.println("Operacion realizada con exito! Dinero actual en cuenta: $" + usuarioLogueado.getDinero());

		mostrarMenuCliente();
		
	}
	
	public void transferirDinero() {

		System.out.println("Ingrese el nombre de usuario al que desea transferir dinero");
		String v1 = sc.next();
		
		if (listaUsuarios.get(v1) == null) {
			
			System.out.println("Error: El nombre de usuario no se encuentra en el sistema");
			mostrarMenuCliente();
			
		}

		System.out.println("Ingrese la cantidad de dinero que desea transferir");
		int v2 = sc.nextInt();
		
		if (usuarioLogueado.getDinero() < v2) {
			System.out.println("No dispone de dinero suficiente para realizar la operacion");
			mostrarMenuCliente();
		}
		
		usuarioLogueado.setDinero(usuarioLogueado.getDinero() - v2);
		
		listaUsuarios.get(v1).setDinero(listaUsuarios.get(v1).getDinero() + v2);
		
		System.out.println("Operacion realizada con exito! Dinero actual en cuenta: $" + usuarioLogueado.getDinero());

		mostrarMenuCliente();
		
	}
	
	public void retirarDinero() {

		System.out.println("Ingrese la cantidad de dinero que desea retirar");
		int v1 = sc.nextInt();
		
		if (usuarioLogueado.getDinero() < v1) {
			System.out.println("No dispone de dinero suficiente para realizar la operacion");
			mostrarMenuCliente();
		}
		
		usuarioLogueado.setDinero(usuarioLogueado.getDinero() - v1);
		
		System.out.println("Operacion realizada con exito! Dinero actual en cuenta: $" + usuarioLogueado.getDinero());

		mostrarMenuCliente();
		
	}
	
	public void cerrarSesion() {
		
		usuarioLogueado = null;
		mostrarMenuInicio();
		
	}
	
}
