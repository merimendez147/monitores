package ProblemaSaludo;

public class Saludo {
	
	synchronized void esperarJefe(String empleado) {
		try {
			wait();
			System.out.println(empleado + "> Buenos diasjefe!");
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
	}

	synchronized void saludoJefe() {
		System.out.println("JEFE> Buenos dias!");
		notifyAll();
	}
}
