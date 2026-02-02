public class Cerchio {
    private double raggio;

    // 1st constructor
    public Cerchio() {
        raggio = 10;
    }

    // 2st constructor
    public Cerchio(double raggio) {
        this.raggio = raggio;
    }

    public double area() {
        return (raggio * raggio) * Math.PI;
    }

    public double circonferenza() {
        return (raggio * 2) * Math.PI;
    }

    // Getter and Setter
    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    public static void main(String[] args) {
        Cerchio c1 = new Cerchio(40);
        Cerchio c2 = new Cerchio();
        System.out.println(String.format("Cerchio 1:\nArea = %.2f\nCirconferenza = %.2f\n", c1.area(), c1.circonferenza()));
        System.out.println(String.format("Cerchio 2:\nArea = %.2f\nCirconferenza = %.2f", c2.area(), c2.circonferenza()));
    }
}
