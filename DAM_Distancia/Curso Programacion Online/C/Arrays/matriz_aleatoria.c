/*
programa que rellene aleatoriamente una matriz de 
3x4 y la muestre por pantalla (num entre 0 y 20)
ampliar para que pregunte un numero y nos diga fila 
y columna
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){
    srand(time(NULL));
    int matriz [3][4], numUsuario;
    int tamArrayFila =sizeof(matriz)/sizeof(matriz[0]);
    int tamArrayColumna =sizeof(matriz[0])/sizeof(matriz[0][0]);

    for (int i = 0; i< tamArrayFila; i++){
        for (int j = 0; j< tamArrayColumna;j++){
            matriz[i][j] = rand()%21; 
        }
    }

    printf("Introduce un numero: ");
    scanf(" %i",&numUsuario);

    for (int i = 0; i< tamArrayFila; i++){
        for (int j = 0; j< tamArrayColumna;j++){
            if (matriz[i][j] == numUsuario){
                printf("La posicion del valor es Fila:%d Columna:%d\n", i, j);
            }
        }
        
    }
}