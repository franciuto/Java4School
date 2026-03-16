import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// gestisce la simulazione: turni, ordine dei maghi, fine partita
public class Arena {
    private List<Wizard> wizards;
    private int turno;

    public Arena(List<Wizard> wizards) {
        this.wizards = new ArrayList<>(wizards);
        this.turno = 0;
    }

    // restituisce i maghi ancora vivi, ordinati per velocita decrescente
    public List<Wizard> getAliveWizards() {
        List<Wizard> alive = new ArrayList<>();
        for (Wizard w : wizards) {
            if (w.isAlive())
                alive.add(w);
        }
        alive.sort(Comparator.comparingInt(Wizard::getVelocita).reversed());
        return alive;
    }

    // controlla se la partita e' finita
    public boolean isGameOver() {
        return getAliveWizards().size() <= 1;
    }

    // restituisce il vincitore o null
    public Wizard getWinner() {
        List<Wizard> alive = getAliveWizards();
        if (alive.size() == 1)
            return alive.get(0);
        return null;
    }

    // avanza il contatore dei turni
    public int nextTurn() {
        turno++;
        return turno;
    }

    public int getTurno() {
        return turno;
    }

    public List<Wizard> getWizards() {
        return wizards;
    }
}
