public class Test {
    public static void main(String[] args) {
        Motorizzato m1 = new MezzoDiSoccorso(5);
        Nuotante m2 = new MezzoDiSoccorso(10);
        Trasportatore m3 = new MezzoDiSoccorso(10);
        Volante m4 = new MezzoDiSoccorso(400);

        m1.motore();
        m2.nuota();
        m3.trasporta();
        m4.vola();
    }   
}
