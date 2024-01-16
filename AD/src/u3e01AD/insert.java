package u3e01AD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class insert {
	public static void main(String[] args) {
		// Datos de conexión para localhost
		String urlConnection = "jdbc:mysql://localhost:3306/ad";
		String user = "root";
		String pwd = "";

		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
				Statement s = c.createStatement()) {
			int nFil = s.executeUpdate(
					"INSERT INTO CLIENTES (DNI, APELLIDOS, CP) VALUES " +
							"('78901234X', 'NADALES', '44126')," +
							"('89012345E', 'HOJAS', null)," +
							"('56789012B', 'SAMPER', '29730')," +
					"('09876543K', 'LAMIQUIZ', null);");
			System.out.println(nFil + " Filas insertadas.");
		} catch (SQLException e) {
			muestraErrorSQL(e);
			System.err.println("SQL código específico: " + e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	private static void muestraErrorSQL(SQLException e) {
		// Método para manejar errores SQL, puedes personalizarlo según tus necesidades.
		e.printStackTrace();
	}
}