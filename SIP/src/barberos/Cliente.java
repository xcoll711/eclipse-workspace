package barberos;

public class Cliente  {
	
	int n;
   Sillas sillas;
    public Cliente(int n,Sillas g){
    		this.n = n;
            this.sillas = g;
    }
    public void entrarEnBarberia(){
            int posSillaLibre = this.sillas.getPosSillaLibre();
            if (posSillaLibre==-1){
                    System.out.println("Cliente "+ n + " NO encuentra silla libre. *Desaparece* ");
                    
                    try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    return ;
            }
            System.out.println("Cliente "+ n + " se sienta en Silla "+posSillaLibre);
            
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}