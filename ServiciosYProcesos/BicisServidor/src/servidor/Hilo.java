package servidor;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.concurrent.Semaphore;

import bici.Bici;
public class Hilo extends Thread{
	Socket socket1;
	Semaphore semaforo;
	Bici[] bici;
	private Ventanas ventana;
	
	Hilo(Socket socket, Semaphore semaforo, Bici[] bici, Ventanas ventana){
		this.socket1=socket;
		this.semaforo=semaforo;
		this.bici=bici;
		this.ventana=ventana;
	}
	
	public void run(){
		try {
			Bici bicireserva=new Bici();
			int i=0;
			socket1.setTcpNoDelay(true);
			semaforo.acquire();
			
			while(i<bici.length && bici[i].isReservada()){
				i++;
			}
			
			ObjectOutputStream oos=new ObjectOutputStream(socket1.getOutputStream());
			
			oos.writeObject(bici[i]);
			
			ObjectInputStream ois=new ObjectInputStream(socket1.getInputStream());
			Bici bicicleta=(Bici) ois.readObject();

			
			bici[i]=bicicleta;
			if(bici[i].isReservada()){
				ventana.escribecadena("Bicicleta numero: "+bici[i].getNumero()+" reservada: "+bici[i].isReservada());
				//-------------------------------------------------------------------
				OutputStream os=socket1.getOutputStream();
				os.write("Bicicleta reservada correctamente".getBytes());
				System.out.println("Holap");
				//--------------------------------------------------------------------
			}else{
				ventana.escribecadena("No se ha podido reservar la bici numero: "+bici[i].getNumero());
			}
			
			//-----------------------------------------------
			semaforo.release();
			
//			InputStream is=socket1.getInputStream();
//			int pos=is.read();
//			bici[pos-1].setReservada(true);
//			ventana.escribecadena("Bici numero "+pos+" devuelta.");
//			
//			ois.close();
//			oos.close();
//			socket1.close();
			
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
