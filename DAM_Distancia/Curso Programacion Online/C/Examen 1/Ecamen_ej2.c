/*
El supermercado Pitón Market ha lanzado una promoción para todos 
sus clientes que posean la tarjeta Raw Input. 
La promoción consiste en aplicar un descuento a 5 productos
que pasan por caja.
El primer descuento es de 20%, y se aplica sobre los primeros
2 productos ingresados.
Luego,cada descuento es la mitad del anterior, y es 
aplicado sobre los siguientes productos.
Por ejemplo, deberá aparecer la cuenta total a pagar.
*/

#include <stdio.h>


int main() {
    float producto1, producto2, producto3, producto4, producto5, precioFinal;  

    printf("Introduce el precio del primer producto \n");
    scanf(" %f",&producto1);
    printf("Introduce el precio del segundo producto \n");
    scanf(" %f",&producto2);
    printf("Introduce el precio del tercer producto \n");
    scanf(" %f",&producto3);
    printf("Introduce el precio del cuarto producto \n");
    scanf(" %f",&producto4);
    printf("Introduce el precio del quinto producto \n");
    scanf(" %f",&producto5);

    precioFinal = ((producto1 + producto2)-((producto1+producto2)*0.2))+(producto3-(producto3*0.1))+(producto4-(producto4*0.05))+(producto5-(producto5*0.025));
    printf("El total de tu cuenta es: %.2f €",precioFinal);

    
    return 0;
}
