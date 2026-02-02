abstract class Vagone {
    private int codice;
    private double pesoVuoto;
    private String aziendaCostruttrice;
    private int annoCostruzione;

    public Vagone(int codice, double pesoVuoto, String aziendaCostruttrice, int annoCostruzione) {
        this.codice = codice;
        this.pesoVuoto = pesoVuoto;
        this.aziendaCostruttrice = aziendaCostruttrice;
        this.annoCostruzione = annoCostruzione;
    }

    @Override
    public String toString() {
        return "Vagone [codice=" + codice + ", pesoVuoto=" + pesoVuoto + ", aziendaCostruttrice=" + aziendaCostruttrice
                + ", annoCostruzione=" + annoCostruzione + "]";
    }

    public int getCodice() {
        return codice;
    }
    public void setCodice(int codice) {
        this.codice = codice;
    }
    public double getPesoVuoto() {
        return pesoVuoto;
    }
    public void setPesoVuoto(double pesoVuoto) {
        this.pesoVuoto = pesoVuoto;
    }
    public String getAziendaCostruttrice() {
        return aziendaCostruttrice;
    }
    public void setAziendaCostruttrice(String aziendaCostruttrice) {
        this.aziendaCostruttrice = aziendaCostruttrice;
    }
    public int getAnnoCostruzione() {
        return annoCostruzione;
    }
    public void setAnnoCostruzione(int annoCostruzione) {
        this.annoCostruzione = annoCostruzione;
    }

    abstract double getPeso();
    
}
