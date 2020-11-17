package TP6_Punto2;

public class MedidorTemp implements Runnable {
	GestorSala gestorSala;
	private int temperatura;

	public MedidorTemp(GestorSala gS) {
		gestorSala = gS;
	}

	private void sensarTemperatura() {
		temperatura = (int) (Math.random() * 20 + 50);
	}

	public void run() {
		while (true) {
			sensarTemperatura();
			gestorSala.notificarTemperatura(temperatura);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
