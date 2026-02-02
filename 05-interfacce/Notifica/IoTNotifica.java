public class IoTNotifica implements Notifica {
    @Override
    public boolean invia(String messaggio) {
        System.err.println("IoT invo: " + messaggio);
        return true;
    }
}
