/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 * 
 * Autor Daniel Martínez
 *
 * Ejercicio 4: Juego para adivinar el número oculto, Funcionamiento: 
 * -> Mostrar menu con las opciones
    1) Configurar
    2) Jugar
    3) Salir
 * -> Primera opción: solicitar por teclado el numero de intentos permitidos
      y el número máximo generado (numInt y numMax)
 * -> Segunda Opción: generar un numero aleatorio entre 0 y numMax que será
      el numero a adivinar (numOculto). A partir de este momento se le preguntan
      al usuario números hasta adivinar el numero oculto
        -Si el usuario adivina el número, se muestra el mensaje
         "Has ganado!. Has necesitado X intentos"
        -Si se consume el número de intentos sin adivinar el numero se muestra:
         "Perdiste!. Intentos consumidos"
        -En cada intento, si el usuario no adivina el numero se le proporcionará
         una pista, por ejemplo "El numero oculto es menor"
        -En ambos casos, la siguiente acción será mostrar el menu
        -Si el usuario selecciona Jugar sin configurar previamente el número de
         intentos y el número máximo generado, se tomarán como valores por
         defecto: numInt=5 y numMax=10.
 * positivos, el programa mostrará un mensaje por pantalla y finalizará 
 */
package juego.prog04_ejerc4;

//importamos la clase scanner para la entrada de datos
import java.util.Scanner;

public class PROG04_Ejerc4 {
    //decalro variables estáticas para que puedan ser usadas por todos los métodos
    public static int opcion = 0;
    public static int intentos = 5;
    public static int numMax = 10;
    public static int salir = 0;
    
    public static void main(String[] args) {
        Scanner entradaOpcion = new Scanner (System.in);
        
        //bucle while para salir del programa, cuando vale -1m sale
        while (salir != -1){
            System.out.println("Selecciona una de la opciones siguientes:"
                + "\n1. Configurar \n2. Jugar \n3. Salir ");
            opcion = entradaOpcion.nextInt();
            switch (opcion){
                case 1:
                    //llamada al metodo configurar()
                    configurar();
                    break;
                case 2:
                    //llamada al metodo jugar()
                    jugar();
                    break;
                case 3:
                    salir = -1;
                    break;
                default:
                    /*añado una opción deffault por si el usuario mete
                     *un valor que no corresponda
                    */
                    System.out.println("Introduce una opción válida");
                    break;
            }
        }
    }
    /* Metodo configurar, simplemente mediante el lector de datos de teclado
     * cargo ese valor en su variable correspondiente
    */
    public static void configurar(){
        System.out.println("Este es el menú de configuració, se te pedirá un"
                + " número de Intentos y el número maximo que se genera");
        Scanner entradaConfig = new Scanner (System.in);
        System.out.println("Introduce el número de intentos: ");
        intentos = entradaConfig.nextInt();
        System.out.println("Introduce el número máximo a generar: ");
        numMax = entradaConfig.nextInt();
    }
    
    /* Metodo jugar, empiezo generando un número aleatorio según la variable 
     * numMax definida antes por usuario o la que va por defecto
     * Luego defino la variable respuesta a -1 por si el numero es 0 o 1 que
     * pueda decir el programa que el numero del usuario es menor al oculto
     * Con un bucle for, hago sumatorio de i hasta el numero de intentos dado
     * que al llegar sale del bucle y da el mensaje de error
    */
    public static void jugar(){
        int numOculto = (int)Math.floor(Math.random()*numMax+1);
        int respuesta = -1;
        Scanner entradaNum = new Scanner (System.in);
        System.out.println("Ya se ha decidido tu número oculto. Mucha suerte!");
        int i;
        for (i=1; i<=intentos; i++){
            System.out.println("Ingresa un número");
            respuesta = entradaNum.nextInt();
            if (respuesta < numOculto) {
                System.out.println("El número oculto es mayor");
            }else if (respuesta > numOculto){
                System.out.println("El número oculto es menor");
            }else {
                System.out.println("Has ganado! Has necesitado "+ i + " intentos.");
                return;
            }
        }
        System.out.println("Te has quedado sin intentos. Perdiste. El numero oculto"
            + " era: " + numOculto);          
    }

    
}
        

