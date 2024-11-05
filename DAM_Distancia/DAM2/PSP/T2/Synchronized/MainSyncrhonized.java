public class MainSyncrhonized {
    public static void main(String[] args) {
        Contador contador = new Contador();
        int numIncrementos = 1000;
        Incrementador incrementador1 = new Incrementador(contador, numIncrementos);
        Incrementador incrementador2 = new Incrementador(contador, numIncrementos);
        incrementador1.start();
        incrementador2.start();
        try {
            incrementador1.join();
            incrementador2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("El contador vale " + contador.getCount());  
    
}
}
