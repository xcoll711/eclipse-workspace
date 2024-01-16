package model;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import view.ViewLogin;

public class ServerFunctions {

	public static void register(String user, String pwd) throws SQLException {

		// Datos de conexión para localhost
		String urlConnection = "jdbc:mysql://localhost:3306/espotyfaiXCV";
		String dbUser = "root";
		String dbPwd = "";

		try (
				Connection c = DriverManager.getConnection(urlConnection, dbUser, dbPwd);
				Statement statement = c.createStatement();
				) {
			// Creates the table
			String createTableQuery = "CREATE TABLE IF NOT EXISTS users ("
			        + "user_id INT AUTO_INCREMENT PRIMARY KEY,"
			        + "user_name VARCHAR(100),"
			        + "user_pwd VARCHAR(100))";
			statement.executeUpdate(createTableQuery);



			try (PreparedStatement sInsert = c.prepareStatement("INSERT INTO users (user_name,user_pwd) VALUES (?,?)")) {
				sInsert.setString(1, user);
				sInsert.setString(2,pwd);
				sInsert.executeUpdate();

			}

		}
	}

	public static boolean userExists(String username) {
        String urlConnection = "jdbc:mysql://localhost:3306/espotyfaiXCV";
        String dbUser = "root";
        String dbPwd = "";

        try (Connection c = DriverManager.getConnection(urlConnection, dbUser, dbPwd);
             PreparedStatement sSelect = c.prepareStatement("SELECT * FROM users WHERE user_name = ?")) {

            sSelect.setString(1, username);

            try (ResultSet resultSet = sSelect.executeQuery()) {
                // Si hay algún resultado, significa que el usuario ya existe
                return resultSet.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
	
	public static boolean checkCredentials(String username, String password) {
		

	    String urlConnection = "jdbc:mysql://localhost:3306/espotyfaiXCV";
	    String dbUser = "root";
	    String dbPwd = "";

	    try (Connection c = DriverManager.getConnection(urlConnection, dbUser, dbPwd);
	         PreparedStatement sSelect = c.prepareStatement("SELECT * FROM users WHERE user_name = ? AND user_pwd = ?")) {

	        sSelect.setString(1, username.toLowerCase()); // I do not want to have the username key sensitive
	        sSelect.setString(2, password);
	        

	        try (ResultSet rs = sSelect.executeQuery()) {

	     
	            if (rs.next()) {

	            	System.out.println(password);
	            	System.out.println(rs.getString("user_pwd"));

	              if(rs.getString("user_pwd").equals(password)) {
	            	  System.out.println("pwd good");

	                return true;
	              }else {
	            	  
	            	  ViewLogin.lblAvis.setText("Contrassenya errònea");
	            	  System.out.println("pwd wrong");

	            	  return false;
	              }
	            } else {
	                // No hay resultados, las credenciales son incorrectas
	                ViewLogin.lblAvis.setForeground(Color.RED);
	                ViewLogin.lblAvis.setText("Credencials incorrectes");
	                return false;
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; // If it throws an error we assume the credentials are wrong.
	    }
	}



	
}
