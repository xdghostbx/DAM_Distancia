/*
Programa que nos ponga la tabla del 5
Debe aparecer : 
5x0 = 0
5x1 = 5
etc
*/

#include <stdio.h>

int main() {
    int cinco = 5;
    int resultado;
    for (int a = 0; a <= 10; a++){
        resultado = a * cinco;
        printf("%i x %i = %i\n",cinco, a, resultado);
    }
    
    return 0;
}