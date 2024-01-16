package exception1;

public class ExcepcionesDivPorCero {


	public int divide(int a, int b) { 
		return a/b; 
	} 



	public static void main(String[] args) { 

		//tindrem que inicialitzar els ints per a poder fer el try catch
		int a = 0,b = 0; 

		//I ara amb els try catch tenim gestionats els errors que puguin donar diràn el problema gràcies al nostre syse 
		try {
			a=5; b=2; System.out.println(a+"/"+b+"="+a/b);
		}catch(ArithmeticException e){
			System.err.println("Error al dividir: "+ a + "/" + b);
		}
		
		try {
			b=0; System.out.println(a+"/"+b+"="+a/b); 
		}catch(ArithmeticException e){
			System.err.println("Error al dividir: "+ a + "/" + b);
		}
		
		
		try {
			b=3; System.out.println(a+"/"+b+"="+a/b); 
		}catch(ArithmeticException e){
			System.err.println("Error al dividir: "+ a + "/" + b);
		}
	}
}