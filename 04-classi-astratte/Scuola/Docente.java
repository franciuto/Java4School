import java.time.LocalDate;

public class Docente extends Dipendente {
    private int oreDocenza;

    public Docente(String nominativo, Genere genere, LocalDate dataNascita, double stipendioBase, int oreDocenza) {
        super(nominativo, genere, dataNascita, stipendioBase);
        this.oreDocenza = oreDocenza;
    }

    public int getOreDocenza() {
        return oreDocenza;
    }

    @Override
    public double calcolaStipendio() {
        return getStipendioBase();
    }

    @Override
    public String toString() {
        return String.format("Docente - %s, Ore Docenza: %d", super.toString(), oreDocenza);
    }
}
