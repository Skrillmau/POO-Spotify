package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mundo.Cancion;


public class DatosCancion {
	private String ruta2;

	public DatosCancion(){
		this.ruta2="canciones.txt";
	}
	
	// leer canciones 
		public ArrayList<Cancion> leerCanciones() {
			ArrayList<Cancion> lista = new ArrayList<Cancion>();
			try {
			FileReader fr = new FileReader(this.ruta2);
			BufferedReader br= new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
				String[] info = line.split(",");
				int cod = Integer.parseInt(info[0]);
				String nom = info[1];
				int nea = Integer.parseInt(info[2]);
				int dur = Integer.parseInt(info[3]);
				String gen = info[4];
				int pop = Integer.parseInt(info[5]);
				Cancion x = new Cancion (cod,nom,nea,dur,gen,pop);
				lista.add(x);
				}
			br.close();
			return lista;
			} 
			catch (IOException e) {
				e.printStackTrace();
				return null;
			}	}
		
		
		//leer usuario
		

}

