public class Furgone extends Veicolo {
    private double capacitaCarico;

    public Furgone(String targa, int numeroMatricola, String marca, String modello, int cilindrata, int annoAcquisto,
            double capacitàSerbatoio, double capacitaCarico) {
        super(targa, numeroMatricola, marca, modello, cilindrata, annoAcquisto, capacitàSerbatoio);
        this.capacitaCarico = capacitaCarico;
    }

    @Override
    public String toString() {
        return super.toString() + "Furgone [capacitaCarico=" + capacitaCarico + "]";
    }

    public double getcapacitaCarico() {
        return capacitaCarico;
    }

    public void setcapacitaCarico(double capacitaCarico) {
        this.capacitaCarico = capacitaCarico;
    }

    public double calcolaCosto(int giorni, double km, double litriMancanti) {
        double costo = 0;
        costo += giorni * 70;
        if (km > 100) {
            double kmExtra = km - 100;
            costo += (kmExtra / 30.0);
        }
        costo += litriMancanti * 2;
        return costo;

    }

}
