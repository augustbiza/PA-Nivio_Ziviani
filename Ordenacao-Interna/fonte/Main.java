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
    public static void selection(int[] array, int tam) {

        long comp = 0, mov = 0;

        for(int i = 0; i < tam-1; i++) {
            int posMenor = i;
            for(int j = i+1; j < tam; j++) {
                if(array[j] < array[posMenor]) posMenor = j;
                comp++;
            }

            swapIndex(array, i, posMenor);
            mov += 3;
        }

        System.out.println("Selection\nComparações: " + comp + "\nMovimentações: " + mov + "\n");
    }

    //INSERTION - 
    public static void insertion(int[] array, int tam) {

        long comp = 0, mov = 0;

        for(int i = 1; i < tam; i++) {

            int aux = array[i]; mov++;
            int j = i-1;

            while(j >= 0 && array[j] > aux) {
                comp++;
                array[j+1] = array[j]; mov++;
                j--;
            }

            array[j+1] = aux; mov++;
        }
        System.out.println("Insertion\nComparações: " + comp + "\nMovimentações: " + mov + "\n");
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

        mostrar(array, tam);

        //Ordenacao.selection(array, tam);
        //Ordenacao.insertion(array, tam);

        mostrar(array, tam);
    }
}