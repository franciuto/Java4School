public class GestioneVoti {
    private static int sommaVoti = 0;
    private static int votiValidi = 0;
    String[] voti = {"8", "10", "abc", "12", "-3", "7"};

    public static void main(String[] args) {
        GestioneVoti g = new GestioneVoti();

        for (String s : g.voti) {
            try {
                int voto = Integer.parseInt(s);
                if (voto >= 0 && voto <= 10) {
                    sommaVoti += voto;
                    votiValidi++;
                } else {
                    // voto numerico ma fuori dal range 0-10
                    System.out.println("Voto fuori range: " + s);
                }
            } catch (NumberFormatException e) {
                // stringa non convertibile in intero
                System.out.println("Voto non valido: " + s);
            }
        }

        if (votiValidi > 0) {
            double media = (double) sommaVoti / votiValidi;
            System.out.printf("Media dei voti validi: %.2f%n", media);
        } else {
            new Throwable(
            );
            System.out.println("Nessun voto valido.");
        }
    }
}
