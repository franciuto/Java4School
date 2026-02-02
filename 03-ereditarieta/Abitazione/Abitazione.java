public class Abitazione {
    private int numeroStanze;
    private double superficie;
    private String città;

    public Abitazione(int numeroStanze, double superficie, String città) {
        this.numeroStanze = numeroStanze;
        this.superficie = superficie;
        this.città = città;
    }

    public int getNumeroStanze() {
        return numeroStanze;
    }

    public void setNumeroStanze(int numeroStanze) {
        this.numeroStanze = numeroStanze;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }
    
    @Override
    public String toString () {
        return String.format("Numero stanze: %s\nSuperficie: %.2f\nCittà: %s", numeroStanze, superficie, città);
    }

}
