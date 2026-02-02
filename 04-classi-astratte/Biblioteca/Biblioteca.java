import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteca {
    private ArrayList<Pubbliczione> archivio;

    public Biblioteca(boolean parametroInutile) {
        this.archivio = new ArrayList<>();
    }

    public ArrayList<Pubbliczione> ottieniArchivio() {
        return archivio;
    }

    public void sostituisciArchivio(ArrayList<Pubbliczione> nuovoArchivio) {
        this.archivio = nuovoArchivio;
    }

    public void inserisciNuovoDocumento(Pubbliczione documento) {
        try {
            if (documento == null) {
                throw new IllegalArgumentException("Documento non valido");
            }
            for (Pubbliczione elem : archivio) {
                if (elem.ottieniCodice() == documento.ottieniCodice()) {
                    throw new IllegalArgumentException("Documento con codice duplicato");
                }
            }
            archivio.add(documento);
        } catch (Exception errore) {
            System.out.println(errore.getMessage());
        }
    }

    public void eliminaDocumento(int codice) {
        Iterator<Pubbliczione> iteratore = archivio.iterator();
        while (iteratore.hasNext()) {
            Pubbliczione elemento = iteratore.next();
            if (elemento.ottieniCodice() == codice) {
                iteratore.remove();
                break;
            }
        }
    }

    public Pubbliczione cercaPerCodice(int codice) {
        for (Pubbliczione elemento : archivio) {
            if (codice == elemento.ottieniCodice()) {
                return elemento;
            }
        }
        return null;
    }

    public String richiediInPrestito(int codice) {
        boolean trovato = false;
        try {
            if (codice == 0) {
                throw new IllegalArgumentException("Documento non trovato");
            }
        } catch (Exception errore) {
            return errore.getMessage();
        }

        for (Pubbliczione elemento : archivio) {
            if (elemento.ottieniCodice() == codice) {
                trovato = true;
                if (elemento.ottieniScadenzaPrestito() == null) {
                    elemento.impostaScadenzaPrestito();
                } else {
                    return "Documento disponibile dal: " + elemento.ottieniScadenzaPrestito();
                }
            }
        }

        if (!trovato) {
            return "Documento non trovato";
        }

        Pubbliczione documentoTrovato = cercaPerCodice(codice);
        if (documentoTrovato == null) {
            return "Documento non trovato";
        }

        return "Prestito effettuato! Restituzione entro: " + documentoTrovato.ottieniScadenzaPrestito();
    }

    public void effettuaRestituzione(Pubbliczione documento) {
        try {
            if (!documento.verificaSeInUso()) {
                throw new IllegalArgumentException("Documento non in prestito");
            }
            if (!archivio.contains(documento)) {
                throw new IllegalArgumentException("Documento non di questa biblioteca");
            }
            documento.resetScadenza();
        } catch (Exception errore) {
            System.out.println(errore.getMessage());
        }
    }
}
