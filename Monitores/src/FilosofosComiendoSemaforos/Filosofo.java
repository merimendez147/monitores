package FilosofosComiendoSemaforos;

public class Filosofo implements Runnable {

	Mesa mesa;
	int idFilosofo;

	public Filosofo(int id, Mesa m) {
		mesa = m;
		idFilosofo = id;
	}

	private void comer() {
		try {
			System.out.println(Thread.currentThread().getName() + " esta comiendo");
			int espera = (int) (Math.random() * 200);
			Thread.sleep(espera);
			System.out.println(Thread.currentThread().getName() + " termino de comer");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void pensar() {
		try {
			System.out.println(Thread.currentThread().getName() + " esta pensando");
			int espera = (int) (Math.random() * 100);
			Thread.sleep(espera);
			System.out.println(Thread.currentThread().getName() + " termino de pensar");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			pensar();
			mesa.tomarTenedores(idFilosofo);
			comer();
			mesa.dejarTenedores(idFilosofo);
		}
	}

}
