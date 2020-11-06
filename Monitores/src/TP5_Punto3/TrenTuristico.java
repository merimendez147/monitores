package TP5_Punto3;

import java.util.concurrent.Semaphore;

public class TrenTuristico {
	private int cantTicketsVendidos;
	private int cantAsientosTren;
	private Semaphore mutex = new Semaphore(1);
	private Semaphore vendedor;
	private Semaphore control;

	public TrenTuristico(int cant) {
		cantAsientosTren = cant;
		cantTicketsVendidos = 0;
		vendedor = new Semaphore(0);
		control = new Semaphore(0);
	}

	public void obtenerTicket() {
		vendedor.release();
	}

	public void venderTicket() {
		try {
			vendedor.acquire();
			mutex.acquire();
			cantTicketsVendidos++;
			System.out.println("se han vendido "+ cantTicketsVendidos+ " tickets");
			mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void subirTren() {
		control.release();
	}

	public void salirTren() {
		try {
			control.acquire(cantAsientosTren);
			System.out.println("el tren salio con "+ cantAsientosTren+ " pasajeros");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
