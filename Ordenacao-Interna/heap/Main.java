// pai (i-1)/2
// filho esq: (i*2) + 1
// filho dir: (i*2) + 2
import java.util.*;

class Main {

    public static void mostrar(int[] arvore, int n) {
        for(int i : arvore) System.out.print(i + " ");
        System.out.println();
    }

    public static boolean temPai(int[] arvore, int pos) {

        if(pos == 0) return false;
        
        int n = arvore.length;
        boolean pai = false;

        if((pos-1)/2 >= 0 && (pos-1)/2 <= n/2) pai = true;

        return pai;
    }

    public static boolean temFilhoEsquerda(int[] arvore, int pos) {

        int n = arvore.length;
        boolean filho = false;

        if((pos*2)+1 > 0 && (pos*2)+1 < n) filho = true;

        return filho;
    }

    public static boolean temFilhoDireita(int[] arvore, int pos) {

        int n = arvore.length;
        boolean filho = false;

        if((pos*2)+2 > 0 && (pos*2)+2 < n) filho = true;

        return filho;
    }

    public static void mostrarElemento(int[] arvore, int i) {

        int n = arvore.length;

        System.out.println("\nElemento: " + arvore[i]);
        
        if(temPai(arvore, i)) System.out.println("Pai: " + arvore[(i-1)/2]);
        else System.out.println("Sem pai(Raiz)");

        if(temFilhoEsquerda(arvore, i)) { 
            System.out.println("Filho esquerda: " + arvore[(i*2)+1]);
            if(temFilhoDireita(arvore, i)) System.out.println("Filho direita: " + arvore[(i*2)+2]);
            else System.out.println("Sem filho direita");
        }
        else System.out.println("Sem Filhos(Folha)");
    }

    public static int pegarElemento(int[] arvore, int elem) {
        int pos = 0;

        for(int i = 0; i < arvore.length; i++) {
            if(arvore[i] == elem) pos = i;
        }

        return pos;
    }

    public static int escolherElemento(int[] arvore, int n) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Escolha um elemento: ");

        boolean elemExiste = false;
        int elem;

        do {

            elem = scan.nextInt();

            for(int i = 0; i < n && !elemExiste; i++) {
                if(elem == arvore[i]) elemExiste = true;
            }
            if(!elemExiste) System.out.println("Erro!\nEscolha um elemento válido: ");

        }while(!elemExiste);

        scan.close();

        return elem;
    }

    public static void main(String[] args) {

        int[] arvore = new int[]{8, 6, 7, 4, 3, 0};
        int n = arvore.length;

        mostrar(arvore, n);

        int elem = escolherElemento(arvore, n);
        
        int pos = pegarElemento(arvore, elem);

        mostrarElemento(arvore, pos);

    }
}