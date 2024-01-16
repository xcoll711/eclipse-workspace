package u3e02AD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class SelectRS {

	public static void main(String[] args) {
		String urlConnection = "jdbc:mysql://localhost:3306/ad";
		String user = "root";
		String pwd = "";


		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement sSelect = c.prepareStatement("SELECT * FROM clientes1 WHERE DNI=?")) {




			String[] dni={"78901234X","89012345E","56789012B"};

			int d =0;
			for(String i : dni) {
				sSelect.setString(1, i);
				ResultSet rs = sSelect.executeQuery();

				if(rs.next()) {
					String nom = rs.getString(2);
					String cp = rs.getString(3);

					System.out.println("NOM: "+nom+ " DNI: " + dni[d]+ " CP : "+ (cp == null?"No especificat":cp));

					d++;
				}

			}





		} catch (SQLException e) {
			muestraErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	private static void muestraErrorSQL(SQLException e) {
		// Implementa la lógica para manejar errores SQL
		e.printStackTrace(System.err);
	}
}

