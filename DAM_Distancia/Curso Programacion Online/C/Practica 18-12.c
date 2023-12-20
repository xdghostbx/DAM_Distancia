/*
1. Pedir un número do 1-10 e dicir se é primo.
2. Pedir un número do 1-12 e diga o nome do mes.
3. Pedir un número e que diga se é positivo ou negativo
4. Pedir tres números e que detecte se están en orde creciente
5. Pedir 10 números e que diga cal é o maior e cal o menor.
6. Pedir tres números e que diga se o terceiro é igual a suma do primeiro e do segundo.
7. Pedir tres números e que diga se a multiplicación dos dous primeiros é igual ó terceiro.
8. Pedir tres números e que diga se o terceiro é o resto da división dos dous primeiros.
9. Que muestre un menú onde as opcións son Equilátero, Isósceles e Escaleno, pida unha opción e calcule o perímetro do triángulo seleccionado.
10. Que lea un importe bruto y calcule su importe neto, si es mayor de 15.000 se le aplicará un 16% de impuestos, en caso contrario se le aplicará un 10%.
11. Que calcule el sueldo que le corresponde al trabajador de una empresa que cobra 40.000 euros anuales, el programa debe realizar los cálculos en función de los siguientes criterios:
a.       Si lleva más de 10 años en la empresa se le aplica un aumento del 10%.
b.      Si lleva menos de 10 años pero más que 5 se le aplica un aumento del 7%.
c.       Si lleva menos de 5 años pero más que 3 se le aplica un aumento del 5%.
d.      Si lleva menos de 3 años se le aplica un aumento del 3%.
*/


#include <stdio.h>
#include <math.h>


void ej1();
void ej2();
void ej3();
void ej4();
void ej5();
void ej6();
void ej7();
void ej8();
void ej9();
void ej10();
void ej11();
void clearInputBuffer();

int main() {

    int ejercicio; //usa el menu
    int numero; //usa ej1, ej2, ej3ç
    int numero2, numero3, numero4,numero5,numero6,numero7,numero8,numero9,numero10; //usa ej 4 al 8
    float importe; //usa 10 y 11

    do{
        printf("Introduce el numero de ejercicio a ejecutar: \n");
        printf("1.- Primo.\n");
        printf("2.- Nombre mes.\n");
        printf("3.- Positivo o negativo.\n");
        printf("4.- Numeros en orden.\n");
        printf("5.- Cual mayor o menos de 10 numeros. \n");
        printf("6.- El tercero es la suma?. \n");
        printf("7.- El tercero es la multiplicacion?. \n");
        printf("8.- El tercero es el resto?. \n");
        printf("9.- Calculo de perimetro con menu. \n");
        printf("10.- Calculo importe. \n");
        printf("11.- calculo sueldo trabajador. \n");
        scanf(" %i",&ejercicio);
        clearInputBuffer();
        
        switch (ejercicio){
            case 1: 
                ej1();
                break;
            case 2: 
                ej2();
                break;
            case 3: 
                ej3();
                break;
            case 4: 
                ej4();
                break;
            case 5:
                ej5();
                break;
            case 6:
                ej6();
                break;
            case 7:
                ej7();
                break;
            case 8:
                ej8();
                break;
            case 9:
                ej9();
                break;
            case 10:
                ej10();
                break;
            case 11:
                ej11();
                break;
            default:
                printf("Introduce un numero de ejercicio correcto... \n");
                break;
        }
        
        printf("\nPresiona Enter para continuar...");
        while (getchar() != '\n');
    } while (ejercicio != 5);

    return 0;
}

void ej2(){
    printf("Introduce un numero de mes (1 al 12). \n");
    scanf(" %i",&numero);
    clearInputBuffer();

    switch (numero){
        case 1:
            printf("Enero\n");
            break;
        case 2:
            printf("Febrero\n");
            break;
        case 3:
            printf("Marzo\n");
            break;
        case 4:
            printf("Abril\n");
            break;
        case 5:
            printf("Mayo\n");
            break;
        case 6:
            printf("Junio\n");
            break;
        case 7:
            printf("Julio\n");
            break;
        case 8:
            printf("Agosto\n");
            break;
        case 9:
            printf("Septiembre\n");
            break;
        case 10:
            printf("Octubre\n");
            break;
        case 11:
            printf("Noviembre\n");
            break;
        case 12:
            printf("Diciembre\n");
            break;
        default:
            printf("\n");
    }
}

void ej3(){
    printf("Introduce un numero, positivo o negativo. \n");
    scanf(" %i",&numero);
    clearInputBuffer();

    if (numero > 0){
        printf("Tu numero es positivo\n");
    }else if (numero < 0){
        printf("Tu numero es negativo\n");
    }else{
        printf("Ni positivo ni negativo, tu numero es 0\n");
    }
}

void ej4(){
    printf("Introduce tres numeros, el programa dirá si están en orden. \n");
    printf("Introduce el primer numero: \n");
    scanf(" %i",&numero);
    clearInputBuffer();
    printf("Introduce el segundo numero: \n");
    scanf(" %i",&numero2);
    clearInputBuffer();
    printf("Introduce el tercer numero: \n");
    scanf(" %i",&numero3);
    clearInputBuffer();

    if (numero < numero2 && numero2 < numero3){
        printf("Tus numeros están en orden\n");
    }
}

void ej6(){
    printf("Introduce tres numeros \n");
    printf("Introduce el primer numero: \n");
    scanf(" %i",&numero);
    clearInputBuffer();
    printf("Introduce el segundo numero: \n");
    scanf(" %i",&numero2);
    clearInputBuffer();
    printf("Introduce el tercer numero: \n");
    scanf(" %i",&numero3);
    clearInputBuffer();

    if (numero + numero2 == numero3){
        printf("El tercer numero es la suma de los otros dos\n");
    }else {
        printf("no\n");
    }
}

void ej7(){
    printf("Introduce tres numeros \n");
    printf("Introduce el primer numero: \n");
    scanf(" %i",&numero);
    clearInputBuffer();
    printf("Introduce el segundo numero: \n");
    scanf(" %i",&numero2);
    clearInputBuffer();
    printf("Introduce el tercer numero: \n");
    scanf(" %i",&numero3);
    clearInputBuffer();

    if (numero * numero2 == numero3){
        printf("El tercer numero es la multiplicacion de los otros dos\n");
    }else {
        printf("no\n");
    }
}

void ej8(){
    printf("Introduce tres numeros \n");
    printf("Introduce el primer numero: \n");
    scanf(" %i",&numero);
    clearInputBuffer();
    printf("Introduce el segundo numero: \n");
    scanf(" %i",&numero2);
    clearInputBuffer();
    printf("Introduce el tercer numero: \n");
    scanf(" %i",&numero3);
    clearInputBuffer();

    if (numero % numero2 == numero3){
        printf("El tercer numero es el resto de los otros dos\n");
    }else {
        printf("no\n");
    }
}