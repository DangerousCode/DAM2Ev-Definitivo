package cliente;
import java.net.*;
import java.io.*;
import persona.*;
public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket=new Socket("localhost",8952);
		
		ObjectInputStream fin=new ObjectInputStream(socket.getInputStream());
		Persona persona=(Persona) fin.readObject();
		
		System.out.println("Datos de la persona: "+persona.getNombre()+", "+persona.getEdad());
		
		persona.setNombre("Alvaro Santos");
		persona.setEdad(21);
		
		ObjectOutputStream fout=new ObjectOutputStream(socket.getOutputStream());
		fout.writeObject(persona);
		
		fin.close();
		fout.close();
	}

}
