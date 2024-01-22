package examenudp_xavi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;

public class Servidor {

	public static void main(String[] args) throws IOException {
		int puerto = 6000;
		DatagramSocket socket = new DatagramSocket(puerto);
		System.out.println("Servidor de Xavi esperando...");

		Alumno[] arr = generarAlumnos(10);
		
		while (true) {
			byte[] buffer = new byte[1024];
			DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);

			socket.receive(paqueteRecibido);

			String id = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
			if (id.equals("*")) {
				break;
			}

			try {
				int idAlumno = Integer.parseInt(id);
				System.out.println("Id insertada: "+idAlumno);

				if (idAlumno >= 0 && idAlumno < arr.length) {
					String alumnoInfo = arr[idAlumno].toString();
					buffer = alumnoInfo.getBytes();
					DatagramPacket paqueteEnviado = new DatagramPacket(buffer, buffer.length, paqueteRecibido.getAddress(), paqueteRecibido.getPort());
					socket.send(paqueteEnviado);
				} else {
					String error = "** ID de Alumno no válido **\n"+new Alumno().toString();
					buffer = error.getBytes();
					DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length, paqueteRecibido.getAddress(), paqueteRecibido.getPort());
					socket.send(responsePacket);
				}
			}catch(Exception e) {
				String error = "** ID de Alumno no válido **\n"+new Alumno().toString();
				buffer = error.getBytes();
				DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length, paqueteRecibido.getAddress(), paqueteRecibido.getPort());
				socket.send(responsePacket);
			}
		}

		socket.close();
	}

	private static Alumno[] generarAlumnos(int cantidad) {
		Alumno[] arr = new Alumno[cantidad];
		String[] nombres = {"Pedro", "Juan", "Ana", "María", "Luis"};
		String[] asignaturas = {"Matemáticas", "Biologia", "Castellano", "Inglés"};
		Random r = new Random();

		for (int i = 0; i < cantidad; i++) {
			String id = String.valueOf(i);
			String nombre = nombres[r.nextInt(nombres.length)];
			Curso curso = new Curso(id, asignaturas[r.nextInt(asignaturas.length)]);
			int nota = r.nextInt(10);

			arr[i] = new Alumno(id, nombre, curso, nota);
		}

		return arr;
	}
}