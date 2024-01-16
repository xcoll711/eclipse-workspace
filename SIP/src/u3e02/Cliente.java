package u3e02;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

    public static void main(String[] args) throws IOException {
        // Cream els sockets per als clients
        Socket client1 = null;
        Socket client2 = null;

        //assignam als sockets el mateix port que al server
        try {
            client1 = new Socket("localhost", 6665);
            client2 = new Socket("localhost", 6665);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("1 Puerto local: " + client1.getLocalPort());
        System.out.println("1 Puerto remoto: " + client1.getPort());
        System.out.println("1 Nombre Host/IP: " + client1.getInetAddress());
        System.out.println("1 Host remoto: " + client1.getInetAddress().getHostName());
        System.out.println("1 IP Host remoto: " +client1.getInetAddress().getHostAddress() + "\n");

        
        System.out.println("2 Puerto local: " + client2.getLocalPort());
        System.out.println("2 Puerto remoto: " + client2.getPort());
        System.out.println("2 Nombre Host/IP: " + client2.getInetAddress());
        System.out.println("2 Host remoto: " + client2.getInetAddress().getHostName());
        System.out.println("2 IP Host remoto: " + client2.getInetAddress().getHostAddress());

        
        // Tancam els processos
        try {
            client1.close();
            client2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
