public class Punto {
    private double y;
    private double x;
    
    // 1st constructor
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // 2st constructor
    public Punto (Punto p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * Set x attribute
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Returns X attribute
     * @return (double) x
     */
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    // Methods
    public boolean equals(Punto p) {
        if (this.x == p.x && this.y == p.y) {
            return true;
        } else {
            return false;
        }
    }

    public double distanza(Punto p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }
    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }

    
    /*
    public static void main(String[] args) {
        Punto p1 = new Punto(3, 5);
        Punto p2 = new Punto(6, 7);


        System.out.println(p1.toString());
        System.out.println(p1.distanza(p2));
        System.out.println(p1.equals(p2));
    }
 */
}