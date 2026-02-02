import java.time.LocalDate;

public class Libro extends Pubbliczione {
    private String scrittore;
    private String codiceISBN;

    public Libro(String nome, LocalDate dataRilascio, int quantitaPagine, boolean inUso, String scrittore, String codiceISBN){
        super(nome, dataRilascio, quantitaPagine, inUso);
        this.scrittore = scrittore;
        this.codiceISBN = codiceISBN;
    }

    public String ottieniScrittore() {
        return scrittore;
    }

    public String ottieniCodiceISBN() {
        return codiceISBN;
    }

    public void modificaScrittore(String scrittore) {
        this.scrittore = scrittore;
    }

    public void modificaCodiceISBN(String codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    @Override
    public void impostaScadenzaPrestito() {
        this.scadenzaPrestito = LocalDate.now().plusDays(60);
        this.inUso = true;
    }

    @Override
    public String mostraDettagli() {
        return super.mostraDettagli() + " | Autore: " + scrittore + " | ISBN: " + codiceISBN;
    }

    @Override
    public String toString() {
        return mostraDettagli();
    }
}
