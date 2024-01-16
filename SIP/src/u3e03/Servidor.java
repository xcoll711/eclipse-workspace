package u3e03;
/*
 * Crea un programa servidor que pueda atender hasta 3 clientes. 
 * Debe enviar a cada cliente un mensaje indicando el número de cliente que es.
 *  Este número será 1, 2 o 3. El cliente mostrará el mensaje recibido. 
 *  Cambia el programa para que lo haga para N clientes, 
 *  siendo N un parámetro que tendrás que definir en el programa. 
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	  public static void main(String[] args) throws IOException {
		
							int numeroPuerto = 6000;
							ServerSocket servidor = new ServerSocket(numeroPuerto);
							Socket cliente = null;
							System.out.println("Esperando al cliente.....");
							cliente = servidor.accept();

							OutputStream salida = null;
							salida = cliente.getOutputStream();
							DataOutputStream flujoSalida = new DataOutputStream(salida);

							flujoSalida.writeUTF("MAYÚSCULAS");
							
							InputStream entrada = null;
							entrada = cliente.getInputStream();
							DataInputStream flujoEntrada = new DataInputStream(entrada);

							System.out.println("Recibiendo del CLIENTE: " + flujoEntrada.readUTF());

							entrada.close();
							flujoEntrada.close();
							salida.close();
							flujoSalida.close();
							cliente.close();
							servidor.close();
				}
			}