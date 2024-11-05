public class Contador {
    private int count = 0;

    public synchronized void incrementar(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
