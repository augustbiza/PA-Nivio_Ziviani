// Algorimo de Ordenação Interna SELECTION e suas variações
class Selection {

    public static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
    
    //PADRÃO = menor no inicio
    public static void selection(int[] array, int n) {

        long comp = 0, mov = 0;

        for(int i = 0; i < n-1; i++) {
            int posMenor = i;
            for(int j = i+1; j < n; j++) {
                if(array[j] < array[posMenor]) posMenor = j;
                comp++;
            }

            swap(array, i, posMenor);
            mov += 3;
        }

        System.out.println("Selection Padrão\nComparações: " + comp + "\nMovimentações: " + mov);
    }

    //Menor no início
    public static void selectionMin(int[] array, int n) {

        long comp = 0, mov = 0;

        for(int i = 0; i < n-1; i++) {
            int posMenor = i;
            for(int j = i+1; j < n; j++) {
                if(array[j] < array[posMenor]) posMenor = j;
                comp++;
            }

            swap(array, i, posMenor);
            mov += 3;
        }

        System.out.println("Selection Crescente menor-inicio\nComparações: " + comp + "\nMovimentações: " + mov);
    }

    //Maior no final
    public static void selectionMax(int[] array, int n) {
        
        long comp = 0, mov = 0;

        for(int i = n-1; i > 0; i--) {

            int posMaior = i;

            for(int j = i-1; j >= 0; j--) {
                if(array[j] > array[posMaior]) posMaior = j;
            }

            swap(array, i, posMaior);
            mov += 3;
        }

        System.out.println("Selection Crescente maior-final\nComparações: " + comp + "\nMovimentações: " + mov);
    }

    //Coloca os menores k elementos ordenados
    public static void selectionPartial(int[] array, int n, int k) {
        long comp = 0, mov = 0;

        for(int i = 0; i < k; i++) {
            int posMenor = i;
            for(int j = i+1; j < n; j++) {
                if(array[j] < array[posMenor]) posMenor = j;
                comp++;
            }

            swap(array, i, posMenor);
            mov += 3;
        }

        System.out.println("Partial Selection - k = " + k  + "\nComparações: " + comp + "\nMovimentações: " + mov);
    }

    //Maior no inicio
    public static void selectionInverseMax(int[] array, int n) {

        long comp = 0, mov = 0;

        for(int i = 0; i < n-1; i++) {

            int posMaior = i;

            for(int j = i+1; j < n; j++) {
                if(array[j] > array[posMaior]) posMaior = j;
                comp++;
            }

            swap(array, i, posMaior);
            mov += 3;
        }

        System.out.println("Selection Decrescente maior-inicio\nComparações: " + comp + "\nMovimentações: " + mov);
    }

    //Menor no final
        public static void selectionInverseMin(int[] array, int n) {

        long comp = 0, mov = 0;

        for(int i = n-1; i > 0; i--) {
            
            int posMenor = i;

            for(int j = i-1; j >= 0; j--) {
                if(array[j] < array[posMenor]) posMenor = j;
                comp++;
            }

            swap(array, i, posMenor);
            mov += 3;
        }

        System.out.println("Selection Decrescente menor-final\nComparações: " + comp + "\nMovimentações: " + mov);
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

        Selection.selection(array, n);
        //Selection.selectionMin(array, n);
        //Selection.selectionMax(array, n);
        //Selection.selectionPartial(array, n, 4);
        //Selection.selectionInverseMax(array, n);
        //Selection.selectionInverseMin(array, n);

        mostrar(array, n);
    }
}