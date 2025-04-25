// Algorimo de Ordenação Interna INSERTION e suas variações
#include <stdio.h>
#include <string.h>

void mostrar(int* array, int n) {
    printf("[");
    for(int i = 0; i < n; i++) {
        if(i != n-1) printf("%d, ", array[i]);
        else printf("%d", array[i]);
    }
    printf("]\n\n");    
}

void swap(int* a, int* b) {
    int aux = *a;
    *a = *b;
    *b = aux;
}

void insertion(int* array, int n) {

    long comp = 0, mov = 0;

    for(int i = 1; i < n; i++) {

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
    int n = sizeof(array)/sizeof(array[0]);

    mostrar(array, n);

    insertion(array, n);

    mostrar(array, n);

    return 0;
}