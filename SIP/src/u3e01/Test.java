package u3e01;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
/*C:\Users\ciclesgs.EAAULA211W-024\eclipse-workspace\SIP\src\u3e01>java Test.java www.google.es
------------
Inserte el nombre de la máquina o una dirección IP o URL
Metodo getName() www.google.es/142.250.200.99
metodo getLocalHost() EAAULA117W-013/192.168.56.1
Metodo getHostName() www.google.es
Metodo getHostAddress() 142.250.200.99
Metodo toString() www.google.es/142.250.200.99
Metodo getCanonicalHostName() mad41s13-in-f3.1e100.net
direccioneswww.google.es
www.google.es/142.250.200.99
------------

C:\Users\ciclesgs.EAAULA211W-024\eclipse-workspace\SIP\src\u3e01>
*/
public class Test {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        InetAddress dir =null;
     
        try {
           

            System.out.println("------------");
            
            
            System.out.println("Inserte el nombre de la máquina o una dirección IP o URL");
            String address = args[0];
            
            
            dir = InetAddress.getByName(address);
            pruebametodos(dir);

            System.out.println("direcciones" + dir.getHostName());
            InetAddress [] direc = InetAddress.getAllByName(dir.getHostName());
            for (int i = 0; i < direc.length; i++) {
                System.out.println(direc[i].toString());
            }
            System.out.println("------------");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void pruebametodos(InetAddress dir) {
        System.out.println("Metodo getName() " + dir);
        InetAddress dir2;

        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("metodo getLocalHost() " + dir2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println("Metodo getHostName() " + dir.getHostName());
        System.out.println("Metodo getHostAddress() " + dir.getHostAddress());
        System.out.println("Metodo toString() " + dir.toString());
        System.out.println("Metodo getCanonicalHostName() " + dir.getCanonicalHostName());

    }
}