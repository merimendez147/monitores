package TP5_Punto3;

public class Main {
public static void main(String[] args) { 
    	
        TrenTuristico atraccion = new TrenTuristico(5);
        ControlTren c = new ControlTren(atraccion);
        Thread controladorTren = new Thread(c);
        controladorTren.start();
        VendedorTickets v = new VendedorTickets(atraccion);
        Thread vendedorTickets = new Thread(v);
        vendedorTickets.start();
        Thread[] pasajeros = new Thread[10];
        for (int i = 0; i < pasajeros.length; i++) {
            pasajeros[i] = new Thread(new Pasajero(atraccion));
        }
        for (int i = 0; i < pasajeros.length; i++) {
            pasajeros[i].start();
        }    
    }
}

