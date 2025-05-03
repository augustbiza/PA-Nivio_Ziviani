# Quicksort - Análise do algoritmo
### Comparações
#### Melhor: (n*Log(n))
#### Pior: O(n^2)
#### Médio: (n*Log(n))

### Movimentações
#### Melhor: (n*Log(n))
#### Pior: O(n^2) 
#### Médio: (n*Log(n))

### Estabilidade
#### Não estável

### Vantagens
#### Complexidade MÉDIA linear-algoritmica: O(n*Log(n))

### Desvantagens
#### Out Situ
#### Complexidade quadrática quando o pivô escolhido for o MENOR ou MAIOR elemento do arquivo 

### Bom
#### Quando não se sabe a ordenação atual do arquivo, pois a média é O(n*Log(n))
### Ruim
#### Escolha errada do pivo(menor ou maior)
#### Se o pivô não for o meio é preciso colocar um swap após o while(i<=f) externo antes de partir o arquivo em dois
Primeiro
```c
while(i <= f) {...}
swap(array+inicio, array+f);
```
Ultimo
```c
while(i <= f) {...}
swap(array+i, array+fim);
```