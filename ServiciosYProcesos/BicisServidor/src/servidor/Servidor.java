package servidor;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import bici.Bici;
public class Servidor {

	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket serverSocket=new ServerSocket(6000);
		Bici[] bici=new Bici[7];
		Semaphore semaforo=new Semaphore(1);
		Hilo[] hilo=new Hilo[50];
		Ventanas ventana=new Ventanas("Server");
		ventana.escribecadena("Servidor Creado");
		for(int i=0;i<7;i++){
			bici[i]=new Bici(i+1,false);
		}
		
		for(int i=0;i<50;i++){
			Socket cliente=serverSocket.accept();
			hilo[i]=new Hilo(cliente,semaforo,bici,ventana);
			hilo[i].start();
		}
		for(int i=0;i<50;i++){
			hilo[i].join();
		}
		serverSocket.close();
	}
}
