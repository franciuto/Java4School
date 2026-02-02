// Translate to english
public class Quadrato {
    private Punto centro;
    private double lato;
    private double angoloRotazione;

    // Costruttore
    Quadrato(Punto centro, double lato, double angoloRotazione) {
        this.centro = centro;
        this.lato = lato;
        this.angoloRotazione = angoloRotazione;
    }

    // -------- Getters --------
    public Punto getCentro () {
        return centro;
    }

    public double getLato () {
        return lato;
    }

    public double getangoloRotazione () {
        return angoloRotazione;
    }   
    // --------------------------

    // -------- Setter --------
    public void setCentro (Punto centro) {
        this.centro = centro;
    }

    public void setLato (double lato) {
        this.lato = lato;
    }

    public void setangoloRotazione (double angoloRotazione) {
        this.angoloRotazione = angoloRotazione;
    }
    // --------------------------

    // -------- Methods --------

    /**
     * Calcola l'area del quadrato
     * @return (double) lato ^ 2
     */
    public double area () {
        return Math.pow(lato, 2);
    }

    /**
     * Calcola il perimetro del quadrato
     * @return (double) lato * 4
     */
    public double perimetro() {
        return lato * 4;
    }

    /**
     * Calcola le coordinate del punto 
     * @return Nuovo oggetto punto con coordinate del punto A
     */
    public Punto getVerticeA () {
        return new Punto(centro.getX() - this.lato/2,centro.getY() + this.lato/2);
    }

    public Punto getVerticeB () {
        return new Punto(centro.getX() + this.lato/2,centro.getY() + this.lato/2);
    }

    public Punto getVerticeC () {
        return new Punto(centro.getX() - this.lato/2,centro.getY() - this.lato/2);
    }

    public Punto getVerticeD () {
        return new Punto(centro.getX() + this.lato/2,centro.getY() - this.lato/2);
    }

    @Override
    public String toString() {
        return String.format("-------------\nCentro: %.2f, %.2f\nAngolo rotazione: %.2f\nLato: %.2f\nVertice A: %.2f, %.2f\nVertice B: %.2f, %.2f\nVertice C: %.2f, %.2f\nVertice D: %.2f, %.2f\n-------------", 
            centro.getX(), centro.getY(), angoloRotazione, lato, 
            getVerticeA().getX(), getVerticeA().getY(), 
            getVerticeB().getX(), getVerticeB().getY(),
            getVerticeC().getX(), getVerticeC().getY(),
            getVerticeD().getX(), getVerticeD().getY());
    }

    public static void main(String[] args) {
        Quadrato q1 = new Quadrato(new Punto(4,6), 4, 0);

        System.out.println(q1.toString());
    }
}
