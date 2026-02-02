public class Notebook extends PcPortatili {
    private boolean haWebcam;
    private int risoluzioneMegapixel;

    public Notebook(String tipoProcessore, int memoriaDiMassa, int ram, String marca, String modello, String sistemaOperativo, double peso, double dimensioneDelVideo, boolean haInterfacciaWireless, boolean haWebcam, int risoluzioneMegapixel) {
        super(tipoProcessore, memoriaDiMassa, ram, marca, modello, sistemaOperativo, peso, dimensioneDelVideo, haInterfacciaWireless);
        this.haWebcam = haWebcam;
        this.risoluzioneMegapixel = risoluzioneMegapixel;
    }

    public boolean getHaWebcam() {
        return haWebcam;
    }

    public void setHaWebcam(boolean haWebcam) {
        this.haWebcam = haWebcam;
    }

    public int getRisoluzioneMegapixel() {
        return risoluzioneMegapixel;
    }

    public void setRisoluzioneMegapixel(int risoluzioneMegapixel) {
        this.risoluzioneMegapixel = risoluzioneMegapixel;
    }

    @Override
    public String toString() {
        return String.format("Notebook [Webcam: %s, %dMP] - %s", 
                haWebcam ? "Si" : "No", risoluzioneMegapixel, super.toString());
    }
}
