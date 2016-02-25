package cliente;

import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import bici.Bici;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;

public class Cliente {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Socket socket = new Socket("localhost", 6000);
		socket.setTcpNoDelay(true);
		Ventanas ventana=new Ventanas("Cliente");
		Random random=new Random();
		//Se envia res para que el hilo sepa que es una reserva
		OutputStream osres=socket.getOutputStream();
		osres.write("res".getBytes());
		//-----------------------------------
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		Bici datos = (Bici) ois.readObject();
		
		ventana.escribecadena("Bicicleta disponible con numero: "+datos.getNumero());
		datos.setReservada(true);
		
		ventana.escribecadena("\nEnviando datos de reserva al server");
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(datos);
		ventana.escribecadena("Datos enviados");
		//-------------------------------------------------------------
		ventana.escribecadena("\nA la espera de confirmacion");
		InputStream is=socket.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		String confirmacion=br.readLine().toString();
		//-------------------------------------------------------------
		is.close();
		ois.close();
		oos.close();
		osres.close();
		socket.close();
		
		//##############FIN RESERVA##############
		
		
		if(confirmacion.equals("X")){
			ventana.escribecadena("No se ha podido reservar la bici.");
		}else{
			ventana.escribecadena("Se ha reservado correctamente la bici.");
			ventana.escribecadena("Voy a utilizar la bici");
			switch(random.nextInt(4)){
			case 0:
				Thread.sleep(1000);
			case 1:
				Thread.sleep(2000);
			case 2:
				Thread.sleep(3000);
			case 3:
				Thread.sleep(4000);
			}
			ventana.escribecadena("Ya he terminado de utilizarla, voy a devolverla");
			
			Socket socketdev=new Socket ("localhost",6000);
			OutputStream osdev= socketdev.getOutputStream();
			//Se envia dev para que el hilo ejecute la opcion de devolver
			osdev.write("dev".getBytes());
		}
	}

}
