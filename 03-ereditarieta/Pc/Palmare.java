public class Palmare extends Pc {
    private double peso;
    private boolean haInterfacciaWireless;
    private boolean haInterfacciaBluetooth;
    private String tipoEspansioneMemoria;

    public Palmare(String tipoProcessore, int memoriaDiMassa, int ram, String marca, String modello, String sistemaOperativo, double peso, boolean haInterfacciaWireless, boolean haInterfacciaBluetooth, String tipoEspansioneMemoria) {
        super(tipoProcessore, memoriaDiMassa, ram, marca, modello, sistemaOperativo);
        this.peso = peso;
        this.haInterfacciaWireless = haInterfacciaWireless;
        this.haInterfacciaBluetooth = haInterfacciaBluetooth;
        this.tipoEspansioneMemoria = tipoEspansioneMemoria;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isHaInterfacciaWireless() {
        return haInterfacciaWireless;
    }

    public void setHaInterfacciaWireless(boolean haInterfacciaWireless) {
        this.haInterfacciaWireless = haInterfacciaWireless;
    }

    public boolean isHaInterfacciaBluetooth() {
        return haInterfacciaBluetooth;
    }

    public void setHaInterfacciaBluetooth(boolean haInterfacciaBluetooth) {
        this.haInterfacciaBluetooth = haInterfacciaBluetooth;
    }

    public String getTipoEspansioneMemoria() {
        return tipoEspansioneMemoria;
    }

    public void setTipoEspansioneMemoria(String tipoEspansioneMemoria) {
        this.tipoEspansioneMemoria = tipoEspansioneMemoria;
    }

    @Override
    public String toString() {
        return String.format("Palmare: %.2fkg, Wireless: %s, Bluetooth: %s, Espansione: %s, %s", 
                peso, haInterfacciaWireless ? "Si" : "No", haInterfacciaBluetooth ? "Si" : "No", tipoEspansioneMemoria, super.toString());
    }
}
