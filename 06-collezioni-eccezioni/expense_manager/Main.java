import java.time.LocalDateTime;
public class Main {
    Spesa[] speseList;
    public static void main(String[] args) {
        Spesa[] speseList = {
            new Spesa(LocalDateTime.of(2021, 5, 28, 10, 40, 43), 34.58, "Trasporti", "Satispay"),
            new Spesa(LocalDateTime.of(2022, 3, 15, 14, 20, 0), 50.00, "Cibo", "Carta di Credito"),
            new Spesa(LocalDateTime.of(2023, 1, 10, 9, 15, 30), 120.75, "Intrattenimento", "Contanti"),
            new Spesa(LocalDateTime.of(2023, 6, 22, 18, 45, 12), 85.30, "Salute", "Bancomat"),
            new Spesa(LocalDateTime.of(2022, 11, 5, 12, 0, 0), 25.50, "Intrattenimento", "PayPal"),
            new Spesa(LocalDateTime.of(2023, 8, 17, 20, 30, 45), 67.90, "Cibo", "Carta di Credito")
        };         
    
    }    
}
