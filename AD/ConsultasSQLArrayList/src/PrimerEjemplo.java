import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class PrimerEjemplo {

	public static void main(String[] args) throws SQLException {
		ArrayList lista=new ArrayList();
		lista.add(1);
		lista.add("pepe");
		lista.add(2);
		lista.add("pepa");
		lista.add(3);
		lista.add("silvia");
		
		String consulta="Insert into eje1(id,nombre) values(?,?)";
		Connection c=Herramientas.connectSQLite("ejemplo");
		PreparedStatement ps=c.prepareStatement(consulta);
		Iterator it=lista.iterator();
		while(it.hasNext()){
			ps.setInt(1, (int)it.next());
			ps.setString(2, (String)it.next());
			ps.executeUpdate();
		}
	}

}
