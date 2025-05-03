// Algorimo de Ordenação Interna QUICKSORT e suas variações
#include <stdio.h>
#include <string.h>
//-------------------Swap e Mostrar elementos-----------------------
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

//-------------------Quicksort com duas funções-------------------
//A ordenação é feita somente por uma, a outra apenas chama ela uma vez
void ordenaQuick(int* array, int inicio, int fim) {
    
    int pivo = array[(inicio+fim)/2];
    int i = inicio, f = fim;
    
    while(i <= f) {
        
        while(i <= fim && array[i] < pivo) i++;
        while(f >= inicio && array[f] > pivo) f--;
        
        if(i <= f) {
            swap(array+i, array+f);
            i++; f--;
        }
    }
    if(inicio < f) ordenaQuick(array, inicio, f);
    if(fim > i) ordenaQuick(array, i, fim);
}
void quicksort(int* array, int n) {
    ordenaQuick(array, 0, n-1);
}

//-------------------Quicksort com pivô no início-------------------
void quicksortPrimeiro(int* array, int inicio, int fim, long* comp, long* mov) {

    int pivo = array[inicio]; (*mov)++; //mov
    int i = inicio+1, f = fim;

    while(i <= f) {

        while(i <= fim && array[i] < pivo) { i++; (*comp)++;} (*comp)++; //comp
        while(f >= inicio && array[f] > pivo) { f--; (*comp)++;} (*comp)++; //comp

        if(i <= f) {
            //swap(&array[i], &array[f]);
            swap(array+i, array+f); (*mov) += 3;   //mov
            i++;
            f--;
        }
    }
    swap(array+inicio, array+f);

    if(inicio < f) quicksortPrimeiro(array, inicio, f, comp, mov);
    if(fim > i) quicksortPrimeiro(array, i, fim, comp, mov);
}

//-------------------Quicksort com pivô no Último-------------------
void quicksortUltimo(int* array, int inicio, int fim, long* comp, long* mov) {

    int pivo = array[fim]; (*mov)++; //mov
    int i = inicio, f = fim-1;

    while(i <= f) {

        while(i <= fim && array[i] < pivo) { i++; (*comp)++;} (*comp)++; //comp
        while(f >= inicio && array[f] > pivo) { f--; (*comp)++;} (*comp)++; //comp

        if(i <= f) {
            //swap(&array[i], &array[f]);
            swap(array+i, array+f); (*mov) += 3;   //mov
            i++;
            f--;
        }
    }
    swap(array+i, array+fim);

    if(inicio < f) quicksortUltimo(array, inicio, f, comp, mov);
    if(fim > i) quicksortUltimo(array, i, fim, comp, mov);
}



int main(void) {

    int array[] = {5,2,9,7,0,8,1,4,3,6};
    //int array[] = {0,1,2,3,4,5,6,7,8,9};      //arquivo ordenado
    //int array[] = {9,8,7,6,5,4,3,2,1,0};      //arquivo decrescente
    //int array[] = {5,2,9,7,0,8,1,4,3,6};      //pivo menor
    //int array[] = {5,2,0,7,9,8,1,4,3,6};      //pivo maior

    int n = sizeof(array)/sizeof(array[0]);

    long comp = 0, mov = 0;

    mostrar(array, n);
    
    //quicksortPrimeiro(array, 0, n-1, &comp, &mov);
    //printf("Quicksort - pivo no primeiro\nComparacoes: %ld\nMovimentacoes: %ld\n\n", comp, mov);
    //comp = 0; mov = 0;
    

    //quicksortUltimo(array, 0, n-1, &comp, &mov);
    //printf("Quicksort - pivo no ultimo\nComparacoes: %ld\nMovimentacoes: %ld\n\n", comp, mov);
    //comp = 0; mov = 0;


    //quicksort(array, n);

    mostrar(array, n);

    return 0;
}