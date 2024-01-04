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
void clearInputBuffer();

int main() {

    ej3();

    return 0;
}

void ej1(){
    int num;
    printf("Introduce un número\n");
    scanf(" %i",&num);
    if (num%2 == 0){
        printf("Tu numero es par\n");
    }else {
        printf("Tu numero es impar\n");
    }
}

void ej2(){
    char letra;
    printf("Introduce una letra\n");
    scanf(" %c",&letra);
    if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u'){
        printf("Has introducido una vocal");
    }else {
        printf("Has introducido una consonante");
    }
}

void ej3(){
    int num1, num2, temp;
    printf("Introduce una numero\n");
    scanf(" %i",&num1);
    printf("Introduce otro numero\n");
    scanf(" %i",&num2);
    if (num1 != num2){
        temp = num1;
        num1 = num2;
        num2 = temp;
        printf("Ahora el primer numero vale %i y el segundo vale %i\n",num1, num2);
    }
}

void ej4(){
    int entero, entero2, entero3, temp;
    printf("Introduce un numero\n");
    scanf(" %i",&entero);
    printf("Introduce otro numero\n");
    scanf(" %i",&entero2);
    printf("Introduce otro numero\n");
    scanf(" %i",&entero3);

    if (entero > entero2) {
        temp = entero;
        entero = entero2;
        entero2 = entero;
    }else if (entero2 > entero3) {
        temp = entero2;
        entero2 = entero3;
        entero3 = temp;

        if (entero > entero2) {
            temp = entero;
            entero = entero2;
            entero2 = temp;
        }
    }

    printf("Los números ordenados son: %i, %i, %i\n", entero, entero2, entero3);
}

void ej5(){
    //areas otra vez ??
}

void ej6(){
    int num;
    printf("Introduce un número\n");
    scanf(" %i",&num);
    if (num%2 == 0){
        printf("Tu numero es par ");
        if (num%4 == 0){
           printf("y es divisible entre 4\n"); 
        }else {
            printf("y no es divisible entre 4\n"); 
        }
    }else {
        printf("Tu numero es impar\n");
    }
}

void ej7(){
    int anho;
    printf("Introduce un año para saber si es o no bisiesto: ");
    scanf(" %i",&anho);
    if ((anho % 4 == 0 && anho % 100 != 0 ) || (anho % 400 == 0)){
        printf("El año es bisiesto");
    } else {
        printf("El año no es bisiesto");
    }
}

void ej8(){
    int opcionMenu;
    float euros, pesetas, temp;

    do {
        printf("Introduce una opcion (0 para salir): \n");
        printf("1.- Introduce una cifra de Euros\n");
        printf("2.- Introduce una cifra de Pesetas\n");
        printf("3.- Pasar euros a pesetas\n");
        printf("4.- Pasar pesetas a euros\n");
        printf("0.- Salir del programa\n");
        scanf(" %i",&opcionMenu);

        
        switch (opcionMenu) {
            case 1:
                printf("Introduce una cifra de euros: \n");
                scanf(" %f",&euros);
                break;
            case 2:
                printf("Introduce una cifra de pesetas: \n");
                scanf(" %f",&pesetas);
                break;
            case 3:
                temp = euros * 166.386;
                printf("%.2f euros son %.2f pesetas\n", euros, temp);
                break;
            case 4:
                temp = pesetas * 0.006;
                printf("%.2f pesetas son %.2f euros\n", pesetas, temp);
                break;
            case 0:
                printf("Saliendo del programa...\n");
                break;
            default:
                printf("Opcion invalida. Introduce un numero del 0 al 11.\n");
        }
    } while (opcionMenu != 0);
}

//Metodo para limpiar el buffer cada vez que lo llamo
void clearInputBuffer() {
    int c;
    while ((c = getchar()) != '\n' && c != EOF) { }
}