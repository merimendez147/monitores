package TP6_Punto2;

public class NoJubilada extends Persona implements Runnable {
	
	
	public NoJubilada(GestorSala gs) {
		super(gs);
	}


	public void run(){
		this.gestorSala.entrarSala();
	}
}
