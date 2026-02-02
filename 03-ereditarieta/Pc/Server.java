public class Server extends PcFissi {
    private int numeroProcessori;
    private boolean containRaidDisks;

    public Server(String tipoProcessore, int memoriaDiMassa, int ram, String marca, String modello, String sistemaOperativo, String tipoDiCase, int numeroProcessori, boolean containRaidDisks) {
        super(tipoProcessore, memoriaDiMassa, ram, marca, modello, sistemaOperativo, tipoDiCase);
        this.numeroProcessori = numeroProcessori;
        this.containRaidDisks = containRaidDisks;
    }

    public int getNumeroProcessori() {
        return numeroProcessori;
    }

    public void setNumeroProcessori(int numeroProcessori) {
        this.numeroProcessori = numeroProcessori;
    }

    public boolean isContainRaidDisks() {
        return containRaidDisks;
    }

    public void setContainRaidDisks(boolean containRaidDisks) {
        this.containRaidDisks = containRaidDisks;
    }

    @Override
    public String toString() {
        return String.format("Server [%d CPU, RAID: %s] - %s", 
                numeroProcessori, containRaidDisks ? "Si" : "No", super.toString());
    }
}
