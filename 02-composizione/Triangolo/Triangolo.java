public class Triangolo {
    private Punto a;
    private Punto b;
    private Punto c;

    Triangolo(Punto a, Punto b, Punto c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Triangolo(Triangolo t) {
        this.a = new Punto(t.a);
        this.b = new Punto(t.b);
        this.c = new Punto(t.c);
    }

    // Getters
    public Punto getA() {
        return a;
    }

    public Punto getB() {
        return b;
    }

    public Punto getC() {
        return c;
    }

    // Setters
    public void setA(Punto a) {
        this.a = a;
    }

    public void setB(Punto b) {
        this.b = b;
    }

    public void setC(Punto c) {
        this.c = c;
    }

    // Methods
    public double area() {
        return 0.5 * Math.abs(
            a.getX() * (b.getY() - c.getY()) +
            b.getX() * (c.getY() - a.getY()) +
            c.getX() * (a.getY() - b.getY())
        );
    }

    public double perimeter() {
        return a.distanza(b) + b.distanza(c) + c.distanza(a);
    }

    @Override
    public String toString() {
        return String.format(
            "Punto a: %f , %f\nPunto b: %f , %f\nPunto c: %f , %f",
            this.getA().getX(), this.getA().getY(),
            this.getB().getX(), this.getB().getY(),
            this.getC().getX(), this.getC().getY()
        );
    }

}
