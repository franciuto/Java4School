public class Autovettura extends Veicolo {
    private int numeriPosti;

    public Autovettura(String targa, int numeroMatricola, String marca, String modello, int cilindrata,
            int annoAcquisto, double capacitaSerbatoio, int numeriPosti) {
        super(targa, numeroMatricola, marca, modello, cilindrata, annoAcquisto, capacitaSerbatoio);
        this.numeriPosti = numeriPosti;
    }

    @Override
    public String toString() {
        return super.toString() + "Autovettura [numeriPosti=" + numeriPosti + "]";
    }

    public int getNumeriPosti() {
        return numeriPosti;
    }

    public void setNumeriPosti(int numeriPosti) {
        this.numeriPosti = numeriPosti;
    }

    public double calcolaCosto(int giorni, double km, double litriMancanti) {
        double costo = 0;
        costo += giorni * 50;
        costo += (km / 25.0);
        costo += litriMancanti * 2;
        return costo;
    }

}
