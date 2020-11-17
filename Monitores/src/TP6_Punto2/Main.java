package TP6_Punto2;

public class Main {
public static void main(String[] args) { 
    	
        GestorSala sala = new GestorSala();
	MedidorTemp medidor = new MedidorTemp(sala);
        Thread mt = new Thread(medidor);
        mt.start();
        Thread[] jubilados = new Thread[10];
	Thread[] nojubilados = new Thread[5];
        for (int i = 0; i < jubilados.length; i++) {
            jubilados[i] = new Thread(new Jubilada(sala));
            jubilados[i].setName("persona jubilada " + i);
        }
        for (int i = 0; i < jubilados.length; i++) {
            jubilados[i].start();
        } 
	for (int i = 0; i < nojubilados.length; i++) {
            nojubilados[i] = new Thread(new NoJubilada(sala));
            nojubilados[i].setName("persona no jubilada " + i);
        }
        for (int i = 0; i < nojubilados.length; i++) {
            nojubilados[i].start();
        }       
    }
}