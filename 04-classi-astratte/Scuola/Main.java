import java.time.LocalDate;

public class Main {

    Docente paganuzzi = new Docente("Alberto Paganuzzi", Genere.MASCHIO, LocalDate.of(1978, 5, 12), 1850.50, 18);
    Docente cafferata = new Docente("Carlo Cafferata", Genere.MASCHIO, LocalDate.of(1965, 9, 23), 2100.75, 20);
    Docente vescovi = new Docente("Orienzo Vescovi", Genere.MASCHIO, LocalDate.of(1972, 3, 8), 1920.00, 16);
    Docente evangelista = new Docente("Claudio Evangelista", Genere.MASCHIO, LocalDate.of(1980, 11, 15), 1800.25, 19);
    Docente mercuri = new Docente("Maurizio Mercuri", Genere.MASCHIO, LocalDate.of(1968, 7, 30), 2050.00, 22);
    Docente prandi = new Docente("Cristina Prandi", Genere.FEMMINA, LocalDate.of(1975, 2, 18), 1900.00, 17);
    Docente ugolotti = new Docente("Ramon Ugolotti", Genere.MASCHIO, LocalDate.of(1982, 6, 5), 1750.50, 18);
    Docente granelli = new Docente("Rossella Granelli", Genere.FEMMINA, LocalDate.of(1976, 4, 9), 1950.75, 19);
    Docente distefano = new Docente("Mariacinzia Di Stefano", Genere.FEMMINA, LocalDate.of(1983, 8, 14), 1700.00, 15);
    Docente franciosi = new Docente("Monica Franciosi", Genere.FEMMINA, LocalDate.of(1969, 10, 27), 2150.00, 21);
    Docente romano = new Docente("Silvana Romano", Genere.FEMMINA, LocalDate.of(1973, 1, 11), 1880.00, 18);
    Docente cesarano = new Docente("Ugo Cesarano", Genere.MASCHIO, LocalDate.of(1979, 5, 3), 1820.50, 17);
    Docente folli = new Docente("Danilo Folli", Genere.MASCHIO, LocalDate.of(1977, 9, 19), 1950.00, 20);

    ImpiegatoStraordinari segretaria = new ImpiegatoStraordinari("Maria Bianchi", Genere.FEMMINA, LocalDate.of(1985, 3, 15), 1450.00, 5, 12);
    Impiegato ata1 = new Impiegato("Giuseppe Verdi", Genere.MASCHIO, LocalDate.of(1980, 7, 21), 1350.00, 3);
    Impiegato ata2 = new Impiegato("Anna Ferrari", Genere.FEMMINA, LocalDate.of(1988, 11, 9), 1320.00, 2);
    Impiegato ata3 = new Impiegato("Paolo Colombo", Genere.MASCHIO, LocalDate.of(1975, 4, 18), 1400.00, 4);

    public static void main(String[] args) {
        System.out.println("=== TEST DOCENTE ===");
        Docente doc = new Docente("Alberto Paganuzzi", Genere.MASCHIO, LocalDate.of(1978, 5, 12), 1850.50, 18);
        System.out.println(doc.toString());
        System.out.println("Nominativo: " + doc.getNominativo());
        System.out.println("Genere: " + doc.getGenere());
        System.out.println("Data Nascita: " + doc.getDataNascita());
        System.out.println("Stipendio Base: " + doc.getStipendioBase());
        System.out.println("Ore Docenza: " + doc.getOreDocenza());
        System.out.println("Stipendio Calcolato: " + doc.calcolaStipendio());

        System.out.println("\n=== TEST SETTER DOCENTE ===");
        doc.setNominativo("Carlo Cafferata");
        doc.setGenere(Genere.MASCHIO);
        doc.setDataNascita(LocalDate.of(1965, 9, 23));
        doc.setStipendioBase(2100.75);
        System.out.println(doc);

        System.out.println("\n=== TEST IMPIEGATO ===");
        Impiegato imp = new Impiegato("Giuseppe Verdi", Genere.MASCHIO, LocalDate.of(1980, 7, 21), 1350.00, 3);
        System.out.println(imp.toString());
        System.out.println("Livello: " + imp.getLivello());
        System.out.println("Stipendio Calcolato: " + imp.calcolaStipendio());
        imp.setLivello(4);
        System.out.println("Nuovo Livello: " + imp.getLivello());

        System.out.println("\n=== TEST IMPIEGATO STRAORDINARI ===");
        ImpiegatoStraordinari impStr = new ImpiegatoStraordinari("Maria Bianchi", Genere.FEMMINA, LocalDate.of(1985, 3, 15), 1450.00, 5, 12);
        System.out.println(impStr.toString());
        System.out.println("Ore Straordinari Mensili: " + impStr.getOreStraordinariMensili());
        System.out.println("Stipendio Calcolato: " + impStr.calcolaStipendio());
        System.out.println("Livello: " + impStr.getLivello());
    }
}