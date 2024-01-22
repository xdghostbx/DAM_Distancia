/*
Programa que calcule áreas de distintas figuras: -Cuadrado, rectángulo, triángulo,
circunferencia y cilindro (pista: se calcula sumando el área de las 2 lado1s y después
la de el contorno que si lo extendemos es un rectángulo).
*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

float perimetroRect(float lado1, float lado2){
    return((lado1*2)+(lado2*2));
}
float areaRect(float lado1, float lado2){
    float areaRe;
    areaRe = lado1 * lado2;
    return areaRe;
}
float volumenRect(float areaRe,float alturaRe){
    float volumenRe;
    printf("Introduce la altura de la figura:\n");
    scanf(" %f",&alturaRe);
    volumenRe = areaRe * alturaRe;
    return volumenRe;
}


float rectangulo(float lado1, float lado2){
    int op2 = 0, ;
    float lado1, lado2, alturaRe;
    printf("Ingrese la lado1 de tu figura:\n");
    scanf("%f", &lado1);
    printf("Ingrese la lado2 de tu figura:\n");
    scanf("%f",&lado2);
    if (lado1 == lado2){
        printf("Su figura es un cuadrado\n");
    }
    printf ("Que quieres calcular?\n");
    printf ("1- Perimetro\n2-Area\n3-Volumen\n");
    scanf(" %i", &op2);
    switch (op2)
    {
    case 1:
        perimetroRect();
        break;
    case 2:
        areaRect();
        break;
    case 3:
        volumenRect();
    default:
        break;
    }
}

float triangulo(){

}

float circulo(){

}

void menu(){
    int opcion;
    printf ("Selecciona una de las siguientes figuras geometricas para hacer los calculos: \n");
    printf("1- Cuadrado\n2- Triangulo\n3- Rectangulo\n4-Salir");
    scanf(" %i", opcion);
    switch (opcion) {
        case 1: 
            rectangulo();
            break;
        case 2:
            triangulo();
            break;
        case 3:
            circulo();
            break;
        case 4:
            printf("saliendo...");
            break;
        default:
            printf("Opcion no valida");
            break;
    }
}

int main(){
    
    menu();
    return 0;
}