package almacenes;

public class Almacen {
	
	
    int nProductos;
   
    /*
     * se asigna el número de productos aquí 
     * para que luego se tenga el método relacionado 
     * directamente con el número de productos 
     * y los pueda ir restando sin tocar el final
     */

    public Almacen(int nProductos){
            this.nProductos=nProductos;
    }
    
    public boolean cogerProducto(){
            if (this.nProductos>0){
                    this.nProductos--;
                    
                    return true;
                    
            }
            return false;
    }
    
}