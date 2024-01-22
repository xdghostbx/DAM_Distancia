/*
    Estructura llamada familiares. El programa debe:
        -Añadir datos (nombre, apellido, numero de telefono, direccion, parentesco)
        -Ver datos
        -Salir del programa
*/

#include <stdio.h>

struct familia {
    char nombre[50];
    char apellido[100];
    int telefono;
    char direccion[256];
    char parentesco[30];
};

int main(){
    struct familia miFamilia[50] = {{NULL}};
    int opcion;
    do{
        printf("Selecciona una opcion de las siguientes:\n");
        printf("\n1. Añadir nuevo familiar\n2. Ver los datos de
        familiares\n3. Salir del programa\n");
        scanf("%d", &opcion);
        switch(opcion){
            case 1: //Añadir un familiar
                break;
            case 2: //ver familiares guardados
                break;
            case 3:
                printf("Saliendo...\n");
                break;

    }while(opcion !=4);
     //Inicializamos el
    //array con NULL para que no nos salga basura al imprimirlos
    printf("Introduce los miembros de tu familia:\n");
    for(int i=0;i<4;i++){
        printf("\nMiembro %d\n",i+1);
        fflush(stdin);
        getchar();
        printf("Nombre: ");
        setbuf(stdin,NULL);
        scanf("%[^\n]%*c",miFamilia[i].nombre
        );//Leo la cadena hasta \n
        printf("Apellido: ");
        scanf("%s",&miFamilia[i].apellido);
        printf("Numero de teléfono: ");
        scanf("%d",&miFamilia[i].telefono);
        printf("Dirección: ");
        setbuf(stdin,NULL);
        scanf("%[^\n]%*c",miFamilia[i].direccion
        +strlen(miFamilia));//Concateno la dirección anterior y lo que
        //se escribe ahora en una misma variable
        printf("Parentesco: ");
        setbuf(stdin,NULL);
        scanf("%s",&miFamilia[i].parentesco);
        }
        printf("\n\nDatos introducidos correctamente.\n");

}

void nuevoFamiliar(struct familia miembro){
    printf("Introduce el nombre del familiar:\n");
    char nombre[50];
    scanf("%s",miembro.nombre);
    printf("Introduce el apellido del familiar:\n");
    char apellido[50];
    scanf("%s", miembro.apellido);
    printf("Introduce el numero de su telefono:\n");
    int telefono;
    scanf("%d", miembro.telefono);
    printf("Introduce su direccion:\n");
    char direccion[256];
    printf("Calle, Numero y Piso (separados por comas):\n");
    scanf("%[^,],%n", miembro.direccion);
}

void verFamilia (struct familia miFamilia[50]){
    for (int i = 0; i< lenghtOf(miFamilia), i++){
        
    }
}