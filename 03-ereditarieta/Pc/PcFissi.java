public class PcFissi extends Pc {
    private String tipoDiCase;

    public PcFissi(String tipoProcessore, int memoriaDiMassa, int ram, String marca, String modello, String sistemaOperativo, String tipoDiCase) {
        super(tipoProcessore, memoriaDiMassa, ram, marca, modello, sistemaOperativo);
        this.tipoDiCase = tipoDiCase;
    }

    public String getTipoDiCase() {
        return tipoDiCase;
    }

    public void setTipoDiCase(String tipoDiCase) {
        this.tipoDiCase = tipoDiCase;
    }

    @Override
    public String toString() {
        return String.format("PcFissi [Case: %s] - %s", tipoDiCase, super.toString());
    }
}