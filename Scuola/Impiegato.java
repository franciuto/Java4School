import java.time.LocalDate;

public class Impiegato extends Dipendente {
    private int livello;

    public Impiegato(String nominativo, Genere genere, LocalDate dataNascita, double stipendioBase, int livello) {
        super(nominativo, genere, dataNascita, stipendioBase);
        this.livello = livello;
    }

    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    @Override
    public double calcolaStipendio() {
        return getStipendioBase();
    }

    @Override
    public String toString() {
        return String.format("Impiegato - %s, Livello: %d", super.toString(), livello);
    }
}
