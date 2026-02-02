public class Noleggio {
    private Veicolo veicolo;
    private int giorni;
    private double kmPercorsi;
    private double litriMancanti;

    public Noleggio(Veicolo veicolo, int giorni, double kmPercorsi, double litriMancanti) {
        this.veicolo = veicolo;
        this.giorni = giorni;
        this.kmPercorsi = kmPercorsi;
        this.litriMancanti = litriMancanti;
    }

    public double calcolaTotale() {
        return veicolo.calcolaCosto(giorni, kmPercorsi, litriMancanti);
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public int getGiorni() {
        return giorni;
    }

    public void setGiorni(int giorni) {
        this.giorni = giorni;
    }

    public double getKmPercorsi() {
        return kmPercorsi;
    }

    public void setKmPercorsi(double kmPercorsi) {
        this.kmPercorsi = kmPercorsi;
    }

    public double getLitriMancanti() {
        return litriMancanti;
    }

    public void setLitriMancanti(double litriMancanti) {
        this.litriMancanti = litriMancanti;
    }

    @Override
    public String toString() {
        return "Noleggio [veicolo=" + veicolo + ", giorni=" + giorni + ", kmPercorsi=" + kmPercorsi + ", litriMancanti="
                + litriMancanti + "]";
    }
}
