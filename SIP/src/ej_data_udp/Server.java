package ej_data_udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

    public static void main(String[] args) throws IOException {
        // Creamos el socket UDP
        DatagramSocket socket = new DatagramSocket(8100);
        
        System.out.println("Servidor iniciado");

        // Bucle infinito para escuchar peticiones
        while (true) {
            // Recibimos el datagrama del cliente
            DatagramPacket datagrama = new DatagramPacket(new byte[1024], 1024);
            socket.receive(datagrama);

            // Obtenemos la dirección y el puerto del cliente
            InetAddress direccionCliente = datagrama.getAddress();
            int puertoCliente = datagrama.getPort();

            // Obtenemos la cadena de formato de la fecha y hora
            String formato = new String(datagrama.getData(), 0, datagrama.getLength());

            // Formateamos la fecha y hora actual
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            Date fechaHoraActual = new Date();
            String fechaHoraFormateada = sdf.format(fechaHoraActual);

            // Enviamos la respuesta al cliente
            byte[] respuesta = fechaHoraFormateada.getBytes();
            DatagramPacket respuestaDatagrama = new DatagramPacket(respuesta, respuesta.length, direccionCliente, puertoCliente);
            socket.send(respuestaDatagrama);
        }
    }
}
