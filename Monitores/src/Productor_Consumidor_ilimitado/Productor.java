package Productor_Consumidor_ilimitado;

public class Productor implements Runnable {

    private String nombre;
    private Buffer recurso;
    private int producto;

    public Productor(String n, Buffer b) {
        nombre = n;
        recurso = b;
        producto=0;
    }
    
  /*  private int hacerProducto(){
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	producto++;
    	return producto;
    }
    */

    public void run() {
        while (true) {
        		recurso.producir(producto++);
          

            
    }

    }
}
