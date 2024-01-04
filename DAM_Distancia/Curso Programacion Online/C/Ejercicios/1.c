#include <stdio.h>

int main() {
    int a = 5;
    char b = 'b';
    int suma = 10;
    int primera = 1, segunda = 2, tercera = 3;
    int edad1 = 25 , edad2 = 30;
    char letra1 = 'a', letra2 = 'b'; 
    float A = 6;
    float B = A;
    char letra3 = 'c', letra4 = 'd', letra5 = 'e'; 
    
    B = A + 10;
    float C = A - 10;
    float D = A * 10;
    float E = A / 10;
    
    printf("Valor de a: %i", a);
    printf("\nValor de b: %c\n", b);
    printf("\nValor de suma inicial: %i", suma);
    printf("\nValor de suma despues: %i", suma + 10);
    printf("\nValor de 3 variables distintas: %i %i %i", primera,segunda,tercera);
    printf("\nValor de las variables edad: %i %i", edad1 , edad2);
    printf("\nValor de las variables char: %c %c", letra1, letra2);
    printf("\nValor de Variable A: %i" , A);
    printf("\nValor de B igualando a A: %i", B);
    printf("\nValor de 3 variables char: %c %c %c", letra3, letra4, letra5);
    printf("\nValor de A: %f", A);
    printf("\nValor de B = A + 10: %f", B);
    printf("\nValor de C = A - 10: %f", C);
    printf("\nValor de D = A * 10: %f", D);
    printf("\nValor de E = A / 10: %f", E);
    
    return 0;
}