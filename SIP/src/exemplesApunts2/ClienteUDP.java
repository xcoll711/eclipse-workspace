package exemplesApunts2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {

    public static void main(String[] args) throws IOException {

        // Crea un socket UDP
        DatagramSocket socket = new DatagramSocket();

        // Solicita al usuario el mensaje a enviar
        System.out.println("Introduce el mensaje a enviar: ");
        String mensaje = System.console().readLine();

        // Crea un paquete UDP con el mensaje
        DatagramPacket paquete = new DatagramPacket(mensaje.getBytes(), mensaje.length(), InetAddress.getLocalHost(), 5000);

        // Envía el paquete al servidor
        socket.send(paquete);

        // Cierra el socket
        socket.close();
    }
}

