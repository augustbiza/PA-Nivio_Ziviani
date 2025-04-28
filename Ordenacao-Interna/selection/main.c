// Algorimo de Ordenação Interna SELECTION e suas variações 
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

//PADRÃO = menor no início
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

    printf("Selection Padrão\nComparações: %ld\nMovimentações: %ld\n\n", comp, mov);
}

//Menor no início
void selectionMin(int* array, int n) {

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

    printf("Selection Crescente menor-inicio\nComparações: %ld\nMovimentações: %ld\n\n", comp, mov);
}

//Maior no final
void selectionMax(int* array, int n) {

    long comp = 0, mov = 0;

    for(int i = n-1; i > 0; i--) {

        int posMaior = i;

        for(int j = i-1; j >= 0; j--) {
            if(array[j] > array[posMaior]) posMaior = j;
            comp++;
        }

        swap(&array[i], &array[posMaior]);
        mov += 3;
    }

    printf("Selection Crescente maior-final\nComparações: %ld\nMovimentações: %ld\n\n", comp, mov);
}

//Coloca os menores k elementos ordenados
void selectionPartial(int* array, int n, int k) {

    long comp = 0, mov = 0;

    for(int i = 0; i < k; i++) {

        int posMenor = i;

        for(int j = i+1; j < n; j++) {
            if(array[j] < array[posMenor]) posMenor = j;
            comp++;
        }

        //swap(&array[i], &array[j]);
        swap(array+i, array+j);
        mov += 3;
    }

    printf("Partial Selection - k = %d\nComparações: %ld\nMovimentações: %ld\n\n", k, comp, mov);
}

//Recursivo
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

//Maior no inicio
void selectionInverseMax(int* array, int n) {

    long comp = 0, mov = 0;

    for(int i = 0; i < n-1; i++) {

        int posMaior = i;

        for(int j = i+1; j < n; j++) {
            if(array[j] > array[posMaior]) posMaior = j;
            comp++;
        }

        swap(&array[i], &array[posMaior]);
        mov += 3;
    }

    printf("Selection Decrescente maior-inicio\nComparações: %ld\nMovimentações: %ld\n\n", comp, mov);
}

void selectionInverseMin(int* array, int n) {

    long comp = 0, mov = 0;

    for(int i = n-1; i > 0; i--) {
        
        int posMenor = i;
    
        for(int j = i-1; j >= 0; j--) {
            if(array[j] < array[posMenor]) posMenor = j;
            comp++;
        }

        swap(&array[i], &array[posMenor]);
        mov += 3;
    }

    printf("Selection Decrescente menor-final\nComparações: %ld\nMovimentações: %ld\n\n", comp, mov);
}

int main(void) {

    int array[] = {5,2,9,7,0,8,1,4,3,6};
    int n = sizeof(array)/sizeof(array[0]);

    mostrar(array, n);

    selection(array, n);
    //selectionMin(array, n);
    //selectionMax(array, n);
    //selectionPartial(array, n, 4);
    //selectionInverseMax(array, n);
    //selectionInverseMin(array, n);

    mostrar(array, n);

    return 0;
}