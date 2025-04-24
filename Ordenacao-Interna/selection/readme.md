# Selection sort - Análise do algoritmo
### Comparações: O(n^2)  
### Movimentações: O(n)
### Vantagens
#### Custo Linear (O(n)) para movimentações
### Desvantagens
#### Custo Quadrático(O(n^2)) para comparações
#### NÃO é estável

# Selection sort - Explicação dos códigos
### Java
```java
public static void selection(int[] array, int n) {

    long comp = 0, mov = 0;

    for(int i = 0; i < n-1; i++) {

        int posMenor = i;

        for(int j = i+1; j < n; j++) {
        
            if(array[j] < array[posMenor]) posMenor = j;
            comp++;
        }

        swap(array, i, posMenor);
        mov += 3;
    }

        System.out.println("Selection Padrão\nComparações: " + comp + "\nMovimentações: " + mov);
}
```
### C
```c
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
```
### O que esse algoritmo faz?
- Percorre todo o arquivo e acha o elemento com **MENOR** valor
- Grava a **posição** desse elemento dentro do arquivo
- Troca o valor do primeiro elemento do arquivo com o valor da menor posição guardada 

## Selection Crescente Menor (PADRÃO)
- Percorre todo o arquivo e acha o elemento com **MENOR** valor
- Grava a **posição** desse elemento dentro do arquivo
- Troca o valor do primeiro elemento do arquivo com o valor da menor posição guardada 
### Java
```java
public static void selectionMin(int[] array, int n) {

    long comp = 0, mov = 0;

    for(int i = 0; i < n-1; i++) {

        int posMenor = i;

        for(int j = i+1; j < n; j++) {
            if(array[j] < array[posMenor]) posMenor = j;
            comp++;
        }

        swap(array, i, posMenor);
        mov += 3;
    }

    System.out.println("Selection Crescente menor-inicio\nComparações: " + comp + "\nMovimentações: " + mov);
}
```
### C
```c
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
```

## Selection Crescente Maior
- Percorre todo o arquivo e acha o elemento com **MAIOR** valor
- Grava a **posição** desse elemento dentro do arquivo
- Troca o valor do último elemento do arquivo com o valor da maior posição guardada
### Java
```java
public static void selectionMax(int[] array, int n) {
        
    long comp = 0, mov = 0;

    for(int i = n-1; i > 0; i--) {

        int posMaior = i;

        for(int j = i-1; j >= 0; j--) {
            if(array[j] > array[posMaior]) posMaior = j;
        }

        swap(array, i, posMaior);
        mov += 3;
    }

    System.out.println("Selection Crescente maior-final\nComparações: " + comp + "\nMovimentações: " + mov);
}
```
### C
```c
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
```

## Selection Parcial
- Percorre todo o arquivo e acha o elemento com **MENOR** valor
- Grava a **posição** desse elemento dentro do arquivo
- Troca o valor do primeiro elemento do arquivo com o valor da menor posição guardada
- FAZ ISSO 'k' VEZES, por isso é chadado de Parcial
### Java
```java
public static void selectionPartial(int[] array, int n, int k) {
        
    long comp = 0, mov = 0;

    for(int i = 0; i < k; i++) {

        int posMenor = i;

        for(int j = i+1; j < n; j++) {
            if(array[j] < array[posMenor]) posMenor = j;
            comp++;
        }

        swap(array, i, posMenor);
        mov += 3;
    }

    System.out.println("Partial Selection - k = " + k  + "\nComparações: " + comp + "\nMovimentações: " + mov);
}
```
### C
```c
void selectionPartial(int* array, int n, int k) {

    long comp = 0, mov = 0;

    for(int i = 0; i < k; i++) {

        int posMenor = i;

        for(int j = i+1; j < n; j++) {
            if(array[j] < array[posMenor]) posMenor = j;
            comp++;
        }

        swap(&array[i], &array[posMenor]);
        mov += 3;
    }

    printf("Partial Selection - k = %d\nComparações: %ld\nMovimentações: %ld\n\n", k, comp, mov);
}
```

#### Código padrão
```java
for(int i = 0; i < n-1; i++)
```
#### Novo código
```java
for(int i = 0; i < k; i++)
```

## Selection Recursivo
### Java
```java
public static int buscaPosMenor(int[] array, int n, int i) {

        if(i >= n-1) return i;

        int menor = buscaPosMenor(array, n, i + 1);

        return (array[i] < array[menor]) ? i : menor;
    }

    public static void selectionRec(int[] array, int n, int i) {
        
        if(i >= n-1) return;

        int menor = buscaPosMenor(array, n, i);

        swap(array, i, menor);

        selectionRec(array, n, i+1);        
    }
```
### C
```c

```

### Explicação Selection Recursivo
```java
selectionRec(array, n, 0);
```
#### Chamada da função selection recursivo
#### 0 é a posição inicial do vetor
``` java
public static void selectionRec(int[] array, int n, int i)
```
#### Função Recursiva Princial
#### Recebe como parâmetros: array, tamanho, 0
``` java
if(i >= n - 1) return;
```
#### Caso Base: retorna nada se a posição atual (i) for igual à ultima posição
#### Isso acontece quando o array de procura tem tamanho 1
``` java
int menor = buscaPosMenor(array, n, i);
```
#### Chama função para buscar a posição do menor elemento do array (de i até n-1)
#### A cada chamada acrescenta +1 no i: i->n-1, i+1->n-1, i+2->n-1, ...
#### Isso acontece quando o array de procura tem tamanho 1
``` java
swap(array, i, menor);
```
#### Troca o menor elemento com a posição i
```java
selectionRec(array, n, i + 1);
```
#### A cada chamada acrescenta +1 no i: i, i+1, i+2

```java

```
#### 




## Selection Decrescente Maior
- Percorre todo o arquivo e acha o elemento com **MAIOR** valor
- Grava a **posição** desse elemento dentro do vetor
- Troca o valor do primeiro elemento do arquivo com o valor da maior posição guardada
### Java
```java
public static void selectionInverseMax(int[] array, int n) {

    long comp = 0, mov = 0;

    for(int i = 0; i < n-1; i++) {
        
        int posMaior = i;

        for(int j = i+1; j < n; j++) {
            if(array[j] > array[posMaior]) posMaior = j;
            comp++
        }

        swap(array, i, posMaior);
        mov += 3;
    }

    System.out.println("Selection Decrescente maior-inicio\nComparações: " + comp + "\nMovimentações: " + mov);
}
```
### C
```c
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
```

## Selection Decrescente Menor
- Percorre todo o arquivo e acha o elemento com **MENOR** valor
- Grava a **posição** desse elemento dentro do vetor
- Troca o valor do último elemento do arquivo com o valor da maior posição guardada
### Java
```java
public static void selectionInverseMin(int[] array, int n) {

    long comp = 0, mov = 0;

    for(int i = n-1; i > 0; i--) {
            
        int posMenor = i;

        for(int j = i-1; j >= 0; j--) {
            if(array[j] < array[posMenor]) posMenor = j;
            comp++;
        }

        swap(array, i, posMenor);
        mov += 3;
    }

    System.out.println("Selection Decrescente menor-final\nComparações: " + comp + "\nMovimentações: " + mov);
}
```
### C
```c
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
```