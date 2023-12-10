#include <stdio.h>
#include <math.h>
//#define _USE_MATH_DEFINES

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
void clearInputBuffer();

int main() {

    ej3();

    return 0;
}
void ej1(){
    float metros, pulgadas, pies;
    printf("Introduce la cantidad de metros: ");
    scanf(" %f",&metros);
    clearInputBuffer();
    pulgadas = metros * 39,3701;
    pies = metros * 3,28084;
    printf("%.2f metros son %.2f pulgadas\n", metros, pulgadas);
    printf("%.2f metros son %.2f pies\n", metros, pies);
}

void ej2(){
    int meses;
    float dinero, dineroFinal;
    printf("Introduce el dinero: ");
    scanf(" %f",&dinero);
    clearInputBuffer();
    printf("Introduce la cantidad de meses que va a estar ingresado: ");
    scanf(" %i",&meses);
    clearInputBuffer();
    
    dineroFinal = dinero;
    for (int i = 1; i<=meses; i++){
        dineroFinal = dineroFinal + (dineroFinal*0.02);
    }

    printf("Al cabo de %i meses, tu saldo sera de %.2f\n",meses, dineroFinal);
}

void ej3(){
    float sueldo, sueldoFinal, ventas;
    printf("Introduce el sueldo: ");
    scanf(" %f",&sueldo);
    clearInputBuffer();
    printf("Introduce la cantidad de ventas: ");
    scanf(" %i",&ventas);
    clearInputBuffer();

    float comision = (10 * ventas)/100;
    sueldoFinal = sueldo + (sueldo * comision);
    printf("Tu sueldo base es de %.2f euros, con %.0f ventas, tu sueldo a final de mes es %.2f\n", sueldo, sueldoFinal, ventas);
}

void ej4(){
    float precio, precioFinal;
    printf("Introduce el importe de compra: ");
    scanf(" %f",&precio);

    precioFinal = precio - (precio * 0.15);
    printf("El precio final es de %.2f euros", precioFinal);
}

void ej5(){
    float hombres, mujeres, porcentaje;
    printf("Introduce el numero de hombres: ");
    scanf(" %f",&hombres);
    clearInputBuffer();
    printf("Introduce el numero de mujeres: ");
    scanf(" %f",&mujeres);
    clearInputBuffer();

    float total = hombres + mujeres;
    porcentaje = (hombres / total)*100;
    float porcentajeM = 100 - porcentaje;

    printf("El porcentaje de hombres es de %.2f y el de mujeres es de %.2f", porcentaje, porcentajeM);
}

void ej6(){
    float euros, dolares;
    printf("Introduce el numero de euros: ");
    scanf(" %f",&euros);
    clearInputBuffer();
    dolares = euros * 1,10;
    printf("%.2f euros son %.2f dolares", euros, dolares);
}

void ej7(){
    int edad, pulsaciones;
    printf("Introduce tu edad: ");
    scanf(" %i",&edad);
    clearInputBuffer();

    pulsaciones = (220 - edad)/10;
    printf("A tu edad, deberias tener %i pulsaciones cada 10 segundos", pulsaciones);
}

void ej8(){
    float presupuesto, ginecologia, pedriatia;
    printf("Introduce el presupuesto: ");
    scanf(" %f",&presupuesto);
    clearInputBuffer();

    ginecologia = presupuesto * 0.4;
    pedriatia = presupuesto * 0.3;

    printf("El total presupuestado es de %.2f euros\n", presupuesto);
    printf("El departamento de Ginecologia recive %.2f\n", ginecologia);
    printf("El departamento de Pedriatia recive %.2f\n", pedriatia);
    printf("El departamento de Traumatologia recive %.2f\n", pedriatia);
}

void ej9(){
    float precioCompra, precioVenta;
    printf("Ingrese el precio de compra : ");
    scanf("%f", &precioCompra);
    clearInputBuffer();

    precioVenta = precioCompra + (precioCompra * 0.3);
        printf("El precio al que debe vender el articulo es: %.2f\n", precioVenta);
}

void ej10(){
    char caracter;

    printf("Ingrese un caracter: ");
    scanf("%c", &caracter);
    clearInputBuffer();
    
    printf("El valor ASCII de '%c' es: %d\n", caracter, caracter);

}
//Metodo para limpiar el buffer cada vez que lo llamo
void clearInputBuffer() {
    int c;
    while ((c = getchar()) != '\n' && c != EOF) { }
}