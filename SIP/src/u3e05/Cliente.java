package u3e05;

/*
 * Crea un programa servidor que pueda atender hasta 3 clientes. 
 * Debe enviar a cada cliente un mensaje indicando el número de cliente que es.
 *  Este número será 1, 2 o 3. El cliente mostrará el mensaje recibido. 
 *  Cambia el programa para que lo haga para N clientes, 
 *  siendo N un parámetro que tendrás que definir en el programa. 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        // Dirección IP y puerto del servidor
        String serverIP = "localhost"; 
        int serverPort = 12345; 
        try {
            // Crea un socket para conectarse al servidor
            Socket socket = new Socket(serverIP, serverPort);

            // Obtiene del socket para recibir datos del servidor
            InputStream inputStream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            // Lee y muestra el mensaje del servidor
            String mensajeServidor = in.readLine();
            System.out.println(mensajeServidor);

            // Cierra la conexión con el servidor
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
