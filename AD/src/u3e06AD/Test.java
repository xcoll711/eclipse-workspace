package u3e06AD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        // Datos de conexión para localhost
        String urlConnection = "jdbc:mysql://localhost:3306/ad?allowMultiQueries=true";
        String user = "root";
        String pwd = "";

        try (Connection c = DriverManager.getConnection(urlConnection, user, pwd)) {
            // Crea la tabla
            try (Statement sConsulta = c.createStatement()) {
                sConsulta.executeUpdate("CREATE TABLE IF NOT EXISTS productes (id INT AUTO_INCREMENT, nom VARCHAR(100), preu DOUBLE(10,2), quantitatEnStock INT, PRIMARY KEY (id))");
            }

            try (Statement sConsulta = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                ResultSet rs = sConsulta.executeQuery("SELECT * FROM productes ");
                // Insereix un nou producte
                rs.moveToInsertRow();
                rs.updateString("nom", "Golden Pepinillo");
                rs.updateString("preu", "12345");
                rs.updateString("quantitatEnStock", "33983");
                rs.insertRow();
                // Insereix un nou producte
                rs.moveToInsertRow();
                rs.updateString("nom", "Zanahoria");
                rs.updateString("preu", "1");
                rs.updateString("quantitatEnStock", "333");
                rs.insertRow();  
                // Insereix un nou producte
                rs.moveToInsertRow();
                rs.updateString("nom", "Manzana");
                rs.updateString("preu", "0.5");
                rs.updateString("quantitatEnStock", "83");
                rs.insertRow();
                
                
                //Actualitza la quantitatEnStock d'un dels productes.
                rs.last();
                rs.updateString("quantitatEnStock", "789");
                rs.updateRow();
                
                //Elimina un dels productes inserits.
                rs.previous();
                rs.previous();
                rs.deleteRow();
                
            } catch (SQLException e) {
                muestraErrorSQL(e);

                try {
                    if (c != null) {
                        c.rollback();
                        System.err.println("Se hace ROLLBACK");
                    }
                } catch (SQLException er) {
                    System.err.println("ERROR haciendo ROLLBACK");
                    er.printStackTrace(System.err);
                }
            } catch (Exception e) {
                System.err.println("ERROR de conexión");
                e.printStackTrace(System.err);
            } finally {
                try {
                    if (c != null) {
                        c.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException e) {
            muestraErrorSQL(e);
        }
        
    }

    private static void muestraErrorSQL(SQLException e) {
        // Método para manejar errores SQL, puedes personalizarlo según tus necesidades.
        e.printStackTrace();
        e.getMessage();
    }
}
