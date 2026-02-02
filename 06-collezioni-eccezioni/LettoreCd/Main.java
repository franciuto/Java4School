public class Main {
	public static void main(String[] args) {
		Cd cd1 = new Cd("La bellavita", "Artie5ive", 18, 54f);
        Cd cd2 = new Cd("SIRIO", "Lazza", 26, 80f);
        Cd cd3 = new Cd("FERITE", "Capo Plaza", 18, 51.22f);

        LettoreCd manager = new LettoreCd(3);

        manager.setCd(cd1);
        manager.setCd(cd2);
        manager.setCd(cd3);
        System.out.println(manager.toString());

        manager.killCd(2);
        System.out.println(manager.toString());

        System.out.println(manager.getN());

	}
}