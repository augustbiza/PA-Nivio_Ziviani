// pai (i-1)/2
// filho esquerda (i*2)+1
// filho direita  (i*2)+2

#include <stdio.h>
#include <stdbool.h>

void mostrar(int* arvore, int n) {
    for(int i = 0; i < n; i++) printf("%d ", arvore[i]);
    printf("\n");
}

int pegarElemento(int* arvore, int n, int elem) {

    int pos;

    for(int i = 0; i < n; i++) {
        if(arvore[i] == elem) pos = i;
    }

    return pos;
}

void mostrarAncestrais(int* arvore, int n, int elem) {

    int i = pegarElemento(arvore, n, elem);

    if(i == 0) {
        printf("Sem pai (Raiz)\n");
        return;
    }

    int ancestral;

    do{

        ancestral = arvore[(i-1)/2];

        printf("%d ", ancestral);

        i = (i-1)/2;

    }while(i > 0);
}



int main(void) {

    int arvore[] = {8, 6, 7, 4, 3, 0};
    int n = sizeof(arvore)/sizeof(arvore[0]);

    mostrar(arvore, n);

    printf("Elemento: ");
    int elem;
    scanf("%d", &elem);

    printf("Ancestrais: ");
    mostrarAncestrais(arvore, n, elem);
    printf("\n");

    return 0;
}