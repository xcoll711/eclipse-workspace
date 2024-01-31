package u4e03;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.net.ftp.FTPClient;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Test403 {

	private static final String HOST = "localhost";
	private static final int PUERTO = 21;

	private JFrame frame;
	private JTextArea textArea;
	private JTextField tfUsu;
	private JTextField tfPwd;

	private  JLabel lbl1;
	private  JLabel lbl2;
	private JLabel lblError;
	private JTextField tfArchivo;
	private JTextField tfRename;
	private JLabel lbl4;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test403 window = new Test403();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Test403() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 368, 440);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JButton btnConectar = new JButton("Iniciar Sesión");
		btnConectar.setBounds(401, 103, 150, 30);
		frame.getContentPane().add(btnConectar);

		JButton btnDescargar = new JButton("Descargar ");
		btnDescargar.setBounds(388, 188, 186, 30);
		frame.getContentPane().add(btnDescargar);

		tfUsu = new JTextField();
		tfUsu.setBounds(388, 33, 186, 20);
		frame.getContentPane().add(tfUsu);
		tfUsu.setColumns(10);

		tfPwd = new JTextField();
		tfPwd.setColumns(10);
		tfPwd.setBounds(388, 72, 186, 20);
		frame.getContentPane().add(tfPwd);

		lbl1 = new JLabel("Usuario:");
		lbl1.setBounds(388, 16, 186, 14);
		frame.getContentPane().add(lbl1);

		lbl2 = new JLabel("Clave:");
		lbl2.setBounds(388, 58, 186, 14);
		frame.getContentPane().add(lbl2);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblError.setBounds(388, 409, 186, 30);
		frame.getContentPane().add(lblError);
		
		JButton btnRenombrar = new JButton("Renombrar");
		btnRenombrar.setBounds(388, 229, 186, 30);
		frame.getContentPane().add(btnRenombrar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(388, 270, 186, 30);
		frame.getContentPane().add(btnBorrar);
		
		tfArchivo = new JTextField();
		tfArchivo.setColumns(10);
		tfArchivo.setBounds(388, 161, 186, 20);
		frame.getContentPane().add(tfArchivo);
		
		JLabel lbl3 = new JLabel("Archivo afectado");
		lbl3.setBounds(388, 149, 186, 14);
		frame.getContentPane().add(lbl3);
		
		tfRename = new JTextField();
		tfRename.setColumns(10);
		tfRename.setBounds(388, 373, 186, 20);
		frame.getContentPane().add(tfRename);
		
		lbl4 = new JLabel("Nuevo nombre: [Escribe extensión]");
		lbl4.setBounds(398, 359, 186, 14);
		frame.getContentPane().add(lbl4);
		
		JButton btnDescargar_1 = new JButton("Descargar ");
		btnDescargar_1.setBounds(388, 311, 186, 30);
		frame.getContentPane().add(btnDescargar_1);

		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connectToFTP();
			}
		});

		btnDescargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descargar();
			}
		});
		
		btnRenombrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renombrar();
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
	}

	private void connectToFTP() {
		try {
			
			lblError.setText("");
			// Creamos un cliente FTP
			FTPClient clienteFTP = new FTPClient();

			// Nos conectamos al servidor FTP
			clienteFTP.connect(HOST, PUERTO);

			// Nos autenticamos
			clienteFTP.login(tfUsu.getText(), tfPwd.getText());

			// Obtenemos la lista de ficheros
			String[] archivos = clienteFTP.listNames();

			// Mostramos la lista de ficheros
			StringBuilder fileList = new StringBuilder("Lista:\n");
			for (String archivo : archivos) {
				fileList.append(archivo).append("\n");
			}
			textArea.setText(fileList.toString());

			// Cerramos la conexión
			clienteFTP.disconnect();

		} catch (SocketException e) {
			lblError.setText("Error");
		} catch (IOException e) {
			lblError.setText("Error");
		}catch(Exception e) {
			lblError.setText("Error");

		}
	}

	private void descargar() {
	    try {
	        lblError.setText("");

	        // Use JFileChooser to select the file to download
	        JFileChooser fileChooser = new JFileChooser();
	        int result = fileChooser.showSaveDialog(frame);

	        if (result == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();

	            // Descargamos el fichero
	            FTPClient clienteFTP = new FTPClient();
	            clienteFTP.connect(HOST, PUERTO);
	            clienteFTP.login(tfUsu.getText(), tfPwd.getText());

	            InputStream inputStream = clienteFTP.retrieveFileStream(selectedFile.getName());
	            FileOutputStream outputStream = new FileOutputStream(selectedFile);
	            byte[] bytes = new byte[1024];
	            int bytesLeidos;
	            while ((bytesLeidos = inputStream.read(bytes)) != -1) {
	                outputStream.write(bytes, 0, bytesLeidos);
	            }
	            inputStream.close();
	            outputStream.close();

	            // Mostramos un mensaje de confirmación
	            JOptionPane.showMessageDialog(frame, "El fichero se ha descargado correctamente.");

	            // Cerramos la conexión
	            clienteFTP.disconnect();
	        }

	    } catch (SocketException e) {
	        lblError.setText("Error");
	    } catch (IOException e) {
	        lblError.setText("Error");
	    } catch (Exception e) {
	        lblError.setText("Error");
	    }
	}

	private void renombrar() {
	    try {
	        lblError.setText("");

	        // Use JFileChooser to select the file to rename
	        JFileChooser fileChooser = new JFileChooser();
	        int result = fileChooser.showOpenDialog(frame);

	        if (result == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            String nuevoNombre = JOptionPane.showInputDialog(frame, "Introduce el nuevo nombre:");

	            // Renombrar el archivo
	            FTPClient clienteFTP = new FTPClient();
	            clienteFTP.connect(HOST, PUERTO);
	            clienteFTP.login(tfUsu.getText(), tfPwd.getText());

	            if (clienteFTP.rename(selectedFile.getName(), nuevoNombre)) {
	                JOptionPane.showMessageDialog(frame, "El archivo se ha renombrado correctamente.");
	            } else {
	                lblError.setText("Error al renombrar el archivo.");
	            }

	            clienteFTP.disconnect();
	        }

	    } catch (SocketException e) {
	        lblError.setText("Error");
	    } catch (IOException e) {
	        lblError.setText("Error");
	    } catch (Exception e) {
	        lblError.setText("Error");
	    }
	}
	private void borrar() {
	    try {
	        lblError.setText("");

	        // Seleccionar el archivo a borrar
	        String archivoABorrar = (String) JOptionPane.showInputDialog(frame, "",
	                "Selecciona el fichero a borrar:", JOptionPane.PLAIN_MESSAGE, null, null, null);

	        if (archivoABorrar != null) {
	            // Borrar el archivo
	            FTPClient clienteFTP = new FTPClient();
	            clienteFTP.connect(HOST, PUERTO);
	            clienteFTP.login(tfUsu.getText(), tfPwd.getText());

	            if (clienteFTP.deleteFile(archivoABorrar)) {
	                JOptionPane.showMessageDialog(frame, "El archivo se ha borrado correctamente.");
	            } else {
	                lblError.setText("Error al borrar el archivo.");
	            }

	            clienteFTP.disconnect();
	        }
	    } catch (SocketException e) {
	        lblError.setText("Error");
	    } catch (IOException e) {
	        lblError.setText("Error");
	    } catch (Exception e) {
	        lblError.setText("Error");
	    }
	}
	
	private void crear() {
	    try {
	        lblError.setText("");

	        // Obtener el nombre del nuevo archivo
	        String nuevoArchivo = JOptionPane.showInputDialog(frame, "Introduce el nombre del nuevo archivo:");

	        if (nuevoArchivo != null && !nuevoArchivo.isEmpty()) {
	            // Crear el nuevo archivo en el servidor
	            FTPClient clienteFTP = new FTPClient();
	            clienteFTP.connect(HOST, PUERTO);

	            clienteFTP.login(tfUsu.getText(), tfPwd.getText());

	            // Utilizamos el método storeFile para crear el nuevo archivo vacío
	            if (clienteFTP.storeFile(nuevoArchivo, new ByteArrayInputStream(new byte[0]))) {
	                JOptionPane.showMessageDialog(frame, "El archivo se ha creado correctamente.");
	            } else {
	                lblError.setText("Error al crear el archivo.");
	            }

	            clienteFTP.disconnect();
	        } else {
	            lblError.setText("Nombre de archivo inválido.");
	        }
	    } catch (SocketException e) {
	        lblError.setText("Error");
	    } catch (IOException e) {
	        lblError.setText("Error");
	    } catch (Exception e) {
	        lblError.setText("Error");
	    }
	}
}
