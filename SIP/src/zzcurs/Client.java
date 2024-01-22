package zzcurs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int puerto = 6000;

		System.out.println("PROGRAMA CLIENTE INICIADO....");
		try (Socket cliente = new Socket(host, puerto);
				DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
				DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream())) {

			String id;
			while (true) {
				System.out.print("ID Alumno (o '*' para salir): ");
				id = sc.nextLine();

				if (id.equals("*")) {
					break;
				}

				flujoSalida.writeUTF(id);
				System.out.println("Recibiendo del SERVIDOR:\n\t" + flujoEntrada.readUTF());
			}
			sc.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage() + "\n" + e.getCause());

		} catch (IOException e) {
			System.out.println(e.getMessage() + "\n" + e.getCause());
			
		}catch(Exception e) {
			System.out.println(e.getMessage() + "\n" + e.getCause());

		}
	}
}