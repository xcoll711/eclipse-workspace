package u4exemple;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.*;

/*
 
 https://sites.google.com/site/nikos3194rfcindex/home/old-school/ftp
 ftp.uv.es
 ftp.rediris.es
 ftp.udc.es
 
 */
public class ClienteFTP1 {
	public static void main(String[] args) throws SocketException, IOException {

		FTPClient cliente = new FTPClient();
		String servFTP = "ftp.uv.es"; // servidor FTP
		System.out.println("Nos conectamos a: " + servFTP);
		cliente.connect(servFTP);

		// respuesta del servidor FTP
		System.out.print(cliente.getReplyString());
		// c�digo de respuesta
		int respuesta = cliente.getReplyCode();

		System.out.println("Respuesta: "+respuesta);
		
		// comprobaci�n del c�digo de respuesta
		if (!FTPReply.isPositiveCompletion(respuesta)) {
			cliente.disconnect();
			System.out.println("Conexi�n rechazada: " + respuesta);
			System.exit(0);
		}
		// desconexi�n del servidor FTP
		cliente.disconnect();
		System.out.println("Conexi�n finalizada.");
	}

}// ..