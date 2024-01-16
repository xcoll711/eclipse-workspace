package ejemploAdivinaNumero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class JugadorAdivina {

	private JFrame frame;
	private static JTextField textField;

	private static String Host = "localhost";
	private static int Puerto = 6001;// puerto remoto
	private static Socket Cliente;

	private static ObjectOutputStream fsalida;
	private static ObjectInputStream fentrada;

	// FLUJO PARA ENTRADA ESTANDAR
	private static Scanner sc = new Scanner(System.in);
	static String cadena;
	static int identificador;
	//
	static Datos datos;

	static JLabel lblAviso;
	static JLabel lblIntentos; 
	static JLabel lblJugadorId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JugadorAdivina window = new JugadorAdivina();
					window.frame.setVisible(true);

					Cliente = new Socket(Host, Puerto);

					fentrada = new ObjectInputStream(Cliente.getInputStream());
					fsalida = new ObjectOutputStream(Cliente.getOutputStream());

					// OBTENER PRIMER OBJETO ENVIADO POR EL SERVIDOR
					datos = (Datos) fentrada.readObject();	

					identificador = datos.getIdentificador();
					System.out.println("Id jugador: " + identificador);		
					System.out.println(datos.getCadena());

					cadena = "";

					// Establecer el título del frame después de obtener el identificador
					window.frame.setTitle("JUGADOR " + identificador + " - ADIVINA UN NUMERO");
					JugadorAdivina.lblJugadorId.setText("ID JUGADOR : "+ identificador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public JugadorAdivina() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("");
		frame.setBackground(new Color(0, 128, 255));
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblJugadorId = new JLabel("");
		lblJugadorId.setFont(new Font("Verdana Pro Semibold", Font.BOLD, 16));
		lblJugadorId.setBounds(42, 38, 226, 24);
		frame.getContentPane().add(lblJugadorId);

		lblIntentos = new JLabel("INTENTOS:  0");
		lblIntentos.setFont(new Font("Verdana Pro Semibold", Font.BOLD, 16));
		lblIntentos.setBounds(298, 38, 226, 24);
		frame.getContentPane().add(lblIntentos);

		JLabel lblNumero = new JLabel("NÚMERO A ADIVINAR: ");
		lblNumero.setFont(new Font("Verdana Pro Semibold", Font.BOLD, 18));
		lblNumero.setBounds(47, 149, 221, 39);
		frame.getContentPane().add(lblNumero);

		JLabel lblAdivinaUnNmero = new JLabel("Adivina un número entre  1 y 25");
		lblAdivinaUnNmero.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdivinaUnNmero.setBounds(84, 132, 421, 14);
		frame.getContentPane().add(lblAdivinaUnNmero);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(235, 282, 89, 39);
		frame.getContentPane().add(btnSalir);

		btnSalir.addActionListener(e -> {
			System.exit(0);
		});


		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(433, 149, 102, 45);
		frame.getContentPane().add(btnEnviar);
		btnEnviar.addActionListener(e -> {
			try {
				if(!textField.getText().trim().equals("")) {
				adivinarNumero();
				}
			} catch (Exception ex) {

				System.out.println(ex.getMessage());
			}
		});


		textField = new JTextField();
		textField.setBounds(264, 162, 159, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		lblAviso = new JLabel("");
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setBounds(84, 225, 421, 14);
		frame.getContentPane().add(lblAviso);
	}



	public static void adivinarNumero() throws IOException, ClassNotFoundException {
		
		if (!datos.isJuega()) {
			cadena="*";

		}

		if(datos.isJuega() &&  !cadena.trim().equals("*")) {	
			System.out.println("a");
			lblAviso.setText("Intento: "+(datos.getIntentos() +1)+" => Introduce número: ");
			cadena = textField.getText();
			Datos d = new Datos();

			
			if(validarCadena(cadena)) {
				d.setCadena(cadena);

				fsalida.reset();
				fsalida.writeObject(d);	

				datos = (Datos) fentrada.readObject();
				
				
				lblAviso.setText("\t"+datos.getCadena());

				lblIntentos.setText("INTENTOS: "+(datos.getIntentos()));
				if (datos.getIntentos()>=5){

					lblAviso.setText("<<JUEGO FINALIZADO, NO HAY MÁS INTENTOS>>");
					cadena="*";					
				}
				if (datos.isGana()) {
					lblAviso.setText("<<HAS GANADO!! EL JUEGO HA TERMINADO>>");	
					cadena="*";						
				} else 
					if (!(datos.isJuega()) ){
						lblAviso.setText("<<EL JUEGO HA TERMINADO, HAN ADIVINADO EL NUMERO>>");
						cadena="*";							
					}			
			}else {
				fsalida.close();
				fentrada.close();
				System.out.println("Fin de proceso... ");
				sc.close();
				Cliente.close();
			}
		}
	}
	private static boolean validarCadena(String cadena) {
		//comprueba si la cadena es numerica
		boolean valor = false;
		try{
			Integer.parseInt(cadena);
			valor=true;
		} catch (NumberFormatException e){

		}

		return valor;
	}//validarCadena
}
