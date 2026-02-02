import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Libro volume1 = new Libro("Il Signore degli Anelli", LocalDate.of(1954, 7, 29), 1216, false, "J.R.R. Tolkien", "978-0261102385");
        Rivista periodico1 = new Rivista("National Geographic", LocalDate.of(2023, 5, 1), 100, true, false);

        Biblioteca sistemaBibliotecario = new Biblioteca(false);
        sistemaBibliotecario.inserisciNuovoDocumento(volume1);
        sistemaBibliotecario.inserisciNuovoDocumento(periodico1);

        System.out.println("Contenuto archivio:");
        for (Pubbliczione item : sistemaBibliotecario.ottieniArchivio()) {
            System.out.println(item);
        }

        System.out.println("\n" + sistemaBibliotecario.richiediInPrestito(volume1.ottieniCodice()));
        System.out.println("\nDopo il prestito:");
        for (Pubbliczione item : sistemaBibliotecario.ottieniArchivio()) {
            System.out.println(item);
        }

        sistemaBibliotecario.effettuaRestituzione(volume1);
        System.out.println("\nDopo la restituzione:");
        for (Pubbliczione item : sistemaBibliotecario.ottieniArchivio()) {
            System.out.println(item);
        }
    }
}
