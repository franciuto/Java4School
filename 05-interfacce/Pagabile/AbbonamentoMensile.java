public class AbbonamentoMensile implements Pagabile {
    
    double prezzo;
    int mesi;

    public AbbonamentoMensile(double prezzo,int mesi) {
        this.prezzo = prezzo;
        this.mesi = mesi;
    }

    public double calcolaTotale () {
        return prezzo;
    }
}
