package u3e07;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Numeros implements Serializable {
    private int numero;
    private long cuadrado;
    private long cubo;

   
    public Numeros(int numero) {
        this.numero = numero;
        calcularCuadradoYCubo();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
        calcularCuadradoYCubo();
    }

    public long getCuadrado() {
        return cuadrado;
    }

    public long getCubo() {
        return cubo;
    }

    private void calcularCuadradoYCubo() {
        this.cuadrado = (long) numero * numero;
        this.cubo = (long) numero * numero * numero;
    }
}
