
/*ACTIVIDAD 3.8 
Usando sockets UDP. 
Realiza un programa servidor que espere un datagrama de un cliente. 
El cliente le envía un objeto Persona que previamente había inicializado. 
El servidor modifica los datos del objeto Persona y se lo envía de vuelta al cliente. 
Visualiza los datos del objeto Persona tanto en el programa cliente cuando los envía y 
los recibe como en el programa servidor cuando los recibe y los envía modificados. 
Realiza la Actividad 3.7 con sockets UDP. 
Realiza el Ejercicio 3. */

package u3e08;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
    public static void main(String[] args) {
        try {
            int puerto = 9876;
            DatagramSocket socket = new DatagramSocket(puerto);

            byte[] recibidos = new byte[1024];
            DatagramPacket recibirPaquete = new DatagramPacket(recibidos, recibidos.length);

            System.out.println("Servidor UDP esperando datagrama...");

            while (true) {
                socket.receive(recibirPaquete);

                ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
                ObjectInputStream in = new ObjectInputStream(bais);

                Persona persona = (Persona) in.readObject();
                System.out.println("Recibido del cliente: " + persona.getNombre() + " - " + persona.getEdad());

                // Modificar datos de Persona (por ejemplo, incrementar la edad)
                persona.setEdad(persona.getEdad() + 100);

                // Enviar objeto Persona modificado al cliente
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(baos);
                out.writeObject(persona);

                DatagramPacket enviarPaquete = new DatagramPacket(baos.toByteArray(),
                        baos.toByteArray().length, recibirPaquete.getAddress(),
                        recibirPaquete.getPort());

                socket.send(enviarPaquete);

                System.out.println("Enviado al cliente: " + persona.getNombre() + " - " + persona.getEdad());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

