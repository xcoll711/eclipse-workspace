package u3e03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Cliente {
	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000;//puerto remoto	
		
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket Cliente = new Socket(Host, Puerto);

		DataInputStream flujoEntrada = new 
	            DataInputStream(Cliente.getInputStream());

		String msg = flujoEntrada.readUTF();
		System.out.println("Recibiendo del SERVIDOR: \n\t" + msg);
		
		DataOutputStream flujoSalida = new
	            DataOutputStream(Cliente.getOutputStream());

		flujoSalida.writeUTF(msg.toLowerCase());

		
		flujoEntrada.close();	
		flujoSalida.close();	
		Cliente.close();
	}
}
