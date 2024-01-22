package u3e07;
/*Crea una clase Java llamada Numeros que defina 3 atributos, uno de ellos entero, y los otros dos de tipo long: 
int numero; long cuadrado; long cubo; 
Define un constructor con parámetros y otro sin parámetros. 
Define los métodos get y set de los atributos. 
Crea un programa cliente que introduzca por teclado un número e inicialice un objeto Numeros, 
el atributo numero debe contener el número introducido por teclado. 
Debe enviar ese objeto al programa servidor. El proceso se repetirá mientras el número introducido por teclado sea mayor que 0. 
Crea un programa servidor que reciba un objeto Numeros. Debe calcular el cuadrado y el cubo del atributo
 numero y debe enviar el objeto al cliente con los cálculos realizados, el cuadrado y 
 el cubo en sus atributos respectivos. El cliente recibirá el objeto y visualizará el cuadrado y 
 el cubo del número introducido por teclado. El programa servidor finalizará cuando el número recibido en 
 el objeto Numeros sea menor o igual que 0. 
Controlar posibles errores, por ejemplo si ejecutamos el cliente y el servidor no está iniciado, 
o si estando el servidor ejecutándose ocurre algún error en el cliente, o este finaliza inesperadamente, etc. 
*/
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int numeroPuerto = 6000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);

        while (true) {
            System.out.println("Esperando al cliente...");
            Socket cliente = servidor.accept();

            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());

            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());

            Numeros numeros = (Numeros) in.readObject();
            System.out.println("Recibo: " + numeros.getNumero());

            if (numeros.getNumero() <= 0) {
                break;
            }

            out.writeObject(numeros);

            out.close();
            in.close();
            cliente.close();
            System.out.println("Cerrado");
        }

        servidor.close();
    }
}
