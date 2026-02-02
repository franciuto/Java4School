public class Libro {
    private String title;
    private String author;
    private int pageN;
    private double pageCost;
    final private double FIXED_COST = 2.4;

    Libro(String title, String author, int pageN) {
        this.title = title;
        this.author = author;
        this.pageN = pageN;
    }
    
    // Getter + Settern
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageN() {
        return pageN;
    }

    public void setPageN(int pageN) {
        this.pageN = pageN;
    }

    public void setPageCost (double pageCost) {
        this.pageCost = pageCost;
    }

    public double prezzo() {
        return pageN * pageCost + FIXED_COST;
    }   

    public static void main(String[] args) {
        Libro l1 = new Libro("Harry Potter", "J.K. Rowling", 830);
        Libro l2 = new Libro("The Hobbit", "J.R.R. Tolkien", 310);

        l1.setPageCost(0.02);
        l2.setPageCost(0.03);
        System.out.printf("%.2f€", l1.prezzo());
    }
}
