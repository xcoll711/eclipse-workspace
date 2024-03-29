package u3pruebaInetAdress;

import java.net.*;

public class Test {

    public static void main(String[] args) {
        InetAddress dir =null;
        System.out.println("------------");
        System.out.println("local");
        try {
            dir = InetAddress.getByName("localhost");
            pruebametodos(dir);

            System.out.println("------------");
            System.out.println("url");
            dir = InetAddress.getByName("classroom.google.com");
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