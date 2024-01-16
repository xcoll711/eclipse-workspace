package u2exemple2;

import java.io.*;

public class exempleProcessos2 {
   public static void main (String[] args) throws IOException {
     //Ejecutamos el proceso DIR
     Process p = new ProcessBuilder ("CMD", "/C", "DIR") .start();
     //Mostramos carácter a carácter la salida generada por DIR
     try {
        InputStream is =p.getInputStream();
         int c;
         while ((c = is.read()) != -1)
              System.out.print ((char) c);
         is.close ();
         } catch (Exception e) {
              e.printStackTrace();
         }
         //COMPROBACIÓN DE ERROR - 0 bien - 1 mal
int exitVal;
try {
     exitVal = p.waitFor();//recoge la salida de System. exit()
      System. out.println ("Valor de Salida: " + exitVal);
 } catch (InterruptedException e) {
     e.printStackTrace ();
 }
         }
        
}