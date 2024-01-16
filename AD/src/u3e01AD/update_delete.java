package u3e01AD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class update_delete {
    public static void main(String[] args) {
        // Datos de conexión para localhost
        String urlConnection = "jdbc:mysql://localhost:3306/ad";
        String user = "root";
        String pwd = "";

        try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
             Statement s = c.createStatement()) {

            // Update para modificar registros 
            s.executeUpdate("UPDATE CLIENTES SET APELLIDOS = 'ROJAS' WHERE DNI = '89012345E'");

            // Delete para eliminar registros 
            s.executeUpdate("DELETE FROM CLIENTES WHERE DNI = '09876543K'");

            System.out.println("Hecho");

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