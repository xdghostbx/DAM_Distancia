/*
Fai un menú no cal o usuario ten que dicir un prezo e 
        lle aparece un menú así:
    a. PREZO NORMAL
    b. PREZO REBAIXAS (20%)
    c. PREZO PREZO LIQUIDACIÓN (40%)
O usuario cando elixe unha das opción sae o prezo final.
*/

#include <stdio.h>

int main() {
    float precio, precioFinal;
    char opcion;

    printf("Introduce un precio: \n");
    scanf(" %f",&precio);

    printf("Introduce una de las siguientes opciones para calcular el precio final\n");
    printf("a.- Precio Normal\n");
    printf("b.- Precio Rebajas (20%%)\n");
    printf("c.- Precio Liquidacion (40%%)\n");
    scanf(" %s", &opcion);

    switch (opcion)
    {
    case 'a':
        printf("Tu precio es de %.2f €", precio);
        break;
    case 'b':
        precioFinal = precio - (precio * 0.2);
        printf("Tu precio es de %.2f €", precioFinal);
        break;
    case 'c':
        precioFinal = precio - (precio * 0.4);
        printf("Tu precio es de %.2f €", precioFinal);
        break;
    
    default:
        printf("Introduce una opcion valida...");
        break;
    }
    return 0;
}
