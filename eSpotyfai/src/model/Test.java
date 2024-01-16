package model;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import controller.ActionListeners;
import view.ViewClient;
import view.ViewLogin;
import view.ViewRegister;

public class Test {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin windowLogin = new ViewLogin();
					windowLogin.frameLogin.setVisible(true);

					ViewRegister windowRegister = new ViewRegister();
					windowRegister.frameRegister.setVisible(false);

					ViewClient windowClient = new ViewClient();
					windowClient.frameClient.setVisible(false);

					//initializing the actionListeners
					ActionListeners actionListenersLogin = new ActionListeners();
					actionListenersLogin.viewLogin();

					ActionListeners actionListenersRegister = new ActionListeners();
					actionListenersRegister.viewRegister();

					ActionListeners actionListenersClient = new ActionListeners();
					actionListenersClient.viewClient();

					//Checking if the essential things exists in the database and if not creating it.
					String urlConnection = "jdbc:mysql://localhost:3306/espotyfaixcv";
					String dbUser = "root";
					String dbPwd = "";

					try (Connection c = DriverManager.getConnection(urlConnection, dbUser, dbPwd);
							Statement statement = c.createStatement();) {

						// Creates the table if not exists
						String createTableQuery = "CREATE TABLE IF NOT EXISTS users ("
								+ "user_id INT AUTO_INCREMENT PRIMARY KEY,"
								+ "user_name VARCHAR(100),"
								+ "user_pwd VARCHAR(100))";
						statement.executeUpdate(createTableQuery);

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
