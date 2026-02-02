public class Pc {
    private String tipoProcessore;
    private int memoriaDiMassa;
    private int ram;
    private String marca;
    private String modello;
    private String sistemaOperativo;

    public Pc(String tipoProcessore, int memoriaDiMassa, int ram, String marca, String modello, String sistemaOperativo) {
        this.tipoProcessore = tipoProcessore;
        this.memoriaDiMassa = memoriaDiMassa;
        this.ram = ram;
        this.marca = marca;
        this.modello = modello;
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getTipoProcessore() {
        return tipoProcessore;
    }

    public void setTipoProcessore(String tipoProcessore) {
        this.tipoProcessore = tipoProcessore;
    }

    public int getMemoriaDiMassa() {
        return memoriaDiMassa;
    }

    public void setMemoriaDiMassa(int memoriaDiMassa) {
        this.memoriaDiMassa = memoriaDiMassa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, RAM: %dGB, Disco: %dGB, SO: %s", 
                marca, modello, tipoProcessore, ram, memoriaDiMassa, sistemaOperativo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Pc pc = (Pc) o;
        if (marca == null || modello == null) return false;
        return marca.equals(pc.marca) && modello.equals(pc.modello);
    }
}
