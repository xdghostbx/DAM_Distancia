/*
Para pedir datos a usuario usamos
    scanf();

En un ejemplo:
int main() {
    int numUsuario;
    printf("Dame un numero: ");
    scanf("%i",&numUsuario);
    printf("Tu numero es: %i",numUsuario);
    return 0;
}
*/

/*
Ejercicio1:
Pedir al usuario un numero y responda " Has introducido el numero (X), gracias."
Que pregunte al usuario cuántos años tiene, y conteste al
usuario: “Ahora se que tienes (x) años, gracias”.
Escribe un programa que pregunte la hora, y conteste con un mensaje: “Hora
introducida ok. Son las 18:30:00 (por ejemplo)”.

Ejercicio2:
Escribe un programa que pregunte al usuario sus iniciales y conteste diciendo:
“Sus iniciales son: A.J.R. (por ejemplo)”.

Ejercicio3:
Escribe un programa que pregunte al usuario su altura aproximada, sus iniciales y
conteste diciendo: “Sus iniciales son: A.J.R. y su altura 1.34 (por ejemplo)”.
*/

#include <stdio.h>

int main() {
    //Variables Ej 1
    int numUsuario , anho, hora , minutos , segundos;

    //Variables Ej 2
    char inicialNombre , inicialApellido1 , inicialApellido2;

    //Variable Ej 3
    //repetimos inciales
    float estatura;

    //pedimos el numero
    printf("Introduce un numero: ");
    scanf(" %i",&numUsuario);
    printf("Has introducido el numero %i, gracias.\n",numUsuario);

    //pedimos la edad
    printf("Introduce tu edad: ");
    scanf(" %i",&anho);
    printf("Ahora se que tienes %i años, gracias.\n",anho);

    //pedimos la hora
    printf("Introduce la hora: ");
    scanf(" %i",&hora);
    printf("Introduce los minutos: ");
    scanf(" %i",&minutos);
    printf("Introduce los segundos: ");
    scanf(" %i",&segundos);
    printf("Hora introducida OK. Son las %i:%i:%i\n",hora, minutos, segundos);

    //pedimos las iniciales
    printf("Introduce la inicial de tu nombre: ");
    scanf(" %c",&inicialNombre);
    printf("Introduce la inicial de tu primer apellido: ");
    scanf(" %c",&inicialApellido1);
    printf("Introduce la inicial de tu segundo apellido: ");
    scanf(" %c",&inicialApellido2);
    printf("Sus iniciales son %c.%c.%c\n",inicialNombre, inicialApellido1, inicialApellido2);

    //Pedimos altura aproximada e iniciales
    printf("Introduce tu altura aproximada en metros (usa el punto para decimal): ");
    scanf(" %f", &estatura);
    printf("Sus iniciales son %c.%c.%c y su altura %.2f",inicialNombre, inicialApellido1, inicialApellido2, estatura);
    return 0;
}