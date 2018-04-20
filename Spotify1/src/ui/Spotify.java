
package ui;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import datos.Datos;
import mundo.Cancion;
import mundo.Cuenta;
import mundo.Playlist;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import datos.Datos;
import mundo.Cancion;
import mundo.Cuenta;
import mundo.Playlist;
import mundo.Usuario;

public class Spotify {

	public static void main(String[] args) {
		int opcion;
		Datos archivo = new Datos();

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog("BIENVENIDO A SPOTIFY \n" + "Ingrese una opción: \n"
					+ "1. Inciar sesion. \n" + "2. Registrar cuenta. \n" + "0. Salir."));
			switch (opcion) {
			case 1:
				// Iniciar sesion
				Cuenta respuesta = archivo.traerCuentas();
				if (respuesta != null) {
					JOptionPane.showMessageDialog(null, "Se ha iniciado sesion correctamente");
					do {
						opcion = Integer.parseInt(JOptionPane.showInputDialog("BIENVENIDO A SPOTIFY \n"

								+ "Ingrese una opción: \n" + "1. Catálogo de canciones. \n"
								+ "2. Mis listas de reproducción. \n" + "3. Ver mi cuenta. \n"
								+ "4. Cerrar sesión. \n"));
						switch (opcion) {

						case 1:
							// Catalogo de Canciones

							ArrayList<Cancion> catalogo = archivo.leerCanciones();
							JOptionPane.showMessageDialog(null, "Catalogo de canciones");
							for (Cancion x : catalogo) {
								if (x != null) {
									JOptionPane.showMessageDialog(null,
											"Cancion " + (x.getCodigo() + 1) + " \n" + "Nombre: " + (x.getNombre())
													+ ". \n" + "Numero en Album: " + (x.getNumeroEnAlbum()) + ". \n"
													+ "Duracion " + (x.getDuracion()) + " minutos.  \n" + "Genero: "
													+ (x.getGenero()) + ". \n" + "Popularidad " + (x.getPopularidad())
													+ ". \n");
								} else {
									JOptionPane.showMessageDialog(null, "Lo siento, no encontré la cancion");
								}
							}

							break;
						case 2:
							int opcion4=0;
							do {
								opcion4 = Integer.parseInt(JOptionPane.showInputDialog(null,
										"MIS LISTAS DE REPRODUCCIÓN \n" + "1. Crear una lista de reproducción. \n"
												+ "2. Abrir lista de reproducción. \n"
												+ "3. Eliminar lista de reproducción. \n" + "5. Atras. \n"));
								switch (opcion4) {
								case 1:
									// Crear lista de reproduccion
									JOptionPane.showMessageDialog(null,
											"¡CREA UNA LISTA DE REPRODUCCION! \n" + "Ingresa los siguientes datos: ");

									String nombre = (JOptionPane
											.showInputDialog("Ingresa un nombre para la lista de reproduccion "));
									String descripcion = (JOptionPane.showInputDialog(
											"Ingresa una pequeña descripcion de tu lista de reproduccion"));
									int col = Integer.parseInt(JOptionPane
											.showInputDialog("¿Deseas que tu lista de reproduccion sea colaborativa? \n"
													+ "1. Si \n" + "2. No."));
									boolean colp;
									if (col == 1) {
										colp = true;
									} else {
										colp = false;
									}
									int pub = Integer.parseInt(JOptionPane
											.showInputDialog("¿Deseas que tu lista de reproduccion sea publica? \n"
													+ "1. Si \n" + "2. No."));
									boolean pubg;
									if (pub == 1) {
										pubg = true;
									} else {
										pubg = false;
									}
									int codigo = archivo.asginarCodigoPlaylist();

									Playlist n = new Playlist(codigo, nombre, descripcion, colp, pubg,
											respuesta.getUsuario());
									boolean g = archivo.crearPlaylist(n);
									if (g) {
										JOptionPane.showMessageDialog(null,
												"¡Se ha registrado correctamente tu lista de reproduccion!");
									} else {

										JOptionPane.showMessageDialog(null,
												"UPS! No se pudo registrar correctamente tu lista de reproduccion ");
									}
									break;
								case 2:
									boolean enc = false;
									ArrayList<Playlist> playL = archivo.leerPlaylist();
									Playlist play = null;
									int p = Integer.parseInt(
											JOptionPane.showInputDialog("Ingrese el codigo de la playlist: "));
									for (int a = 0; a < playL.size(); a++) {
										if (respuesta.getUsuario().getCodigo() == playL.get(a).getCodigo()
												&& playL.get(a).getId() == p) {
											enc=true;
											play = playL.get(a);
											int opcion3;
											do {

												opcion3 = Integer.parseInt(JOptionPane.showInputDialog(null,
														"1. Ver canciones de la Lista \n"
																+ "2. Agregar Canción a la Lista \n"
																+ "3. Quitar Canción de la Lista \n" + "4. Atras"));
												switch (opcion3) {
												case 1:
													for (int b = 0; b < play.getCanciones().size(); b++) {
														Cancion x = play.getCanciones().get(b);
														JOptionPane.showMessageDialog(null,
																"Cancion " + (x.getCodigo() + 1) + " \n" + "Nombre: "
																		+ (x.getNombre()) + ". \n" + "Numero en Album: "
																		+ (x.getNumeroEnAlbum()) + ". \n" + "Duracion "
																		+ (x.getDuracion()) + " minutos.  \n"
																		+ "Genero: " + (x.getGenero()) + ". \n"
																		+ "Popularidad " + (x.getPopularidad())
																		+ ". \n");
													}

													break;
												case 2:
													ArrayList<Cancion> listado = archivo.leerCanciones();
													int y = Integer.parseInt(JOptionPane.showInputDialog(
															"¿Ingrese el codigo de la Canción que desea agregar"));
													for (int i = 0; i < listado.size(); i++) {
														if (y == listado.get(i).getCodigo()) {
															archivo.borrarPlaylist(p);
															playL.get(a).getCanciones().add(listado.get(i));
															archivo.guardarPlaylist(playL);
														}

													}

													break;

												case 3:
													int ss = Integer.parseInt(JOptionPane
															.showInputDialog("¿Cúal Canción desea eliminar"));
													for (int r = 0; r < playL.get(a).getCanciones().size(); r++) {
														if (ss == playL.get(a).getCanciones().get(r).getCodigo()) {
															archivo.borrarPlaylist(p);
															playL.get(a).getCanciones().remove(r);
															archivo.guardarPlaylist(playL);
														}
													}

													break;
												case 4:
													break;
												}

											} while (opcion3 != 4);

										}
									}
									if(enc==false) {
										JOptionPane.showMessageDialog(null, "No se ha encontrado la playlist");
									}
									break;

								case 3:
									// Borrar playlist
									int codiguito = Integer.parseInt(JOptionPane.showInputDialog(null,
											"Ingresa el codigo de la playlist que deseas eliminar"));
									boolean eliminar = archivo.borrarPlaylist(codiguito);
									if (eliminar) {
										JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
									} else {
										JOptionPane.showMessageDialog(null, "No se pudo eliminar :(");
									}
									break;
								}

							} while (opcion4 != 5);

						case 3:
							int opcion1;
							ArrayList<Cuenta> cuentas = archivo.leerCuentas();
							Cuenta cuenta = null;
							do {
								opcion1 = Integer
										.parseInt(JOptionPane.showInputDialog(null, "MI CUENTA \n" + "1. Ver Perfil. \n"
												+ "2. Editar Perfil. \n" + "3. Hacer Premium. \n" + "4. Atras. \n"));
								switch (opcion1) {
								case 1:
									JOptionPane.showMessageDialog(null,
											"ID: " + respuesta.getId() + " \n" + "Nombre: "
													+ (respuesta.getUsuario().getNombre()) + ". \n" + "Contraseña: "
													+ (respuesta.getUsuario().getContraseña()) + ". \n" + "Email: "
													+ (respuesta.getUsuario().getCorreoElectronico()) + "Tipo: "
													+ (respuesta.getTipo()) + "\n");
									break;
								case 2:
									int opcion2;
									do {

										opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null,
												"EDITAR PERFIL \n" + "1. Editar Nombre. \n" + "2. Editar Correo. \n"
														+ "3. Editar Contraseña. \n" + "4. Atras. \n"));
										switch (opcion2) {
										case 1:
											for (int a = 0; a < cuentas.size(); a++) {
												if (cuentas.get(a).getUsuario().getCodigo() == respuesta.getUsuario()
														.getCodigo()) {
													cuenta = cuentas.get(a);
													archivo.borrarCuenta(cuenta.getUsuario().getCodigo());
													cuentas.remove(cuenta);
													String nNombre = JOptionPane
															.showInputDialog("Ingrese el nuevo nombre de usuario: ");
													cuenta.getUsuario().setNombre(nNombre);
													cuentas.add(cuenta);
													archivo.guardarCuentas(cuentas);
													JOptionPane.showMessageDialog(null,
															"Nombre Cambiado exitosamente ");
												}
											}
											break;

										case 2:
											for (int a = 0; a < cuentas.size(); a++) {
												if (cuentas.get(a).getUsuario().getCodigo() == respuesta.getUsuario()
														.getCodigo()) {
													cuenta = cuentas.get(a);
													archivo.borrarCuenta(cuenta.getUsuario().getCodigo());
													cuentas.remove(cuenta);
													String nCorreo = JOptionPane
															.showInputDialog("Ingrese el nuevo Correo Electronico: ");
													cuenta.getUsuario().setCorreoElectronico(nCorreo);
													cuentas.add(cuenta);
													archivo.guardarCuentas(cuentas);
													JOptionPane.showMessageDialog(null,
															"Correo Cambiado exitosamente ");
												}
											}
											break;
										case 3:
											for (int a = 0; a < cuentas.size(); a++) {
												if (cuentas.get(a).getUsuario().getCodigo() == respuesta.getUsuario()
														.getCodigo()) {
													cuenta = cuentas.get(a);
													archivo.borrarCuenta(cuenta.getUsuario().getCodigo());
													cuentas.remove(cuenta);
													String nContraseña = JOptionPane
															.showInputDialog("Ingrese la nueva Contraseña: ");
													cuenta.getUsuario().setContraseña(nContraseña);
													cuentas.add(cuenta);
													archivo.guardarCuentas(cuentas);
													JOptionPane.showMessageDialog(null,
															"Contraseña Cambiado exitosamente ");
												}
											}
											break;

										}
										break;

									} while (opcion2 != 4);

								case 3:
									String mPago = JOptionPane
											.showInputDialog("Ingrese su metodo de pago (Debito,Credito): ");
									String nCuenta = JOptionPane.showInputDialog("Ingrese su numero de cuenta: ");
									int codigo = archivo.asginarCodigoMetodo();
									String metodoPago = codigo + "," + mPago + "," + nCuenta;
									archivo.guardarMetodo(metodoPago);
									for (int a = 0; a < cuentas.size(); a++) {
										if (cuentas.get(a).getUsuario().getCodigo() == respuesta.getUsuario()
												.getCodigo()) {
											cuenta = cuentas.get(a);
											archivo.borrarCuenta(cuenta.getUsuario().getCodigo());
											cuentas.remove(cuenta);
											cuenta.setTipo("Premium");
											;
											cuentas.add(cuenta);
											archivo.guardarCuentas(cuentas);
											JOptionPane.showMessageDialog(null, "Cuenta actualizada exitosamente ");
										}
									}
									break;

								}

							} while (opcion1 != 4);

						}

					} while (opcion != 4);

				} else {
					JOptionPane.showMessageDialog(null, "Ups! contraseña o usuario incorrecto, intentalo de nuevo.");
				}
				break;

			case 2:
				// Registrar cuenta

				JOptionPane.showMessageDialog(null, "¡REGISTRATE! \n" + "Ingresa los siguientes datos: ");

				String nombre = JOptionPane.showInputDialog("Ingresa tu nombre ");
				String contraseña = JOptionPane.showInputDialog("Ingresa la contraseña con la que deseas ingresar");
				String correo = JOptionPane.showInputDialog("Ingresa tu correo electronico");
				Cuenta nueva = new Cuenta(0, 0, nombre, contraseña, correo, "free", 0);
				nueva.getUsuario().setCodigo(archivo.asginarCodigo());

				boolean guardar = archivo.registrarCuenta(nueva);
				if (guardar) {
					JOptionPane.showMessageDialog(null, "¡Te registraste exitosamente!");
				} else {
					JOptionPane.showMessageDialog(null, "UPS! No se pudo registrar correctamente tus datos");
				}
				break;
			}
		} while (opcion != 0);

	}

}
