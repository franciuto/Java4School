import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LibreriaMusicale {
    private String titolo;
    private ArrayList<Brano> libreria;

    public LibreriaMusicale(String titolo, ArrayList<Brano> libreria) {
        if (titolo == null || titolo.isEmpty()) {
            throw new IllegalArgumentException("Parametro titolo non valido");
        }
        if (libreria == null || libreria.isEmpty()) {
            throw new IllegalArgumentException("Parametro libreria non valido o vuoto");
        }
        this.titolo = titolo;
        this.libreria = libreria;
    }

    public boolean aggiungiBrano(Brano b) {
        if (!libreria.contains(b)) {
            return libreria.add(b);
        } else {
            throw new IllegalArgumentException("Brano già presente nella libreria");
        }
    }

    public boolean rimuoviBrano(String titolo, String artista) {
        return libreria.removeIf(b -> b.getTitolo().equalsIgnoreCase(titolo)
                && b.getArtista().equalsIgnoreCase(artista));
    }

    public int getMinutiAscoltati(String titolo, String artista) {
        String t = titolo.toLowerCase();
        String a = artista.toLowerCase();

        for (Brano b : libreria) {
            if (b.getTitolo().toLowerCase().equals(t) &&
            b.getArtista().equalsIgnoreCase(a)) {

                return (int) (b.getDurataSec() / 60);
            }
        }
        throw new BranoNonTrovatoException(String.format("Il brano %s con autore %s non è nella libreria", titolo, artista));
        
    }

    public ArrayList<Brano> braniPerGenere(String genere) {
        if (genere == null || genere.isEmpty()) {
            throw new IllegalArgumentException("Parametro genere non valido");
        }

        ArrayList<Brano> result = new ArrayList<>();
        for (Brano b : libreria) {
            String g = b.getGenere();
            if (g != null && g.equalsIgnoreCase(genere)) {
                result.add(b);
            }
        }
        return result;
    }

    public int contaBraniPerArtista(String artista) {

        if (artista == null || artista.isEmpty()) {
            throw new IllegalArgumentException("Parametro artista non valido");
        }
        int braniPerArtista = 0;
        for (Brano b : libreria) {
            if (b.getArtista().equalsIgnoreCase(artista)) {
                braniPerArtista++;
            }
        }
        return braniPerArtista;
    }

    public Brano piuAscoltato() {
        if (libreria == null || libreria.isEmpty()) {
            throw new BranoNonTrovatoException("Nessun brano nella libreria");
        }

        Brano best = null;
        double bestMetric = -1.0;

        for (Brano b : libreria) {
            if (b == null)
                continue;
            double durata = b.getDurataSec();
            int ascolti = b.getAscolti();
            if (durata <= 0) {
                continue;
            }
            double metric = ascolti / durata;
            if (metric > bestMetric) {
                bestMetric = metric;
                best = b;
            }
        }

        if (best == null) {
            throw new BranoNonTrovatoException("Nessun brano valido nella libreria");
        }
        return best;
    }

    public ArrayList<Brano> shuffleConSeed(String genere, int durataMax) {
        ArrayList<Brano> genereSort = braniPerGenere(genere);
        int durataEffettiva = 0;
        ArrayList<Brano> result = new ArrayList<>();

        for (Brano b : genereSort) {
            if (durataEffettiva + b.getDurataSec() <= durataMax) {
                durataEffettiva += b.getDurataSec();
                result.add(b);
            }
        }

        long seed = new Random().nextLong();
        Random random = new Random(seed);

        Collections.shuffle(result, random);
        return result;
    }

    public double getDurataMediaBrani() {
        int sum = 0;
        for (Brano b : libreria) {
            sum += b.getDurataSec();
        }
        
        return sum / libreria.size();
    }

}
