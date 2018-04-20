package mundo;

public class Cuenta {
	
	private int id;
	private String tipo;
	private float precio;
	private Usuario usuario;
	
	public Cuenta(int id,int codigo, String nombre, String contraseña, String correoElectronico, String tipo, float precio) {
		this.id=id;
		this.tipo=tipo;
		this.precio=precio;
		this.usuario = new Usuario(codigo,nombre,contraseña,correoElectronico, this, null);	
	}
	public Cuenta(int id, String tipo, float precio, Usuario usuario) {
		this.id=id;
		this.tipo=tipo;
		this.precio=precio;
		this.usuario=usuario;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String toRecord() {
		return this.id + "," + this.usuario.getCodigo() + "," + this.usuario.getNombre() + "," + this.usuario.getContraseña() + "," + this.usuario.getCorreoElectronico() + "," + this.tipo + "," + this.precio;
	}
}
