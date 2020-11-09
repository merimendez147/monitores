package Productor_Consumidor_Monitor;

public class Main {
	public static void main(String[] args) {
		int tamañoBuffer = 10;
		Buffer recurso = new Buffer(tamañoBuffer);
		Thread[] consumidores = new Thread[8];
		Thread[] productores = new Thread[10];
		for (int i = 0; i < consumidores.length; i++) {
			consumidores[i] = new Thread(new Consumidor(recurso));
			consumidores[i].setName("Consumidor " + i);
		}
		for (int i = 0; i < productores.length; i++) {
			productores[i] = new Thread(new Productor(recurso));
			productores[i].setName("Productor " + i);
		}
		for (int i = 0; i < productores.length; i++) {
			productores[i].start();
		}
		for (int i = 0; i < consumidores.length; i++) {
			consumidores[i].start();
		}
	}
}
