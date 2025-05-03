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

//-------------------Quicksort com duas funções-------------------
//A ordenação é feita somente por uma, a outra apenas chama ela uma vez
    public void quick(int[] array, int inicio, int fim) {

        int i = inicio, f = fim;
        int pivo = array[(inicio+fim)/2];   this.mov++;

        while(i <= f) {

            while(i <= fim && array[i] < pivo) { i++; this.comp++;}
            while(f >= inicio && array[f] > pivo) { f--; this.comp++;}

            if(i <= f) {
                swap(array, i, f);  this.mov += 3;
                i++;
                f--;
            }
        }

        if(i < fim) quick(array, i, fim);
        if(f > inicio) quick(array, inicio, f);
    }

    public void quicksort(int[] array, int n) {
        quick(array, 0, n-1);
    }


//-------------------Quicksort com pivô no início-------------------
    public void quicksortInicio(int[] array, int inicio, int fim) {

        int i = inicio+1, f = fim;
        int pivo = array[inicio];   this.mov++;

        while(i <= f) {

            while(i <= fim && array[i] < pivo) { i++; this.comp++;}
            while(f >= inicio && array[f] > pivo) { f--; this.comp++;}

            if(i <= f) {
                swap(array, i, f);  this.mov += 3;
                i++;
                f--;
            }
        }

        swap(array, inicio, f);

        if(i < fim) quicksortInicio(array, i, fim);
        if(f > inicio) quicksortInicio(array, inicio, f);
    }

//-------------------Quicksort com pivô no Último-------------------
    public void quicksortFim(int[] array, int inicio, int fim) {

        int i = inicio, f = fim-1;
        int pivo = array[fim];   this.mov++;

        while(i <= f) {

            while(i <= fim && array[i] < pivo) { i++; this.comp++;}
            while(f >= inicio && array[f] > pivo) { f--; this.comp++;}

            if(i <= f) {
                swap(array, i, f);  this.mov += 3;
                i++;
                f--;
            }
        }

        swap(array, i, fim);

        if(i < fim) quicksortFim(array, i, fim);
        if(f > inicio) quicksortFim(array, inicio, f);
    }

//----------------Quicksort pivô Mediana-----------------------
    public int mediana(int a, int b, int c) {
        int med = a;

        if(a > b && a > c) {
            if(b > c) med = b;
            else med = c;
        }
        else if(b > a && b > c) {
            if(a > c) med = a;
            else med = c;
        }
        else if(c > a && c > b) {
            if(a > b) med = a;
            else med = b;
        }

        return med;
    }

    public void quicksortMed(int[] array, int inicio, int fim) {

        int i = inicio, f = fim, med = mediana(array[inicio], array[(inicio+fim)/2], array[fim]);
        int pivo = array[med];   this.mov++;

        while(i <= f) {

            while(i <= fim && array[i] < pivo) { i++; this.comp++;}
            while(f >= inicio && array[f] > pivo) { f--; this.comp++;}

            if(i <= f) {
                swap(array, i, f);  this.mov += 3;
                i++;
                f--;
            }
        }

        if(i < fim) quicksortMed(array, i, fim);
        if(f > inicio) quicksortMed(array, inicio, f);
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

        //int[] array = new int[]{5,2,9,7,3,8,1,4,0,6};     //arquivo desordenado
        //int[] array = new int[]{0,1,2,3,4,5,6,7,8,9};     //arquivo ordenado
        //int[] array = new int[]{9,8,7,6,5,4,3,2,1,0};     //arquivo decrescente
        //int[] array = new int[]{5,2,9,7,0,8,1,4,3,6};     //pivo menor
        //int[] array = new int[]{5,2,0,7,9,8,1,4,3,6};     //pivo maior

        int n = array.length;

        mostrar(array, n);

        Quicksort quick = new Quicksort();


        quick.quicksort(array, n);
        System.out.println("Quicksort \nComparações: " + quick.getComp() + "\nMovimentações: " + quick.getMov() + "\n");

        //quick.quicksortInicio(array, 0, n-1);
        //System.out.println("Quicksort - pivô Mediana\nComparações: " + quick.getComp() + "\nMovimentações: " + quick.getMov() + "\n");

        //quick.quicksortInicio(array, 0, n-1);
        //System.out.println("Quicksort - pivô no inicio\nComparações: " + quick.getComp() + "\nMovimentações: " + quick.getMov() + "\n");
        
        //quick.quicksortFim(array, 0, n-1);
        //System.out.println("Quicksort - pivô no fim\nComparações: " + quick.getComp() + "\nMovimentações: " + quick.getMov() + "\n");
        
        mostrar(array, n);
    }
}