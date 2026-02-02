public class Punto {
    private double x;
    private double y;

    // 1° costruttore
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // 2° costruttore (copia)
    public Punto(Punto p) {
        this.x = p.x;
        this.y = p.y;
    }

    // Setter
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Getter
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Metodi
    public double distanza(Punto p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    public boolean equals(Punto p) {
        return this.x == p.x && this.y == p.y;
    }

    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}
