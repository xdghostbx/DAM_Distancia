    
public class Arrays {
    import java.util.Random;
    import java.util.Scanner;
    public static void main(String[] args) {

        ArrayEj1();
    }
    //escribe un programa que pida 10 numeros y los muestre a la inversa
    public static void ArrayEj3(){
        Scanner entrada = new Scanner(System.in);
        
        int [] numeros = new int[10];
        
        for (int i = 0; i<numeros.length;i++){
        System.out.println("Introduce un numero");
        numeros[i] = entrada.nextInt();
        entrada.nextLine();
        }
        
        for (int i = numeros.length -1;i>=0;i--){
        System.out.println(numeros[i]);
        }
    }

    public static void ArrayEj4(){
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();
        
        int[] numero = new int[20];
        int[] cuadrado = new int[20];
        int[] cubo = new int[20];
        
        
        //cargamos los valores alatorios en el primer array
        for (int i = 0; i<numero.length;i++){
        int rand  = aleatorio.nextInt(100);
        numero[i] = rand;
        }
        
        //hacemos el cuadrado del primer valor 
        for (int i = 0; i<numero.length;i++){
        cuadrado[i] = numero[i]*numero[i];
        }
        
        for (int i = 0; i<numero.length;i++){
        cubo[i] = numero[i]*numero[i]*numero[i];
        }
        
        for (int i = 0; i<numero.length;i++){
        System.out.println("|"+numero[i]+"|"+cuadrado[i]+
                "|"+cubo[i]+"|");
        }
    }

    public static void ArrayEj5(){
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();
        
        int[] numero = new int[10];
        int min = 0, max = 0;
        
        for (int i = 0; i< numero.length;i++){
          System.out.println("Introduce un numero");
          numero[i] = entrada.nextInt();
          entrada.nextLine();
        }
        min = numero[0];
        max = numero[0];
        
        for (int i = 0; i< numero.length;i++){
          if (numero[i]<min){
            min = numero[i];
          }
          
          if (numero[i]>max){
            max = numero[i];
          }
        }
        
        System.out.println("Maximo: "+max);
        System.out.println("Minimo: "+min);
    }

    public static void ArrayEj6(){
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();
        
        int[] numero = new int[15];
        int[] numero2 = new int[15];
        int min = 0, max = 0;
        
        for (int i = 0; i< numero.length;i++){
        numero[i] = aleatorio.nextInt(20);
        }
        for (int i = 0; i< numero.length;i++){
        System.out.println(numero[i]);
        }
        for (int i = numero.length-1; i>=0;i--){
        numero2[min] = numero[i];
        min++;
        }
        for (int i = 0; i< numero.length;i++){
        System.out.println(numero2[i]+"|"+numero[i]);
        }
    }

    public static void ArrayEj7(){
        /*
            Ejercicio 7
            Escribe un programa que genere 100 números aleatorios del 0 al 20 y que los
            muestre por pantalla separados por espacios. El programa pedirá entonces por
            teclado dos valores y a continuación cambiará todas las ocurrencias del primer
            valor por el segundo en la lista generada anteriormente. Los números que se
            han cambiado deben aparecer entrecomillados.
        */
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();
        
        int[] numero = new int[100];
        String[] cadena = new String[100];
        int min = 0, max = 0;
        
        for (int i = 0; i< numero.length;i++){
        numero[i] = aleatorio.nextInt(20);
        }
        System.out.println("Introduce los numeros a buscar");
        System.out.println("Numero 1:");
        min = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Numero 2:");
        max = entrada.nextInt();
        entrada.nextLine();
        for (int i = 0; i< numero.length;i++){
        cadena[i] = String.valueOf(numero[i]);
        
        if (numero[i] == min){
            cadena[i] = "'"+max+"'";
        }
        
        System.out.println(cadena[i]);
        }
    }


    public static void ArrayEj8(){
        /*
            pide temperatura media por mes y dibuja barras horizontales
        */
        Scanner entrada = new Scanner (System.in);
        String[] meses = {"Enero","Febrero","Marzo","Abril"};
        double[] temperatura = new double[4];
        
        for (int i = 0; i< meses.length;i++){
            System.out.println("introduce la temperatura de "+meses[i].toLowerCase());
            temperatura[i] = entrada.nextDouble();
            entrada.nextLine();
        }
        
        for (int i = 0; i< meses.length;i++){
            System.out.println(meses[i]);
            int asteriscos = (int) temperatura[i];
            for (int j = 0;j<= asteriscos;j++){
            System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void ArrayEj9(){
        /*
            Realiza un programa que pida 8 números enteros y que luego muestre esos
            números junto con la palabra “par” o “impar” según proceda.
            */
            Scanner entrada = new Scanner(System.in);
            Random aleatorio = new Random();

            int[] numero = new int[8];

            for (int i = 0; i< numero.length;i++){
            numero[i] = aleatorio.nextInt(50);
            }
            
            for(int i = 0; i< numero.length;i++){
            if(numero[i]%2==0){
                System.out.println(numero[i]+" es par");
            }else
                System.out.println(numero[i]+" es impar");
            }
    }

    

}


    