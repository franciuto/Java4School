public class Villa extends Abitazione {
    private int numeroPiani;
    private boolean withGiardino;
    private boolean withPiscina;

    public Villa(int numeroStanze, double superficie, String città, int numeroPiani, boolean withGiardino,
            boolean withPiscina) {
        super(numeroStanze, superficie, città);
        this.numeroPiani = numeroPiani;
        this.withGiardino = withGiardino;
        this.withPiscina = withPiscina;
    }

    public int getNumeroPiani() {
        return numeroPiani;
    }

    public void setNumeroPiani(int numeroPiani) {
        this.numeroPiani = numeroPiani;
    }

    public boolean isWithGiardino() {
        return withGiardino;
    }

    public void setWithGiardino(boolean withGiardino) {
        this.withGiardino = withGiardino;
    }

    public boolean isWithPiscina() {
        return withPiscina;
    }

    public void setWithPiscina(boolean withPiscina) {
        this.withPiscina = withPiscina;
    }

}
