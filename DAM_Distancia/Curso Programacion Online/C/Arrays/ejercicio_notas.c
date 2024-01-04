#include <stdio.h>

void clearBuffer() {
    int c;
    while ((c = getchar()) != '\n' && c != EOF) { }
}

int main(){
    float notas[5][3];  
    float promedioNotas, promedioIngles, promedioTotal;
    int numUsuario, opcion;
    int numAlumnos =sizeof(notas)/sizeof(notas[0]);
    int numNotas =sizeof(notas[0])/sizeof(notas[0][0]);
     //printf("%i\n",numNotas);//imprimo estos valores para verificar que son correctos
     //printf("%i\n",numAlumnos);
    printf("Asignaturas para referencia:\n");
    printf("1- Ingles\n");
    printf("2- Matematicas\n");
    printf("3- Fisica\n");
    for (int i = 0; i < numAlumnos; i++) {
        printf("Alumno %d:\n", i + 1);
        for (int j = 0; j < numNotas; j++) {
            printf("Introduce la nota %d: ", j + 1);
            scanf(" %f", &notas[i][j]);
            clearBuffer();
        }
    }
    
    do{
        printf("Menu\n");
        printf("1.-Notas del alumno numero 1\n");
        printf("2.-Promedio del alumno\n");
        printf("3.-Promedio de notas de ingles\n");
        printf("4.-Promedio de notas de los alumnos\n");
        printf("5.-Salir\n");
        scanf(" %i",&opcion);
        clearBuffer(); 
        switch(opcion){
            case 1:
                for (int i = 0; i< numNotas; i++){
                    printf("%.2f\n",notas[0][i]);
                }
                break;
            case 2:
                promedioNotas = 0;
                for (int i = 0; i< numNotas; i++){
                    promedioNotas += notas[0][i];
                }
                promedioNotas = promedioNotas/(numNotas+1);
                printf("El promedio de las notas del alumno 1 es de %.2f\n", promedioNotas);
                break;
            case 3:
                promedioIngles = 0;
                for (int i = 0; i< numAlumnos; i++){
                    promedioIngles += notas[i][0];
                }
                promedioIngles = promedioIngles/(numAlumnos+1);
                printf("El promedio de las notas de ingles es de %.2f\n", promedioIngles);
                break;
            
            case 4:
                promedioTotal = 0;
                for (int i = 0; i < numAlumnos; i++) {
                    promedioNotas = 0;
                    for (int j = 0; j < numNotas; j++) {
                        promedioNotas += notas[i][j];
                    }
                    promedioTotal += promedioNotas / numNotas; 
                }
                promedioTotal = promedioTotal / numAlumnos;
                printf("El promedio de notas de todos los alumnos es de %.2f\n", promedioTotal);
                break;
            case 5: 
                printf("Saliendo...");
                break;
            default:
                break;
        }
    }while (opcion!= 5);
    return 0;
}