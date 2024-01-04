#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int calcularPremio(int apuesta, int opcion, int numeroGanador, int opcionApuesta, int numero) {
    int premio = 0;

    switch (opcion) {
        case 1: // Par
            if (numeroGanador % 2 == 0 && opcionApuesta == 1) {
                premio = apuesta * 2;
            }
            break;
        case 2: // Impar
            if (numeroGanador % 2 != 0 && opcionApuesta == 2) {
                premio = apuesta * 2;
            }
            break;
        case 3: // Docena 1-12
            if (numeroGanador >= 1 && numeroGanador <= 12 && opcionApuesta == 3) {
                premio = apuesta * 3;
            }
            break;
        case 4: // Docena 13-24
            if (numeroGanador >= 13 && numeroGanador <= 24 && opcionApuesta == 4) {
                premio = apuesta * 3;
            }
            break;
        case 5: // Docena 25-36
            if (numeroGanador >= 25 && numeroGanador <= 36 && opcionApuesta == 5) {
                premio = apuesta * 3;
            }
            break;
        case 6: // Número exacto
            if (numeroGanador == numero) {
                premio = apuesta * 36;
            }
            break;
        default:
            break;
    }

    return premio;
}

void jugarRuleta(int dinero) {
    int apuesta, opcion, opcionApuesta = 0, numero = 0; 
    int numeroGanador;

    srand(time(NULL));

    while (dinero > 0) {
        printf("\nDinero actual: %d\n", dinero);
        printf("Introduce tu apuesta (0 para salir): ");
        scanf("%d", &apuesta);
        

        if (apuesta == 0) {
            printf("Gracias por jugar. ¡Hasta luego!\n");
            return;
        }

        if (apuesta > dinero) {
            printf("No tienes suficiente dinero para realizar esa apuesta. Introduce una apuesta menor.\n");
            continue;
        }

        printf("Elige tu apuesta:\n");
        printf("1. Par (apuesta x2)\n");
        printf("2. Impar (apuesta x2)\n");
        printf("3. Docena (1-12)(apuesta x3)\n");
        printf("4. Docena (13-24)(apuesta x3)\n");
        printf("5. Docena (25-36)(apuesta x3)\n");
        printf("6. Número en concreto (1-36)(apuesta x36)\n");
        scanf("%d", &opcion);

        if (opcion < 1 || opcion > 6) {
            printf("Opción no válida. Inténtalo de nuevo.\n");
            continue;
        }

        if (opcion == 6) {
            printf("Elige un número (1-36): ");
            scanf("%d", &numero); // Almacenar la apuesta de número concreto en otra variable
            if (numero < 1 || numero > 36) {
                printf("Número no válido . Inténtalo de nuevo.\n");
                continue;
            }
        }

        numeroGanador = rand() % 37;
        printf("El número ganador es: %d\n", numeroGanador);
        if (numeroGanador == 0){
            printf("Gana la banca!\n");
            dinero -= apuesta;
            break;
        }

        int premio = calcularPremio(apuesta, opcion, numeroGanador, opcion, numero);
        if (premio > 0) {
            dinero += premio;
            printf("¡Has ganado! Tu premio es: %d\n", premio);
        } else {
            printf("Lo siento, no has acertado. Has perdido tu apuesta.\n");
            dinero -= apuesta; // Restar la apuesta incorrecta
        }
    }

    printf("Te has quedado sin dinero. ¡Gracias por jugar!\n");
}

int main() {
    int dineroInicial = 100; // Dinero inicial del jugador
    jugarRuleta(dineroInicial);
    return 0;
}