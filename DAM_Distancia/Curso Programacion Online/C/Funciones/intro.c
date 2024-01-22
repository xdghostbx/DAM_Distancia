/*
v1:
ejercicio para sum, resta, mult en 3 funciones
cada funcion no devuelve ni pedimos datos

v2:
ahora no le pasamos nada pero cada funcion devuelve el
resultado. El main pone por pantalla la solucion

v3:
sum, res y mult 2 numeros bla bla bla
pedimos los numeros a operar dentro del main, cada
funcion devuelve el resultado al main
*/
#include <stdio.h>

int sum(int n1, int n2) { 
    return (n1 + n2);
}

int res(int n1, int n2) {
    if (n2 == 0)
        return n1;
    else
        return (n1 - n2);
}

int mult(int n1, int m2) { 
    return (n1 * m2);

}

int main() {
    int n1, n2, op;
    int suma, resta, multi;
    printf("Introduce un numero\n");
    scanf("%d", &n1);
    printf("Introduce otro numero\n");
    scanf("%d", &n2);
    printf("Escoge una opcion\n");
    printf("1.- Sumar\n");
    printf("2.- Restar\n");
    printf("3.- Multiplicar\n");
    scanf("%d",&op);
    switch (op){
        case 1:
            suma = sum(n1, n2);
            printf ("El resultado de la suma es: %i",suma);
            break;
        case 2:
            resta = res(n1, n2);
            printf ("El resultado de la resta es: %i",resta);
            break;
        case 3:
            multi = mult(n1, n2);
            printf ("El resultado de la multiplicacion es: %i",multi);
            break;
        
        default:
            break;
    }
}
   
