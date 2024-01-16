package RecursosXCV;

public class ReservaIAllibera  implements Runnable{
	  private Recurs recurs;
	    private int unitatsReserva;
	    private int unitatsAllibera;

	    public ReservaIAllibera(Recurs recurs, int unitatsReserva, int unitatsAllibera) {
	        this.recurs = recurs;
	        this.unitatsReserva = unitatsReserva;
	        this.unitatsAllibera = unitatsAllibera;
	    }

	    @Override
	    public void run() {

	        // reserva unitats del recurs
	        recurs.reserva(unitatsReserva);



	            try {
					Thread.sleep((int) (Math.random() * 1000));
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
	       


	        recurs.allibera(unitatsAllibera);
	    }
}
