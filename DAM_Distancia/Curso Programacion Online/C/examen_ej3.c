//juego numero mayor o menor

//forma 1, bucle do while para que siga preguntando
//añado tambien un generador de numero aleatorio

#include <stdio.h>
#include <stdlib.h>

int main() {
    int numeroOculto = rand() % 100; //nos genera un numero aleatorio entre 0 y 100
    int opcion;
    
    do{
        printf("Introduce un numero\n");
        scanf(" %i",&opcion);
        if (opcion < numeroOculto){
            printf("El numero oculto es mayor!\n");
        }else if ( opcion > numeroOculto){
            printf("El numero oculto es menor!\n");
        }else if (opcion == numeroOculto){
            printf("Has acertado! El numero oculto era %i",numeroOculto);
        }
    }while (opcion != numeroOculto);


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