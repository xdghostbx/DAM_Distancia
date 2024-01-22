/*
 *    4 playas, preguntar a 3 personas cuanto puntuan por esa playa (5, 10 o 20)
 *      -puntuacion total por persona y final de las playas
 *      -la playa ganadora, llama a una funcion con su propio nombre con la descripcion
*/

#include <stdio.h>
#include <string.h>
//inicializamos arrays, variables y funciones
int playas[4][3], votos[4], puntos, cierto = 0;
char nombre [4][100];
void pregunta(), calculos(), comparar(), vilar(), coroso(), touro(), azor();

int main() {
    //ponemos el nombre de las playas en su posicion del array mediante strcpy (para no inicializarlo a mano)
    strcpy(nombre[0], "Vilar");
    strcpy(nombre[1], "Coroso");
    strcpy(nombre[2], "Touro");
    strcpy(nombre[3], "Azor");

    //llamamos a las funciones
    pregunta();
    calculos(); 
    comparar();
    return 0;
}

/*
 * funcion que recorre el programa mediante 2 bucles for (pasa por numero de persona, nombre de playa) y 
 * verifica que la puntuacion que le damos sea 0, 5, 10 o 20 y guarda esa puntuacion en su lugar correspondiente
 */
void pregunta(){
    printf("Cual es tu playa favorita? Vamos a votar (0, 5, 10 o 20 puntos):\n");
    for (int persona = 0; persona < 3; persona ++){
        printf("Turno de la persona num %i:\n", persona+1);
        for (int i = 0; i<4; i++){
            cierto = 0;
            while (cierto == 0){
                printf("Cuantos puntos le das a la playa de %s?\n", nombre[i]);
                scanf("%d", &puntos);
                if (puntos != 0 && puntos != 5 && puntos != 10 && puntos != 20){
                    printf("Puntos no validos... Vuelve a intentarlo\n");
                    continue;
                }else
                    playas[i][persona] = puntos; cierto = 1;
            }
            
        }
    } 
}

/*
 * Funcion que realiza los calculos de los votos y los guarda en un array de 4 posiciones, cada
 * posicion es una de las playas
 */
void calculos(){
    for (int i = 0; i < 4; i++){
        for (int j = 0; j<3; j++){
            votos[i] += playas[i][j];
        }
    }
}

/*
 * Funcion que compara cual es la posicion mayor segun los votos que tenga en la posicion
 * del array. Cuando detecta cual es el mayor, llama a la funcion con el nombre de la 
 * playa para mostrar su info 
 */
void comparar(){
    if(votos[0] > votos[1] && votos[0] > votos[2] && votos[0] > votos[3]){
        printf("La mayor puntuacion es %s con %d votos\n",nombre[0], votos[0]);
        vilar();
    }else if(votos[1] > votos[0] && votos[1] > votos[2] && votos[1] > votos[3]){
        printf("La mayor puntuacion es %s con %d votos\n",nombre[1], votos[1]);
        coroso();
    }else if(votos[2] > votos[0] && votos[2] > votos[1] && votos[2] > votos[3]){
        printf("La mayor puntuacion es %s con %d votos\n",nombre[2], votos[2]);
        touro();
    }else if(votos[3] > votos[0] && votos[3] > votos[1] && votos[3] > votos[2]){
        printf("La mayor puntuacion es %s con %d votos\n",nombre[3], votos[3]);
        azor();
    }else{
        printf("No se puede determinar la mayor puntuacion entre los 4 valores.\n");
    }
}

//Funciones de las playas individuales, con su informacion
void vilar(){
    printf("Informacion de la playa de Vilar\nblablabla");
}
void coroso(){
    printf("Informacion de la playa de Coroso\nblablabla");
}
void touro(){
    printf("Informacion de la playa de Touro\nblablabla");
}
void azor(){
    printf("Informacion de la playa de Azor\nblablabla");
}