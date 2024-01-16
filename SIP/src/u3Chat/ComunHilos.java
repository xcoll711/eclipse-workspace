package u3Chat;

import java.net.Socket;

public class ComunHilos {
	int N_CONEXIONES; 
	int N_ACTUALES; 
	int MAX_CONN; 
	Socket tabla[] = new Socket[MAX_CONN];
	String mensajes; 

	public ComunHilos(int maximo, int actuales, int conexiones, Socket[] tabla) {
		MAX_CONN = maximo;
		N_ACTUALES = actuales;
		N_CONEXIONES = conexiones;
		this.tabla = tabla;
		mensajes = "";
	}

	public ComunHilos() {
		super();
	}

	public int getMAXIMO() {
		return MAX_CONN;
	}

	public void setMAXIMO(int maximo) {
		MAX_CONN = maximo;
	}

	public int getCONEXIONES() {
		return N_CONEXIONES;
	}

	public synchronized void setCONEXIONES(int conexiones) {
		N_CONEXIONES = conexiones;
	}

	public String getMensajes() {
		return mensajes;
	}

	public synchronized void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}

	public int getACTUALES() {
		return N_ACTUALES;
	}

	public synchronized void setACTUALES(int actuales) {
		N_ACTUALES = actuales;
	}

	public synchronized void addTabla(Socket s, int i) {
		tabla[i] = s;
	}

	public Socket getElementoTabla(int i) {
		return tabla[i];
	}

}
