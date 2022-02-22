
public class Usuario {
	
	private String nombreUsuario;
	private String contraseña;
	private boolean tipo;
	private int dinero;
	
	public Usuario(String nomUsuario, String contraseña, boolean tipo) {
		this.nombreUsuario = nomUsuario;
		this.contraseña = contraseña;
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
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public boolean getTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	

}
