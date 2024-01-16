package u3e05;
/*
 * Crea un programa cliente que introduzca por teclado un número entero 
 * y se lo envíe al servidor.
 *  El servidor le devolverá el cuadrado del número. 
 */
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) {
        // Define el número de clientes (N)
    	int numeroClientes = 0; 
    	Scanner sc = new Scanner(System.in);
    	try {
    	System.out.println("Elija el numero de clientes:");
    	
    	numeroClientes = sc.nextInt();
    	}catch(Exception e) {
    		System.out.println("Reinicia el programa y pon un número válido");
    	}
    	
    

        try {

            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Servidor esperando conexiones...");

            //Lo hace una vz por cliente
            for (int cliente = 1; cliente <= numeroClientes; cliente++) {
                // Espera a que un cliente se conecte
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente " + cliente + " conectado.");

                // Obtiene el flujo de salida del socket para enviar datos al cliente
                OutputStream outputStream = clientSocket.getOutputStream();
                PrintWriter out = new PrintWriter(outputStream, true);

                // Envía un mensaje al cliente indicando su número
                out.println("¡Hola Cliente " + cliente + "!");

                // Cierra la conexión con el cliente actual
                clientSocket.close();
                System.out.println("Cliente " + cliente + " desconectado.");
            }

            // Cierra el socket del servidor
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

