package TP5_Punto1;

public class Main {
public static void main(String[] args) {
    	Comedor comedero = new Comedor(2);
        Thread[] gatos = new Thread[10];
        Thread[] perros = new Thread[10];
        for (int i = 0; i < gatos.length; i++) {
            gatos[i] = new Thread(new Gato(comedero,0));
            gatos[i].setName("Gato"+i);
        }
        for (int i = 0; i < perros.length; i++) {
            perros[i] = new Thread(new Perro(comedero,1));
            perros[i].setName("Perro"+i);
        }
        for (int i = 0; i < gatos.length; i++) {
            gatos[i].start();

        }
        for (int i = 0; i < perros.length; i++) {
            perros[i].start();
        }
    }
}

