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

//-------------------Quicksort com pivô no meio-------------------
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

//-------------------Quicksort com pivô no início-------------------
    public void quicksortInicio(int[] array, int inicio, int fim) {

        int pivo = array[inicio];
        int i = inicio+1, j = fim;

        while(i <= j) {

            while(array[i] < pivo) { i++; this.comp += 1; }
            while(array[j] > pivo) { j--; this.comp += 1; }

            if(i <= j) {
                swap(array, i, j); this.mov += 3;
                i++;
                j--;
            }
        }

        if(inicio < j) quicksortInicio(array, inicio, j);
        if(fim > i) quicksortInicio(array, i, fim);
    }

//-------------------Quicksort com pivô no Último-------------------
    public void quicksortFim(int[] array, int inicio, int fim) {

        int pivo = array[fim];
        int i = inicio, j = fim-1;

        while(i <= j) {

            while(array[i] < pivo) { i++; this.comp += 1; }
            while(array[j] > pivo) { j--; this.comp += 1; }

            if(i <= j) {
                swap(array, i, j); this.mov += 3;
                i++;
                j--;
            }
        }

        if(inicio < j) quicksortFim(array, inicio, j);
        if(fim > i) quicksortFim(array, i, fim);
    }

//-------------------Quicksort com duas funções-------------------
//A ordenação é feita somente por uma, a outra apenas chama ela uma vez
    public void ordenaQuick(int[] array, int inicio, int fim) {

        int pivo = array[(inicio+fim)/2]; this.mov++;
        int i = inicio, j = fim;

        while(i <= j) {

            while(array[i] < pivo) { i++; this.comp++; }
            while(array[j] > pivo) { j--; this.comp++; }

            if(i <= j) {
                swap(array, i, j); this.mov += 3;
                i++;
                j--;
            }
        }

        if(inicio < j) ordenaQuick(array, inicio, j);
        if(fim > i) ordenaQuick(array, i, fim);
    }

    public void quicksort(int[] array, int n) {
        ordenaQuick(array, 0, n-1);
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

        //int[] array = new int[]{5,2,9,7,0,8,1,4,3,6};     //arquivo desordenado
        //int[] array = new int[]{0,1,2,3,4,5,6,7,8,9};     //arquivo ordenado
        int[] array = new int[]{9,8,7,6,5,4,3,2,1,0};       //arquivo decrescente
        int n = array.length;

        mostrar(array, n);

        Quicksort quick = new Quicksort();

        /*
        quick.quicksortMeio(array, 0, n-1);
        System.out.println("Quicksort - pivô no meio\nComparações: " + quick.getComp() + "\nMovimentações: " + quick.getMov() + "\n");

        quick.quicksortInicio(array, 0, n-1);
        System.out.println("Quicksort - pivô no inicio\nComparações: " + quick.getComp() + "\nMovimentações: " + quick.getMov() + "\n");

        quick.quicksortFim(array, 0, n-1);
        System.out.println("Quicksort - pivô no inicio\nComparações: " + quick.getComp() + "\nMovimentações: " + quick.getMov() + "\n");
        */


        quick.quicksort(array, n);
        System.out.println("Quicksort \nComparações: " + quick.getComp() + "\nMovimentações: " + quick.getMov() + "\n");

        mostrar(array, n);
    }
}