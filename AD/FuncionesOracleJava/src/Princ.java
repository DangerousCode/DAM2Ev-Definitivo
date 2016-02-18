import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class Princ {
	public static void main(String[] args){
		try {
			Connection con=Herramientas.ConectarOracle("hr", "root");
			String solucion="{?=call masgana}";
			CallableStatement x=con.prepareCall(solucion);
			x.registerOutParameter(1, Types.VARCHAR);
			x.executeUpdate();
			String enombre=x.getString(1);
			System.out.println(enombre);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
