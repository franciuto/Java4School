import java.time.LocalDate;

public class Brano {
    private String titolo;
    private String artista;
    private String genere;
    private double durataSec;
    private LocalDate dataUscita;
    private int ascolti;

    public Brano(String titolo, String artista, String genere, double durataSec, LocalDate dataUscita, int ascolti) {
        if (titolo == null || titolo.isEmpty()) {
            throw new IllegalArgumentException("Titolo non valido");
        }

        if (durataSec <= 0) {
            throw new IllegalArgumentException("Durata deve essere > 0");
        }

        if (ascolti < 0) {
            throw new IllegalArgumentException("Ascolti non può essere negativo");
        }

        this.titolo = titolo;
        this.artista = artista;
        this.genere = genere;
        this.durataSec = durataSec;
        this.dataUscita = dataUscita;
        this.ascolti = ascolti;
    }

    // --- Getters ---
    public String getTitolo() {
        return titolo;
    }

    public String getArtista() {
        return artista;
    }

    public String getGenere() {
        return genere;
    }

    public double getDurataSec() {
        return durataSec;
    }

    public LocalDate getDataUscita() {
        return dataUscita;
    }

    public int getAscolti() {
        return ascolti;
    }

    // --- Setters ---
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public void setDurataSec(double durataSec) {
        this.durataSec = durataSec;
    }

    public void setDataUscita(LocalDate dataUscita) {
        this.dataUscita = dataUscita;
    }

    public void setAscolti(int ascolti) {
        this.ascolti = ascolti;
    }

    // Methods
    public void incrementaAscolti() {
        ascolti++;
    }

    @Override
    public String toString() {
        return String.format("Brano: %s\nArtista: %s\nGenere: %s\nDurata: %.2f\nData Uscita: %d/%d/%d\nAscolti: %d",
                titolo, artista, genere, durataSec, dataUscita.getDayOfMonth(), dataUscita.getMonthValue(),
                dataUscita.getYear(), ascolti);
    }
}
