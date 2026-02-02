public class Main {
    public static void main(String[] args) {
        Persona p = new Persona("RSSMRA80A01H501U", "Marco", "Romanici");
        System.out.println("Persona:\n" + p);

        Studente s = new Studente("RSSSTU01A23H501X", "Luca", "Bianchi", "S123456", "Universita degli Studi");
        System.out.println("\nStudente:\n" + s);

        Docente d = new Docente("CNNTRN70C03H501X", "Anna", "Verdi", "Matematica", 2500.50);
        System.out.println("\nDocente:\n" + d);
    }
}
