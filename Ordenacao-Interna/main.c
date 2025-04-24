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

void selection(int* array, int n) {

    long comp = 0, mov = 0;

    for(int i = 0; i < n-1; i++) {

        int posMenor = i;

        for(int j = i+1; j < n; j++) {
            if(array[j] < array[posMenor]) posMenor = j;
            comp++;
        }

        swap(&array[i], &array[posMenor]);
        mov += 3;
    }

    printf("Selection\nComparações: %ld\nMovimentações: %ld\n\n", comp, mov);
}

int buscaPosMenor(int* array, int n, int i) {

    if(i == n-1) return i;

    int menor = buscaPosMenor(array, n, i+1);

    if(array[i] < array[menor]) return i;
    else return menor;

}

void selectionRec(int* array, int n, int i) {

    if(i >= n-1) return;

    int menor = buscaPosMenor(array, n, i);

    swap(&array[i], &array[menor]);

    selectionRec(array, n, i+1);
}



int main(void) {

    int array[] = {5,2,9,7,0,8,1,4,3,6};
    int n = sizeof(array)/sizeof(array[0]);

    mostrar(array, n);

    //selection(array, n);
    selectionRec(array, n, 0);

    mostrar(array, n);

    return 0;
}