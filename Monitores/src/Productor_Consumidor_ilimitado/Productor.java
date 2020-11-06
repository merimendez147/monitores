package Productor_Consumidor_ilimitado;

public class Productor implements Runnable {

    private String nombre;
    private Buffer recurso;
   

    public Productor(String n, Buffer b) {
        nombre = n;
        recurso = b;
    }
    
  private void hacerProducto(){
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   

    public void run() {
        while (true) {
        		hacerProducto();
        		recurso.producir();
            }

    }
}
