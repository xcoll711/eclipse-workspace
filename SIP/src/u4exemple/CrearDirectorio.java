package u4exemple;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class CrearDirectorio {

	public static void main(String[] args) {
		FTPClient cliente = new FTPClient();
		String servFTP = "127.0.0.1";
		System.out.println("Nos conectamos a: " + servFTP);

		String usuario = "usuario1";
		String clave = "1234";

		try {
			cliente.connect(servFTP);
	        //modo de conexion del cliente: pasivo-comandos de tipo PASV 
            cliente.enterLocalPassiveMode(); //muestra los ficheros

           	boolean login = cliente.login(usuario, clave);
			if (login)
				System.out.println("Login correcto...");
			else {
				System.out.println("Login Incorrecto...");
				cliente.disconnect();
				System.exit(1);
			}
			
			
		       //MOSTRAR SOLO DIRECTORIOS
			 String directorio="NUEVODIREC1";
	            
	            if(cliente.makeDirectory(directorio))
	            	System.out.println("Directorio creado.");
	            else
	            	System.out.println("NO SE HA PODIDO CREAR EL DIRECTORIO.");
	            
	            //MOSTRAR SOLO ARCHIVOS
			
	        	FTPFile[] files = cliente.listFiles();
							
				String tipos[] = {"Fichero", "Directorio","Enlace simb."};
				
				for (int i = 0; i < files.length; i++) {
					if(files[i].getType()==1)
					  System.out.println("\t" + files[i].getName() );
				}	
				
			
			boolean logout = cliente.logout();
			if (logout) 
				System.out.println("Logout del servidor FTP...");			
		    else 
		  	   System.out.println("Error al hacer Logout...");
			//
			cliente.disconnect();
			System.out.println("Desconectado...");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}	
	}

}
