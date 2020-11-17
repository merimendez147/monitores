package TP6_Punto2;

public class GestorSala {

	private int cantPersonas, cantJubiladosEsperando;
	private int capacidadMinSala=35;
	private int capacidadSala;
	private final int tUmbral = 30;
	
	public GestorSala(){
		cantPersonas=0;	
		capacidadSala=50;
	}
	
	synchronized void entrarSala (){
		while ((cantPersonas == capacidadSala) || (cantJubiladosEsperando > 0)){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cantPersonas++;
		System.out.println(" entro la " + Thread.currentThread().getName());
	}


	synchronized void entrarSalaJubilado (){
		 while (cantPersonas == capacidadSala) {

	            try {
	            	cantJubiladosEsperando++;
	                this.wait();
	                cantJubiladosEsperando--;
	            } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        cantPersonas++;
	        System.out.println(" entro la " + Thread.currentThread().getName());
	    }



	synchronized void salirSala (){
		cantPersonas--;
        this.notifyAll();
	 }


	 synchronized void notificarTemperatura (int temperatura){
		 if (temperatura > tUmbral){
			 capacidadSala=capacidadMinSala;
		 }
	 }
}
