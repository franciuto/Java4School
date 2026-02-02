public class Test {
    public static void main(String[] args) {
        Villa v1 = new Villa(3, 120.5, "Roma", 2, true, false);
        System.out.println("Villa v1:\n" + v1);

        Appartamento a1 = new Appartamento(2, 75.0, "Milano", 3, true, 2);
        System.out.println("\nAppartamento a1:\n" + a1);

        // Dettagli specifici delle sottoclassi
        System.out.println("\nDettagli Villa: piani=" + v1.getNumeroPiani() + ", giardino=" + v1.isWithGiardino() + ", piscina=" + v1.isWithPiscina());
        System.out.println("Dettagli Appartamento: piano=" + a1.getPiano() + ", ascensore=" + a1.isRaggiungibileAscensore() + ", terrazzi=" + a1.getNumeroTerrazzi());
    }    
}
