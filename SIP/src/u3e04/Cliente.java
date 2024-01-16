package u3e04;

/*
 * Crea un programa cliente que introduzca por teclado un número entero 
 * y se lo envíe al servidor.
 *  El servidor le devolverá el cuadrado del número. 
 */import java.io.DataInputStream;
 import java.io.DataOutputStream;
 import java.io.IOException;
 import java.net.Socket;
 import java.util.Scanner;

 public class Cliente {
     public static void main(String[] args) throws IOException {
         String host = "localhost";
         int puerto = 6000; // Puerto remoto

         System.out.println("PROGRAMA CLIENTE INICIADO....");
         Socket cliente = new Socket(host, puerto);

         Scanner sc = new Scanner(System.in);
         System.out.print("Introduce un número entero: ");
         int numero = sc.nextInt();

         DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
         flujoSalida.writeInt(numero);

         DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
         int resultado = flujoEntrada.readInt();
         System.out.println("Recibiendo del SERVIDOR (cuadrado del número): " + resultado);

         flujoEntrada.close();
         flujoSalida.close();
         cliente.close();
     }
 }
