import java.util.Random;

public class t2_test {

    /**
     * Crea una aplicación en Java que utilice hilos para sumar los elementos de un arreglo de enteros de manera concurrente. La aplicación debe dividir el arreglo en dos partes y asignar a cada hilo la tarea de sumar una de las partes. Al final, la aplicación debe sumar los resultados parciales obtenidos por cada hilo para obtener la suma total del arreglo.
     */
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int[] sumatorio = new int[10];

        for (int i = 0; i < sumatorio.length; i++) {
            sumatorio[i] = aleatorio.nextInt(10);
        }

        suma_parcial suma1 = new suma_parcial(sumatorio, 0, sumatorio.length /2);
        suma_parcial suma2 = new suma_parcial(sumatorio, sumatorio.length /2, sumatorio.length);

        Thread hilo1 = new Thread(suma1, "Hilo 1");
        Thread hilo2 = new Thread(suma2, "Hilo 2");

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("La suma total es: " + (suma1.getResultado() + suma2.getResultado()));
        
        /**
            t2_test hilo = new t2_test();
            t2_test hilo2 = new t2_test();

            hilo.start();
            hilo2.start();
        */
        /*
         *  Thread hilo1 = new Thread(new t2_test(), "Hilo 1");
        Thread hilo2 = new Thread(new t2_test(),"Hilo 2");

        hilo1.start();
        hilo2.start();
         * 
         */
       
    }
}
