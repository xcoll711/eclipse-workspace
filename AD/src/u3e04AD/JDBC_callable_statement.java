/*
Crea una funció emmagatzemada amb MySQL 
(o amb Oracle o amb una altra base de dades) 
a la qual se li passi el DNI del client i que 
retorni els seus cognoms. Crea un programa en 
Java que faci una crida a aquesta funció utilitzant
JDBC i escrigui el valor retornat per la funció. 
Serà necessari consultar documentació o investigar 
com crear funcions emmagatzemades en la base de dades utilitzada,
 però es farà de manera molt semblant a un procediment emmagatzemat.
 */


package u3e04AD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_callable_statement {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String urlConnection = "jdbc:mysql://localhost:3306/ad";
		String user = "root";
		String pwd = "";

		
		System.out.println("Inserte un DNI: ");
		String resultado = sc.next();
		
		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
             CallableStatement s = (CallableStatement) c.prepareCall("{call ObtenerApellidos (?)}")) {

            s.setString(1, resultado);
            s.execute();

            ResultSet rs = s.getResultSet();

            while(rs.next()) {
                System.out.println("=> Apellidos: " + rs.getString(1));

            }
        } catch (SQLException e) {
            muestraErrorSQL(e);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private static void muestraErrorSQL(SQLException e) {
        // Implementa el manejo de errores SQL según tus necesidades
        e.printStackTrace(System.err);
    }
}
