import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pagabile> arr = new ArrayList<>();
        
        ProdottoSingolo p1 = new ProdottoSingolo(100);
        AbbonamentoMensile a1 =new AbbonamentoMensile(3, 45);

        arr.add(p1);
        arr.add(a1);

        System.err.println(p1.calcolaTotale());
        System.err.println(a1.calcolaTotale());
    }    
}
