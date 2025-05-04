import java.util.*;

public class Main {
    
    public static void mostrar(int[] arvore) {
        for(int i : arvore) System.out.print(i + " ");
        System.out.println();
    }
    
    public static int pegarPosElemento(int[] arvore, int elem) {
        int pos = 0;

        for(int i = 0; i < arvore.length; i++) {
            if(arvore[i] == elem) pos = i;
        }

        return pos;
    }
    
    public static void mostrarAncestrais(int[] arvore, int elem) {
        
        int i = pegarPosElemento(arvore, elem);
        
        if(i == 0) {
            System.out.println("Sem pai (Raiz)");
            return;
        }

        int ancestral;
        
        do {
            
            ancestral = arvore[(i-1)/2];
            
            System.out.print(ancestral + " ");
            
            i = (i-1)/2;
            
        }while(i > 0);
    }
    
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    
	    int[] arvore = new int[]{4,2,8,7,1,5,3,6};
        int n = arvore.length;
        
        mostrar(arvore);
        
        System.out.print("Elemento: ");
        int elem = scan.nextInt();
        
        System.out.print("Ancestrais: ");
        mostrarAncestrais(arvore, elem);
        System.out.println();
        
        scan.close();
	}
}
