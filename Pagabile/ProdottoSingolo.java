public class ProdottoSingolo implements Pagabile {    

    double prezzo;

    public ProdottoSingolo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double calcolaTotale() {
        return prezzo;
    }

}
