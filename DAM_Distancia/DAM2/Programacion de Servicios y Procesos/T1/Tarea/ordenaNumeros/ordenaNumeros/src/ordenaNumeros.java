import java.util.Arrays;
import java.util.Scanner;

public class ordenaNumeros {
    
    public static void main(String[] args) throws Exception {
        //creamos el scanner para que el usuario introduzca los numeros
        Scanner entrada = new Scanner(System.in);
        int [] numerosAleatorios = new int[10];
        //el usuario introduce 10 numeros
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce el numero " + (i + 1));
            numerosAleatorios[i]=entrada.nextInt();
        }
        //imprimimos los numeros ordenados
        Arrays.sort(numerosAleatorios);
        System.out.println("Numeros ordenados:");
        for (int num : numerosAleatorios){
            System.out.println(num);
        }
    }
}
