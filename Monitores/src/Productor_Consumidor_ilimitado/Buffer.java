package Productor_Consumidor_ilimitado;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Buffer {
    private Semaphore mutex;
    private Semaphore productoDisponible;
    Queue<String> buffer = new LinkedList<String>();
  

    public Buffer() {
        mutex = new Semaphore(1);
        productoDisponible = new Semaphore(0);
    }

    public void consumir(){
    	try {
			productoDisponible.acquire();
			mutex.acquire();
			System.out.println("El consumidor consume el producto " + buffer.poll());
			mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    	
    	 public void producir(int i){
    		 try{
    				mutex.acquire();
    				buffer.add("Producto"+i);
    				System.out.println("El productor produce el producto Producto"+i);
    				mutex.release();
    				productoDisponible.release();
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	    	
    }
}
