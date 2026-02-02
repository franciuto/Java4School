public class PushNotifica implements Notifica {
    @Override
    public boolean invia(String messaggio) {
        System.out.println("Push: Invio: " + messaggio);
        return true;
    }
}
