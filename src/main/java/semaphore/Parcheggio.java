
package semaphore;

import java.util.concurrent.Semaphore;

public class Parcheggio {
    private int postiDisponibili=10;
    private Semaphore postiLiberi;
    private Semaphore postiOccupati;
    
    public Parcheggio(){
        postiLiberi= new Semaphore(postiDisponibili, true);
        postiOccupati= new Semaphore(0, true);
    }

    public int getPostiDisponibili() {
        return postiDisponibili;
    }
    
    public synchronized void ingresso()
    {
        try
        {
            postiLiberi.acquire();
        } catch (InterruptedException e) {}
        postiOccupati.release();
        postiDisponibili--;
    }
    
    public synchronized void uscita()
    {
        try
        {
            postiOccupati.acquire();
        } catch (InterruptedException e) {}
        postiLiberi.release();
        postiDisponibili++;
    }
    
}
