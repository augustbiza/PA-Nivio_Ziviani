// Algorimo de Ordenação Interna SELECTION e suas variações
class Selection {

    private int comp;
    private int mov;

    public Selection() {
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
    
    //PADRÃO = menor no inicio
    public void selectionsort(int[] array, int n) {

        for(int i = 0; i < n-1; i++) {
            int posMenor = i;
            for(int j = i+1; j < n; j++) {
                if(array[j] < array[posMenor]) posMenor = j;
                this.comp++;
            }

            swap(array, i, posMenor);
            this.mov += 3;
        }
    }

    //Menor no início
    public void selectionMin(int[] array, int n) {

        for(int i = 0; i < n-1; i++) {
            int posMenor = i;
            for(int j = i+1; j < n; j++) {
                if(array[j] < array[posMenor]) posMenor = j;
                this.comp++;
            }

            swap(array, i, posMenor);
            this.mov += 3;
        }
    }

    //Maior no final
    public void selectionMax(int[] array, int n) {

        for(int i = n-1; i > 0; i--) {

            int posMaior = i;

            for(int j = i-1; j >= 0; j--) {
                if(array[j] > array[posMaior]) posMaior = j;
                this.comp++;
            }

            swap(array, i, posMaior);
            this.mov += 3;
        }
    }

    //Coloca os menores k elementos ordenados
    public void selectionPartial(int[] array, int n, int k) {

        for(int i = 0; i < k; i++) {
            int posMenor = i;
            for(int j = i+1; j < n; j++) {
                if(array[j] < array[posMenor]) posMenor = j;
                this.comp++;
            }

            swap(array, i, posMenor);
            this.mov += 3;
        }
    }

    //Maior no inicio
    public void selectionInverseMax(int[] array, int n) {

        for(int i = 0; i < n-1; i++) {

            int posMaior = i;

            for(int j = i+1; j < n; j++) {
                if(array[j] > array[posMaior]) posMaior = j;
                this.comp++;
            }

            swap(array, i, posMaior);
            this.mov += 3;
        }
    }

    //Menor no final
        public void selectionInverseMin(int[] array, int n) {

        for(int i = n-1; i > 0; i--) {
            
            int posMenor = i;

            for(int j = i-1; j >= 0; j--) {
                if(array[j] < array[posMenor]) posMenor = j;
                this.comp++;
            }

            swap(array, i, posMenor);
            this.mov += 3;
        }
    }
    
}

class Main {

    public static void mostrar(int[] array, int n) {
        System.out.print("[");
        for(int i = 0; i < n-1; i++) { System.out.print(array[i] + "|"); }
        System.out.println(array[n-1] + "]\n");
    }

    public static void main(String[] args) {

        int[] array = new int[]{5,2,9,7,0,8,1,4,3,6};     //arquivo desordenado
        //int[] array = new int[]{0,1,2,3,4,5,6,7,8,9};     //arquivo ordenado
        //int[] array = new int[]{9,8,7,6,5,4,3,2,1,0};       //arquivo decrescente
        int n = array.length;

        mostrar(array, n);

        Selection selection = new Selection();

        selection.selectionsort(array, n);
        System.out.println("Selection sort\nComparações: " + selection.getComp() + "\nMovimentações: " + selection.getMov());
        
/*
        selection.selectionMax(array, n);
        System.out.println("Selection Crescente maior-final\nComparações: " + selection.getComp() + "\nMovimentações: " + selection.getMov());

        int k = 3;
        selection.selectionPartial(array, n, k);
        System.out.println("Selection Parcial - k: " + k + "\nComparações: " + selection.getComp() + "\nMovimentações: " + selection.getMov());
        selection.selectionInverseMax(array, n);
        System.out.println("Selection Decrescente maior-inicio\nComparações: " + selection.getComp() + "\nMovimentações: " + selection.getMov());


        selection.selectionInverseMin(array, n);
        System.out.println("Selection Decrescente menor-final\nComparações: " + selection.getComp() + "\nMovimentações: " + selection.getMov());
*/
        mostrar(array, n);
    }
}