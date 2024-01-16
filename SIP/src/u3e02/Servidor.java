package u3e02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        ServerSocket servSocket = null;
        try {
            servSocket = new ServerSocket(6665);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Escuchando en " + servSocket.getLocalPort());

        try {
            Socket client1 = servSocket.accept();
            Socket client2 = servSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            servSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
