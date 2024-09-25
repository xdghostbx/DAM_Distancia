import java.util.Random;

public class aleatorios {
    
    public static void main(String[] args) throws Exception {
        Random numero = new Random();
        int aleatorio = numero.nextInt(101)+1000;
        for (int i = 0; i<=aleatorio; i++){
            int aleatorio2 = numero.nextInt(1001);
            System.out.println(aleatorio2);
        }
    }
}
