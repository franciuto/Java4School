import java.time.LocalDate;

public class ImpiegatoStraordinari extends Impiegato {
    private int oreStraordinariMensili;
    private static final double EXTRA = 15.0;

    public ImpiegatoStraordinari(String nominativo, Genere genere, LocalDate dataNascita, double stipendioBase,
            int livello, int oreStraordinariMensili) {
        super(nominativo, genere, dataNascita, stipendioBase, livello);
        this.oreStraordinariMensili = oreStraordinariMensili;
    }

    public int getOreStraordinariMensili() {
        return oreStraordinariMensili;
    }

    @Override
    public double calcolaStipendio() {
        return getStipendioBase() + (oreStraordinariMensili * EXTRA);
    }

    @Override
    public String toString() {
        return String.format("ImpiegatoStraordinari - %s, Ore Straordinari: %d", super.toString(), oreStraordinariMensili);
    }
}

