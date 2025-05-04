// pai (i-1)/2
// filho esquerda (i*2)+1
// filho direita  (i*2)+2

#include <stdio.h>
#include <stdbool.h>

void mostrar(int* arvore, int n) {
    for(int i = 0; i < n; i++) printf("%d ", arvore[i]);
    printf("\n");
}

int escolherElemento(int* arvore, int n) {

    printf("Escolha um elemento: ");

    bool elemExiste = false;
    int elem;

    do{

        scanf("%d", &elem);

        for(int i = 0; i < n && !elemExiste; i++) {
            if(elem == arvore[i]) elemExiste = true;
        }

        if(!elemExiste) printf("Erro!\nEscolha um elemento válido: ");

    }while(!elemExiste);

    return elem;
}

int pegarElemento(int* arvore, int n, int elem) {

    int pos;

    for(int i = 0; i < n; i++) {
        if(arvore[i] == elem) pos = i;
    }

    return pos;
}

bool temPai(int* arvore, int n, int pos) {

    if(pos == 0) return false;

    bool pai = false;

    if((pos-1)/2 >= 0 && (pos-1)/2 <= n/2) pai = true;

    return pai;
}

bool temFilhoEsquerda(int* arvore, int n, int i) {

    bool filho = false;

    if((i*2)+1 > 0 && (i*2)+1 < n) filho = true;

    return filho;
}

bool temFilhoDireita(int* arvore, int n, int i) {

    bool filho = false;

    if((i*2)+2 > 0 && (i*2)+2 < n) filho = true;

    return filho;
}

void mostrarElemento(int* arvore, int n, int i) {

    printf("Elemento: %d\n", arvore[i]);

    if(temPai(arvore, n, i)) printf("Pai: %d\n", arvore[(i-1)/2]);
    else printf("Sem pai (Raiz)\n");

    if(temFilhoEsquerda(arvore, n, i)) {
        printf("Filho esquerda: %d\n", arvore[(i*2)+1]);

        if(temFilhoDireita(arvore, n, i)) printf("Filho direita: %d\n", arvore[(i*2)+2]);
        else printf("Sem filho direita\n");
    }
    else printf("Sem Filhos(Folha)\n");
}


int main(void) {

    int arvore[] = {8, 6, 7, 4, 3, 0};
    int n = sizeof(arvore)/sizeof(arvore[0]);

    mostrar(arvore, n);

    int elem = escolherElemento(arvore, n);

    int pos = pegarElemento(arvore, n, elem);

    mostrarElemento(arvore, n, pos);

    return 0;
}