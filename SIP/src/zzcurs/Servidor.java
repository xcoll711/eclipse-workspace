package zzcurs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor {

    public static void main(String[] args) throws IOException {
        int numeroPuerto = 6000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        System.out.println("Servidor iniciado. Esperando clientes...");

        Alumno[] arr = generarAlumnos(5);

        Random r = new Random();

      
        try {
            while (true) {
                Socket clienteConectado = servidor.accept();
                System.out.println("Nuevo cliente conectado.");
                Thread clientThread = new Thread(() -> handleClient(clienteConectado, arr));
                clientThread.start();
            }
        } finally {
            servidor.close();
        }
    }
    
    private static Alumno[] generarAlumnos(int cantidad) {
        Alumno[] arr = new Alumno[cantidad];
        String[] nombres = {"Antoniete", "Juan Antonio", "Ana Mendez", "Juan Luís Ferran", "Luis Hernando"};
        String[] asignaturas = {"Matematicas", "Biologia", "Castellano", "Ingles"};
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

    private static void handleClient(Socket clienteConectado, Alumno[] arr) {
        try (DataInputStream flujoEntrada = new DataInputStream(clienteConectado.getInputStream());
             DataOutputStream flujoSalida = new DataOutputStream(clienteConectado.getOutputStream())) {

            String id;

            while (true) {
                id = flujoEntrada.readUTF();

                if (id.equals("*")) {
                    break;
                }

                int idAlumno = Integer.parseInt(id);

                if (idAlumno >= 0 && idAlumno < arr.length) {
                    flujoSalida.writeUTF(arr[idAlumno].toString());
                } else {
                    flujoSalida.writeUTF("ID de Alumno no válido");
                }
            }
        } catch (IOException e) {
           // System.err.println("Error al manejar la conexión del cliente: " + e.getMessage());
        } finally {
            try {
                clienteConectado.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Cliente desconectado.");
        }
    }
}
