public class Rettangolo {
    private double base;
    private double height;
    private Punto center;

    // Constructor
    public Rettangolo(float base, float height, Punto center) {
        this.base = base;
        this.height = height;
        this.center = center;
    }

    // Getters and Setters
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getheight() {
        return height;
    }

    public void setheight(double height) {
        this.height = height;
    }

    public Punto getcenter() {
        return center;
    }

    public void setcenter(Punto center) {
        this.center = center;
    }

    /**
     * Calculates the coordinates of vertex A of the rectangle.
     * Vertex A is the top-left corner of the rectangle
     * based on its center point, base, and height.
     *
     * @return A new Punto object representing the coordinates of vertex A.
     */
    public Punto calcVertexA() {
        return new Punto(center.getX() - base / 2, center.getY() + height / 2);
    }

    /**
     * Calculates the coordinates of vertex B of the rectangle.
     * Vertex B is the bottom-left corner of the rectangle
     * based on its center point, base, and height.
     *
     * @return A new Punto object representing the coordinates of vertex B.
     */
    public Punto calcVertexB() {
        return new Punto(center.getX() - base / 2, center.getY() - height / 2);
    }

    /**
     * Calculates the coordinates of vertex C of the rectangle.
     * Vertex C is the top-right corner of the rectangle
     * based on its center point, base, and height.
     *
     * @return A new Punto object representing the coordinates of vertex C.
     */
    public Punto calcVertexC() {
        return new Punto(center.getX() + base / 2, center.getY() + height / 2);
    }

    /**
     * Calculates the coordinates of vertex D of the rectangle.
     * Vertex D is the bottom-right corner of the rectangle
     * based on its center point, base, and height.
     *
     * @return A new Punto object representing the coordinates of vertex D.
     */
    public Punto calcVertexD() {
        return new Punto(center.getX() + base / 2, center.getY() - height / 2);
    }

    public boolean checkPosition(Punto p) {
        if (p.getX() <= calcVertexD().getX() && p.getY() <= calcVertexA().getY()) {
            return true;
        } else {
            return false;
        }
    }
}
/*
c.per restituire
quale dei
vertici si
trova più
vicino all’origine degli assi
 */