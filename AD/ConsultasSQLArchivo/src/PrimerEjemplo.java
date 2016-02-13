import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class PrimerEjemplo {

	public static void main(String[] args) throws IOException, SQLException {
		BufferedReader entrada=new BufferedReader(new FileReader("c:\\Users\\AlumnoT\\Desktop\\prueba.txt"));
		Connection c=Herramientas.connectSQLite("ejemplo");
		String insert="insert into eje1 values(?,?)";
		PreparedStatement ps=c.prepareStatement(insert);
		StringTokenizer st;
		int id;
		String nombre;
		while(entrada.ready()){
			String linea=entrada.readLine();
			st=new StringTokenizer(linea,":");
			while(st.hasMoreTokens()){
				id=Integer.parseInt(st.nextToken());
				nombre=st.nextToken();
				ps.setInt(1, id);
				ps.setString(2, nombre);
				ps.executeUpdate();
			}
		}

	}

}
