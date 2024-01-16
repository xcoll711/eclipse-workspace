package u3e02AD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class insert {
	public static void main(String[] args) {
		// Datos de conexión para localhost
		String urlConnection = "jdbc:mysql://localhost:3306/ad";
		String user = "root";
		String pwd = "";

		try (
				Connection c = DriverManager.getConnection(urlConnection, user, pwd);
				Statement statement = c.createStatement();
				) {
			// Crear la tabla CLIENTES1 si no existe
			String createTableQuery = "CREATE TABLE IF NOT EXISTS CLIENTES1 (DNI VARCHAR(10), APELLIDOS VARCHAR(50), CP INT)";
			statement.executeUpdate(createTableQuery);

			try (
					PreparedStatement sInsert = c.prepareStatement("INSERT INTO CLIENTES1 (DNI, APELLIDOS, CP) VALUES (?,?,?)")
					) {



				sInsert.setString(1, "78901234X");
				sInsert.setString(2, "NADALES");
				sInsert.setInt(3, 44126);
				sInsert.executeUpdate();

				int i = 1;
				sInsert.setString(i++, "89012345E");
				sInsert.setString(i++, "ROJAS");
				sInsert.setNull(i++, Types.INTEGER);
				sInsert.executeUpdate();

				i=1;
				sInsert.setString(i++, "56789012B");
				sInsert.setString(i++, "SAMPER");
				sInsert.setInt(i++, 29730);
				sInsert.executeUpdate();
			} catch (SQLException e) {
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			muestraErrorSQL(e1);
		}
		System.out.println("Fet.");
	}
	private static void muestraErrorSQL(SQLException e) {
		// Método para manejar errores SQL, puedes personalizarlo según tus necesidades.
		e.printStackTrace();
	}
}
