/* Crea un programa cliente usando sockets UDP que envíe el texto
 *  escrito desde la entrada estándar al servidor. El servidor le 
 *  devolverá la cadena en mayúsculas. El proceso de entrada de datos 
 *  finalizará cuando el cliente introduzca un asterisco. 
 *  Crea un programa servidor que reciba cadenas de caracteres,
 *   las muestre en pantalla y se las envíe al emisor en mayúscula. 
 *   El proceso servidor finalizará cuando reciba un asterisco. 
 *   Establece un tiempo de espera de 5000 milisegundos con el 
 *   método setSoTimeout(4000) para hacer que el método receive() 
 *   del programa cliente se bloquee. Pasado ese tiempo controlar 
 *   si no se reciben datos lanzando la excepción InterruptedIOException,
 *    en cuyo caso visualiza un mensaje indicando que el paquete se ha perdido. 
 *    Para probarlo ejecuta el programa cliente sin ejecutar el servidor. 
 *    Puedes ejecutar varios programas cliente a la vez. 
 */

package u3e06;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServidor {
    public static void main(String[] args) {
        try {
            // Asocio el socket al puerto 12345
            DatagramSocket socket = new DatagramSocket(12345);
            System.out.println("Servidor Esperando Datagrama .......... ");

            String mensaje = "";
            while (!mensaje.equals("*")) {
                DatagramPacket recibo;

                byte[] bufer = new byte[1024]; // para recibir el datagrama
                recibo = new DatagramPacket(bufer, bufer.length);

                try {
                    socket.receive(recibo); // recibo datagrama
                } catch (IOException e) {
                    System.out.println("Paquete perdido. Tiempo de espera agotado.");
                    continue;
                }

               mensaje = new String(recibo.getData(), 0, recibo.getLength());// obtengo String

               


                // Convertir a mayúsculas
                String mensajeMayusculas = mensaje.toUpperCase();

                // DIRECCION ORIGEN DEL MENSAJE
                InetAddress IPOrigen = recibo.getAddress();
                int puerto = recibo.getPort();

                

                byte[] enviados = mensajeMayusculas.getBytes();
                DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
                socket.send(envio);
            }

            // CERRAR SOCKET
            System.out.println("Cerrando conexión...");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
