// Algorimo de Ordenação Interna QUICKSORT e suas variações
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

void quicksortMeio(int* array, int inicio, int fim, int* comp, int* mov) {

    int pivo = array[(inicio+fim)/2]; (*mov)++; //mov
    int i = inicio, j = fim;

    while(i <= j) {

        while(array[i] < pivo) { i++; (*comp)++;} (*comp)++; //comp
        while(array[j] > pivo) { j--; (*comp)++;} (*comp)++; //comp

        if(i <= j) {
            //swap(&array[i], &array[j]);
            swap(array+i, array+j); (*mov) += 3;   //mov
            i++;
            j--;
        }
    }

    if(inicio < j) quicksortMeio(array, inicio, j, comp, mov);
    if(fim > i) quicksortMeio(array, i, fim, comp, mov);
}

void quicksortPrimeiro(int* array, int inicio, int fim, int* comp, int* mov) {

    int pivo = array[inicio]; (*mov)++; //mov
    int i = inicio, j = fim;

    while(i <= j) {

        while(array[i] < pivo) { i++; (*comp)++;} (*comp)++; //comp
        while(array[j] > pivo) { j--; (*comp)++;} (*comp)++; //comp

        if(i <= j) {
            //swap(&array[i], &array[j]);
            swap(array+i, array+j); (*mov) += 3;   //mov
            i++;
            j--;
        }
    }

    if(inicio < j) quicksortPrimeiro(array, inicio, j, comp, mov);
    if(fim > i) quicksortPrimeiro(array, i, fim, comp, mov);
}

void quicksortUltimo(int* array, int inicio, int fim, int* comp, int* mov) {

    int pivo = array[fim]; (*mov)++; //mov
    int i = inicio, j = fim;

    while(i <= j) {

        while(array[i] < pivo) { i++; (*comp)++;} (*comp)++; //comp
        while(array[j] > pivo) { j--; (*comp)++;} (*comp)++; //comp

        if(i <= j) {
            //swap(&array[i], &array[j]);
            swap(array+i, array+j); (*mov) += 3;   //mov
            i++;
            j--;
        }
    }

    if(inicio < j) quicksortUltimo(array, inicio, j, comp, mov);
    if(fim > i) quicksortUltimo(array, i, fim, comp, mov);
}



int main(void) {

    int array[] = {5,2,9,7,0,8,1,4,3,6};
    int n = sizeof(array)/sizeof(array[0]);

    long comp = 0, mov = 0;

    mostrar(array, n);

    //quicksortMeio(array, 0, n-1, &comp, &mov);
    //printf("Quicksort - pivo no meio\nComparacoes: %ld\nMovimentacoes: %ld\n", comp, mov);

    //quicksortPrimeiro(array, 0, n-1, &comp, &mov);
    //printf("Quicksort - pivo no primeiro\nComparacoes: %ld\nMovimentacoes: %ld\n", comp, mov);

    //quicksortUltimo(array, 0, n-1, &comp, &mov);
    //printf("Quicksort - pivo no ultimo\nComparacoes: %ld\nMovimentacoes: %ld\n", comp, mov);


    mostrar(array, n);

    return 0;
}