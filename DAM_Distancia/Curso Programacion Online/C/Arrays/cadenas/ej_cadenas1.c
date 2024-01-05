/*
Ejercicios basicos de cadenas
*/

/*
1.- Pide el nombre por teclado y muestralo por pantalla
*/
#include <stdio.h>                
#include <string.h>

int main() {                                
    char nombre[100];
    int tamNombre = sizeof(nombre)/sizeof(nombre[0]);
                                               
    printf("Ingrese su nombre: ");
    fgets(nombre, tamNombre, stdin);

    printf("Tu nombre es: ");
    printf("%s\n", nombre);

    return 0;
}

/*
2.- Introduce tu ciudad y copiar el contenido en otra variables
*/

#include <stdio.h>
#include <string.h>

int main() {
    char ciudad1[100];
    char ciudad2[100];

    printf("Introduce tu ciudad: ");
    fgets(ciudad1, sizeof(ciudad1), stdin);

    strcpy(ciudad2, ciudad1);

    printf("La ciudad introducida es: %s", ciudad1);
    printf("Y la ciudad copiada es: %s", ciudad2);

    return 0;
}

/*
3.- Pide o teu nome por teclado e mostra a lonxitude que ten dito nome.
*/

#include <stdio.h>
#include <string.h>

int main() {                                
    char nombre[100];
    int tamNombre = sizeof(nombre)/sizeof(nombre[0]);
                                               
    printf("Ingrese su nombre: ");
    fgets(nombre, tamNombre, stdin);

    printf("Tu nombre tiene una longitud de: ");
    printf("%li\n", strlen(nombre)-1);

    return 0;
}

/*
4.- Pide duas cidades por teclado e di cal é a maior.
*/

#include <stdio.h>
#include <string.h>

int main() {
    char ciudad1[100];
    char ciudad2[100];
    int tamCiud1 = sizeof(ciudad1)/sizeof(ciudad1[0]);
    int tamCiud2 = sizeof(ciudad2)/sizeof(ciudad2[0]);

    printf("Introduce tu ciudad: ");
    fgets(ciudad1, sizeof(ciudad1), stdin);
    printf("Introduce otra ciudad ciudad: ");
    fgets(ciudad1, sizeof(ciudad1), stdin);

    if (strlen(ciudad1) > strlen(ciudad2)){
        printf(" %s es mayor que %s\n",ciudad1,ciudad2);
    }else 
        printf(" %s es mayor que %s\n",ciudad2,ciudad1);

    return 0;
}

/*
5.- Pide o teu nome por teclado, o primeiro apelido e tamén o segundo apelido. 
Cada dato en cadavariable distinta, une as tres nunha cuarta variable
que se chame Nome_completo e móstraa por pantalla.
*/

#include <stdio.h>
#include <string.h>
int main(){
    char nombre[100], apellido1[100], apellido2[100], nombre_completo [300];
    int tamNombre = sizeof(nombre)-1, tamAp1 = sizeof(apellido1)-1, tamAp2 = sizeof(apellido2)-1;
    printf("Inserte el nombre: \n");
    fgets(nombre,tamNombre,stdin);
    nombre[strcspn(nombre, "\n")] = '\0';
    
    printf("Inserte el primeir apellido:\n");
    fgets(apellido1,tamAp1,stdin);
    apellido1[strcspn(apellido1, "\n")] = '\0';

    printf("Inserte el segundo apellido:\n");
    fgets(apellido2,tamAp2,stdin);
    apellido2[strcspn(apellido2, "\n")] = '\0';

    strcpy(nombre_completo, nombre);
    strcat(nombre_completo, apellido1);
    strcat(nombre_completo, apellido2);

    printf("Tu nombre completo es: ");
    printf("%s",nombre_completo);
}

/*
6.- Pide un refrán por teclado e móstrao en maiúsculas todo. (Lembra usar fgets en lugar de scanf para que colla os espacios en blanco).
*/

#include <stdio.h>                

int main() {                                
    char frase[500];
    int tamFrase = sizeof(frase)/sizeof(frase[0]);
                                               
    printf("Ingrese un refran: ");
    fgets(frase, tamFrase, stdin);
    for (int i = 0; i < tamFrase; i++){
        if (frase[i] >= 'a' && frase[i] <= 'z') {
            frase[i] = frase[i] - 'a' + 'A';
        }
    }

    printf("El refran en mayusculas es: ");
    printf("%s\n", frase);

    return 0;
}

/*
7. Pedir por teclado unha frase e cun menú que faga o seguinte:
    • Pasalo a maiúsculas.
    • Pasalo a minúsculas.
    • Qué lonxitude ten.
*/

#include <stdio.h>
#include <string.h>


int main() {                                
    char frase[500];
                                               
    printf("Ingrese una frase: ");
    fgets(frase, sizeof(frase), stdin);

    int tamFrase = strlen(frase)-1, opcion;
    do{
        printf("Selecciona una de las siguiente opciones\n");
        printf("1.- Pasar a mayusculas\n");
        printf("2.- Pasar a minusculas\n");
        printf("3.- Obtener la longitud\n");
        printf("4.- Salir\n");
        scanf(" %i",&opcion);

        switch (opcion){
        case 1:
            for (int i = 0; i < tamFrase; i++){
                if (frase[i] >= 'a' && frase[i] <= 'z') {
                    frase[i] = frase[i] - 'a' + 'A';
                }
            }
            printf("La frase en mayusculas es: ");
            printf("%s\n", frase);
            break;

        case 2:
            for (int i = 0; i < tamFrase; i++){
                if (frase[i] >= 'A' && frase[i] <= 'Z') {
                    frase[i] = frase[i] - 'A' + 'a';
                }
            }
            printf("La frase en minusculas es: ");
            printf("%s\n", frase);
            break;

        case 3:
            printf("La longitud de la frase es: ");
            printf("%i\n", tamFrase);
            break;
        
        default:
            printf("Introduce una opcion valida...\n");
            break;
        }
    }while (opcion != 4);

    return 0;
}

/*
8.-Escribir un programa que solicite dos cadeas que puede contener espacios, el programa deberá:
    • Decir qué cadena es mayor y cuál es menor alfabéticamente
    • Generar una nueva cadena que será la primera cadena leída, con las vocales convertidas
        a MAYÚSCULAS
    • Generar una nueva cadena que será la segunda cadena leída, con las consonantes
        convertidas a MAYÚSCULAS
    • Generar una nueva cadena concatenando las dos que ya fueron convertidas
    • Generar una nueva cadena que contenga la cadena concatenada invertida

Al finalizar el programa, este deberá:
    • Imprimir las dos cadenas originales
    • Imprimir las dos cadenas con las conversiones
    • Imprimir la cadena concatenada
    • Imprimir la cadena concatenada invertida
*/

#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main(){
    char cadena1[100], cadena2[100], cad1[100], cad2[100], nuevaCad[200], invertida[200];

    printf("Ingrese una frase: ");
    fgets(cadena1, sizeof(cadena1), stdin);
    cadena1[strcspn(cadena1, "\n")] = '\0';
    strcpy(cad1, cadena1);

    printf("Ingrese otra frase: ");
    fgets(cadena2, sizeof(cadena2), stdin);
    cadena2[strcspn(cadena2, "\n")] = '\0';
    strcpy(cad2, cadena2);

    int tamCad1 = strlen (cadena1)-1, tamCad2 = strlen (cadena2)-1;
    int resComparacion = strcmp (cadena1, cadena2);

    if (resComparacion == 0){
        printf ("Las cadenas son iguales.\n");
    }else if (resComparacion < 0){
        printf ("La cadena %s es menor que %s.\n", cadena1, cadena2);
    }else if (resComparacion > 0){
        printf ("La cadena %s es menor que %s.\n", cadena2, cadena1);
    } 
    //vocales a minus
    for (int i = 0; i < strlen(cad1); i++) {
        if (tolower(cad1[i]) == 'a' || tolower(cad1[i]) == 'e' 
        || tolower(cad1[i]) == 'i' || tolower(cad1[i]) == 'o' 
        || tolower(cad1[i]) == 'u') {
            cad1[i] = toupper(cad1[i]);
        }
    }

    //consonantes a mayus
    for (int i = 0; i < strlen(cad2); i++) {
        if (tolower(cad2[i]) != 'a' && tolower(cad2[i]) != 'e' 
        && tolower(cad2[i]) != 'i' && tolower(cad2[i]) != 'o' 
        && tolower(cad2[i]) != 'u') {
            cad2[i] = toupper(cad2[i]);
        }
    }

    //concatenada
    strcpy(nuevaCad, cad1);
    strcat(nuevaCad, cad2);

    //contatenada invertida
    strcpy(invertida, nuevaCad);
    for (int i = 0; i < strlen(invertida) / 2; i++) {
        char temp = invertida[i];
        invertida[i] = invertida[strlen(invertida) - i - 1];
        invertida[strlen(invertida) - i - 1] = temp;
    }
    
    
    printf("La primera cadena convertida es: %s\n", cad1);
    printf("La segunda cadena convertida es: %s\n", cad2);
    printf("La cadena concatenada es: %s\n", nuevaCad);
    printf("La cadena concatenada invertida es: %s\n", invertida);
}