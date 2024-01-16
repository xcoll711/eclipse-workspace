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

 */package u3e06;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPCliente {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket(); // socket cliente

            // DATOS DEL SERVIDOR al que enviar mensaje
            InetAddress IPServidor = InetAddress.getLocalHost(); // localhost
            int puerto = 12345; // puerto por el que escucha

            String cadena = "";
            while (!cadena.trim().equals("*")) {
                // INTRODUCIR DATOS POR TECLADO
                System.out.print("Introduce mensaje (o * para salir): ");
                cadena = sc.nextLine();

                byte[] enviados = cadena.getBytes();

                // ENVIANDO DATAGRAMA AL SERVIDOR
                DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
                clientSocket.send(envio);

                // RECIBIENDO DATAGRAMA DEL SERVIDOR
                byte[] recibidos = new byte[1024];
                DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
                System.out.println("Esperando datagrama....");

                try {
                    clientSocket.receive(recibo);
                   
                    System.out.println("Respuesta del servidor: " + new String(recibo.getData()).trim());
                } catch (IOException e) {
                    System.out.println("Paquete perdido. Tiempo de espera agotado.");
                }
            }

            // CERRAR SOCKET
            System.out.println("Cerrando conexión...");
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
