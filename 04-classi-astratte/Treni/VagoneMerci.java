public class VagoneMerci extends Vagone{
    private double volumeDiCarico;
    private double pesoMassimoCarico;
    private double pesoEffettivoCarico;
    
    public VagoneMerci(int codice, double pesoVuoto, String aziendaCostruttrice, int annoCostruzione,
            double volumeDiCarico, double pesoMassimoCarico, double pesoEffettivoCarico) {
        super(codice, pesoVuoto, aziendaCostruttrice, annoCostruzione);
        this.volumeDiCarico = volumeDiCarico;
        this.pesoMassimoCarico = pesoMassimoCarico;
        this.pesoEffettivoCarico = pesoEffettivoCarico;
    }

    @Override
    public String toString() {
        return "VagoneMerci [volumeDiCarico=" + volumeDiCarico + ", pesoMassimoCarico=" + pesoMassimoCarico
                + ", pesoEffettivoCarico=" + pesoEffettivoCarico + "]";
    }
    public double getVolumeDiCarico() {
        return volumeDiCarico;
    }
    public void setVolumeDiCarico(double volumeDiCarico) {
        this.volumeDiCarico = volumeDiCarico;
    }
    public double getPesoMassimoCarico() {
        return pesoMassimoCarico;
    }
    public void setPesoMassimoCarico(double pesoMassimoCarico) {
        this.pesoMassimoCarico = pesoMassimoCarico;
    }
    public double getPesoEffettivoCarico() {
        return pesoEffettivoCarico;
    }
    public void setPesoEffettivoCarico(double pesoEffettivoCarico) {
        this.pesoEffettivoCarico = pesoEffettivoCarico;
    }

    public double getPeso() {
        return getPesoVuoto() + pesoEffettivoCarico;
    }
    
}
