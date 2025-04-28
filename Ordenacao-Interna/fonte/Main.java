class Ordenacao {

    public static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
    
    
    //SELECTION - Menor no início
    public static void selection(int[] array, int tam) {

        for(int i = 0; i < tam-1; i++) {
            int posMenor = i;
            for(int j = i+1; j < tam; j++) {
                if(array[j] < array[posMenor]) posMenor = j;
            }

            swap(array, i, posMenor);
        }

        System.out.println("Selection sort");
    }

    //INSERTION - 
    public static void insertion(int[] array, int tam) {

        for(int i = 1; i < tam; i++) {

            int aux = array[i];
            int j = i-1;

            while(j >= 0 && array[j] > aux) {
                array[j+1] = array[j]; 
                j--;
            }

            array[j+1] = aux;
        }
        System.out.println("Insertion sort");
    }

    //QUICKSORT -
    public static void quicksort(int[] array, int inicio, int fim) {

        int pivo = array[(inicio+fim)/2];
        int i = inicio, j = fim;

        while(i <= j) {

            while(array[i] < pivo) i++;
            while(array[j] > pivo) j--;

            if(i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if(inicio < j) quicksort(array, inicio, j);
        if(fim > i) quicksort(array, i, fim);
    }
}

class Main {

    public static void mostrar(int[] array, int tam) {
        System.out.print("[");
        for(int i = 0; i < tam-1; i++) {
            System.out.print(array[i] + "|");
            
        }
        System.out.println(array[tam-1] + "]\n");
    }

    public static void main(String[] args) {

        int[] array = new int[]{5,2,9,7,0,8,1,4,3,6};
        int tam = array.length;

        System.out.println("Array Inicial");
        mostrar(array, tam);

        //Ordenacao.selection(array, tam);
        //Ordenacao.insertion(array, tam);
        System.out.println("Quicksort"); Ordenacao.quicksort(array, 0, tam-1);

        mostrar(array, tam);
    }
}