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
    //--------------------------

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
    //-----------------------------------

    //SHELLSORT - 

    //----------------------------------

    //QUICKSORT -
    public static void sortQuick(int[] array, int inicio, int fim) {

        int i = inicio, f = fim;
        int pivo = array[(inicio+fim)/2];

        while(i <= f) {

            while(i <= fim && array[i] < pivo) i++;
            while(f >= inicio && array[f] > pivo) f--;

            if(i <= f) {
                swap(array, i, f);
                i++;
                f--;
            }
        }

        if(inicio < f) sortQuick(array, inicio, f);
        if(i < fim) sortQuick(array, i, fim);
    }

    public static void quicksort(int[] array, int n) {
        sortQuick(array, 0, n-1);
    }
    //------------------------------------------

    //MERGE

    //COUNTSORT
    
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

        Ordenacao colection = new Ordenacao();

        //colection.selection(array, tam);
        //colection.insertion(array, tam);
        System.out.println("Quicksort"); colection.quicksort(array, tam);

        mostrar(array, tam);
    }
}