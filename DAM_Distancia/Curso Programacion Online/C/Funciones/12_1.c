/*
    Ejemplo 1, por referencia
 */

#include <stdio.h>
void incrementar (int *a);
void main ()
{
int i;
i = 0;
printf ("\n\n\nFunción main. Valor inicial: %i\n", i);
incrementar (&i);
printf ("\nFunción main. Valor final: %i", i);
}
void incrementar (int *a)
{
printf ("\nFunción incrementar:\nAntes de incrementar: %i", *a);
(*a)++;
printf ("\nDespués de incrementar: %i\n",*a);
}

/*
    Ejemplo 2, por valor
 */

#include <stdio.h>
void incrementar(int i);
void main ()
{
int i;
i = 0;
printf ("\n\n\nFunción main. Valor inicial: %i\n", i);
incrementar (i);
printf ("\nFunción main. Valor final: %i", i);
}
void incrementar (int i)
{
printf ("\nDentro de la función incrementar:\nAntes de incrementar:%i", i);
i++;
printf ("\nDespués de incrementar: %i\n", i);
}