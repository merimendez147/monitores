package Productor_Consumidor_Monitor;

public class Buffer {
	private int cantidad;
	private final int tama�o;

	public Buffer(int tam) {
		this.cantidad = 0;
		this.tama�o = tam;
	}

	public synchronized void producir() throws InterruptedException {
		while (cantidad == tama�o) {
			System.out.println(Thread.currentThread().getName() + " est� esperando");
			this.wait(); // espera bloqueado
		}
		cantidad++;
		this.notifyAll();
	}

	public synchronized void consumir() throws InterruptedException {
		while (cantidad == 0) {
			System.out.println(Thread.currentThread().getName() + " est� esperando");
			this.wait(); // espera bloqueado
		}
		cantidad--;
		this.notifyAll();
	}
}