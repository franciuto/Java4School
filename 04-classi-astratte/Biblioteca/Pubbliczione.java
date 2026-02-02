import java.time.LocalDate;

public abstract class Pubbliczione {
    protected String nome;
    protected int codice;
    protected LocalDate dataRilascio;
    protected LocalDate scadenzaPrestito;
    protected boolean inUso;
    protected int quantitaPagine;
    private static int contatore = 0;

    public Pubbliczione(String nome, LocalDate dataRilascio, int quantitaPagine, boolean inUso) {
        this.nome = nome;
        this.codice = ++contatore;
        this.dataRilascio = dataRilascio;
        this.quantitaPagine = quantitaPagine;
        this.inUso = inUso;
        this.scadenzaPrestito = null;
    }

    public String ottieniNome() {
        return nome;
    }

    public int ottieniCodice() {
        return codice;
    }

    public LocalDate ottieniDataRilascio() {
        return dataRilascio;
    }

    public int ottieniQuantitaPagine() {
        return quantitaPagine;
    }

    public LocalDate ottieniScadenzaPrestito() {
        return scadenzaPrestito;
    }

    public boolean verificaSeInUso() {
        return inUso;
    }

    public void modificaNome(String nome) {
        this.nome = nome;
    }

    public void modificaCodice(int codice) {
        this.codice = codice;
    }

    public void modificaDataRilascio(LocalDate dataRilascio) {
        this.dataRilascio = dataRilascio;
    }

    public void modificaQuantitaPagine(int quantitaPagine) {
        this.quantitaPagine = quantitaPagine;
    }

    public abstract void impostaScadenzaPrestito();

    public void resetScadenza() {
        this.scadenzaPrestito = null;
        this.inUso = false;
    }

    public String mostraDettagli() {
        StringBuilder sb = new StringBuilder();
        sb.append("Opera: ").append(nome);
        sb.append(" | Codice: ").append(codice);
        sb.append(" | Data: ").append(dataRilascio);
        sb.append(" | Pagine: ").append(quantitaPagine);
        sb.append(" | In prestito: ").append(inUso);
        sb.append(" | Scadenza: ").append(scadenzaPrestito);
        return sb.toString();
    }

    @Override
    public String toString() {
        return mostraDettagli();
    }
}