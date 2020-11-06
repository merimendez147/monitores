package Productor_Consumidor_ilimitado;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor implements Runnable {

    private String nombre;
    private Buffer recurso;

    public Consumidor(String n, Buffer b) {
        nombre = n;
        recurso = b;
    }

    public void run() {

        while (true) {
            try {
                recurso.consumir();
                Thread.sleep(2000);
           
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
