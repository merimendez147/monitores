package TP5_Punto1;

public class Gato implements Runnable {
Comedor comedero;

	
	public Gato(Comedor c){
		comedero=c;
		
	}
	
	private void comer(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		comedero.esperarTurnoGato();
		comedero.entrarGato();
		comer();
		comedero.salirGato();
	}

}
