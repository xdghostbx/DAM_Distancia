#include <stdio.h>
#include <math.h>

void ej1();
void ej2();
void ej3();
void ej4();
void ej5();
void clearInputBuffer();

int main() {

    ej3();

    return 0;
}

void ej1(){
    float v1,v2,mediakm,mediasg;
    printf("escriba la velocidad1:");
    scanf("\n %f",&v1);
    printf("escriba la velocidad2:");
    scanf("\n %f",&v2);
    mediakm=(v1+v2)/2;
    mediasg=mediakm*0.277778;
    printf("la media en km/hora es de %.2f y la media en m/s es de %.2f",mediakm,mediasg);
}

void ej2(){
    int opcionMenu;
    int num1, num2;

    printf("Introduce 2 numeros para realizar los calculos: \n");
    printf("Introduce el primer número: \n");
    scanf(" %i",&num1);
    printf("Introduce el segundo número: \n");
    scanf(" %i",&num2);

    do {
        printf("Introduce una opcion (0 para salir): \n");
        printf("1.- Calcular el resto\n");
        printf("2.- Calcular la suma\n");
        printf("3.- Calcular la resta\n");
        printf("4.- Calcular la multiplicacion\n");
        printf("5.- Calcular la division\n");
        printf("6.- Cambiar numeros \n");
        scanf(" %i",&opcionMenu);

        
        switch (opcionMenu) {
            case 1:
                printf("El modulo de %i y de %i es %i \n", num1, num2, num1%num2);
                break;
            case 2:
                printf("La suma de %i y de %i es %i \n", num1, num2, num1+num2);
                break;
            case 3:
                printf("La resta de %i y de %i es %i \n", num1, num2, num1-num2);
                break;
            case 4:
                printf("La multiplicacion de %i y de %i es %i \n", num1, num2, num1*num2);
                break;
            case 5:
                printf("La division de %i y de %i  es %i \n", num1, num2, num1/num2);
                break;
            case 6:
                printf("Introduce el primer número: \n");
                scanf(" %i",&num1);
                printf("Introduce el segundo número: \n");
                scanf(" %i",&num2);
                break;
            case 0:
                printf("Saliendo del programa...\n");
                break;
            default:
                printf("Opcion invalida. Introduce un numero del 0 al 11.\n");
        }
    } while (opcionMenu != 0);
}

void ej3(){
    
    float ladoCuadrado, ladoTri, ladoTri2, ladoTri3, ladoRect, alturaRect, radioCirculo;;
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
    printf("Introduce el radio de un circulo: \n");
    scanf(" %f",&radioCirculo);
    clearInputBuffer();
    float perimCuad = ladoCuadrado * 4;
    float perimTri = ladoTri + ladoTri2 + ladoTri3;
    float perimRect = (ladoRect * 2) + (alturaRect * 2);
    float areaCuadrado = ladoCuadrado * ladoCuadrado;
    float S = (ladoTri + ladoTri2 + ladoTri3)/2;
    float areaTri =  sqrt((S)*(S-ladoTri)*(S-ladoTri2)*(S-ladoTri3));
    float areaRectangulo = ladoRect * alturaRect;
    float perimetroCirculo = 2 * M_PI * radioCirculo;

    printf("El perimeto del cuadrado de lado %.0f es: %.0f\n",ladoCuadrado,perimCuad); 
    printf("El perimeto del triangulo de lados %.0f, %.0f y %.0f es: %.0f\n",ladoTri, ladoTri2,ladoTri3, perimTri); 
    printf("El perimeto del rectangulo de lado %.0f y altura %.0f es: %.2f\n",ladoRect, alturaRect, perimRect);
    printf("El area del cuadrado de lado %.0f es: %.0f\n",ladoCuadrado,areaCuadrado); 
    printf("El area del triangulo de lados %.0f, %.0f y %.0f es: %.2f\n",ladoTri, ladoTri2,ladoTri3, areaTri);
    printf("El area del rectangulo de lado %.0f y altura %.0f es: %.2f\n",ladoRect, alturaRect, areaRectangulo);
    printf("El valor del perimetro es: %.2f\n",perimetroCirculo);  
}

void ej4(){
    float radioCirculo, alturaCilindro;
    printf("Introduce el radio de un circulo: \n");
    scanf(" %f",&radioCirculo);
    clearInputBuffer();
    printf("Introduce la altura de un cilindro: \n");
    scanf(" %f",&alturaCilindro);
    clearInputBuffer();
    float areaCilindro = M_PI * pow(radioCirculo, 2) * alturaCilindro;
    printf("El valor del area del cilindro es: %.2f\n",areaCilindro);
}

void ej5(){
    int opcion;
    float a, b, c, x, x1, x2;
    printf("Introduce que quieres resolver: \n");
    printf("1.- Ecuacionde primer grado\n");
    printf("2.- Ecuacion de segundo grado\n");
    scanf(" %i",&opcion);
    if (opcion == 1){
        printf("Vamos a resolver ax + b = 0: \n");
        printf("introduce el valor de a: \n");
        scanf(" %f",&a);
        
        printf("introduce el valor de b: \n");
        scanf(" %f",&b);
        
        x = -b/a;

        printf("La solción para %0.fx + %.0f = 0 es x = %.2f", a, b, x);
    }else{
        printf("Vamos a resolver ax^2 + bx + c = 0: \n");
        printf("introduce el valor de a: \n");
        scanf(" %f",&a);
    
        printf("introduce el valor de b: \n");
        scanf(" %f",&b);
        printf("introduce el valor de c: \n");
        scanf(" %f",&c);
        
        x1 = (-b + sqrt(pow(b, 2)-(4*a*c)))/2;
        x2 = (-b - sqrt(pow(b, 2)-(4*a*c)))/2;

        printf("Una solcion para %0.fx^2 + %.0fx + %.0f es x= %.2f\n", a, b, c, x1);
        printf("La otra solucion para %0.fx^2 + %.0fx + %.0f es x= %.2f\n", a, b, c, x2);
    }
}

//Metodo para limpiar el buffer cada vez que lo llamo
void clearInputBuffer() {
    int c;
    while ((c = getchar()) != '\n' && c != EOF) { }
}

/*

*/