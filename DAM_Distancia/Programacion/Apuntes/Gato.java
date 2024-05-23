Colecciones de Datos

Una coleccion a nivel software es un grupo de elementos almacenados de forma
conjunta en una misma estructura (como una coleccion de libros)

#Definicion
Una coleccion o contenedor es un objeto que agrupa elementos multiples en un
objeto simple. Las colecciones son usadas para almacenar, recuperar y manipular
Datos

Los beneficios de usar este framework son:
    -Reducen el esfuerzo de programacion
    -Incrementan la calidad de las aplicaiones
    -Incrementan las interoperabilidad
    -Reducen el esfuerzo de aprender nuevas apis
    Cuntribuyen a la reusabilidad del codigo

_______________________________________________________________
Clases y metodos genericos

<T> es la definicon de una variable o parametro formal de tipo de la clase
o metodo generico que se le puede llamar parametro de tipo o parametro
generico. Hace referencia a una clase con la que el algoritmo tiene que trabajar. Puede haber mas de un parametro generico.

Los parámetros de tipo de las clases genéricas solo pueden ser clases, no pueden ser jamás tipos de datos primitivos como int, short, double, etc. En su lugar debemos usar sus clases envoltorio Integer, Short, Double, etc


_________________________________________________________________
Conjuntos

Un conjunto es un tipo de coleccion que no admite duplicados.
Las implementaciones mas usadas son las siguientes:

java.util.HashSet: almacena objetos usando tablas hash, acelera el
acceso a los elementos almacenados. Necesitan bastante memoria y 
almacena los elementos de forma ordenada

java.util.LinkedHashSet: Lo mismo que el anterior pero usa listan enlazadas
para almacnar los objetos en orden de insercion. Se puede cedir que es Una
estructura ordenada a medias. Necesitan bastante memoria y es algo mas
lenta que el HashSet

java.util.TreeSet: almacena los objetos en un arbol binario, es una
estructura mas lenta que las anteriores pero los datos almacenados se ordenan
por valor. Se ordenan internamente

_________________________EJEMPLO DE HASHSET______________________________________
import java.util.HashSet;
import java.util.Scanner;


public class Pruebas {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> numeros = new HashSet<>();

        while (numeros.size() < 5) {
            System.out.print("Introduce un número (debe ser único): ");
            int numero = scanner.nextInt();
            // Agrega el número al HashSet y verifica si fue realmente agregado
            if (!numeros.add(numero)) {
                System.out.println("Número repetido, por favor introduce un número diferente.");
            }
        }

        int suma = 0;
        for (int num : numeros) { //bucle for each
            suma += num;
        }

        System.out.println("La suma de los números es: " + suma);
}
__________________________________________________________________________________

Estas estructuras nos permiten combinar datos de varias colecciones, como por 
ejemplo:

TreeSet<Integer> A= new TreeSet<Integer>();
A.add(9); A.add(19); A.add(5); A.add(7); 
// Elementos del conjunto A: 9, 19, 5 y 7

LinkedHashSet<Integer> B= new LinkedHashSet<Integer>();
B.add(10); B.add(20); B.add(5); B.add(7);
 // Elementos del conjunto B: 10, 20, 5 y 7

nos da las siguientes erramientas:

Union: A.addAll(B); Añade el conjunto B al conjunto A 

Diferencia: A.removeAll(B); Elimina los elementos de A que están en B

Interseccion: A.retainAll(B); Retiene los elementos comunes a ambos elementos

En un elemento TreeSet, para indicar el orden de los elementos asi como si estan
repedos, usaremos la interfaz generica java.util.Comparator

class ComparadorDeObjetos implements Comparator<Objeto> {

    public int compare(Objeto o1, Objeto o2) { ... }    

}

Esta interfaz obliga a implementar un unico metodo, el metodo Compare, que tiene
2 parametros, los 2 elementos a Comparar 

-Si el primer objeto es menor que el segundo, retorna numero negativo
-Si el primer objeto es mayor que el segundo, retorna un numero positivo
-Si son iguales, retorna 0

Una vez creado el comparador simplemente tenemos que pasarlo como parámetro 
en el momento de la creación al TreeSet, y los datos internamente mantendrán 
dicha ordenación:

TreeSet<Objeto> ts=new TreeSet<Objeto>(new ComparadorDeObjetos());

__________________________________________________________________________________
ArrayList

La principal diferencia entre listas y conjuntos es que son elementos de
programacion mas avanzados. Amplian el conjunto de operaciones y Añade
operaciones extra como:
-Pueden almacenar duplicados
-Acceso posicional. Podemos acceder a un elemento 
    indicando su posición en la lista.
-Busqueda. Podemos buscar elementos en la lista y saber su posicion 
-Extraccion de sublistas. Podemos extraer una sublista de una lista


En Java, para las listas se dispone de una interfaz llamada java.util.List, y 
dos implementaciones (java.util.LinkedList y java.util.ArrayList), con diferencias
 significativas entre ellas. Los métodos de la interfaz List, que obviamente 
 estarán en todas las implementaciones, y que permiten las operaciones
  anteriores son:

E get(int index). El método get permite obtener un elemento partiendo de su 
    posición (index).
E set(int index, E element). El método set permite cambiar el elemento almacenado
     en una posición de la lista (index), por otro (element).
void add(int index, E element). Se añade otra versión del método add, en la cual 
    se puede insertar un elemento (element) en la lista en una posición concreta (index), desplazando los existentes.
E remove(int index). Se añade otra versión del método remove, esta versión permite 
    eliminar un elemento indicando su posición en la lista.
boolean addAll(int index, Collection<? extends E> c). Se añade otra versión del 
    método addAll, que permite insertar una colección pasada por parámetro en una 
    posición de la lista, desplazando el resto de elementos.
int indexOf(Object o). El método indexOf permite conocer la posición (índice) de 
    un elemento, si dicho elemento no está en la lista retornará -1.
int lastIndexOf(Object o). El método lastIndexOf nos permite obtener la última 
    ocurrencia del objeto en la lista (dado que la lista si puede almacenar 
    duplicados).
List<E> subList(int from, int to). El método subList genera una sublista 
    (una vista parcial de la lista) con los elementos comprendidos entre la 
    posición inicial (incluida) y la posición final (no incluida).


Para usar las listas en Java, debemos importar la clase java.util.List, y 
usar la interfaz List en lugar de la clase ArrayList. Como en el siguiente ejemplo

LinkedList<Integer> t=new LinkedList<Integer>(); // Declaración y creación del LinkedList de enteros.

t.add(1); // Añade un elemento al final de la lista.

t.add(3); // Añade otro elemento al final de la lista.

t.add(1,2); // Añade en la posición 1 el elemento 2.

t.add(t.get(1)+t.get(2)); // Suma los valores contenidos en la posición 1 y 2, y lo agrega al final.

t.remove(0); // Elimina el primer elementos de la lista.

for (Integer i: t) System.out.println("Elemento:" + i); // Muestra la lista.  


Diferencias entre LinkedList y ArrayList
La principal diferencia entre LinkedList y ArrayList es que LinkedList es una 
lista doblemente enlazada, mientras que ArrayList es una lista simplemente 
enlazada.
Si se van a realizar muchas operaciones de eliminacion de elementos sobre la lista
es mejor usar una lista enlazada, pero si solamente se van a insertar y consultar
elementos por posicion, conviene un ArrayList

___________________________________________________________________________________
Ejercicio Repaso 1
___________________________________________________________________________________
/*
EJERCICIO 1

Escribe un programa en Java que utilice la clase ArrayList para almacenar una lista de colores. El programa debe realizar las siguientes acciones:

    Crear un ArrayList llamado colores.
    Añadir los colores "rojo", "verde" y "azul" a colores.
    Añadir el color "blanco" a colores.
    Imprimir el número total de colores en la lista.
    Imprimir el color que está en la primera posición de la lista.
    Intentar imprimir el color que estaría en la posición 3 de la lista. Asegúrate de manejar apropiadamente el caso en el que la posición esté fuera del rango de la lista.

*/

import java.util.ArrayList;

public class Pruebas {

    public static void main(String[] args) {
        ArrayList<String> colores = new ArrayList<>();
        colores.add("rojo");
        colores.add("verde");
        colores.add("azul");
        colores.add("blanco");

        String tercero = colores.get(2);
        String primero = colores.get(0);

        try{
            for (String i : colores){System.out.println(i);} //imprimir con bucle for each
            System.out.println("Arraylist "+ colores); //imprimir directamente la lista, sale como [lista de elementos]
            System.out.println("Primer elemento "+primero);
            System.out.println("Tercer elemento "+tercero);
            System.out.println("Cuarto elemento" + colores.get(4));
        }catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
}
___________________________________________________________________________________
Ejercicio 2
___________________________________________________________________________________
/*
EJERCICIO 2

Escribe un programa en Java que utilice la clase ArrayList para almacenar una lista de colores. El programa debe seguir los siguientes pasos:

    Crear un ArrayList llamado a.
    Añadir los siguientes colores a a: "rojo", "verde", "azul", "blanco" y "amarillo".
    Imprimir el contenido de la lista.
*/

import java.util.ArrayList;

public class Pruebas {

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("rojo");
        a.add("verde");
        a.add("azul");
        a.add("blanco");
        a.add("amarillo");
        try{
            for (String i : a){System.out.println(i);} //imprimir con bucle for each
        }catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
___________________________________________________________________________________
Ejercicio 3
___________________________________________________________________________________
/*
EJERCICIO 3

Escribe un programa en Java que utilice la clase ArrayList para manejar una lista de colores. El programa debe realizar las siguientes acciones:

    Crear un ArrayList llamado a e inicializarlo con los siguientes colores: "rojo", "verde", "azul", "blanco", "amarillo" y "blanco" (permitiendo duplicados).
    Imprimir el contenido de la lista.
    Verificar si la lista contiene el color "blanco" e imprimir un mensaje correspondiente.
    Eliminar la primera ocurrencia del color "blanco" de la lista.
    Imprimir el contenido de la lista después de eliminar la primera ocurrencia de "blanco".
    Eliminar el elemento en la posición 2 de la lista.
    Imprimir el contenido de la lista después de eliminar el elemento en la posición 2.

*/

import java.util.ArrayList;

public class Pruebas {

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("rojo");
        a.add("verde");
        a.add("azul");
        a.add("blanco");
        a.add("amarillo");
        a.add("blanco");
        int j = 0;
        try{
            for (String i : a){System.out.print(i+" ");} //imprimir con bucle for each
            System.out.println("");
            for (String i : a){
                if (i == "blanco"){
                    System.out.println("La lista contiene el color blanco en la posicion "+j);
                    break;
                }
                j++;
            }
            a.remove(j);
            for (String i : a){System.out.print(i+" ");}
            System.out.println("");
            a.remove(2);
            for (String i : a){System.out.print(i+" ");}
            System.out.println("");
        }catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
___________________________________________________________________________________
Ejercicio 4
___________________________________________________________________________________
/*
EJERCICIO 4

Escribe un programa en Java que utilice la clase ArrayList para manejar una lista de colores. El programa debe realizar las siguientes acciones:

    Crear un ArrayList llamado a e inicializarlo con los siguientes colores: "rojo", "verde", "azul", "blanco" y "amarillo".
    Imprimir el contenido de la lista.
    Insertar el color "turquesa" en la posición 1 de la lista.
    Imprimir el contenido de la lista después de insertar "turquesa" en la posición 1
*/

import java.util.ArrayList;

public class Pruebas {

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("rojo");
        a.add("verde");
        a.add("azul");
        a.add("blanco");
        a.add("amarillo");
        try{
            for (String i : a){System.out.print(i+" ");} //imprimir con bucle for each
            System.out.println("");
            a.set(0,"turquesa");
            for (String i : a){System.out.print(i+" ");} //imprimir con bucle for each
        }catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
___________________________________________________________________________________
Ejercicio 5
___________________________________________________________________________________
/*
EJERCICIO 5

Escribe un programa en Java que utilice la clase ArrayList para manejar una lista de objetos de tipo Gato. Cada gato tiene un nombre, un color y una raza. El programa debe realizar las siguientes acciones:

    Crear un ArrayList llamado g para almacenar objetos de tipo Gato.
    Añadir cuatro gatos a la lista con los siguientes datos:
        Nombre: "Garfield", Color: "naranja", Raza: "mestizo"
        Nombre: "Pepe", Color: "gris", Raza: "angora"
        Nombre: "Mauri", Color: "blanco", Raza: "manx"
        Nombre: "Ulises", Color: "marrón", Raza: "persa"
    Imprimir los datos de cada gato en la lista.
*/

public class Gato {
    private String nombre;
    private String color;
    private String raza;

    public Gato(String nombre, String color, String raza) {
        this.nombre = nombre;
        this.color = color;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    public void imprimir(){
        System.out.println("nombre "+nombre+", color "+color+", raza "+raza);
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Color: " + color + ", Raza: " + raza;
    }
}

import java.util.ArrayList;

public class Pruebas {
    
    public static void main(String[] args) {
        ArrayList<Gato> g = new ArrayList<Gato>(); // Creación del ArrayList para almacenar objetos Gato

        // Añadir objetos Gato al ArrayList
        g.add(new Gato("Garfield", "naranja", "mestizo"));
        g.add(new Gato("Pepe", "gris", "angora"));
        g.add(new Gato("Mauri", "blanco", "manx"));
        g.add(new Gato("Ulises", "marrón", "persa"));

        // Imprimir los datos de cada gato en la lista
        for (Gato gato : g) {
            System.out.println(gato);
            gato.imprimir();
        }
    }
}