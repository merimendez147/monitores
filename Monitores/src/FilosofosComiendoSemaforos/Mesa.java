package FilosofosComiendoSemaforos;

import java.util.concurrent.Semaphore;

public class Mesa {

	private Semaphore[] tenedores;
	private int cantidadTenedores;

	public Mesa(int cantidad) {
		cantidadTenedores = cantidad-1;
		tenedores = new Semaphore[cantidad];
		for (int i = 0; i < cantidad; i++) {
			tenedores[i] = new Semaphore(1);
		}
	}

	private void tenedorDer(int t) {
		try {
			if (t == cantidadTenedores) {
				tenedores[0].acquire();
				System.out.println(Thread.currentThread().getName()+" tiene el tenedor 0");

			} else {
				tenedores[t + 1].acquire();
				System.out.println(Thread.currentThread().getName()+" tiene el tenedor"+(t+1));
			}
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void tenedorIzq(int t) {
		try {
			tenedores[t].acquire();
			System.out.println(Thread.currentThread().getName()+" tiene el tenedor"+t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void tomarTenedores(int idFilosofo){
		tenedorDer(idFilosofo);
		tenedorIzq(idFilosofo);
	}
	
	public void dejarTenedores(int idFilosofo){
		tenedores[idFilosofo].release();
		if (idFilosofo == cantidadTenedores) {
			tenedores[0].release();

		} else {
			tenedores[idFilosofo + 1].release();
		}
		System.out.println(Thread.currentThread().getName()+" soltó los dos tenedores.");
	}
	
}
