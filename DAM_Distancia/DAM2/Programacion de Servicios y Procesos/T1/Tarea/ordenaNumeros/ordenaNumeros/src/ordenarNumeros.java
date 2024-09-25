import java.util.*;

public class ordenarNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numeros = new ArrayList<>();  

        Random aleatorio = new Random();

        System.out.println("Introduce los números, si quiere números aleatorios escribe Aleatorio y cuando termines escribe Ordenar:");

        while (true) {
            String entrada = scanner.next();

            if (entrada.equalsIgnoreCase("Aleatorio")) {
                for (int i = 0; i < 40; i++) {
                    int numero = aleatorio.nextInt(101);
                    numeros.add(numero);
                }
            } else if (entrada.equalsIgnoreCase("Ordenar")) {
                break;
            }else{
                try {
                    int numero = Integer.parseInt(entrada);
                    numeros.add(numero);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida, por favor escribe un número entero, Aleatorio para rellenar random o Ordenar para finalizar");
                }
            }
            
            
            
        }

        Collections.sort(numeros);

        System.out.println("Números ordenados:");
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}