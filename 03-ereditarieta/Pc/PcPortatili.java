public class PcPortatili extends Pc {
    private double peso;
    private double dimensioneDelVideo;
    private boolean haInterfacciaWireless;

    public PcPortatili(String tipoProcessore, int memoriaDiMassa, int ram, String marca, String modello, String sistemaOperativo, double peso, double dimensioneDelVideo, boolean haInterfacciaWireless) {
        super(tipoProcessore, memoriaDiMassa, ram, marca, modello, sistemaOperativo);
        this.peso = peso;
        this.dimensioneDelVideo = dimensioneDelVideo;
        this.haInterfacciaWireless = haInterfacciaWireless;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getDimensioneDelVideo() {
        return dimensioneDelVideo;
    }

    public void setDimensioneDelVideo(double dimensioneDelVideo) {
        this.dimensioneDelVideo = dimensioneDelVideo;
    }

    public boolean isHaInterfacciaWireless() {
        return haInterfacciaWireless;
    }

    public void setHaInterfacciaWireless(boolean haInterfacciaWireless) {
        this.haInterfacciaWireless = haInterfacciaWireless;
    }

    @Override
    public String toString() {
        return String.format("PcPortatili: %.2fkg, Video: %.1f\", Wireless: %s, %s", 
                peso, dimensioneDelVideo, haInterfacciaWireless ? "Si" : "No", super.toString());
    }
}
