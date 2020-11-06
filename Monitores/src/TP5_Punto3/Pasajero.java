package TP5_Punto3;

public class Pasajero implements Runnable {
	private TrenTuristico atraccion;

	public Pasajero(TrenTuristico a) {
		atraccion = a;
	}

	public void run() {
		atraccion.obtenerTicket();
		atraccion.subirTren();
	}

}
