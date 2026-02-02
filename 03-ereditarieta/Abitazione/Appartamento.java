public class Appartamento extends Abitazione {
    private int piano;
    private boolean raggiungibileAscensore;
    private int numeroTerrazzi;

    public Appartamento(int numeroStanze, double superficie, String città, int piano, boolean raggiungibileAscensore,
            int numeroTerrazzi) {
        super(numeroStanze, superficie, città);
        this.piano = piano;
        this.raggiungibileAscensore = raggiungibileAscensore;
        this.numeroTerrazzi = numeroTerrazzi;
    }

    public int getPiano() {
        return piano;
    }

    public void setPiano(int piano) {
        this.piano = piano;
    }

    public boolean isRaggiungibileAscensore() {
        return raggiungibileAscensore;
    }

    public void setRaggiungibileAscensore(boolean raggiungibileAscensore) {
        this.raggiungibileAscensore = raggiungibileAscensore;
    }

    public int getNumeroTerrazzi() {
        return numeroTerrazzi;
    }

    public void setNumeroTerrazzi(int numeroTerrazzi) {
        this.numeroTerrazzi = numeroTerrazzi;
    }
}