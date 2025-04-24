class Ordenacao {

    public static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
    
    //Menor no início
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

    ///////////////////////////////////
    public static int buscaPosMenor(int[] array, int n, int i) {

        if(i == n-1) return i;

        int menor = buscaPosMenor(array, n, i + 1);

        return (array[i] < array[menor]) ? i : menor;
    }

    public static void selectionRec(int[] array, int n, int i) {
        
        if(i >= n-1) return;

        int menor = buscaPosMenor(array, n, i);

        swap(array, i, menor);

        selectionRec(array, n, i+1);        
    }


    ///////////////////////////////////
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
        System.out.println("Selection Recursivo");
        Ordenacao.selectionRec(array, n, 0);

        mostrar(array, n);
    }
}