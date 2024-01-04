//juego numero mayor o menor

//forma 1, bucle do while para que siga preguntando
//añado tambien un generador de numero aleatorio

#include <stdio.h>
#include <stdlib.h>

int main()
{   
    int filas = 10;
    /* ascendente
    for (int i = 1; i <= filas; i++) {
        for (int j = 1; j <= i; j++) {
            printf("*");
        }
        printf("\n");
    }
    */
    /* descendente
    for (int i = filas; i >= 1; i--) {
        for (int j = 1; j <= i; j++) {
            printf("*");
        }
        printf("\n");
    }
    */
    
    /* ascendente y descendente
    for (int i = 1; i <= filas; i++) {
        for (int j = 1; j <= i; j++) {
            printf("*");
        }
        printf("\n");
    }
    
    for (int i = filas; i >= 1; i--) {
        for (int j = 1; j <= i; j++) {
            printf("*");
        }
        printf("\n");
    }
    */
    
    /* empezando con espacios
    for (int i = 1; i <= filas; i++) {
        for (int j = 1; j <= filas - i; j++) {
            printf(" ");
        }
        for (int k = 1; k <= i; k++) {
            printf("*");
        }
        printf("\n");
    }*/
    
    //rombo completo
    /*
    for (int i = 1; i <= filas; i++) {
        for (int j = 1; j <= filas - i; j++) {
            printf(" ");
        }
        for (int k = 1; k <= i; k++) {
            printf("*");
        }
        for (int l = 1; l <= i; l++) {
            printf("*");
        }
        printf("\n");
    }
    for (int i = filas; i >= 1; i--) {
        for (int j = 1; j <= filas - i; j++) {
            printf(" ");
        }
        for (int k = 1; k <= i; k++) {
            printf("*");
        }
        for (int j = 1; j <= i; j++) {
            printf("*");
        }
        printf("\n");
    }*/
    
    return 0;
}


/*
Forma 2: Sin numero aleatorio y sin bucle
int main() {
    int numeroOculto = 63
    int opcion;

    printf("Introduce un numero\n");
    scanf(" %i",&opcion);
    if (opcion < numeroOculto){
        printf("El numero oculto es mayor!\n");
    }else if ( opcion > numeroOculto){
        printf("El numero oculto es menor!\n");
    }else if (opcion == numeroOculto){
        printf("Has acertado! El numero oculto era %i",numeroOculto);
    }

    return 0;
}

*/

/*forma 3, con bucle y numero aleatorio*/

#include <stdio.h>
#include <stdlib.h>

int main() {
    int numeroOculto = rand() % 100 + 1; // Generar un número aleatorio entre 1 y 100
    int opcion;
    int intentos = 0;

    printf("Adivina el numero entre 1 y 100\n");

    do {
        printf("Introduce un numero: ");
        scanf(" %d", &opcion);
        intentos++;

        if (opcion < numeroOculto) {
            printf("El numero oculto es mayor!\n");
        } else if (opcion > numeroOculto) {
            printf("El numero oculto es menor!\n");
        } else if (opcion == numeroOculto) {
            printf("Has acertado! El numero oculto era %d en %d intentos.\n", numeroOculto, intentos);
        }
    } while (opcion != numeroOculto);

    return 0;
}