package barberos;

public class Sillas {
	
	
	private int MAX_SILLAS; //cogerá este número de la creación en Test
	private boolean[] sillasLibres;
	private boolean[] clienteEstaAtendido;
	private int siguienteClienteParaAtender=0;

	
	Sillas(int num){
		MAX_SILLAS=num;
		sillasLibres=new boolean[MAX_SILLAS];
		clienteEstaAtendido=new boolean[MAX_SILLAS];
		for (int i=0; i<MAX_SILLAS; i++){
			sillasLibres[i]       = true;
			clienteEstaAtendido[i]  = false;
			
		}
	}
	
	/**
	 * Nos dice que silla está libre dandonos su número
	 * Si está ocupada nos da -1 (la posición que le he puesto por defecto)
	 * 
	 */
	public synchronized int getPosSillaLibre(){
		int posSilla=-1;
		for (int pos=0; pos<MAX_SILLAS;pos++){
			if (sillasLibres[pos]==true){
				sillasLibres[pos]=false;
				return pos;
			}
		}
		return posSilla;
	}

	  public synchronized void liberarSilla(int pos) {
	        sillasLibres[pos] = true;
	        clienteEstaAtendido[pos] = false;
	        System.out.println("Cliente se va de la Silla " + pos);
	        notify();  // Notificar que la silla está disponible
	    }

	public synchronized int getSiguienteCliente(){
		// pos
		int pos=-1;
		boolean salir;
		int i;
		salir=false;
		i=this.siguienteClienteParaAtender;
		while(!salir){
			if ((this.sillasLibres[i]==false) &&(this.clienteEstaAtendido[i]==false)){
				this.clienteEstaAtendido[i]=true;
				this.siguienteClienteParaAtender= (i+1) % MAX_SILLAS;
				return i;
			}

			i++;
			if (i==this.MAX_SILLAS){
				i=0;
			}
			
			if (i==this.siguienteClienteParaAtender) { 
				salir=true;
			}


		}

		return pos;
	}
}