package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metodos {
	
	public static void alta(){
		
	}

	public static void select(Connection c, int cod_paciente) throws SQLException {
		int i=1;
		String select="select * from pacientes where cod_paciente=?";
		PreparedStatement ps=c.prepareStatement(select);
		ps.setInt(1, cod_paciente);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt(1)
					+":"+rs.getString(2)
					+":"+rs.getString(3)
					+":"+rs.getString(4)
					+":"+rs.getString(5)
					+":"+rs.getString(6)
					+":"+rs.getString(7));
		}
	}

	public static void insert(Connection c, int numpac, String dni, String nombre, int edad, String sex, String alergias, int codhab) throws SQLException {
		String insert="insert into pacientes values(?,?,?,?,?,?,?)";
		PreparedStatement ps=c.prepareStatement(insert);
		ps.setInt(1, numpac);
		ps.setString(2, dni);
		ps.setString(3, nombre);
		ps.setInt(4, edad);
		ps.setString(5, sex);
		ps.setString(6, alergias);
		ps.setInt(7, codhab);
		
		ps.executeUpdate();
		
		System.out.println("Insert completado. Si desea comprobarlo, ejecute la opcion 1.");
		
	}

	public static void borrar(Connection c, int codpacdel) throws SQLException {
		String delete="delete from pacientes where cod_paciente=?";
		PreparedStatement ps=c.prepareStatement(delete);
		ps.setInt(1, codpacdel);
		ps.executeUpdate();
		System.out.println("Paciente con numero "+codpacdel+" eliminado.");
	}

	public static void update(Connection c, int numpacup, String dniup, String nombreup, int edadup, String sexup, String alergiasup,
			int codhabup) throws SQLException {
		String update="update pacientes set dni=?, nombre=?, edad=?, sexo=?, alergias=?, cod_habitacion=? where cod_paciente=?";
		PreparedStatement ps=c.prepareStatement(update);
		ps.setString(1, dniup);
		ps.setString(2, nombreup);
		ps.setInt(3, edadup);
		ps.setString(4, sexup);
		ps.setString(5, alergiasup);
		ps.setInt(6, codhabup);
		ps.setInt(7, numpacup);
		
		ps.executeUpdate();
	}
}
