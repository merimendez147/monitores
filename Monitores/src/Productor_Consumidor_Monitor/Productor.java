package Productor_Consumidor_Monitor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor implements Runnable {

    private Buffer recurso;

    public Productor(Buffer b) {
        recurso = b;
    }

    public void run() {
        while (true) {
            try {
            	recurso.producir();
                System.out.println(Thread.currentThread().getName() + " está produciendo un producto");
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}

