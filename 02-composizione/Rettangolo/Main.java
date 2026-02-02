public class Main {
    public static void main(String[] args) {
        Punto pr1 = new Punto(40, 40);
        Rettangolo r1 = new Rettangolo(10, 14.5f, pr1);

        System.out.printf("aura %f, %f", r1.calcVertexA().getX(), r1.calcVertexA().getY());
    }
}