public class Main {
    public static void main(String[] args) {
        Autovettura auto = new Autovettura("AB123CD", 1001, "Fiat", "Panda", 1200, 2020, 45.0, 5);
        Furgone furgone = new Furgone("IL789MN", 2001, "Iveco", "Daily", 3000, 2019, 80.0, 1500.0);

        Noleggio n1 = new Noleggio(auto, 3, 200, 10);
        Noleggio n2 = new Noleggio(furgone, 4, 250, 20);

        System.out.println("Autovettura: " + n1.calcolaTotale() + " euro");
        System.out.println("Furgone: " + n2.calcolaTotale() + " euro");
    }
}
