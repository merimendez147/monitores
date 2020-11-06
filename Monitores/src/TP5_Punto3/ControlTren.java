package TP5_Punto3;

public class ControlTren implements Runnable {
	private TrenTuristico atraccion;

	public ControlTren(TrenTuristico a) {
		atraccion = a;
	}

	public void run() {
		while (true) {
			atraccion.salirTren();
		}
	}
}
