import java.util.ArrayList;

public class SpeseManager {
    private Spesa[] speseList;

    SpeseManager(Spesa[] spese) {
        this.speseList = spese;
    }

    public double spesaTotale() {
        double result = 0;
        for (Spesa currentSpesa : speseList) {
            result += currentSpesa.getImporto();
        }
        return result;
    }

    public double spesaMedia() {
        return this.spesaTotale() / speseList.length;
    }

    public double spesaMassima() {
        double bigger = speseList[0].getImporto();
        for (Spesa currentSpesa : speseList) {
            if (currentSpesa.getImporto() > bigger) {
                bigger = currentSpesa.getImporto();
            }
        }
        return bigger;
    }

    public double spesaMinima() {
        double smaller = speseList[0].getImporto();
        for (Spesa currentSpesa : speseList) {
            if (currentSpesa.getImporto() < smaller) {
                smaller = currentSpesa.getImporto();
            }
        }
        return smaller;
    }

    private double spesaMediaPerCategoria(String categoria) {
        double somma = 0;
        double elements = 0;
        for (Spesa currentSpesa : speseList) {
            if (currentSpesa.getCategory().equals(categoria)) {
                somma += currentSpesa.getImporto();
                elements += 1;
            }
        }
        return somma / elements;
    }

    public String categoriaSpesaMinore() {
        String categoriaMin = null;
        double mediaMin = Double.POSITIVE_INFINITY;

        for (Spesa s : speseList) {
            String cat = s.getCategory();
            double media = spesaMediaPerCategoria(cat);

            if (media < mediaMin) {
                mediaMin = media;
                categoriaMin = cat;
            }
        }
        return categoriaMin;
    }

}
