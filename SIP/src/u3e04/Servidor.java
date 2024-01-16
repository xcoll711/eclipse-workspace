package u3e04;
/*
 * Crea un programa cliente que introduzca por teclado un número entero 
 * y se lo envíe al servidor.
 *  El servidor le devolverá el cuadrado del número. 
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int numeroPuerto = 6000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        Socket cliente = null;
        System.out.println("Esperando al cliente.....");
        cliente = servidor.accept();

        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
        int numero = flujoEntrada.readInt();
        System.out.println("Recibiendo del CLIENTE: " + numero);

        int cuadrado = numero * numero;

        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
        flujoSalida.writeInt(cuadrado);

        flujoEntrada.close();
        flujoSalida.close();
        cliente.close();
        servidor.close();
    }
}
