package Hamsters;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static class Rueda {
		public synchronized void rodar(String nombre) {
			System.out.println(nombre + " empieza a rodar");
			try {
				Thread.sleep((long) Math.random() * 15500);
			} catch (InterruptedException ex) {
				Logger.getLogger(Rueda.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public static class Plato {
		int cantidad;
		private int comiendo;

		public Plato(int maximo) {
			cantidad = maximo;
			comiendo = 0;
		}

		public synchronized void empezarAComer(String nombre) {
			try {
				while (comiendo >= 3) {
					System.out.println(nombre + " debe esperar para comer");
					this.wait();
				}
			} catch (InterruptedException ex) {
				Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
			}
			System.out.println(nombre + " empieza a comer ");
			comiendo++;

		}

		public synchronized void terminarDeComer(String nombre) {
			System.out.println(nombre + " termino de comer");
			comiendo--;
			this.notify();
		}
	}

	public static class HamsterMonitor implements Runnable {
		private Plato comida;
		private Rueda ejercicio;
		private String miNombre;

		public HamsterMonitor(Plato laComida, Rueda elEjercicio, String nombre) {
			comida = laComida;
			ejercicio = elEjercicio;
			miNombre = nombre;
		}

		public void run() {
			while (true) {
				comida.empezarAComer(miNombre);
				try {
					Thread.sleep((long) Math.random() * 15500);
				} catch (InterruptedException ex) {
					Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
				}
				comida.terminarDeComer(miNombre);
				ejercicio.rodar(miNombre);
			}
		}
	}

	public static void main(String[] args) {
		Plato comida = new Plato(3);
		Rueda ejercicio = new Rueda();
		Thread[] hamsters = new Thread[6];
		for (int i = 0; i < hamsters.length; i++) {
			hamsters[i] = new Thread(new HamsterMonitor(comida, ejercicio, "Hamster " + i));
		}
		for (int i = 0; i < hamsters.length; i++) {
			hamsters[i].start();
		}
	}

}
