package u3e03AD;

// Ejecución de varias sentencias en una transacción


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTransacciones {

    public static void main(String[] args) {
		String urlConnection = "jdbc:mysql://localhost:3306/ad";
		String user = "root";
		String pwd = "";

        try (Connection c = DriverManager.getConnection(urlConnection, user, pwd)) {
            try (PreparedStatement sInsert = c.prepareStatement("INSERT INTO CLIENTES1 (DNI, APELLIDOS, CP) VALUES (?,?,?);")) {
                c.setAutoCommit(false);

                int i = 0;

                // Primer cliente
                sInsert.setString(++i, "54320198V");
                sInsert.setString(++i, "CARVAJAL");
                sInsert.setString(++i, "10109");
                sInsert.executeUpdate();

                // Segundo cliente
                sInsert.setString(i = 1, "76543210S");
                sInsert.setString(++i, "MARQUEZ");
                sInsert.setString(++i, "46987");
                sInsert.executeUpdate();

                // Tercer cliente
                sInsert.setString(i = 1, "90123456A");
                sInsert.setString(++i, "MOLINA");
                sInsert.setString(++i, "35153");
                sInsert.executeUpdate();

                c.commit();
            } catch (SQLException e) {
                muestraErrorSQL(e);
                try {
                    c.rollback();
                    System.err.println("Se hace ROLLBACK");
                } catch (SQLException er) {
                    System.err.println("ERROR haciendo ROLLBACK");
                    muestraErrorSQL(er);
                }
            }
        } catch (Exception e) {
            System.err.println("ERROR de conexión");
            e.printStackTrace(System.err);
        }
    }

    private static void muestraErrorSQL(SQLException e) {
    	System.out.println(e.getMessage());
    }
}
