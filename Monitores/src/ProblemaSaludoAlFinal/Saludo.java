package ProblemaSaludoAlFinal;

import java.util.concurrent.Semaphore;

public class Saludo {
	Semaphore semSaludo=new Semaphore(0, true);
	public void aTrabajar(){
		try {
			semSaludo.acquire(6);
			System.out.println("LISTO, ahora que todos han saludado - a trabajar");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	synchronized void esperarJefe(String empleado) {
		try {
			wait();
			System.out.println(empleado + "> Buenos diasjefe!");
			semSaludo.release();
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
	}

	synchronized void saludoJefe() {
		System.out.println("JEFE> Buenos dias!");
		semSaludo.release();
		notifyAll();
		
	}
}
