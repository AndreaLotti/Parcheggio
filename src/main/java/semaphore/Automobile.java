
package semaphore;

public class Automobile extends Thread{
   private Parcheggio p1;
   
   public Automobile(String nome, Parcheggio p){
       super(nome);
       this.p1=p;
       start();
   }            
   
   public void run(){
       while (true){
           synchronized(p1){
                p1.ingresso();
                System.out.println(getName()+": è entrata posti liberi:"+p1.getPostiDisponibili());
            }
           synchronized(p1){
               p1.uscita();
               System.out.println(getName()+": è uscita posti liberi:"+p1.getPostiDisponibili());
           }
        }
   }  
}
