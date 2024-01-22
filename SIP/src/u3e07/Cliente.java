package u3e07;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "localhost";
        int numeroPuerto = 6000;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Introduce un número (0 o menor para salir): ");
            int numero = scanner.nextInt();

            Socket cliente = new Socket(host, numeroPuerto);

            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());

            Numeros numeros = new Numeros(numero);
            out.writeObject(numeros);

            if (numero <= 0) {
                break;
            }

            Numeros resultado = (Numeros) in.readObject();
            System.out.println("Cuadrado: " + resultado.getCuadrado() + ", Cubo: " + resultado.getCubo());

            out.close();
            in.close();
            cliente.close();
        }

        scanner.close();
    }
}