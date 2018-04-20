package mundo;

public class Usuario {
	private int codigo;
	private String nombre;
	private String contrase�a;
	private String correoElectronico;
	private Cuenta cuenta;
	private Playlist playlist;
	public Usuario(int codigo, String nombre, String contrase�a, String correoElectronico, Cuenta cuenta, Playlist playlist) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.correoElectronico = correoElectronico;
		this.cuenta=cuenta;
		this.playlist=playlist;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
}
