package TP5_Punto1;

import java.util.concurrent.Semaphore;

public class Comedor {
	private Semaphore semGato;// turno del gato
	private Semaphore semPerro; // turno del perro
	private Semaphore mutex = new Semaphore(1); //exclusion mutua
	private int cantPlatos, platosUsados;

	public Comedor(int platos) {
		cantPlatos = platos;
		platosUsados = 0;
		semGato = new Semaphore(0, true); 
		semPerro = new Semaphore(cantPlatos, true); //arrancan comiendo los perros
	}

	public void esperarTurnoPerro() {
		try {
			semPerro.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void esperarTurnoGato() {
		try {
			semGato.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void pasarTurnoPerro() {
		System.out.println("Le toca comer a los perros");
		semPerro.release(cantPlatos);
	}

	private void pasarTurnoGato() {
		System.out.println("Le toca comer a los gatos");
		semGato.release(cantPlatos);
	}

	public void entrarGato() {
		try {
			mutex.acquire();
			if (platosUsados < cantPlatos) {
				System.out.println("El " + Thread.currentThread().getName() + " esta comiendo");
				platosUsados++;
				System.out.println("platos ocupados "+platosUsados);
			} 
			mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void salirGato(){
		try {
			mutex.acquire();
			System.out.println("El " + Thread.currentThread().getName() + " dejo de comer");
			platosUsados--;
			System.out.println("platos ocupados "+platosUsados);
			if (platosUsados==0){
				pasarTurnoPerro();
			}
			mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void salirPerro(){
		try {
			mutex.acquire();
			System.out.println("El " + Thread.currentThread().getName() + " dejo de comer");
			platosUsados--;
			System.out.println("platos ocupados "+platosUsados);
			if (platosUsados==0){
				pasarTurnoGato();
			}
			mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void entrarPerro() {
		try {
			mutex.acquire();
			if (platosUsados < cantPlatos) {
				System.out.println("El " + Thread.currentThread().getName() + " esta comiendo");
				platosUsados++;
				System.out.println("platos ocupados "+platosUsados);
			}
			mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
