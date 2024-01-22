/*
1
    Crear un programa con el menu
        -carnes
        -pescados
        -postres
    Cada opcion deberá mostrar 2 platos de cada
*/

/*
2
    Al entrar en el submenu y escoger un plato deberá mostrar la preparacion y el precio
*/

/*
3
    Crea 10 usuarios, cada uno deberá elegir su plato preferido y al finalizar su eleccion
    deberá salir el numero de votos de cada plato ordenado por votos
*/

/*
4
    Hacer una opcion 4 que permita buscar un plato de cada y nos ponga una factura escogiendo
    una carne, un pescado y un postre
*/

#include <stdio.h>
#include <string.h>

#define NUM_PLATOS 6
#define NUM_COMENSALES 10

int votos[NUM_COMENSALES][NUM_PLATOS] = {0}; //10 personas a 3 platos cada una inicializada a 0
//iniciamos todas las funciones antes del main
void platos_carnes(), platos_pescados(), platos_postres(), chuleta(), jamon(), lubina(), salmon(), arroz(), queso();
void menu(), votaciones(), buscar_plato();

char nombre[NUM_PLATOS][50]; //array para el nombre de los platos

int main(){
    //ponemos el nombre de los platos mediante strcpy (para no inicializarlo a mano)
    strcpy(nombre[0], "Chuletas de Cordero");
    strcpy(nombre[1], "Jamon Asado");
    strcpy(nombre[2], "Lubina al Horno");
    strcpy(nombre[3], "Salmon a la plancha");
    strcpy(nombre[4], "Arroz con Leche");
    strcpy(nombre[5], "Tarta de Queso");

    int opcion, op2;
    //menu con switch a las funciones correspondientes
    while (opcion != 6) {
        menu();
        printf("Introduzca una opcion: ");
        scanf("%d", &opcion);
        switch (opcion) {
        case 1:
            platos_carnes();
            break;
        case 2:
            platos_pescados();
            break;
        case 3:
            platos_postres();
            break;
        case 4:
            buscar_plato();
            break;
        case 5:
            votaciones();
            break;
        default:
            printf ("Selecciona una opcion correcta...\n");
            break;
        }
    }
    return 0;
}
//funcion menu, imprime las opciones
void menu(){
    printf("Menu\n");
    printf("1. Carnes \n2. Pescados \n3. Postres \n4. Buscar plato\n5. Votos\n6. Salir\n");
}
/*funcion para buscar el plato y sacar el ticket (ej4)
    Tiene una variable "total" que va haciendo un sumatorio
    del precio acumulado y lo imprime
*/
void buscar_plato() {
   int carne, pescado, postre;
   printf("Escoge una carne:\n 1. Chuletas de cordero\n 2. Jamon Asado\n");
   scanf("%d", &carne);
   printf("Escoge un pescado:\n 1. Lubina al honro\n 2. Salmon a la plancha\n ");
   scanf("%d", &pescado);
   printf("Escoge un postre:\n 1. Arroz con leche\n 2. Tarta de queso\n ");
   scanf("%d", &postre);

   float total = 0;

   printf("Factura:\n______________\n");
   if(carne == 1) {
       printf("Chuletillas de Cordero: 12.50€\n");
       total += 12.50;
   } else {
       printf("Jamon Asado: 10.50€\n");
       total += 10.50;
   }
   if(pescado == 1) {
       printf("Lubina al horno: 16.00€\n");
       total += 16.00;
   } else {
       printf("Salmon a la plancha: 18.00€\n");
       total += 18.00;
   }
   if(postre == 1) {
       printf("Arroz con leche: 4.50€\n");
       total += 4.50;
   } else {
       printf("Tarta de queso: 5.50€\n");
       total += 5.50;
   }
   return printf("Total: %.2f€\n", total);
}
//menus intermedios para ver las distintas opciones (ej1)
void platos_carnes(){
    int op2;
    printf("Escoge una carne:\n1. Chuletillas de Cordero\n2. Jamon Asado\n");
    scanf("%d",&op2);
    if(op2==1){
        chuleta();
    }else if (op2 == 2){
        jamon();
    }else printf("Selecciona una opcion correcta...\n");
}
void platos_pescados(){
    int op2;
    printf("Escoge un pescado:\n1. Lubina al horno\n2. Salmon a la plancha\n");
    scanf("%d",&op2);
    if(op2==1){
        lubina();
    }else if (op2 == 2){
        salmon();
    }else printf("Selecciona una opcion correcta...\n");
}
void platos_postres(){
    int op2;
    printf("Escoge un postre:\n1. Arroz con leche\n2. Tarta de queso\n");
    scanf("%d",&op2);
    if(op2==1){
        arroz();
    }else if (op2 == 2){
        queso();
    }else printf("Selecciona una opcion correcta...\n");
}
//funciones de cada plato con su preparacion ej(2)
void chuleta() {
   printf("Has elegido Chuletillas de Cordero\n");
   printf("Preparacion:\n- Chuletillas de cordero\n- Ajo, Perejil, Sal y Pimienta\n- Aceite de oliva\n");
   printf("Precio: 12.50€\n");
}
void jamon() {
   printf("Has elegido Jamon Asado\n");
   printf("Preparacion:\n- Jamon\n- Ajo, Perejil, Sal y Pimienta\n- Aceite de oliva\n");
   printf("Precio: 10.50€\n");
}
void lubina() {
   printf("Has elegido Lubina al horno\n");
   printf("Preparacion:\n- Lubina\n- Ajo, Perejil, Sal y Pimienta\n- Aceite de oliva\n");
   printf("Precio: 14.00€\n");
}
void salmon() {
   printf("Has elegido Salmon a la plancha\n");
   printf("Preparacion:\n- Salmon\n- Ajo, Perejil, Sal y Pimienta\n- Aceite de oliva\n");
   printf("Precio: 13.00€\n");
}
void arroz() {
   printf("Has elegido Arroz con leche\n");
   printf("Preparacion:\n- Arroz\n- Leche, Azucar, Canela\n");
   printf("Precio: 5.00€\n");
}
void queso() {
   printf("Has elegido Tarta de queso\n");
   printf("Preparacion:\n- Queso crema, Huevos, Azucar, Harina\n");
   printf("Precio: 6.00€\n");
}
//funcion para realizar las votaciones y ordenar por orden de votos (ej3)
void votaciones(){
    printf("Cual es tu plato favorito? Selecciona solo 1:\nLista de platos: \n");
    for (int i = 0; i < NUM_PLATOS; i++) {
        printf("%d- %s \n", i + 1, nombre[i]);
    }

    int resultados[NUM_PLATOS] = {0};  // Array para almacenar los resultados de los votos

    for (int i = 0; i < NUM_COMENSALES; i++) {
        printf("Comensal %d, elige tu plato favorito (1 al %d):\n", i + 1, NUM_PLATOS);
        int eleccion;
        do {
            printf("Plato: ");
            scanf("%d", &eleccion);
        } while (eleccion < 1 || eleccion > NUM_PLATOS);

        votos[i][eleccion - 1] = 1;  // Marcar el plato elegido
        resultados[eleccion - 1]++;   // Incrementar los votos para el plato correspondiente
    }

    for (int i = 0; i < NUM_PLATOS - 1; i++) {
        for (int j = 0; j < NUM_PLATOS - i - 1; j++) {
            if (resultados[j] < resultados[j + 1]) {
                // Intercambiar los resultados y los nombres correspondientes
                int temp = resultados[j];
                resultados[j] = resultados[j + 1];
                resultados[j + 1] = temp;

                // Intercambiar los nombres
                char tempNombre[50];
                strcpy(tempNombre, nombre[j]);
                strcpy(nombre[j], nombre[j + 1]);
                strcpy(nombre[j + 1], tempNombre);
            }
        }
    }

    printf("\n----- RESULTADOS -----\n");

    for (int i = 0; i < NUM_PLATOS; i++) {
        printf("Plato %s: %d votos\n", nombre[i], resultados[i]);
    }
}