#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){
    srand(time(NULL));
    int primitiva [2][6];
    int tamArrayFila =sizeof(primitiva)/sizeof(primitiva[0]);
    int tamArrayColumna =sizeof(primitiva[0])/sizeof(primitiva[0][0]);

    for (int i = 0; i< tamArrayColumna; i++){
        primitiva[1][i] = rand() % 7;
    }

    for (int i = 0; i< tamArrayColumna; i++){
        printf("Introduce el %i numero de tu boleto: \n", i+1);
        scanf(" %i",&primitiva[0][i]);
    }

    printf("El numero ganador es: \n");
    for (int i = 0; i< tamArrayColumna; i++){
        printf("%i",primitiva[1][i]);
    }
}
