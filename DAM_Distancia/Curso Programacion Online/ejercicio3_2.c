#include <stdio.h>
#include <math.h>
//#define _USE_MATH_DEFINES

void notasExamen();
void sumaMultiplicacion();
void mediaExamenes();
void perimetroCircunferencia();
void perimetroFiguras();
void numeroAnterior();
void llamada();
void horas();
void azucar();
void variables1();
void variables2();
void clearInputBuffer();

int main() {
    int opcionMenu;
    char input[100];

    do {
        printf("Introduce un numero de ejercicio (0 para salir): ");
        printf("\n1.- Notas de Examen");
        printf("\n2.- Suma y multiplicacion");
        printf("\n3.- Media 5 examenes");
        printf("\n4.- Perimetro de circunferencia");
        printf("\n5.- Area y perimetro de figuras");
        printf("\n6.- Numero anterior y posterior al numero dado");
        printf("\n7.- Coste llamada telefonica");
        printf("\n8.- Numero de segundos en x horas");
        printf("\n9.- Kilos de azucar y cafe");
        printf("\n10.- Variables v1, v2 y v3");
        printf("\n11.- Variables a, b y c");
        printf("\n0.- Salir programa\n");


        //Busqué por internet, evita un bucle infinito en el menú
        fgets(input, sizeof(input), stdin);
        if (sscanf(input, "%i", &opcionMenu) != 1) {
            printf("Error al leer la opcion. Introduce un numero valido.\n");
            opcionMenu = -1;
            clearInputBuffer(); // Limpiar el búfer si la entrada es inválida
            continue;
        }

        switch (opcionMenu) {
            case 1:
                notasExamen();
                break;
            case 2:
                sumaMultiplicacion();
                break;
            case 3:
                mediaExamenes();
                break;
            case 4:
                perimetroCircunferencia();
                break;
            case 5:
                perimetroFiguras();
                break;
            case 6:
                numeroAnterior();
                break;
            case 7:
                llamada();
                break;
            case 8:
                horas();
                break;
            case 9:
                azucar();
                break;
            case 10:
                variables1();
                break;
            case 11:
                variables2();
                break;
            case 0:
                printf("Saliendo del programa...\n");
                break;
            default:
                printf("Opcion invalida. Introduce un numero del 0 al 11.\n");
        }
        printf("\nPresiona Enter para continuar...");
        while (getchar() != '\n');
    } while (opcionMenu != 0);

    return 0;
}

void notasExamen(){
    float nota1, nota2, nota3;
    printf("Introduce 3 notas de examen: \n");
    printf("Introduce la primera nota: ");
    scanf(" %f",&nota1);
    clearInputBuffer();
    printf("Introduce la segunda nota: ");
    scanf(" %f",&nota2);
    clearInputBuffer();
    printf("Introduce la tercera nota: ");
    scanf(" %f",&nota3);
    clearInputBuffer();

    float notaMedia = ((nota1 + nota2 + nota3)/3);
    printf("La nota media es: %.2f\n",notaMedia);
}

void sumaMultiplicacion(){
    int num1, num2;
    printf("Introduce 2 numeros: \n");
    printf("Introduce el primer numero: ");
    scanf(" %i",&num1);
    clearInputBuffer();
    printf("Introduce el segundo numero: ");
    scanf(" %i",&num2);
    clearInputBuffer();

    int suma = num1 + num2;
    int mult = num1 * num2;
    printf("La suma de %i + %i es:  %i\n",num1, num2, suma);
    printf("La multiplicacion de %i x %i es:  %i\n",num1, num2, mult);
}

void mediaExamenes(){
    float nota1, nota2, nota3, nota4, nota5;
    printf("Introduce 5 notas de examen: \n");
    printf("Introduce la primera nota: ");
    scanf(" %f",&nota1);
    clearInputBuffer();
    printf("Introduce la segunda nota: ");
    scanf(" %f",&nota2);
    clearInputBuffer();
    printf("Introduce la tercera nota: ");
    scanf(" %f",&nota3);
    clearInputBuffer();
    printf("Introduce la cuarta nota: ");
    scanf(" %f",&nota4);
    clearInputBuffer();
    printf("Introduce la quinta nota: ");
    scanf(" %f",&nota5);
    clearInputBuffer();

    float notaMedia = (nota1 + nota2 + nota3 + nota4 + nota5)/5;
    printf("La nota media es: %.2f\n",notaMedia);
}

void perimetroCircunferencia(){
    //#define PI 3.1416
    float radioCirculo;
    printf("Introduce el radio de un circulo: \n");
    scanf(" %f",&radioCirculo);
    clearInputBuffer();
    float perimetroCirculo = 2 * M_PI * radioCirculo;
    printf("El valor del perimetro es: %.2f\n",perimetroCirculo);
}

void perimetroFiguras(){
    float ladoCuadrado, ladoTri, ladoTri2, ladoTri3, ladoRect, alturaRect;
    printf("Introduce los lados de las distintas figuras: \n");
    printf("Introduce lado del cuadrado: ");
    scanf(" %f",&ladoCuadrado);
    clearInputBuffer();
    printf("Introduce lado 1 del triangulo: ");
    scanf(" %f",&ladoTri);
    clearInputBuffer();
    printf("Introduce lado 2 del triangulo: ");
    scanf(" %f",&ladoTri2);
    clearInputBuffer();
    printf("Introduce lado 3 del triangulo: ");
    scanf(" %f",&ladoTri3);
    clearInputBuffer();
    printf("Introduce lado rectangulo: ");
    scanf(" %f",&ladoRect);
    clearInputBuffer();
    printf("Introduce altura del rectangulo: ");
    scanf(" %f",&alturaRect);
    clearInputBuffer();
    float perimCuad = ladoCuadrado * 4;
    float perimTri = ladoTri + ladoTri2 + ladoTri3;
    float perimRect = (ladoRect * 2) + (alturaRect * 2);
    float areaCuadrado = ladoCuadrado * ladoCuadrado;
    float S = (ladoTri + ladoTri2 + ladoTri3)/2;
    float areaTri =  sqrt((S)*(S-ladoTri)*(S-ladoTri2)*(S-ladoTri3));
    float areaRectangulo = ladoRect * alturaRect;

    printf("El perimeto del cuadrado de lado %.0f es: %.0f\n",ladoCuadrado,perimCuad); 
    printf("El perimeto del triangulo de lados %.0f, %.0f y %.0f es: %.0f\n",ladoTri, ladoTri2,ladoTri3, perimTri); 
    printf("El perimeto del rectangulo de lado %.0f y altura %.0f es: %.2f\n",ladoRect, alturaRect, perimRect);
    printf("El area del cuadrado de lado %.0f es: %.0f\n",ladoCuadrado,areaCuadrado); 
    printf("El area del triangulo de lados %.0f, %.0f y %.0f es: %.2f\n",ladoTri, ladoTri2,ladoTri3, areaTri);
    printf("El area del rectangulo de lado %.0f y altura %.0f es: %.2f\n",ladoRect, alturaRect, areaRectangulo);  
}

void numeroAnterior(){
    int numUsuario;
    printf("Introduce un numero: \n");
    scanf(" %i", &numUsuario);
    clearInputBuffer();
    int numAntes = numUsuario -1;
    int numDespues = numUsuario +1;
    printf("Tu numero es: %i, el numero anterior es: %i y el siguiente es %i\n", numUsuario, numAntes, numDespues);
}

void llamada(){
    float duracionLlamada;
    float costeMinuto = 5.56; //valor medio segun google
    printf("Introduce la duracion de la llamada (en minutos): \n");
    scanf(" %f", &duracionLlamada);
    clearInputBuffer();

    float costeLlamada = duracionLlamada * costeMinuto;
    printf("Su llamada ha durado %.0f minutos a un coste de %.2feuros\n",duracionLlamada, costeMinuto);
    printf("Lo que hace un coste total de %.2feuros\n",costeLlamada);
}

void horas(){
    int horas;
    printf("Introduce una cantidad de horas: ");
    scanf(" %i", &horas);
    clearInputBuffer();

    int segundos = horas * 3600;
    printf("%i horas son %isegundos\n",horas, segundos);
}

void azucar(){
    float cantidadEuros, cantidadAzucar, cantidadCafe, sobrante;
    float precioAzucar = 0.6;
    float precioCafe = 0.72;

    printf("Introduce una cantidad en euros: ");
    scanf(" %f", &cantidadEuros);
    clearInputBuffer();

    cantidadAzucar = cantidadEuros / 2 / precioAzucar; 
    cantidadCafe = cantidadEuros / 3 / precioCafe;

    sobrante = cantidadEuros - ((cantidadEuros / 2) + (cantidadEuros / 3));

    printf("Con %.2f euros puedes comprar:\n", cantidadEuros);
    printf("Azucar: %.2f kilos\n", cantidadAzucar);
    printf("Cafe: %.2f kilos\n", cantidadCafe);
    printf("Dinero sobrante: %.2f euros\n", sobrante);
}

void variables1(){
    int v1, v2, v3, temp;

    printf("Introduce tres numeros enteros: \n");
    printf("Introduce el primer numero: ");
    scanf(" %i",&v1);
    clearInputBuffer();
    printf("Introduce el segundo numero: ");
    scanf(" %i",&v2);
    clearInputBuffer();
    printf("Introduce el tercer numero: ");
    scanf(" %i",&v3);
    clearInputBuffer();

    temp = v1;
    v1 = v2;
    v2 = v3;
    v3 = temp;

    printf("Valores intercambiados:\n");
    printf("v1 = %i\nv2 = %i\nv3 = %i\n", v1, v2, v3);
}

void variables2(){
    int a, b, c, temp;

    printf("Introduce tres numeros enteros: \n");
    printf("Introduce el primer numero: ");
    scanf(" %i",&a);
    clearInputBuffer();
    printf("Introduce el segundo numero: ");
    scanf(" %i",&b);
    clearInputBuffer();
    printf("Introduce el tercer numero: ");
    scanf(" %i",&c);
    clearInputBuffer();

    temp = a;
    a = 2 * c;
    b = temp + c;
    c = 3 * (b-c);

    printf("Valores intercambiados:\n");
    printf("a = %i\nb = %i\nc = %i\n", a, b, c);
}

//Metodo para limpiar el buffer cada vez que lo llamo
void clearInputBuffer() {
    int c;
    while ((c = getchar()) != '\n' && c != EOF) { }
}