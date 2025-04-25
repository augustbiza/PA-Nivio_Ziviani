class Ordenacao {

    public static void swapIndex(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
    public static void swapValue(int[] array, int i, int j) {
        int aux = i;
        i = j;
        j = aux;
    }
    
    //SELECTION - Menor no início
    public static void selection(int[] array, int n) {

        long comp = 0, mov = 0;

        for(int i = 0; i < n-1; i++) {
            int posMenor = i;
            for(int j = i+1; j < n; j++) {
                if(array[j] < array[posMenor]) posMenor = j;
                comp++;
            }

            swapIndex(array, i, posMenor);
            mov += 3;
        }

        System.out.println("Selection\nComparações: " + comp + "\nMovimentações: " + mov + "\n");
    }

    //INSERTION
    public static void insertion(int[] array, int n) {

        for(int i = 1; i < n; i++) {

            int aux = array[i];
            int j = i-1;

            while(j >= 0 && array[j] > aux) {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = aux;
        }
        System.out.println("Insertion\nComparações: " + comp + "\nMovimentações: " + mov + "\n");
    }
}

class Main {

    public static void mostrar(int[] array, int n) {
        System.out.print("[");
        for(int i = 0; i < n; i++) {
            if(i != n-1) System.out.print(array[i] + "|");
            else System.out.print(array[i]);
        }
        System.out.println("]\n");
    }

    public static void main(String[] args) {

        int[] array = new int[]{5,2,9,7,0,8,1,4,3,6};
        int n = array.length;

        mostrar(array, n);

        //Ordenacao.selection(array, n);
        Ordenacao.insertion(array, n);

        mostrar(array, n);
    }
}