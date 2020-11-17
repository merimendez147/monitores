package FilosofosComiendoSemaforos;

public class Main {
	public static void main(String[] args) {
		Mesa mesa = new Mesa(5);
		Thread[] filosofos = new Thread[5];
		for (int i = 0; i < filosofos.length; i++) {
			filosofos[i] = new Thread(new Filosofo(i, mesa));
			filosofos[i].setName("Filosofo " + i);
		}
		for (int i = 0; i < filosofos.length; i++) {
            filosofos[i].start();
		}
	}
}