import java.util.ArrayList;
// sarebbe una buona idea aggiungere una classe Assegnazione per eliminare le due liste parallele e semplificare la gestione

public class Progetto {
    private final String nomeProgetto;
    private final ArrayList<Personale> membri;  // lista per membri
    private final ArrayList<Integer> oreAssegnate;  // lista per contenere ore assegnate x membri
    private final int annoCorrente;

    public Progetto(String nomeProgetto, int annoCorrente) {
        this.nomeProgetto = nomeProgetto;
        this.annoCorrente = annoCorrente;
        this.membri = new ArrayList<>();
        this.oreAssegnate = new ArrayList<>();
    }

    public void aggiungiMembro(Personale membro, int ore) {
        this.membri.add(membro);
        this.oreAssegnate.add(ore);
    }

    public double calcolaCostoComplessivo() {
        double costoTotale = 0.0;

        for (int i = 0; i < this.membri.size(); i++) {
            Personale membro = this.membri.get(i);
            double costoOrario = membro.getCostoOrario(this.annoCorrente);
            int ore = this.oreAssegnate.get(i);
            costoTotale += ore * costoOrario;
        }

        return costoTotale;
    }

    public void stampaDettagliCosti() {
        System.out.println("Progetto: " + this.nomeProgetto);
        System.out.println("Anno: " + this.annoCorrente);
        System.out.println();

        double costoTotale = 0.0;

        for (int i = 0; i < this.membri.size(); i++) {
            Personale membro = this.membri.get(i);
            int ore = this.oreAssegnate.get(i);
            double costoOrario = membro.getCostoOrario(this.annoCorrente);
            double costoMembro = ore * costoOrario;

            System.out.println(membro);
            System.out.println("Ore: " + ore);
            System.out.println("Costo orario: " + costoOrario);
            System.out.println("Costo: " + costoMembro);

            costoTotale += costoMembro;
        }

        System.out.println("COSTO totale: " + costoTotale);
    }

    public String getNomeProgetto() {
        return this.nomeProgetto;
    }

    public ArrayList<Personale> getMembri() {
        return this.membri;
    }
}
