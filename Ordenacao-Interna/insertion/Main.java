// Algorimo de Ordenação Interna INSERTION e suas variações
class Insertion {

    public static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    public static void insertion(int[] array, int n) {

        long comp = 0, mov = 0;

        for(int i = 1; i < n; i++) {

            int aux = array[i];
            int j = i-1;

            while(j >= 0 && array[j] > aux) {
                array[j+1] = array[j];
                j--;
                comp++; mov++;
            }
            array[j+1] = aux;
            mov++;
        }

        System.out.println("Insertion\nComparações: " + comp + "\nMovimentações: " + mov);
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

        Insertion.insertion(array, n);

        mostrar(array, n);
    }
}