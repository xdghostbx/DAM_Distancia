/*Inicio arrays en C*/
/*
#include <stdio.h>;
    int main(){
        // Declaración e inicialización de un array de enteros
    int numeros[5] = {1, 2, 3, 4, 5};

    // Declaración de un array de caracteres (cadena)
    char nombre[20]; // Array de 20 caracteres

    // Declaración de un array multidimensional
    int matriz[3][3]; // Matriz 3x3

    int valores[5] = {10, 20, 30, 40, 50};

    // Acceder y modificar elementos del array
    valores[2] = 35; // Modifica el tercer elemento (índice 2) a 35
    int x = valores[0]; // Lee el primer elemento y lo asigna a 'x'

    int numeros[5] = {1, 2, 3, 4, 5};
    int i;

    // Recorriendo e imprimiendo los elementos del array
    for (i = 0; i < 5; i++) {
        printf("%d ", numeros[i]);
    }
    // Salida: 1 2 3 4 5

    void imprimirArray(int arr[], int tam) {
    int i;
    for (i = 0; i < tam; i++) {
        printf("%d ", array[i]);
    }
}

    int main() {
        int numeros[5] = {1, 2, 3, 4, 5};
        imprimirArray(numeros, 5);
        return 0;
    }
    // Salida: 1 2 3 4 5


    int matriz[3][3] = {
        {1, 2, 3}, 
        {4, 5, 6},
        {7, 8, 9}
    };

    // Acceder a un elemento específico de la matriz
    int elemento = matriz[1][2]; // Accede al elemento en la segunda fila, tercera columna (6)


    int numeros[5] = {1, 2, 3, 4, 5};
    int tam = sizeof(numeros) / sizeof(numeros[0]);
    printf("El tamaño del array es: %d\n", tam);
    // Salida: El tamaño del array es: 5


        return 0;
    }*/

    #include <stdio.h>;
    int main(){
        int num[9];
        int numUsuario;
        printf("Vamos a introducir 10 numeros\n");
        for (int i = 0 ; i<10 ; i++){
            printf("Introduce el %i numero:  \n", i);
            scanf(" %i",&num[i]);
        }
        printf("Introduce un numero para ver si está el tu lista: ");
        scanf(" %i",&numUsuario);
    }

    /*ejercicio en que se guardan 3 notas de 5 alumnos
    luego se puede escoger lo siguiente:
    1.- Notas de alumno 1
    2.- Promedio alumno 1
    3.- Promedio de notas de asignatura de ingles 
    */

   #include <stdio.h>;
    int main(){
        char alumno[4][50] = {"Dani", "Fernando", "Eloisa", "Nico", "Alberto"};
        float notas[2]; 
        int numUsuario;
        printf("Vamos a introducir las notas\n");
        for (int i = 0 ; i<sizeof(alumno) ; i++){
            printf("Introduce el nombre del %i alumno:  \n", i);
            scanf(" %c",&alumno[i].notas[j]);
        }
        printf("Introduce un numero para ver si está el tu lista: ");
        scanf(" %i",&numUsuario);
    }