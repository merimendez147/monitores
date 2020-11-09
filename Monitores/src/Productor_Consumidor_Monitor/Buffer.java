package Productor_Consumidor_Monitor;

public class Buffer {
	private int cantidad;
	private final int tamaño;

	public Buffer(int tam) {
		this.cantidad = 0;
		this.tamaño = tam;
	}

	public synchronized void producir() throws InterruptedException {
		while (cantidad == tamaño) {
			System.out.println(Thread.currentThread().getName() + " está esperando");
			this.wait(); // espera bloqueado
		}
		cantidad++;
		this.notifyAll();
	}

	public synchronized void consumir() throws InterruptedException {
		while (cantidad == 0) {
			System.out.println(Thread.currentThread().getName() + " está esperando");
			this.wait(); // espera bloqueado
		}
		cantidad--;
		this.notifyAll();
	}
}