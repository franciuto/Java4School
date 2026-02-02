public class GestoreNotifiche {
    public static void main(String[] args) {

        int test = Integer.parseInt(args[0]);

        if (test == 1) {
            Notifica notifica;

            notifica = new EmailNotifica();
            notifica.invia("auraaa");

            notifica = new SmsNotifica();
            notifica.invia("auraaa");

            notifica = new PushNotifica();
            notifica.invia("auraaa");
        } else if (test == 2) {
            Notifica[] canali = new Notifica[5];
            canali[0] = new EmailNotifica();
            canali[1] = new SmsNotifica();
            canali[2] = new PushNotifica();
            canali[3] = new IoTNotifica();
            canali[4] = new FaxNotifica();

            for (Notifica currentMetodo : canali) {
                boolean status = currentMetodo.invia("hello world!");
                try {
                    if (!status) {
                        throw new NotificationErrorException("Errore invio notifica: " + currentMetodo.getClass().getSimpleName());
                    }
                } catch (NotificationErrorException e) {
                    System.out.println("Errore: " + e.getMessage());
                }
            }
        }
    }
}
