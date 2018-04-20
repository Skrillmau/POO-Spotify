package mundo;

import java.util.ArrayList;

public class Playlist {
	
	private int id;
	private int codigo;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	private String pnombre;
	private String descripcion;
	private boolean colaborativo;
	private boolean publico;
	private Usuario usuario;
	private ArrayList<Cancion> canciones=new ArrayList<Cancion>();
	
	public Playlist(int id,int codigo, String nombre, String descripcion, boolean colaborativo, boolean publico, ArrayList<Cancion> can) {
		this.id=id;
		this.codigo = codigo;
		this.pnombre = nombre;
		this.descripcion=descripcion;
		this.colaborativo=colaborativo;
		this.publico=publico;
		this.canciones=can;

	}
	public Playlist(int id,int codigo, String nombre, String descripcion, boolean colaborativo, boolean publico) {
		this.id=id;
		this.codigo = codigo;
		this.descripcion=descripcion;
		this.colaborativo=colaborativo;
		this.publico=publico;
		
	}
	public Playlist(int id, String pnombre, String descripcion, boolean colaborativo, boolean publico,
			Usuario usuario) {
		super();
		this.id = id;
		this.pnombre = pnombre;
		this.descripcion = descripcion;
		this.colaborativo = colaborativo;
		this.publico = publico;
		this.usuario = usuario;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPnombre() {
		return pnombre;
	}
	public void setPnombre(String pnombre) {
		this.pnombre = pnombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isColaborativo() {
		return colaborativo;
	}
	public void setColaborativo(boolean colaborativo) {
		this.colaborativo = colaborativo;
	}
	public boolean isPublico() {
		return publico;
	}
	public void setPublico(boolean publico) {
		this.publico = publico;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}
	public void setCanciones(ArrayList<Cancion> canciones) {
		this.canciones = canciones;
	}
	public String toRecord() {
		String codCanciones="";
		for(int x=0;x<canciones.size();x++) {
			codCanciones=codCanciones+","+canciones.get(x).getCodigo();
		}
		String a = (this.codigo + "," + this.id + "," + this.pnombre + "," + this.descripcion + "," + this.colaborativo + "," + this.publico+codCanciones); 
		return a; 
	}
	
}
