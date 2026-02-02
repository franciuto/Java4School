import java.time.LocalDate;

public class Rivista extends Pubbliczione {
    private boolean copertinaPatinatata;

    public Rivista(String nome, LocalDate dataRilascio, int quantitaPagine, boolean copertinaPatinatata, boolean inUso) {
        super(nome, dataRilascio, quantitaPagine, inUso);
        this.copertinaPatinatata = copertinaPatinatata;
    }

    public boolean verificaCopertinaPatinatata() {
        return copertinaPatinatata;
    }

    public void modificaCopertinaPatinatata(boolean copertinaPatinatata) {
        this.copertinaPatinatata = copertinaPatinatata;
    }

    @Override
    public void impostaScadenzaPrestito() {
        this.scadenzaPrestito = LocalDate.now().plusDays(30);
        this.inUso = true;
    }

    @Override
    public String mostraDettagli() {
        return super.mostraDettagli() + " | Copertina patinata: " + copertinaPatinatata;
    }

    @Override
    public String toString() {
        return mostraDettagli();
    }
}
