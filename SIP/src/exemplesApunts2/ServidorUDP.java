package exemplesApunts2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {

    public static void main(String[] args) throws IOException {

        // Crea un socket UDP
        DatagramSocket socket = new DatagramSocket(5000);

        // Bucle infinito para recibir mensajes
        while (true) {

            // Recibe un paquete UDP
            DatagramPacket paquete = new DatagramPacket(new byte[1024], 1024);
            socket.receive(paquete);

            // Obtiene el mensaje del paquete
            String mensaje = new String(paquete.getData(), 0, paquete.getLength());

            // Guarda el mensaje en un archivo
            File archivo = new File("mensajes.txt");
            archivo.createNewFile();
            FileWriter escritor = new FileWriter(archivo, true);
            escritor.write(mensaje + "\n");
            escritor.close();

            // Devuelve un mensaje de confirmación
            DatagramPacket paqueteConfirmacion = new DatagramPacket("Mensaje recibido correctamente".getBytes(), "Mensaje recibido correctamente".length(), paquete.getAddress(), paquete.getPort());
            socket.send(paqueteConfirmacion);
        }
    }
}