//Tipos de datos:
byte identificador;  //de -128 a 127  (8 bits)
short identificador; //de -32768 a 32767 (16 bits)
int identificador;   //de -2147483648 a 214783647 (32bits)
long identificador;  //de  -mucho a mucho (64 bits)
float identificador; //de -mucho a mucho decimal (32 bits)
double identificador; //de -mucho a mucho decimal (64 bits)
char identificador;   //todo el rango unicode (16 bits)
boolean identificador; //true o false

//creacion de clase (main):

import javax.swing.JOptionPane;

{public|final|abstract} class name{
    [class variable declarations]
    public static void main(String[] args) {
        //statements
        //methods()
    }
}

//creacion de metodos:
{public|private} [static] {type|void} name (arg, arg...){
    //statements
}

//creación de variables:
{public|private} [static] type name [= expresion];

//java orientado a objetos (OOP):

//crear una clase:
class Test {
    //cuerpo de la clase
    //variables
    //metodos
}

//crear un objeto
Test t = new Test();

//constructor por defecto:
class Test {
    public static void main (String args[]){
        Test testObj = new Test();
    }
}

//Contructor:

public class Test {
    int appId;
    String appName;

    Test (int id, String name){
        this.appId = id;
        this.appName = name;
    }

    void info(){
        System.out.println("Id: "+ appId + "Name: "+ appName);
    }

    public static void main(String args[]){
        Test obj1 = new Test(11001, "Facebook");
        Test obj2 = new Test(23003, "Instagram");
        obj1.info();
        obj2.info();
    }
}

//cadenas (String):
/* 
 * No es un tipo primitivo, existe como clase
 * Para almacenar una cadena de clases se puede hacer de las siguientes formas
*/

String cadena = "Cadena de texto"; //donde cadena sería un objeto, al no ser String un primitivo
// metodos más usados para la clase String:
cadena.length(); //devuelve la longitud de una cadena de caracteres
cadena.charAt(n); //donde n es un numero (empiezan a contar desde 0)
cadena.substring(x, y); //de tal posicion a tal otra posicion
cadena.equals(otraCadena);// devuelve true si son iguales, false si no lo son
cadena.equalsIgnoreCase(otraCadena); //lo mismo que la anterior pero no diferencia mayus y minus

//ejemplos
String nombre = "Daniel";
String frase = "Las vacas hacen muu";
String frase_resumen = frase.substring(4, 9); //devuelve "vacas"

nombre.length() //de imprimirlo sacaría 6, el total de letras
nombre.charAt(0)//de imprimirlo sacaría la "D";


//expresiones regulares (validar dni y nombre):

public class Expresiones_regulares{
    public static void main(String args[]){
        System.out.println("77010220X: " + validaDNI("77010220X"));
    }

    public static boolean validarDNI(String DNI){
        return DNI.matches("^[0-9]{8} [letras validad para dni]$"); //obliga que empieza y que acabe de esa forma
        // ^empieza [rango] {repeticiones} [rango]$ con el que termina
    }
}

public class Expresiones_regulares2{
    public static void main(String args[]){
        System.out.println("Daniel: " + validarNombre("Daniel"));
    }

    public static boolean validarNombre(String nombre){
        return nombre.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$"); //obliga que empieza y que acabe de esa forma
        // ^empieza [rango] {repeticiones} [rango] +(minimo se repite 1 vez) [ ] espacio ? optativo y que se repita entre 1 y 2 veces }
    }
}

//expresiones regulares 2 (validar matricula y fecha):

public class Expresiones_regulares3{
    public static void main(String args[]){
        System.out.println("3695ABC: " + validarMatricula("3695ABC"));
    }
    public static boolean validarMatricula(String matricula){
        return matricula.matches("^[0-9]{4}[A-Z]{3}$")
    }
}

public class Expresiones_regulares4{
    public static void main(String args[]){
        System.out.println("3695ABC: " + validarMatricula("3695ABC"));
    }
    public static boolean validarFecha(String fecha){
        return fecha.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/]([012][0-9])\\d{2}$");
    }
}


//arrays:

/*
 * 
 */

 //declaracion
 int [] mi_matriz = new int [5];
 //tipo de matriz, nombre de la matriz y [5] numero de valores de la matriz

 mi_matriz[0] = 15; //declarar el valor de la posicion 0
 mi_matriz[1] = 25; 

 int [] mi_matriz = {15, 25, 8, -7, 30}; //declaramos valores de la matriz en la misma linea

 //tambien se puede usar .legth para saber cuantos elementos tiene
 mi_matriz.length;

 //bucle for each para facilitar el recorrido de arrays

 public class Arrays{
    public static void main(String args[]){
        String [] paises = new String [8];

        paises[0] = "España";
        paises[2] = "Francia";
        paises[3] = "Portugal";
        paises[4] = "Italia";
        paises[8] = "Venezuela";
        //metodo for, tradicional para pasar por cada elemento
        /*for (int i = 0; i<paises.length; i++){
            System.out.println("Pais "+ (i+1) + " "+ paises [i]);
        }*/
        //metodo nuevo
        for(String elemento:paises){
            System.out.println(elemento);
        }
    }
}

//import javax.swing.*;  //importamos esta clase para pedir datos al usuario
public class Arrays2{
    public static void main(String args[]){
        String [] paises = new String [8];

        for (int i = 0; i<8;i++){
            paises[i] = JOptionPane.showInputDialog("Introduce país "+ (i+1));
        }

        for(String elemento:paises){
            System.out.println("Pais:+" elemento);
        }
    }
}
//rellenar una matriz con numeros aleatorios
public class Arrays3{
    public static void main(String args[]){
        int [] martiz_aleatoria = new int [150];

        for (int i = 0; i<martiz_aleatoria.legth;i++){
            martiz_aleatoria[i] = (int)Math.round(Math.random()*100);
        }

        for(int numeros:martiz_aleatoria){
            System.out.print(numeros + " ");
        }
    }
}

//array bidimensionales (un array dentro de otro):

//declarar matriz de 2 dimensiones

public class Arrays_bidimensionales{
    public static void main(String args[]){
        int [] [] matriz = new int [4] [5] ; 

        matriz[0] [0] = 15;
        matriz[0] [1] = 10;
        matriz[3] [4] = 18;

        System.out.println(matriz [3][4]);
        //para recorrer estas arrays hacen falta 2 bucles for
        //el primero recorre la primera dimension y el segundo, la segunda
        for (int i = 0; i < 4; i++ ){
            for (int j = 0; j<5; j++){
                System.out.println(matriz[i][j]);
            }
        }
    }
}

public class Arrays_bidimensionales2{
    public static void main(String args[]){
        int [] [] matriz = {
            {10,15,18,19,21}, //posicion 0
            {59,5,423,14,1}, //posicion1
            {n,n,n,n,n}, //posicion 2
            {n,n,n,n,n}, //posicion 3
        }

        for (int[]fila:matriz){
            System.out.println();
            for(int z:fila){
                System.out.print (z + " ");
            }
        }
    }
}

public class Arrays_bidimensionales3{ //ejemplo excell
    public static void main(String args[]){
        double acumulado;
        double interes = 0.10;

        double [] [] saldo = new double[6][5];

        for (int i = 0; i<6; i++){
            saldo [i][0]=10000;
            acumulado = 10000;
            for (int j = 1; j<5 ; j++){
                acumulado = acumulado+(acumulado * interes);
                saldo [i] [j] = acumulado;
            }
            interes = interes + 0.01;
        }

        for (int z = 0; z < 6;z++ ){
            System.out.println();
            for(int h = 0; h<5; h++){
                System.out.printf("%1.2f", saldo[z][h]);
                System.out.print(" ");
            }
        }
    }
}