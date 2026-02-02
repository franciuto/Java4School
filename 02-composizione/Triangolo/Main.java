public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto(0, 0);
        Punto p2 = new Punto(3, 0);
        Punto p3 = new Punto(0, 4);

        System.out.println("Punti del triangolo:");
        System.out.println("A: " + p1);
        System.out.println("B: " + p2);
        System.out.println("C: " + p3);
        Triangolo t1 = new Triangolo(p1, p2, p3);

        System.out.println(t1.toString());
        System.out.printf("Perimetro: %.2f\n", t1.perimeter());
        System.out.printf("Area: %.2f\n", t1.area());

        // Test costruttore di copia
        Triangolo t2 = new Triangolo(t1);
        System.out.println("\nTriangolo copiato:");
        System.out.println(t2.toString());

        // Test modifica di un punto
        t2.getA().setX(1);
        t2.getA().setY(1);
        System.out.println("\nDopo modifica triangolo copiato:");
        System.out.println("Triangolo originale:\n" + t1);
        System.out.println("Triangolo copiato:\n" + t2);
    }
}
