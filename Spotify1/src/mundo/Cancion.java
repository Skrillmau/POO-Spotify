package mundo;

public class Cancion {

	private int codigo;
	private String nombre;
	private int numeroEnAlbum;
	private int duracion;
	private String genero;
	private int popularidad;
	public Cancion(int codigo, String nombre, int numeroEnAlbum, int duracion, String genero, int popularidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.numeroEnAlbum = numeroEnAlbum;
		this.duracion = duracion;
		this.genero = genero;
		this.popularidad = popularidad;
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
	public int getNumeroEnAlbum() {
		return numeroEnAlbum;
	}
	public void setNumeroEnAlbum(int numeroEnAlbum) {
		this.numeroEnAlbum = numeroEnAlbum;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getPopularidad() {
		return popularidad;
	}
	public void setPopularidad(int popularidad) {
		this.popularidad = popularidad;
	}
	
	
}
