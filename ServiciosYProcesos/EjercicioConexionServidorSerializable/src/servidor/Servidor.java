package servidor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

import persona.Persona;
public class Servidor {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		ServerSocket ssocket=new ServerSocket(8952);
		System.out.println("Esperando cliente");
		Socket cliente=ssocket.accept();
		
		ObjectOutputStream oos=new ObjectOutputStream(cliente.getOutputStream());
		Persona persona=new Persona("Alvaro",20);
		oos.writeObject(persona);
		
		System.out.println("Envío del objeto completado: "+persona.getNombre());
		
		ObjectInputStream ois=new ObjectInputStream(cliente.getInputStream());
		Persona persin=(Persona) ois.readObject();
		
		System.out.println("Recibido: "+persin.getNombre());
		
		ssocket.close();
		cliente.close();
		ois.close();
		oos.close();
	}
}
