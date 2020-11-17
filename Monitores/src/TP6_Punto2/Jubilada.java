package TP6_Punto2;

public class Jubilada extends Persona implements Runnable {
	
	
	public Jubilada(GestorSala gs) {
		super(gs);
	}


	public void run(){
		this.gestorSala.entrarSalaJubilado();
	}
}