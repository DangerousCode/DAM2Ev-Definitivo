package main;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import javax.crypto.*;
public class Main {
	public static void main(String[] args){
		System.out.println("Obteniendo generador de claves de cifrado AES");
		try {
			KeyGenerator keygen=KeyGenerator.getInstance("AES");
			System.out.println("Generando la clave");
			SecretKey key=keygen.generateKey();
			System.out.println("Obteniendo la factoria de claves con cifrado AES");
			
			Cipher desCipher=Cipher.getInstance("AES");
			
			System.out.println("Configurando");
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
