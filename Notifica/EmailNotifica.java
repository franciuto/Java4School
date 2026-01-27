public class EmailNotifica implements Notifica {
    @Override
    public boolean invia(String messaggio) {
        System.out.println("Email: Invio: " + messaggio);
        return true;
    }
}
