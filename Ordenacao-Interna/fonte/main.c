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

    long comp = 0, mov = 0;

    for(int i = 0; i < tam-1; i++) {

        int posMenor = i;

        for(int j = i+1; j < tam; j++) {
            if(array[j] < array[posMenor]) posMenor = j;
            comp++;
        }

        swap(&array[i], &array[posMenor]);
        mov += 3;
    }

    printf("Selection\nComparações: %ld\nMovimentações: %ld\n\n", comp, mov);
}

//INSERTION
void insertion(int* array, int tam) {

    long comp = 0, mov = 0;

    for(int i = 1; i < tam; i++) {

        int aux = array[i]; mov++;
        int j = i-1;

        while(j >= 0 && array[j] > aux) {
            comp++; 
            array[j+1] = array[j]; mov++;
            j--;
        }

        array[j+1] = aux; mov++;
    }

    printf("Insertion\nComparações: %ld\nMovimentações: %ld\n\n", comp, mov);
}



int main(void) {

    int array[] = {5,2,9,7,0,8,1,4,3,6};
    int tam = sizeof(array)/sizeof(array[0]);

    mostrar(array, tam);

    //selection(array, tam);
    //insertion(array, tam);

    mostrar(array, tam);

    return 0;
}