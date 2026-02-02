class Lampadina {
    public String colore;
    public int potenza;
    public static int lampadineAccese = 0;

    public Lampadina(String colore, int potenza) {
        this.colore = colore;
        this.potenza = potenza;
        lampadineAccese++;
    }

    @Override
    public String toString() {
        return String.format("\nColore: %s\nPotenza: %s\nLampadine accese: %d", colore, potenza, lampadineAccese)
    }
}