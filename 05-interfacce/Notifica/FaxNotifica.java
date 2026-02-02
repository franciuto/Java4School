import java.util.Random;
public class FaxNotifica implements Notifica {
    @Override
    public boolean invia(String messaggio) {
        System.err.println("FAX invio: " + messaggio);
        boolean[] status = {true,false};
        java.util.Random random = new java.util.Random();
        int choice = random.nextInt(status.length);
        return status[choice];
    }
}
