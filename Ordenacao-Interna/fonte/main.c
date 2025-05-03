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
void sortQuick(int* array, int inicio, int fim) {

    int pivo = array[(inicio+fim)/2];
    int i = inicio, f = fim;

    while(i <= f) {

        while(i <= fim && array[i] < pivo) i++;
        while(f >= inicio && array[f] > pivo) f--;

        if(i <= f) {
            swap(&array[i], &array[f]);
            //swap(array+i, array+f);
            i++;
            f--;
        }
    }

    if(inicio < f) sortQuick(array, inicio, f);
    if(fim > i) sortQuick(array, i, fim);
}
void quicksort(int* array, int tam) {
    sortQuick(array, 0, tam-1);
}


int main(void) {

    int array[] = {5,2,9,7,0,8,1,4,3,6};
    int tam = sizeof(array)/sizeof(array[0]);

    printf("Array Inicial\n");
    mostrar(array, tam);

    //selection(array, tam);
    //insertion(array, tam); 
    printf("Quicksort\n"); quicksort(array, tam);

    mostrar(array, tam);

    return 0;
}