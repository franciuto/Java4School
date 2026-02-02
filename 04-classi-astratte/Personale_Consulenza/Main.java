public class Main {
    public static void main(String[] args) {
        Progetto progetto = new Progetto("Progetto Test", 2026);

        Dirigente d1 = new Dirigente("D001", "Rossi", "Mario", 2010);
        Funzionario f1 = new Funzionario("F001", "Bianchi", "Luigi", 2020);
        Tecnico t1 = new Tecnico("T001", "Verdi", "Anna", 2018, Tecnico.Area.INFORMATICA_TELECOMUNICAZIONI, true);

        progetto.aggiungiMembro(d1, 50);
        progetto.aggiungiMembro(f1, 100);
        progetto.aggiungiMembro(t1, 150);

        progetto.stampaDettagliCosti();
    }
}
