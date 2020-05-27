
package semaphore;

public class Test {
    public static void main(String[] args){
        Parcheggio p=new Parcheggio();
        for (int i=1; i<= 10; i++) {
        Automobile a = new Automobile("Auto "+i, p);}
    }
}
