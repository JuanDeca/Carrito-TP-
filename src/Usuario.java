
public class Usuario {
	
	private String nombreUsuario;
	private String contrase�a;
	private boolean tipo;
	private int dinero;
	
	public Usuario(String nomUsuario, String contrase�a, boolean tipo) {
		this.nombreUsuario = nomUsuario;
		this.contrase�a = contrase�a;
		this.tipo = tipo;
		this.dinero = 0;
	}
	
	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public boolean getTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	

}
