package GlobosXCV;

import java.util.Arrays;

public class Globus {
	final int MAX_INFLANTSE = 3; //a la vegada
	final int MAX_GLOBUS = 10; //nombre de globus de l'almacén
	final int MAX_VOLUM = 5; // volum per a que exploti
	int nGlobus = 1; //nombre per on començam a l'hora de posarli el nom
	int inflantse = 0; // num de globus inflantse actualment
	int[] globus;

	public Globus() {
		globus = new int[MAX_GLOBUS];
		Arrays.fill(globus, 0); // es ficaràn tots els globus aqui dins
	}

	
	public synchronized int donarGlobus() {
		
		// esperarà mentre hi hagi globus sense inflar i no pugui fer-ho
		while (inflantse == MAX_INFLANTSE && nGlobus != MAX_GLOBUS + 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

		if (nGlobus == MAX_GLOBUS + 1) {
			return -1;
		}

		globus[nGlobus - 1] = 1;
		System.out.println("Globus " + nGlobus + " LLIURAT a " + Thread.currentThread().getName());
		inflantse++;
		notifyAll();
		return nGlobus++;
	}

	public synchronized boolean punxar() {
		while (inflantse == 0 && nGlobus != MAX_GLOBUS + 1) {
			try {
				wait();
			} catch (InterruptedException e) {

			}
		}

		if (nGlobus == MAX_GLOBUS + 1) {
			return true;
		}

		// avisar i dir si un globus ha estat punxat i per qui
		for (int i = 0; i < MAX_GLOBUS; i++) {
			if (globus[i] > 0 && globus[i] <= MAX_VOLUM) {
				System.out.println("Globus " + (i + 1) + " PUNXAT per " + Thread.currentThread().getName());
				globus[i] = MAX_VOLUM + 2;
				inflantse--;
				notifyAll();
				break;
			}
		}

		return inflantse != 0;
	}

	public synchronized boolean inflar(int num) {
		if (globus[num - 1] <= MAX_VOLUM) {
			globus[num - 1]++;
		} else {
			return true;
		}

		if (globus[num - 1] == MAX_VOLUM + 1) {
			inflantse--;
			System.out.println("Globus " + num + " EXPLOTA per el seu volum");
			notifyAll();
			return true;
		} else {
			System.out.println("Globus " + num + " VOLUM " + globus[num - 1]);
			return false;
		}
	}
}

