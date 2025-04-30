// Algorimo de Ordenação Interna INSERTION e suas variações
class Insertion {

    private int comp;
    private int mov;

    public Insertion() {
        this.comp = 0;
        this.mov = 0;
    }

    public int getComp() {
        return comp;
    }
    public int getMov() {
        return mov;
    }

    public static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    public void insertionsort(int[] array, int n) {

        for(int i = 1; i < n; i++) {

            int aux = array[i];
            int j = i-1;

            while(j >= 0 && array[j] > aux) {
                array[j+1] = array[j];
                j--;
                this.comp++; this.mov++;
            }
            array[j+1] = aux;
            this.mov++;
        }
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

        int[] array = new int[]{5,2,9,7,0,8,1,4,3,6};     //arquivo desordenado
        //int[] array = new int[]{0,1,2,3,4,5,6,7,8,9};     //arquivo ordenado (melhor caso)
        //int[] array = new int[]{9,8,7,6,5,4,3,2,1,0};     //arquivo decrescente (pior caso)
        int n = array.length;

        mostrar(array, n);

        Insertion insertion = new Insertion();
        insertion.insertionsort(array, n);
        System.out.println("Insertion sort\nComparações: " + insertion.getComp() + "\nMovimentações: " + insertion.getMov());

        mostrar(array, n);
    }
}