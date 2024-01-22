package examentcpudp_xavi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		int puerto = 6000;

		try (ServerSocket servidor = new ServerSocket(puerto)) {
			System.out.println("Servidor esperando conexiones...");

			while (true) {
				Socket clienteConectado = servidor.accept();
				System.out.println("Nuevo cliente conectado.");

				// Crear un hilo para manejar la conexión
				Thread hiloCliente = new Thread(new HiloCliente(clienteConectado));
				hiloCliente.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class HiloCliente implements Runnable {
	private Socket clienteConectado;

	public HiloCliente(Socket clienteConectado) {
		this.clienteConectado = clienteConectado;
	}

	@Override
	public void run() {
		try {
			DataInputStream flujoEntrada = new DataInputStream(clienteConectado.getInputStream());
			DataOutputStream flujoSalida = new DataOutputStream(clienteConectado.getOutputStream());

			// Recibiendo la cadena del cliente
			String cadenaCliente = flujoEntrada.readUTF().toLowerCase().trim();
			System.out.println("Cliente dice: " + cadenaCliente);

			
			boolean contieneHolaMundo = false;
	        int longitudCadena = cadenaCliente.length();

	        for (int i = 0; i <= longitudCadena - 10; i++) {
	            String subcadena = cadenaCliente.substring(i, i + 10);

	            if (subcadena.equals("hola mundo") || subcadena.equals("mundo hola")) {
	                contieneHolaMundo = true;
	                break;
	            }
	            
	            
	        }
	        
	            
	            
	        

			// Verificando la cadena del cliente
			if (contieneHolaMundo) {
				// Respondiendo al cliente
				flujoSalida.writeUTF("hola mon");
				clienteConectado.close();

			}else {

				
			}

			flujoEntrada.close();
			flujoSalida.close();
			clienteConectado.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
