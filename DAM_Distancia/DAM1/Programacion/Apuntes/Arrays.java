    
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

    public static void ArrayEj10(){
            /*
        Escribe un programa que genere 20 números enteros aleatorios entre 0 y 100
    y que los almacene en un array. El programa debe ser capaz de pasar todos
    los números pares a las primeras posiciones del array (del 0 en adelante) y
    todos los números impares a las celdas restantes. Utiliza arrays auxiliares si es
    necesario.
        */
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();

        int[] numero = new int[20];
        int[] par = new int [20];
        int[] impar = new int [20];
        int a = 0, b = 0;

        for (int i = 0; i< numero.length;i++){
        numero[i] = aleatorio.nextInt(100);
        }
        for (int i = 0; i< numero.length;i++){
        System.out.println(numero[i]);
        }
        System.out.println("---------------------");
        //usar un array para los pares?
        //otro para los impares??
        //para estos arrays deberia usar un indice alternatico
        //cargar los valores en el inicial?
        for (int i = 0; i< numero.length;i++){
        if (numero[i]%2==0){
            par[a] = numero[i];
            a++;
        }else{
            impar[b] = numero[i];
            b++;
        }
        }
        
        for (int i = 0; i<a;i++){
        numero[i] = par[i];
        }
        int aux = a;
        for (int i = 0;i<b;i++){
        numero[aux] = impar[i];
        aux++;
        }
        
        for (int i = 0; i< numero.length;i++){
        System.out.println(numero[i]);
        }
    }

    public static void ArrayEj13(){
       /*
    Escribe un programa que rellene un array de 100 elementos con números en-
teros aleatorios comprendidos entre 0 y 500 (ambos incluidos). A continuación
el programa mostrará el array y preguntará si el usuario quiere destacar el
máximo o el mínimo. Seguidamente se volverá a mostrar el array escribiendo
el número destacado entre dobles asteriscos
    */
    Random aleatorio = new Random();
    Scanner entrada = new Scanner(System.in);
    
    
    int[] numero = new int[100];
    String[] cadena = new String[100];
    int maximo = 0, minimo = 500;
    for (int i  = 0;i<numero.length;i++){
      numero[i] = aleatorio.nextInt(500);
      System.out.print(numero[i]+" ");
      if ((i==25) ||(i == 50)|| (i==75)||i==100){
        System.out.println();
      }
      
      if (numero[i]<minimo){
        minimo = numero[i];
      }
      if (numero[i]>maximo){
        maximo = numero[i];
      }
    }
    System.out.println("Seleccione que desea buscar");
    System.out.println("1.- El numero minimo");
    System.out.println("2.- El numero maximo");
    int opcion = entrada.nextInt();
    switch(opcion){
      case 1:
        for (int i = 0; i< numero.length;i++){
          cadena[i] = String.valueOf(numero[i]);
          if (numero[i] == minimo){
            cadena[i] = "**"+numero[i]+"**";
          }
          System.out.print(cadena[i]+" ");
          if ((i==25) ||(i == 50)|| (i==75)||i==100){
            System.out.println();
          }   
        }
          break;
      case 2:
          for (int i = 0; i< numero.length;i++){
            cadena[i] = String.valueOf(numero[i]);
            if (numero[i] == maximo){
              cadena[i] = "**"+numero[i]+"**";
            }
            System.out.print(cadena[i]+" ");
            if ((i==25) ||(i == 50)|| (i==75)||i==100){
              System.out.println();
            }
        }
          break;
      default:
          System.out.println("Instroduce una opcion correcta...");
          break;
    }

    public static void ArrayEj15(){
        /*
    Tenemos un array multidimensional con mesas y numero de ocupantes
    El ejercicio pide que sea de 2 dimensiones 2 filas 10 columnas
    voy a hacer de 3 filas con "ocupado" y "libre"
    */
    Random aleatorio = new Random();
    Scanner entrada = new Scanner(System.in);
    
    String[][] mesas = new String [3][11];
    
    //aplicamos el "titulo" de la posicion 0
    mesas[0][0] = "Mesa numero";
    mesas[1][0] = "Sillas";
    mesas[2][0] = "Estado";
    //ponemos los numeros de las mesas del 1 al 10
    //aplicamos un generador random para poner el numero de comensales
    //ponemos todas las mesas con estado libre
    for (int i = 1;i< 11; i++){
      mesas[0][i]=String.valueOf(i);
      mesas[1][i] = String.valueOf(aleatorio.nextInt(4)+1);
      mesas[2][i] = "Libre";
    }
    
    //imprimimos la tabla
      for (int j = 0;j< 3; j++){
        for (int z = 0;z < 11; z++){
          System.out.print(mesas[j][z]+" ");
        }
        System.out.println();
      }
      
      //menu para seleccionar la mesa segun los comensaleso
      while (true){
        System.out.println("Introduzca el numero de comensales:");
        int comensales = entrada.nextInt();
        entrada.nextLine();
        if (comensales > 4){
          System.out.println("El numero de comensales no puede ser superior a 4");
        }else{
          System.out.println("Introduzca una mesa para sentarse 1 al 10");
          int numMesa = entrada.nextInt();
          entrada.nextLine();
          // Verificar si la mesa tiene suficientes sillas y está libre
          int sillas = Integer.parseInt(mesas[1][numMesa]);
          String estadoMesa = mesas[2][numMesa];

          if (comensales <= sillas && estadoMesa.equals("Libre")) {
              mesas[2][numMesa] = "Ocupada";
              System.out.println("Mesa " + numMesa + " reservada para " + comensales + " comensales.");
          } else if (!estadoMesa.equals("Libre")) {
              System.out.println("La mesa " + numMesa + " ya está ocupada.");
          } else {
              System.out.println("La mesa " + numMesa + " no tiene suficientes sillas.");
          }
        }
        //volvemos a imprimir la tabla para mantener la info actualizada
        for (int j = 0;j< 3; j++){
          for (int z = 0;z < 11; z++){
            System.out.print(mesas[j][z]+" ");
          }
          System.out.println();
        }
      }
    }

}


    