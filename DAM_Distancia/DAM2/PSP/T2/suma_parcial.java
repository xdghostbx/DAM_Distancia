import java.util.ArrayList;

public class suma_parcial implements Runnable{

    private int[] sumatorio;
    private int inicio;
    private int fin;
    private int resultado;
    private ArrayList<Integer> resultados = new ArrayList<Integer>();

    public suma_parcial(int [] sumatorio, int inicio, int fin){
        this.sumatorio = sumatorio;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        resultado = 0;
        for (int i = inicio; i < fin; i++) {
            resultado += sumatorio[i];
        }
        
        System.out.println(Thread.currentThread().getName() + " ha sumado " + resultado);
    }

    public int getResultado() {
        return resultado;
    }

}
