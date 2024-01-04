/*
1. Creamos un array(unidimensional) de números float con cinco prezos de cinco productos.
Pedimos os cinco prezos por teclado e os mostramos.
*/

#include <stdio.h>

int main()
{
    float precios[4];
    int tamPrecio =1+ sizeof(precios)/sizeof(precios[0]);
    printf("Introduce 5 precios\n");
    for (int i = 0; i < tamPrecio; i++ ){
        printf("precio %i:\n",i+1);
        scanf(" %f",&precios[i]);
    }
    
    for (int i =0; i< tamPrecio; i++){
        printf("Precio %i: %.2f€\n",i+1, precios[i]);
    }
    return 0;
}

/*
2. Do exercicio anterior creamos un array unidimensional para gardar os cinco prezos anteriores cun desconto dun 20%.
O mostramos por pantalla o prezo inicial e o prezo con desconto.
*/

#include <stdio.h>

int main()
{
    float precios[4],descuento[4];
    int tamPrecio =1+ sizeof(precios)/sizeof(precios[0]);
    printf("Introduce 5 precios\n");
    for (int i = 0; i < tamPrecio; i++ ){
        printf("precio %i:\n",i+1);
        scanf(" %f",&precios[i]);
        descuento[i]=precios[i]-(precios[i]*0.2);
    }
    
    for (int i =0; i< tamPrecio; i++){
        printf("Precio %i: %.2f€ y con descuento: %.2f€\n",i+1, precios[i],descuento[i]);
    }
    
    return 0;
}

/*
3. Creamos un array bidimensional que garda cinco prezos de cinco productos e automáticamente ten que calcular e gardar os productos cun 40% de desconto.
Debemos mostrar os productos cos prezos e os descontos.
4. Baseándonos no exercicio anterior debemos crear un programa que primeiro nos mostre este menú:
a. Ver prezos
b. Ver prezos con desconto
c. Ver productos con prezos e descontos.
*/

#include <stdio.h>

int main()
{
    float tienda[4][1];
    int tamPrecio =1+ sizeof(tienda)/sizeof(tienda[0]);
    
    printf("Introduce 5 precios\n");
    for (int i = 0; i < tamPrecio; i++ ){
        printf("precio %i:\n",i+1);
        scanf(" %f",&tienda[i][0]);
        tienda[i][1]=tienda[i][0]-((tienda[i][0])*0.4);
        //printf("Precio %i: %.2f€ y con descuento: %.2f€\n",i+1, tienda[i][0],tienda[i][1]);
    }
    
    for (int i =0; i< tamPrecio; i++){
        printf("Precio %i: %.2f€ y con descuento: %.2f€\n",i+1, tienda[i][0],tienda[i][1]);
    }
    
    return 0;
}
//ampliacion del 3
#include <stdio.h>

int main()
{
    float tienda[5][2];
    int tamPrecio =1+ sizeof(tienda)/sizeof(tienda[0]), opcion;
    
    printf("Introduce 5 precios\n");
    for (int i = 0; i < tamPrecio; i++ ){
        printf("precio %i:\n",i+1);
        scanf(" %f",&tienda[i][0]);
        tienda[i][1]=tienda[i][0]-((tienda[i][0])*0.4);
        //printf("Precio %i: %.2f€ y con descuento: %.2f€\n",i+1, tienda[i][0],tienda[i][1]);
    }
    do{
        printf("Introduce una de las opciones siguientes:\n");
        printf("1.- Ver precios\n");
        printf("2.- Ver precios con descuento\n");
        printf("3.- Ver producto con precios y descuentos\n");
        printf("4.- Salir\n");
        scanf(" %i",&opcion);
        
        switch (opcion){
            case 1:
                for (int i = 0; i < tamPrecio; i++ ){
                    printf("Precio %i: %.2f€\n",i+1, tienda[i][0]);
                }
                break;
            case 2:
                for (int i = 0; i < tamPrecio; i++ ){
                    printf("Precio %i con su descuento: %.2f€\n",i+1, tienda[i][1]);
                }
                break;
            case 3:
                for (int i = 0; i < tamPrecio; i++ ){
                    printf("Precio %i: %.2f€ y con descuento: %.2f€\n",i+1, tienda[i][0],tienda[i][1]);
                }
                break;
            case 4:
                printf("Saliendo...\n");
                break;
            default:
                printf("Introduce una opcion valida...\n");
                break;
        }
    }while (opcion != 4);
    
    return 0;
}