package Productor_Consumidor_Monitor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor implements Runnable {

    private Buffer recurso;

    public Consumidor(Buffer b) {
        recurso = b;
    }

    public void run() {
        while (true) {
            try {
                recurso.consumir();
                System.out.println(Thread.currentThread().getName() + " está consumiendo un producto");
                Thread.sleep(2000);
           
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}