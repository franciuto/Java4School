import java.time.LocalDateTime;

public class Spesa {
    private LocalDateTime date;
    private double importo;
    private String category;
    private String paymentMethod;

    public Spesa(LocalDateTime date, double importo, String category, String paymentMethod) {
        this.date = date;
        this.importo = importo;
        this.category = category;
        this.paymentMethod = paymentMethod;
    }

    public double applicaIVA() {
        return importo * 1.22;
    }

    // ------ Getters ------
    public LocalDateTime getDate() {
        return date;
    }

    public double getImporto() {
        return importo;
    }

    public String getCategory() {
        return category;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    
}
