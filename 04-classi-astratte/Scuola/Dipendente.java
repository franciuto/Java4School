import java.time.LocalDate;

public abstract class Dipendente {
    private String nominativo;
    private Genere genere;
    private LocalDate dataNascita;
    private double stipendioBase;

    public Dipendente(String nominativo, Genere genere, LocalDate dataNascita, double stipendioBase) {
        this.nominativo = nominativo;
        this.genere = genere;
        this.dataNascita = dataNascita;
        this.stipendioBase = stipendioBase;
    }

    public abstract double calcolaStipendio();

    // GETTERS
    public String getNominativo() {
        return nominativo;
    }

    public Genere getGenere() {
        return genere;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public double getStipendioBase() {
        return stipendioBase;
    }
    
    // SETTERS
    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setStipendioBase(double stipendioBase) {
        this.stipendioBase = stipendioBase;
    }

    @Override
    public String toString() {
        return String.format("Nominativo: %s, Genere: %s, Data Nascita: %s, Stipendio Base: %.2f",
                             nominativo, genere, dataNascita, stipendioBase);
    }
}
