#include <stdio.h>
#include <math.h>

void ej1();
void ej2();
void ej3();
void ej4();
void clearInputBuffer();

int main() {

    int ejercicio;

    printf("Introduce el numero de ejercicio a ejecutar (1, 2, 3 o 4) \n");
    printf("1.- Introducir peso, altura y edad.\n");
    printf("2.- Introducir peso, altura y edad y calculo de IMC.\n");
    printf("3.- Introducir marca de vehiculo.\n");
    printf("4.- Introducir marca y modelo de vehiculo.\n");
    printf("5.- Salir. \n");
    scanf(" %i",&ejercicio);
    clearInputBuffer();
    do{
        switch (ejercicio){
            case 1: 
                ej1();
                break;
            case 2: 
                ej2();
                break;
            case 3: 
                ej3();
                break;
            case 4: 
                ej4();
                break;
            case 5:
                printf("saliendo del programa... \n");
                break;
            default:
                printf("Introduce un numero de ejercicio correcto... \n");
                break;
        }
    } while (ejercicio != 5);

    return 0;
}

void ej1(){
    float peso, edad, altura;

    printf("Intruduce tu peso (en Kg): \n");
    scanf(" %f",&peso);
    clearInputBuffer();
    printf("Intruduce tu edad: \n");
    scanf(" %f",&edad);
    clearInputBuffer();
    printf("Intruduce tu altura (en m): \n");
    scanf(" %f",&altura);
    clearInputBuffer();

    printf("Tu peso es de %.2f, tu altura es de %.2f y tienes %.0f años.\n", peso, altura, edad);
}


void ej2(){
    float peso, edad, altura, imc;

    printf("Intruduce tu peso (en Kg): \n");
    scanf(" %f",&peso);
    clearInputBuffer();
    printf("Intruduce tu edad: \n");
    scanf(" %f",&edad);
    clearInputBuffer();
    printf("Intruduce tu altura (en m): \n");
    scanf(" %f",&altura);
    clearInputBuffer();

    printf("Tu peso es de %.2fKg, tu altura es de %.2fm y tienes %.0f años.\n", peso, altura, edad);

    imc = peso/(pow(altura/100, 2));

    if (imc < 18.5){
        printf("Bajo peso, deberias ganar algo de peso.\n");
    }else if (imc >= 18.5 && imc < 24.9){
        printf("Peso normal.\n");
    }else if (imc >= 24.9 && imc < 29.9){
        printf("Sobrepeso, deberias bajar algo de peso.\n");
    }else if (imc >= 29.9){
        printf("Obesidad, deberias bajar mucho de peso.\n");
    }
}

void ej3(){
    int opcionMenu;
    printf("PROGRAMA DE VEHICULOS \n");
    printf("ESCOGE LA MARCA QUE QUIERAS MIRAR\n");
    printf("1.- Peugeot\n");
    printf("2.- Seat\n");
    printf("3.- Citroen\n");
    printf("4.- Toyota\n");
    printf("5.- Hyundai \n");
    scanf(" %i",&opcionMenu);
    clearInputBuffer();

    switch (opcionMenu) {
        case 1:
            printf("Peugeot es una marca francesa de automóviles conocida por su diseño innovador y su larga historia en la fabricación de vehículos.\n");
            break;
        case 2:
            printf("SEAT es una reconocida marca española de automóviles que destaca por su diseño moderno y su enfoque en la producción de vehículos con estilo y rendimiento.\n");
            break;
        case 3:
            printf("Citroën es una marca francesa de automóviles reconocida por su enfoque vanguardista en diseño, innovación tecnológica y comodidad, destacándose por vehículos con estilo distintivo y soluciones creativas en la industria automotriz.\n");
            break;
        case 4:
            printf("Toyota es una destacada marca japonesa de automóviles conocida por su fiabilidad, calidad y liderazgo en tecnología híbrida, ofreciendo una amplia gama de vehículos que combinan eficiencia, innovación y durabilidad.\n");
            break;
        case 5:
            printf("Hyundai es una marca surcoreana de automóviles reconocida por su excelente relación calidad-precio, diseño atractivo, y enfoque en tecnología y seguridad, ofreciendo una amplia gama de vehículos con alto valor y rendimiento.\n");
            break;
        default:
            printf("Introduce un numero correcto...\n");
            break;
    }
            
}

void ej4(){
    int opcionMenu, opcionSubmenu;
    printf("PROGRAMA DE VEHICULOS \n");
    printf("ESCOGE LA MARCA QUE QUIERAS MIRAR\n");
    printf("1.- Peugeot\n");
    printf("2.- Seat\n");
    printf("3.- Citroen\n");
    printf("4.- Toyota\n");
    printf("5.- Hyundai \n");
    scanf(" %i",&opcionMenu);
    clearInputBuffer();

    switch (opcionMenu) {
        case 1:
            printf("Escoge un submodelo:\n");
            printf("1.- 208\n");
            printf("2.- 308\n");
            scanf(" %i",&opcionSubmenu);
            clearInputBuffer();
            if (opcionSubmenu == 1){
                printf("El Peugeot 208: Compacto, moderno y eficiente.\n");
            }else if (opcionSubmenu == 2){
                printf("El Peugeot 308: Elegante, versátil y sofisticado.\n");
            }else{
                printf("Introduce una opcion valida...\n");
            }
            break;
        case 2:
            printf("Escoge un submodelo:\n");
            printf("1.- Ibiza\n");
            printf("2.- Leon\n");
            scanf(" %i",&opcionSubmenu);
            clearInputBuffer();
            if (opcionSubmenu == 1){
                printf("El SEAT Ibiza: Dinámico, compacto y versátil.\n");
            }else if (opcionSubmenu == 2){
                printf("El SEAT León: Deportivo, ágil y refinado.\n");
            }else{
                printf("Introduce una opcion valida...\n");
            }
            break;
        case 3:
            printf("Escoge un submodelo:\n");
            printf("1.- c3\n");
            printf("2.- AMI\n");
            scanf(" %i",&opcionSubmenu);
            clearInputBuffer();
            if (opcionSubmenu == 1){
                printf("El Citroën C3: Estilizado, urbano y distintivo.\n");    
            }else if (opcionSubmenu == 2){
                printf("El Citroën AMI: Pequeño, eléctrico y urbano.\n");
            }else{
                printf("Introduce una opcion valida...\n");
            }
            break;
        case 4:
            printf("Escoge un submodelo:\n");
            printf("1.- Cruiser\n");
            printf("2.- Yaris\n");
            scanf(" %i",&opcionSubmenu);
            clearInputBuffer();
            if (opcionSubmenu == 1){
                printf("El Toyota Land Cruiser: Todoterreno robusto y versátil.\n");
            }else if (opcionSubmenu == 2){
                printf("El Toyota Yaris: Compacto, ágil y eficiente.\n");
            }else{
                printf("Introduce una opcion valida...\n");
            }
            break;
        case 5:
            printf("Escoge un submodelo: \n");
            printf("1.- i30\n");
            printf("2.- santafe\n");
            scanf(" %i",&opcionSubmenu);
            clearInputBuffer();
            if (opcionSubmenu == 1){
                printf("El Hyundai i30: Versátil, moderno y dinámico.\n");
            }else if (opcionSubmenu == 2){
                printf("El Hyundai Santa Fe: Espacioso, versátil y potente.\n");
            }else{
                printf("Introduce una opcion valida...\n");
            }
            break;
        default:
            printf("Introduce un numero correcto...\n");
            break;
    }
            
}

//Metodo para limpiar el buffer cada vez que lo llamo
void clearInputBuffer() {
    int c;
    while ((c = getchar()) != '\n' && c != EOF) { }
}