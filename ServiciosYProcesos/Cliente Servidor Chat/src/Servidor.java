import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress; 
import java.net.InetSocketAddress; 
import java.net.Socket; 
import java.net.ServerSocket;

public class Servidor {
	public static void main(String[] args) throws IOException{
		int numeroPuerto=6000;
		ServerSocket servidor=new ServerSocket(numeroPuerto);
		String cad="";
		System.out.print("Esperando conexió....");
		Socket clienteConectado=servidor.accept();
		System.out.println("Cliente conectado");
		PrintWriter fsalida=new PrintWriter(clienteConectado.getOutputStream(),true);
		BufferedReader fentrada=new BufferedReader(new InputStreamReader(clienteConectado.getInputStream()));
		while((cad=fentrada.readLine())!=null){
			fsalida.println(cad);
			System.out.println("Recibiendo\n"+cad);
			if(cad.equals("")){
				break;
			}
		}
		System.out.println("Cerrando conexion");
		fentrada.close();
		fsalida.close();
		clienteConectado.close();
		servidor.close();
	}
}