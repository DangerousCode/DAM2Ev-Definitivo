package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Hospital {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		Connection c = Herramientas.connectSQLite("hospital");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Conectado correctamente");
		char continuar = ' ';
		int opcion = 0;

		do {
			System.out.println("1.Consultar datos de un paciente dando su cod_hab."
					+ "\n2.Alta de un paciente dando todos sus datos." + "\n3.Borrar un paciente."
					+ "\n4.Modificar un paciente.\n");

			System.out.print("Introduzca una opcion: ");
			opcion = Integer.parseInt(br.readLine());
			System.out.println("");
			switch (opcion) {//INICIO SWITCH
			
			case 1:
				System.out.println("Introduce el codigo de paciente para obtener sus datos: ");
				int cod_paciente = Integer.parseInt(br.readLine());
				
				Metodos.select(c, cod_paciente);
				break;

			case 2:
				System.out.println("Introduce el codigo de paciente:");
				int numpac = Integer.parseInt(br.readLine());
				System.out.println("Introduce el DNI: ");
				String dni = br.readLine();
				System.out.println("Introduce el nombre: ");
				String nombre = br.readLine();
				System.out.println("Introduce la edad: ");
				int edad = Integer.parseInt(br.readLine());
				System.out.println("Introduce el sexo: ");
				String sex = br.readLine();
				System.out.println("Introduce alergias: ");
				String alergias = br.readLine();
				System.out.println("Introduce el codigo de habitacion: ");
				int codhab = Integer.parseInt(br.readLine());
				
				Metodos.insert(c, numpac, dni,nombre,edad,sex,alergias,codhab);
				break;
				
			case 3:
				System.out.print("Introduce el codigo de paciente para borrar sus datos: ");
				int codpacdel = Integer.parseInt(br.readLine());
				
				Metodos.borrar(c, codpacdel);
				break;
			
			case 4:
				System.out.println("Introduce el codigo de paciente que desea actualizar:");
				int numpacup = Integer.parseInt(br.readLine());
				System.out.println("Introduce el DNI: ");
				String dniup = br.readLine();
				System.out.println("Introduce el nombre: ");
				String nombreup = br.readLine();
				System.out.println("Introduce la edad: ");
				int edadup = Integer.parseInt(br.readLine());
				System.out.println("Introduce el sexo: ");
				String sexup = br.readLine();
				System.out.println("Introduce alergias: ");
				String alergiasup = br.readLine();
				System.out.println("Introduce el codigo de habitacion: ");
				int codhabup = Integer.parseInt(br.readLine());
				
				Metodos.update(c,numpacup,dniup,nombreup,edadup,sexup,alergiasup,codhabup);
				break;
			}//FIN SWITCH
			System.out.print("Desea continuar?: ");
			continuar=br.readLine().toLowerCase().charAt(0);
			System.out.println("");
		} while (continuar == 's');

	}

}
