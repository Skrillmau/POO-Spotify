package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mundo.Cancion;
import mundo.Cuenta;
import mundo.Usuario;
import mundo.Playlist;

public class Datos {

	private String ruta;
	private String ruta2;
	private String ruta3;
	private String ruta4;
	private DatosCancion dCanciones;

	public Datos() {
		this.ruta = "cuenta.txt";
		this.ruta2 = "canciones.txt";
		this.ruta3 = "playlist.txt";
		this.ruta4="metodopago.txt";
		dCanciones = new DatosCancion();
	}

	public boolean registrarCuenta(Cuenta x) {
		try {
			FileWriter fw;
			fw = new FileWriter(this.ruta, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String info = x.toRecord();
			bw.write(info);
			bw.newLine();
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	//Guardar metodo de pago
	public boolean guardarMetodo(String x) {
		try {
			FileWriter fw;
			fw = new FileWriter(this.ruta4, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String info = x;
			bw.write(info);
			bw.newLine();
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Generar codigo
	public int asginarCodigo() {
		try {
			int maximo = 0;
			FileReader fr = new FileReader(this.ruta);
			BufferedReader br = new BufferedReader(fr);
			if (br.readLine() == null) {
				maximo = 0;
			} else {
				while ((br.readLine()) != null) {
					maximo = maximo + 1;
				}
			}
			return maximo;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int asginarCodigoMetodo() {
		try {
			int maximo = 0;
			FileReader fr = new FileReader(this.ruta4);
			BufferedReader br = new BufferedReader(fr);
			if (br.readLine() == null) {
				maximo = 0;
			} else {
				while ((br.readLine()) != null) {
					maximo = maximo + 1;
				}
			}
			return maximo;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// Leer cuenta

	public ArrayList<Cuenta> leerCuentas() {
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		try {
			FileReader fr = new FileReader(this.ruta);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] info = line.split(",");
				int id = Integer.parseInt(info[0]);
				int cod = Integer.parseInt(info[1]);
				String nom = info[2];
				String cont = info[3];
				String corr = info[4];
				String tip = info[5];
				float pre = Float.valueOf(info[6]);
				Cuenta x = new Cuenta(id, cod, nom, cont, corr, tip, pre);
				lista.add(x);
			}
			br.close();
			return lista;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// iniciar sesion

	public Cuenta traerCuentas() {
		ArrayList<Cuenta> lista = leerCuentas();
		String n = JOptionPane.showInputDialog("Ingresa tu nombre de usuario o correo");
		String c = JOptionPane.showInputDialog("Ingresa la contraseña");
		Cuenta respuesta = null;
		for (Cuenta x : lista) {
			if (x.getUsuario().getContraseña().equals(c)) {
				if (x.getUsuario().getCorreoElectronico().equals(n)) {
					respuesta = new Cuenta(x.getId(), x.getUsuario().getCodigo(), x.getUsuario().getNombre(),
							x.getUsuario().getContraseña(), x.getUsuario().getCorreoElectronico(), x.getTipo(),
							x.getPrecio());
					break;
				} else {
					if (x.getUsuario().getNombre().equals(n)) {
						respuesta = new Cuenta(x.getId(), x.getUsuario().getCodigo(), x.getUsuario().getNombre(),
								x.getUsuario().getContraseña(), x.getUsuario().getCorreoElectronico(), x.getTipo(),
								x.getPrecio());
						break;
					}
				}
			}
		}
		return respuesta;

	}

	// leer canciones
	public ArrayList<Cancion> leerCanciones() {
		ArrayList<Cancion> lista = new ArrayList<Cancion>();
		try {
			FileReader fr = new FileReader(this.ruta2);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] info = line.split(",");
				int cod = Integer.parseInt(info[0]);
				String nom = info[1];
				int nea = Integer.parseInt(info[2]);
				int dur = Integer.parseInt(info[3]);
				String gen = info[4];
				int pop = Integer.parseInt(info[5]);
				Cancion x = new Cancion(cod, nom, nea, dur, gen, pop);
				lista.add(x);
			}
			br.close();
			return lista;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	//guardar cuentas
	public boolean guardarCuentas(ArrayList<Cuenta> x) {
		try {
			FileWriter fw;
			fw = new FileWriter(this.ruta, false);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < x.size(); i++) {
				String info = x.get(i).toRecord();
				bw.write(info);
				bw.newLine();
			}
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// crear playlist
	public boolean crearPlaylist(Playlist x) {
		try {
			FileWriter fw;
			fw = new FileWriter(this.ruta3, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String info = x.toRecord();
			bw.write(info);
			bw.newLine();
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean guardarPlaylist(ArrayList<Playlist> x) {
		try {
			FileWriter fw;
			fw = new FileWriter(this.ruta3, false);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < x.size(); i++) {
				String info = x.get(i).toRecord();
				bw.write(info);
				bw.newLine();
			}
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Generar codigo playlist
	public int asginarCodigoPlaylist() {
		try {
			int maximo = 0;
			FileReader fr = new FileReader(this.ruta3);
			BufferedReader br = new BufferedReader(fr);
			if (br.readLine() == null) {
				maximo = 0;
			} else {
				while ((br.readLine()) != null) {
					maximo = maximo + 1;
				}
			}
			return maximo;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// leer playtlist
	public ArrayList<Playlist> leerPlaylist() {
		ArrayList<Playlist> lista = new ArrayList<Playlist>();
		try {
			FileReader fr = new FileReader(this.ruta3);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] info = line.split(",");
				int cod = Integer.parseInt(info[0]);
				int id = Integer.parseInt(info[1]);
				String n = info[2];
				String c = info[3];
				boolean col = Boolean.parseBoolean(info[4]);
				boolean pub = Boolean.parseBoolean(info[5]);
				ArrayList<Cancion> can = new ArrayList<Cancion>();
				ArrayList<Cancion> canT = this.dCanciones.leerCanciones();
				for (int x = 6; x < info.length; x++) {
					for (int y = 0; y < canT.size(); y++) {
						if (canT.get(y).getCodigo() == Integer.parseInt(info[x])) {
							can.add(canT.get(y));
						}
					}
				}
				Playlist x = new Playlist(id, cod, n, c, col, pub, can);
				lista.add(x);
			}
			br.close();
			return lista;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	// eliminar cuenta

	public boolean borrarPlaylist(int codigo) {
		ArrayList<Playlist> lista = leerPlaylist();
		for (Playlist p : lista) {
			if (p.getId() == codigo) {
				lista.remove(p);
				break;
			}
		}
		boolean resultado = guardarPlaylist(lista);
		return resultado;
	}

	public boolean borrarCuenta(int codigo) {
		ArrayList<Cuenta> lista = leerCuentas();
		for (Cuenta p : lista) {
			if (p.getUsuario().getCodigo() == codigo) {
				lista.remove(p);
				break;
			}
		}
		boolean resultado = this.guardarCuentas(lista);
		return resultado;
	}

}
