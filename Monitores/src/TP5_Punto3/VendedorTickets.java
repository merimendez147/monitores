package TP5_Punto3;

public class VendedorTickets implements Runnable {

	private TrenTuristico atraccion;

	public VendedorTickets(TrenTuristico a) {
		atraccion = a;
	}

	public void run() {
		while (true) {
			atraccion.venderTicket();
		}
	}
}
