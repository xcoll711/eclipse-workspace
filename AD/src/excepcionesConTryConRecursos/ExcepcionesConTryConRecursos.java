package excepcionesConTryConRecursos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Random;

public class ExcepcionesConTryConRecursos {

	public static void main(String[] args) {

		File fm1=null;
		File fm2=null;
		
		//Començam amb aquesta declaració de File, 
		// però com que no pot trobar el fitxer ni entrarà dins el try i ens enviarà directament al catch de FileNotFoundException
		// 
		try(FileInputStream ifs1 = new FileInputStream( ("f1.dat"));
				FileInputStream ifs2 = new FileInputStream("f2.dat")) {



			//Mostra la descripció dels arxius d'abans
			System.out.println("Abierto fl.dat: " + ifs1.getFD().toString());
			System.out.println("Abierto f2.dat: " + ifs2.getFD().toString());

			// Crea un objete Random y genera un nombre aleatori entre 1 y 3
			Random aleat = new Random();
			int falloTras = aleat.nextInt(3) + 1;

			// Comprueba si el número aleatorio generado anteriormente es menor o igual que 1. Si es así, imprime un mensaje y sale del programa
			if (falloTras <= 1) {
			    System.out.println("SE SALE AL LLEGAR A " + falloTras);
			    return;
			}

			// crea un  nou arxiu amb aquest nom
			 fm1 = new File("f1.info.tmp");
			fm1.createNewFile();

			System.out.println("Creado " + fm1.getAbsolutePath());

			// Comprueba si el número aleatorio generado anteriormente es menor o igual que 2. Si es así, imprime un mensaje y sale del programa
			if (falloTras <= 2) {
			    System.out.println("SE SALE AL LLEGAR A " + falloTras);
			    return;
			}

			// crea un  nou arxiu amb aquest nom
			 fm2 = new File("f2.info.tmp");
			fm2.createNewFile();
			System.out.println("Creado " + fm2.getAbsolutePath());

			
			System.out.println("Ejecutado hasta el final");

			
			//Catch de l'excepció de que no ha trobat l'arxiu en el FileInput.
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado: "+e.getMessage());

			//Catch de excepctions general
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			System.out.println("Liberando recursos: INICIO.");

			//esborra els arxius si no estàn buids 
			if(fm1!=null) {
				fm1.delete();
				System. out.println( "Borrado "+fm1.getName ());
			}

			if(fm2!=null) {
				fm1.delete();
				System. out.println( "Borrado "+fm2.getName ());
			}

			System.out.println("Liberando recursos. FINN.");

		}
	}
}
