package examenudp_xavi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        String host = "localhost";
        int puerto = 6000;

        System.out.println("PROGRAMA CLIENTE INICIADO....\n Si quieres cambiar el número de entradas cambia el array de la clase Servidor ");
        DatagramSocket socket = new DatagramSocket();

        while (true) {
            System.out.print("ID Alumno (o '*' para salir): [IDs disponibles => 0 - 9] ");
            String id = sc.nextLine();

            byte[] datosRecibidos = id.getBytes();
            DatagramPacket paqueteEnviar = new DatagramPacket(datosRecibidos, datosRecibidos.length, InetAddress.getByName(host), puerto);
            socket.send(paqueteEnviar);

            if (id.equals("*")) {
            	System.out.println("Cerrando~~");
                break;
            }

            datosRecibidos = new byte[1024];
            DatagramPacket paqueteRecibir = new DatagramPacket(datosRecibidos, datosRecibidos.length);
            socket.receive(paqueteRecibir);

            String response = new String(paqueteRecibir.getData(), 0, paqueteRecibir.getLength());
            System.out.println("=> Recibiendo del SERVIDOR:\n\t" + response);
        }

        socket.close();
    }
}
