import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class ordenaNumeros {
    
    public static void main(String[] args) throws Exception {
        //creamos el scanner para que el usuario introduzca los numeros
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();
        int numeroAleatorio = aleatorio.nextInt(1000)+1;
        int [] numeros = new int[numeroAleatorio];
        //el usuario introduce 10 numeros
        for (int i = 0; i < numeroAleatorio; i++) {
            while(true){
                try{
                    //System.out.println("Introduce el numero " + (i + 1));
                    numeros[i]=entrada.nextInt();
                    break;
                } catch (InputMismatchException e){
                    System.out.println("Introduce un numero valido");
                    entrada.next(); //limpiamos el buffer
                }
            }
            
        }
        //se cierra el scanner
        entrada.close();
        //imprimimos los numeros ordenados
        Arrays.sort(numeros);
        System.out.println(numeroAleatorio + " numeros ordenados:");
        for (int num : numeros){
            System.out.print(num);
            System.out.print(" - ");
        }
    }
}
