#include <stdio.h>
#include <stdbool.h>
#include <time.h>

char tablero[3][3]; // Tablero 3x3 para el juego

// Función para inicializar el tablero
void inicializarTablero() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            tablero[i][j] = '-';
        }
    }
}

// Función para imprimir el tablero
void imprimirTablero() {
    printf("\nTablero actual:\n");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%c ", tablero[i][j]);
        }
        printf("\n");
    }
}

// Función para verificar la victoria
int verificarVictoria(char jugador) {
    // Verificar filas y columnas
    for (int i = 0; i < 3; i++) {
        if ((tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) ||
            (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)) {
            return 1; // Victoria en fila o columna
        }
    }
    // Verificar diagonales
    if ((tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) ||
        (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador)) {
        return 1; // Victoria en diagonal
    }
    return 0; // No hay victoria
}

int main() {
    int fila, columna;
    char jugador = 'X';
    inicializarTablero();
    srand(time(NULL));
    
    while (true) {
        imprimirTablero();
        printf("Jugador %c, introduce coordenadas (0-2) fila y (0-2) columna:\n", jugador);
        if (scanf("%d %d", &fila, &columna) != 2 || fila < 0 || fila > 2 || columna < 0 || columna > 2) {
            printf("Coordenadas no válidas, vuelve a intentarlo...\n");
            continue; //buscado en google, vuelve al inicio del bucle si no se cumple
        }
        
        if (tablero[fila][columna] != '-') {
            printf("Esta casilla ya está ocupada, vuelve a intentarlo...\n");
            continue;
        }
        
        tablero[fila][columna] = jugador;
        
        if (verificarVictoria(jugador)) {
            printf("¡Felicidades! El jugador %c ha ganado.\n", jugador);
            break;
        } else {
            if (jugador == 'X') {
                jugador = 'O';
            } else {
                jugador = 'X';
            }
        }
    }
    
    return 0;
}