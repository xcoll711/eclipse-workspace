package examentcpudp_xavi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String host = "localhost";
		int puerto = 6000;

		try {
			
			while(true) {
			Socket socketCliente = new Socket(host, puerto);
			DataInputStream flujoEntrada = new DataInputStream(socketCliente.getInputStream());
			DataOutputStream flujoSalida = new DataOutputStream(socketCliente.getOutputStream());

		
				// Leer la cadena desde la entrada estándar
				System.out.print("Ingrese una Hola mundo: ('fin' para finalizar)");
				String cadenaCliente = sc.nextLine();

				// Enviar la cadena al servidor
				flujoSalida.writeUTF(cadenaCliente);

				String respuestaServidor;
				// Recibir y mostrar la respuesta del servidor
				try {
					respuestaServidor = flujoEntrada.readUTF();

				}catch(Exception e) {
					respuestaServidor ="";
				}

				if(!respuestaServidor.equals("")) {
					System.out.println("Servidor responde: " + respuestaServidor);

				}
				if(respuestaServidor.equalsIgnoreCase(null)) {
					System.out.println("Cerrando...");
					break;
				}

				// Cerrar conexiones
				flujoEntrada.close();
				flujoSalida.close();
				socketCliente.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
