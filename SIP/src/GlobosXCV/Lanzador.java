package GlobosXCV;


public class Lanzador {
    public static void main(String[] args) {
       
    	final int MAX_IG = 7;
    	final int MAX_PG = 7;
    	
    	Globus g = new Globus();    
    	

    	// Bucles per crear el nombre d'Infladors i Punxadors de globus que haguem dit abans
        for (int i = 1; i <= MAX_IG; i++) {

            new InflarGlobus(g, i).start();    
        }

        for (int i = 1; i <= MAX_PG; i++) {

            new PunxarGlobus(g, i).start();   
        }
    }
}


