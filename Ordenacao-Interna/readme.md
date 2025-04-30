# Algoritmos de Ordenação Interna
## O que é ordenação interna?
Quando os dados a serem ordenados cabem na memória principal(RAM) utiliza-se ordenação interna.
## Tipos
- Selection / Selection Parcial
- Insertion / Insertion Parcial
- Bubble
- Quicksort / Quicksort Parcial
- Mergesort
- Shellsort
- Heapsort / Heapsort Parcial

## Classificação: quando usar
### 1.Simples
- Arquivos Pequenos
- Comparações: O(n^2)
### 2.Eficientes
- Arquivos Grandes
- Comparações: O(n*Log2(n))

## Classificação: estabilidade
### 1.Estável
- Não altera a ordem dos elemetos que possuem a mesma chave
- Insertion
### 2.NÃO Estável
- Altera a ordem dos elemetos que possuem a mesma chave
- Obs.: pode ter a estabilidade forçada
- Selection
- Shellsort
- Quicksort