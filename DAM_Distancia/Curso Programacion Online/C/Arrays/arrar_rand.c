/******************************************************************************

Lista de 10 numeros aleatorios

*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>

int main() {
    int listaNumeros[10], intentos = 0, num;
    int tamLista = sizeof(listaNumeros) / sizeof(listaNumeros[0]);

    for (int i = 0; i < tamLista; i++) {
        listaNumeros[i] = rand() % 20 + 1;
    }

    for (int i = 0; i < tamLista; i++) {
        printf("%i.- %i\n", i + 1, listaNumeros[i]);
    }

    do {
        printf("Introduce un numero del 1 al 20: ");
        scanf("%i", &num);

        for (int j = 0; j < tamLista; j++) {
            if (num == listaNumeros[j]) {
                printf("Has acertado, tu numero está en la posición %i\n", j + 1); // Cambiado a j + 1
            }
        }
        intentos++;
    } while (intentos != 3);

    return 0;
}

/******************************************************************************

Pasar frase a mayus

*******************************************************************************/
/*
#include <stdio.h>                

int main() {                                
    char frase[100];
    int tamFrase = sizeof(frase)/sizeof(frase[0]);
                                               
    printf("Ingrese una frase: ");
    fgets(frase, tamFrase, stdin);
    for (int i = 0; i < tamFrase; i++){
        if (frase[i] >= 'a' && frase[i] <= 'z') {
            frase[i] = frase[i] - 'a' + 'A';
        }
    }

    printf("La frase en mayusculas es: ");
    printf("%s\n", frase);

    return 0;
}*/

/******************************************************************************

Pasar frase a mayus

*******************************************************************************/