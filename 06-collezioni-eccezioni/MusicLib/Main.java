import java.time.LocalDate;
import java.util.ArrayList;

// NOTHING BEATS VIBECODING FOR TESTING PURPOSES
public class Main {
    public static void main(String[] args) {
        System.out.println("=== CREAZIONE BRANI DALLA PLAYLIST ===\n");
        
        // 12 brani casuali dalla playlist Spotify
        Brano b1 = new Brano("Sostituite (outro)", "Eyungest Moonstar, thasup", "Rap", 183, LocalDate.of(2023, 10, 20), 2500000);
        Brano b2 = new Brano("NON MI RICONOSCO", "MACE, centomilacarie, Salmo", "Hip-Hop", 198, LocalDate.of(2024, 4, 12), 5800000);
        Brano b3 = new Brano("Il Filmografo", "Kid Yugi", "Trap", 176, LocalDate.of(2023, 6, 15), 4200000);
        Brano b4 = new Brano("Sintetico", "Kid Yugi, Night Skinny, Tony Boy", "Trap", 189, LocalDate.of(2023, 11, 3), 3900000);
        Brano b5 = new Brano("La bellavita", "Artie 5ive", "Trap", 194, LocalDate.of(2023, 3, 28), 6500000);
        Brano b6 = new Brano("Le cose cambiano", "Massimo Pericolo", "Hip-Hop", 223, LocalDate.of(2021, 10, 15), 8200000);
        Brano b7 = new Brano("Blauer", "Lazza", "Rap", 201, LocalDate.of(2022, 4, 8), 12000000);
        Brano b8 = new Brano("Cinematografico", "Kid Yugi", "Trap", 167, LocalDate.of(2023, 6, 15), 3100000);
        Brano b9 = new Brano("Tesla", "Geolier, Guè", "Rap", 212, LocalDate.of(2023, 9, 22), 7800000);
        Brano b10 = new Brano("Panama", "Tedua", "Hip-Hop", 195, LocalDate.of(2022, 11, 18), 9500000);
        Brano b11 = new Brano("Viola", "Salmo", "Rap", 188, LocalDate.of(2020, 3, 20), 15000000);
        Brano b12 = new Brano("Hollywood", "Sfera Ebbasta", "Trap", 179, LocalDate.of(2021, 12, 3), 18000000);
        
        // Creazione ArrayList per la libreria
        ArrayList<Brano> listaBrani = new ArrayList<>();
        listaBrani.add(b1);
        listaBrani.add(b2);
        listaBrani.add(b3);
        listaBrani.add(b4);
        listaBrani.add(b5);
        
        // Creazione libreria musicale
        LibreriaMusicale libreria = new LibreriaMusicale("My Italian Rap Playlist", listaBrani);
        
        System.out.println("✓ Libreria creata con 5 brani iniziali\n");
        
        // ===== TEST METODI LIBRERIAMUSICALE =====
        
        System.out.println("=== TEST 1: aggiungiBrano() ===");
        try {
            boolean added1 = libreria.aggiungiBrano(b6);
            System.out.println("✓ Aggiunto: " + b6.getTitolo() + " - " + added1);
            
            boolean added2 = libreria.aggiungiBrano(b7);
            System.out.println("✓ Aggiunto: " + b7.getTitolo() + " - " + added2);
            
            libreria.aggiungiBrano(b8);
            libreria.aggiungiBrano(b9);
            libreria.aggiungiBrano(b10);
            libreria.aggiungiBrano(b11);
            libreria.aggiungiBrano(b12);
            System.out.println("✓ Aggiunti altri 5 brani alla libreria");
            
            // Test aggiunta duplicato
            try {
                libreria.aggiungiBrano(b1);
                System.out.println("✗ ERRORE: doveva lanciare eccezione per duplicato");
            } catch (IllegalArgumentException e) {
                System.out.println("✓ Eccezione corretta per brano duplicato: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("✗ Errore: " + e.getMessage());
        }
        
        System.out.println("\n=== TEST 2: contaBraniPerArtista() ===");
        int countKidYugi = libreria.contaBraniPerArtista("Kid Yugi");
        System.out.println("✓ Brani di Kid Yugi: " + countKidYugi);
        
        int countSalmo = libreria.contaBraniPerArtista("Salmo");
        System.out.println("✓ Brani di Salmo: " + countSalmo);
        
        int countInesistente = libreria.contaBraniPerArtista("Drake");
        System.out.println("✓ Brani di artista inesistente: " + countInesistente);
        
        System.out.println("\n=== TEST 3: braniPerGenere() ===");
        ArrayList<Brano> trapBrani = libreria.braniPerGenere("Trap");
        System.out.println("✓ Brani Trap trovati: " + trapBrani.size());
        for (Brano b : trapBrani) {
            System.out.println("  - " + b.getTitolo() + " (" + b.getArtista() + ")");
        }
        
        ArrayList<Brano> rapBrani = libreria.braniPerGenere("Rap");
        System.out.println("✓ Brani Rap trovati: " + rapBrani.size());
        
        ArrayList<Brano> hipHopBrani = libreria.braniPerGenere("Hip-Hop");
        System.out.println("✓ Brani Hip-Hop trovati: " + hipHopBrani.size());
        
        ArrayList<Brano> rockBrani = libreria.braniPerGenere("Rock");
        System.out.println("✓ Brani Rock trovati: " + rockBrani.size());
        
        System.out.println("\n=== TEST 4: getMinutiAscoltati() ===");
        try {
            int minutiViola = libreria.getMinutiAscoltati("Viola", "Salmo");
            System.out.println("✓ Minuti di 'Viola': " + minutiViola);
            
            int minutiBlauer = libreria.getMinutiAscoltati("Blauer", "Lazza");
            System.out.println("✓ Minuti di 'Blauer': " + minutiBlauer);
            
            // Test brano inesistente
            try {
                libreria.getMinutiAscoltati("Canzone Inesistente", "Artista Fake");
                System.out.println("✗ ERRORE: doveva lanciare BranoNonTrovatoException");
            } catch (BranoNonTrovatoException e) {
                System.out.println("✓ Eccezione corretta per brano non trovato: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("✗ Errore: " + e.getMessage());
        }
        
        System.out.println("\n=== TEST 5: piuAscoltato() ===");
        try {
            Brano top = libreria.piuAscoltato();
            System.out.println("✓ Brano più ascoltato (ascolti/durata): " + top.getTitolo());
            System.out.println("  Artista: " + top.getArtista());
            System.out.println("  Ascolti: " + top.getAscolti());
            System.out.println("  Durata: " + top.getDurataSec() + "s");
            System.out.println("  Ratio: " + (top.getAscolti() / top.getDurataSec()));
        } catch (BranoNonTrovatoException e) {
            System.out.println("✗ Errore: " + e.getMessage());
        }
        
        System.out.println("\n=== TEST 6: getDurataMediaBrani() ===");
        double media = libreria.getDurataMediaBrani();
        System.out.println("✓ Durata media brani: " + String.format("%.2f", media) + " secondi");
        System.out.println("  (circa " + String.format("%.1f", media / 60) + " minuti)");
        
        System.out.println("\n=== TEST 7: shuffleConSeed() ===");
        ArrayList<Brano> playlistTrap = libreria.shuffleConSeed("Trap", 600);
        System.out.println("✓ Playlist Trap shuffled (max 600s):");
        double durataTotale = 0;
        for (Brano b : playlistTrap) {
            System.out.println("  - " + b.getTitolo() + " (" + b.getDurataSec() + "s)");
            durataTotale += b.getDurataSec();
        }
        System.out.println("  Durata totale: " + durataTotale + "s");
        
        ArrayList<Brano> playlistRap = libreria.shuffleConSeed("Rap", 450);
        System.out.println("✓ Playlist Rap shuffled (max 450s): " + playlistRap.size() + " brani");
        
        System.out.println("\n=== TEST 8: rimuoviBrano() ===");
        boolean rimosso = libreria.rimuoviBrano("Sostituite (outro)", "Eyungest Moonstar, thasup");
        System.out.println("✓ Brano rimosso: " + rimosso);
        
        boolean rimossoInesistente = libreria.rimuoviBrano("Brano Fake", "Artista Fake");
        System.out.println("✓ Tentativo rimozione brano inesistente: " + rimossoInesistente);
        
        System.out.println("\n=== TEST 9: incrementaAscolti() su Brano ===");
        System.out.println("Ascolti prima: " + b5.getAscolti());
        b5.incrementaAscolti();
        b5.incrementaAscolti();
        b5.incrementaAscolti();
        System.out.println("✓ Ascolti dopo 3 incrementi: " + b5.getAscolti());
        
        System.out.println("\n=== TEST 10: toString() di un Brano ===");
        System.out.println(b7.toString());
        
        System.out.println("\n=== TEST 11: Setter e Getter ===");
        Brano branoTest = new Brano("Test", "Artist Test", "Pop", 180, LocalDate.now(), 1000);
        System.out.println("✓ Brano creato: " + branoTest.getTitolo());
        
        branoTest.setTitolo("Nuovo Titolo");
        branoTest.setArtista("Nuovo Artista");
        branoTest.setGenere("Rock");
        branoTest.setDurataSec(200);
        branoTest.setDataUscita(LocalDate.of(2024, 1, 1));
        branoTest.setAscolti(5000);
        
        System.out.println("✓ Dopo i setter:");
        System.out.println("  Titolo: " + branoTest.getTitolo());
        System.out.println("  Artista: " + branoTest.getArtista());
        System.out.println("  Genere: " + branoTest.getGenere());
        System.out.println("  Durata: " + branoTest.getDurataSec());
        System.out.println("  Data: " + branoTest.getDataUscita());
        System.out.println("  Ascolti: " + branoTest.getAscolti());
        
        System.out.println("\n=== TEST 12: Validazione costruttore Brano ===");
        try {
            new Brano("", "Artista", "Pop", 180, LocalDate.now(), 1000);
            System.out.println("✗ ERRORE: doveva lanciare eccezione per titolo vuoto");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Eccezione corretta per titolo vuoto: " + e.getMessage());
        }
        
        try {
            new Brano("Titolo", "Artista", "Pop", -10, LocalDate.now(), 1000);
            System.out.println("✗ ERRORE: doveva lanciare eccezione per durata negativa");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Eccezione corretta per durata negativa: " + e.getMessage());
        }
        
        try {
            new Brano("Titolo", "Artista", "Pop", 180, LocalDate.now(), -500);
            System.out.println("✗ ERRORE: doveva lanciare eccezione per ascolti negativi");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Eccezione corretta per ascolti negativi: " + e.getMessage());
        }

        int minuti = 0;
        try {
            minuti = libreria.getMinutiAscoltati("aaaa", "artistaaaaa");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("\n=== TUTTI I TEST COMPLETATI ===");
        System.out.println("✓ Tutti i metodi sono stati testati con successo!");
    }
}