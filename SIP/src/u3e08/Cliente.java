package u3e08;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);

			InetAddress servidorDireccion = InetAddress.getByName("localhost");
			int puerto = 9876;
			DatagramSocket socket = new DatagramSocket();
			while (true) {
				System.out.print("Introduce nombre: ");
				String nombre = sc.nextLine(); // Leemos toda la línea, incluso el salto de línea
				System.out.print("Introduce edad: ");

				// Verificamos si hay un próximo entero antes de leerlo
				if (sc.hasNextInt()) {
					int edad = sc.nextInt();
					sc.nextLine(); // agregamos un salto de linea 

					Persona persona = new Persona(nombre, edad);


					// Enviar objeto Persona al servidor
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ObjectOutputStream out = new ObjectOutputStream(baos);
					out.writeObject(persona);

					DatagramPacket enviarPaquete = new DatagramPacket(baos.toByteArray(),
							baos.toByteArray().length, servidorDireccion, puerto);

					socket.send(enviarPaquete);

					// Recibimos objeto Persona modificado del servidor
					byte[] recibidos = new byte[1024];
					DatagramPacket recibirPaquete = new DatagramPacket(recibidos, recibidos.length);
					socket.receive(recibirPaquete);

					ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
					ObjectInputStream in = new ObjectInputStream(bais);

					Persona personaModificada = (Persona) in.readObject();
					System.out.println("Recibido del servidor ya modificado: " + personaModificada.getNombre() + " - "
							+ personaModificada.getEdad());
				} else {
					System.out.println("Edad no válida. Introduce un número entero.");
					sc.nextLine(); // Limpiar el input incorrecto
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}