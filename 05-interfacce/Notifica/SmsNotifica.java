public class SmsNotifica implements Notifica {
    @Override
    public boolean invia(String messaggio) {
        System.out.println("SMS: Invio: " + messaggio);
        return true;
    }
}

