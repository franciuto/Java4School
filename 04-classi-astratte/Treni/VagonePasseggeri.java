public class VagonePasseggeri extends Vagone {
    private char classe;
    private int nPostiDisponibili;
    private int numeroPostiOccupati;
    private double pesoMedioPasseggeri = 65;

    public VagonePasseggeri(int codice, double pesoVuoto, String aziendaCostruttrice, int annoCostruzione, char classe,
            int nPostiDisponibili, int numeroPostiOccupati) {
        super(codice, pesoVuoto, aziendaCostruttrice, annoCostruzione);
        this.classe = classe;
        this.nPostiDisponibili = nPostiDisponibili;
        this.numeroPostiOccupati = numeroPostiOccupati;

    }

    @Override
    public String toString() {
        return "VagonePasseggeri [classe=" + classe + ", nPostiDisponibili=" + nPostiDisponibili
                + ", numeroPostiOccupati=" + numeroPostiOccupati + "]";
    }
    public char getClasse() {
        return classe;
    }
    public void setClasse(char classe) {
        this.classe = classe;
    }
    public int getnPostiDisponibili() {
        return nPostiDisponibili;
    }
    public void setnPostiDisponibili(int nPostiDisponibili) {
        this.nPostiDisponibili = nPostiDisponibili;
    }
    public int getNumeroPostiOccupati() {
        return numeroPostiOccupati;
    }
    public void setNumeroPostiOccupati(int numeroPostiOccupati) {
        this.numeroPostiOccupati = numeroPostiOccupati;
    }

    public double getPesoMedioPasseggeri() {
        return pesoMedioPasseggeri;
    }

    public void setPesoMedioPasseggeri(double peso) {
        pesoMedioPasseggeri = peso;
    }

    public double getPeso() {
        return getPesoVuoto() + numeroPostiOccupati * pesoMedioPasseggeri;
    }
    
}
