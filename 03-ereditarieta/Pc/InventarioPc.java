import java.util.ArrayList;
import java.util.List;

public class InventarioPc {
    private ArrayList<Pc> pool;

    public InventarioPc() {
        pool = new ArrayList<Pc>();
    }

    public void aggiungiPC(Pc pc) {
        pool.add(pc);
    }

    public boolean rimuoviPC(Pc pc) {
        return pool.remove(pc);
    }

    public List<Pc> cercaPerMarca(String marca) {
        List<Pc> risultato = new ArrayList<Pc>();
        for (int i = 0; i < pool.size(); i++) {
            Pc pc = pool.get(i);
            if (pc.getMarca().equals(marca)) {
                risultato.add(pc);
            }
        }
        return risultato;
    }

    public List<Pc> cercaPerSistemaOperativo(String sistemaOperativo) {
        List<Pc> risultato = new ArrayList<Pc>();
        for (int i = 0; i < pool.size(); i++) {
            Pc pc = pool.get(i);
            if (pc.getSistemaOperativo().equals(sistemaOperativo)) {
                risultato.add(pc);
            }
        }
        return risultato;
    }

    public Pc trovaPCConPiuRAM() {
        if (pool.size() == 0) {
            return null;
        }
        Pc maxPc = pool.get(0);
        for (int i = 1; i < pool.size(); i++) {
            Pc pc = pool.get(i);
            if (pc.getRam() > maxPc.getRam()) {
                maxPc = pc;
            }
        }
        return maxPc;
    }

    public double calcolaMediaRAM() {
        if (pool.size() == 0) {
            return 0.0;
        }
        int somma = 0;
        for (int i = 0; i < pool.size(); i++) {
            somma += pool.get(i).getRam();
        }
        return (double) somma / pool.size();
    }

    public int contaPortatiliConWifi() {
        int conta = 0;
        for (int i = 0; i < pool.size(); i++) {
            Pc pc = pool.get(i);
            if (pc instanceof Notebook) {
                Notebook notebook = (Notebook) pc;
                if (notebook.isHaInterfacciaWireless()) {
                    conta++;
                }
            } else if (pc instanceof Palmare) {
                Palmare palmare = (Palmare) pc;
                if (palmare.isHaInterfacciaWireless()) {
                    conta++;
                }
            }
        }
        return conta;
    }

    public int contaServerConRaid() {
        int conta = 0;
        for (int i = 0; i < pool.size(); i++) {
            Pc pc = pool.get(i);
            if (pc instanceof Server) {
                Server server = (Server) pc;
                if (server.isContainRaidDisks()) {
                    conta++;
                }
            }
        }
        return conta;
    }

    public Notebook trovaNotebookPiuLeggero() {
        Notebook minNotebook = null;
        for (int i = 0; i < pool.size(); i++) {
            Pc pc = pool.get(i);
            if (pc instanceof Notebook) {
                Notebook notebook = (Notebook) pc;
                if (minNotebook == null || notebook.getPeso() < minNotebook.getPeso()) {
                    minNotebook = notebook;
                }
            }
        }
        return minNotebook;
    }

    public List<Pc> cercaPortatili(double pesoMassimo, boolean richiedeWifi) {
        List<Pc> risultato = new ArrayList<Pc>();
        for (int i = 0; i < pool.size(); i++) {
            Pc pc = pool.get(i);
            if (pc instanceof Notebook) {
                Notebook notebook = (Notebook) pc;
                if (notebook.getPeso() <= pesoMassimo) {
                    if (richiedeWifi) {
                        if (notebook.isHaInterfacciaWireless()) {
                            risultato.add(notebook);
                        }
                    } else {
                        risultato.add(notebook);
                    }
                }
            } else if (pc instanceof Palmare) {
                Palmare palmare = (Palmare) pc;
                if (palmare.getPeso() <= pesoMassimo) {
                    if (richiedeWifi) {
                        if (palmare.isHaInterfacciaWireless()) {
                            risultato.add(palmare);
                        }
                    } else {
                        risultato.add(palmare);
                    }
                }
            }
        }
        return risultato;
    }
}
