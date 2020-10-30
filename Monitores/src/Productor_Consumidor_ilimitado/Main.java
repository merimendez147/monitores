package Productor_Consumidor_ilimitado;

public class Main {

    public static void main(String[] args) {
    	
        Buffer recurso = new Buffer();

        Thread[] consumidores = new Thread[1];
        Thread[] productores = new Thread[3];

        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Thread(new Consumidor("Consumidor " + i, recurso));

        }
        for (int i = 0; i < productores.length; i++) {
            productores[i] = new Thread(new Productor("Productor " + i, recurso));

        }
        for (int i = 0; i < productores.length; i++) {
            productores[i].start();

        }
        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i].start();

        }

    }

}


