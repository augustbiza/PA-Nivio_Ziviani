#include <stdio.h>
#include <string.h>

void mostrar(int* array, int tam) {
    printf("[");
    for(int i = 0; i < tam-1; i++) {
        printf("%d|", array[i]);
    }
    printf("%d]\n\n", array[tam-1]);    
}

void swap(int* a, int* b) {
    int aux = *a;
    *a = *b;
    *b = aux;
}

//SELECTION - Menor no início
void selection(int* array, int tam) {

    for(int i = 0; i < tam-1; i++) {

        int posMenor = i;

        for(int j = i+1; j < tam; j++) {
            if(array[j] < array[posMenor]) posMenor = j;
        }

        swap(&array[i], &array[posMenor]);
    }

    printf("Selection sort\n");
}

//INSERTION
void insertion(int* array, int tam) {

    for(int i = 1; i < tam; i++) {

        int aux = array[i]; 
        int j = i-1;

        while(j >= 0 && array[j] > aux) {
            array[j+1] = array[j];
            j--;
        }

        array[j+1] = aux; 
    }

    printf("Insertion sort\n");
}

//QUICKSORT
void quicksort(int* array, int inicio, int fim) {

    int pivo = array[(inicio+fim)/2];
    int i = inicio, j = fim;

    while(i <= j) {

        while(array[i] < pivo) i++;
        while(array[j] > pivo) j--;

        if(i <= j) {
            swap(&array[i], &array[j]);
            //swap(array+i, array+j);
            i++;
            j--;
        }
    }

    if(inicio < j) quicksort(array, inicio, j);
    if(fim > i) quicksort(array, i, fim);
}


int main(void) {

    int array[] = {5,2,9,7,0,8,1,4,3,6};
    int tam = sizeof(array)/sizeof(array[0]);

    printf("Array Inicial\n");
    mostrar(array, tam);

    //selection(array, tam);
    //insertion(array, tam); 
    //printf("Quicksort\n"); quicksort(array, 0, tam-1);

    mostrar(array, tam);

    return 0;
}