
package waitNotify;

public class Parcheggio {
    private int postiDisponibili=10;

    public int getPostiDisponibili() {
        return postiDisponibili;
    }
    
    public synchronized void ingresso (){
       while (postiDisponibili==0){
           try{wait();
           }catch (InterruptedException e)
           {
               e.printStackTrace();
           }
       } 
       postiDisponibili--;
    }
    
    public synchronized void uscita(){
      postiDisponibili++;
      notifyAll();  
    }
    
}
