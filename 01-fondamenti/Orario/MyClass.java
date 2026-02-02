public class MyClass {
    public static void main(String[] args) {
        Orario o1 = new Orario(23, 59, 59);
        System.out.println(o1.show());
        o1.tic();
        System.out.println(o1.show());
        o1.aggiungiMinuti(125);
        System.out.println(o1.show());
        Orario o2 = new Orario(23, 59, 59);
        System.out.println(o1.sameAs(o2));

    }
}
