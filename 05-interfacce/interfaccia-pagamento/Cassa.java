public class Cassa {

    public static void main(String[] args) {
        float importo = -0.20f;

        MetodoPagamento[] metodi = new MetodoPagamento[4];
        metodi[0] = new CartaDiCredito();
        metodi[1] = new PayPal();
        metodi[2] = new BuonoRegalo();
        metodi[3] = new Satispay();

        for (MetodoPagamento current_metodo : metodi) {
            try {
                current_metodo.paga(importo);
            
            } catch (Exception e) {
                System.out.println("Errore: " + current_metodo.getClass().getSimpleName() + " - " + e.getMessage());
            }
        }
    }

}