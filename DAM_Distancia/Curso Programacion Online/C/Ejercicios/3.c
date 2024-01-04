/*
Programa que aparezcan por pantalla los datos siguientes
"Cangas tiene ___ playas"
"Cangas tiene ___ habitantes"
"Cangas tiene ___ parroquias"
"Estas son las parroquias de cangas: cangas, darbo, hío, aldán y coiro"
La cantidad de playas, habitantes y parroquias debe estar guadado
en 3 variables tipo int
*/

#include <stdio.h>

int main() {
    int playas = 38, habitantes = 26.487, parroquias = 5;
    printf("Cangas tiene %i playas\n",playas);
    printf("Cangas tiene %i habitantes\n", habitantes);
    printf("Cangas tiene %i parroquias\n", parroquias);
    printf("Estas son las parroquias de cangas: Cangas, Darbo, Hio, Aldan y Coiro");

    return 0;
}