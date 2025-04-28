// Algorimo de Ordenação Interna QUICKSORT e suas variações
class Quicksort {

    private int comp;
    private int mov;

    public Quicksort() {
        this.comp = 0;
        this.mov = 0;
    }

    public int getComp() {
        return comp;
    }
    public int getMov() {
        return mov;
    }

    public void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }


    public void quicksortMeio(int[] array, int inicio, int fim) {

        int pivo = array[(inicio+fim)/2]; this.mov += 1;
        int i = inicio, j = fim;

        while(i <= j) {

            while(array[i] < pivo) { i++; this.comp += 1; }
            while(array[j] > pivo) { j--; this.comp += 1; }

            if(i <= j) {
                swap(array, i, j); this.mov += 3;
                i++;
                j--;
            }
        }

        if(inicio < j) quicksortMeio(array, inicio, j);
        if(fim > i) quicksortMeio(array, i, fim);
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

        Quicksort quick = new Quicksort();
        quick.quicksortMeio(array, 0, n-1);
        System.out.println("Quicksort - pivô no meio\nComparações: " + quick.getComp() + "\nMovimentações: " + quick.getMov());

        mostrar(array, n);
    }
}