package servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.concurrent.Semaphore;

import bici.Bici;

public class Hilo extends Thread {
	Socket socket1;
	Semaphore semaforo;
	Bici[] bici;
	private Ventanas ventana;

	Hilo(Socket socket, Semaphore semaforo, Bici[] bici, Ventanas ventana) {
		this.socket1 = socket;
		this.semaforo = semaforo;
		this.bici = bici;
		this.ventana = ventana;
	}

	public void run() {
		try {
			socket1.setTcpNoDelay(true);
			DataInputStream disin = new DataInputStream(socket1.getInputStream());
			String tipo_conexion = disin.readUTF();
			ventana.escribecadena(tipo_conexion);

			if (tipo_conexion.equals("res")) {
				Bici bicireserva = new Bici();
				int i = 0;
				semaforo.acquire();

				while (i < bici.length && bici[i].isReservada()) {
					i++;
				}

				ObjectOutputStream oos = new ObjectOutputStream(socket1.getOutputStream());

				oos.writeObject(bici[i]);

				ObjectInputStream ois = new ObjectInputStream(socket1.getInputStream());
				Bici bicicleta = (Bici) ois.readObject();

				bici[i] = bicicleta;

				OutputStream os = socket1.getOutputStream();
				if (bici[i].isReservada()) {
					ventana.escribecadena(
							"Bicicleta numero: " + bici[i].getNumero() + " reservada: " + bici[i].isReservada());
					// -------------------------------------------------------------------
					os.write("Y".getBytes());
					ventana.escribecadena("Confirmacion enviada");
					// --------------------------------------------------------------------
				} else {
					ventana.escribecadena("No se ha podido reservar la bici numero: " + bici[i].getNumero());
					os.write("X".getBytes());
				}

				// -----------------------------------------------
				semaforo.release();
				ois.close();
				oos.close();
				os.close();
				socket1.close();
				//
			} else {
				InputStream is=socket1.getInputStream();
				int numbici=is.read();
				bici[numbici].setReservada(false);
				ventana.escribecadena("La bicicleta numero "+numbici+" ha sido devuelta");
			}
		disin.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
