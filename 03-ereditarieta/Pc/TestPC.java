import java.util.List;

public class TestPC {
    public static void main(String[] args) {
        InventarioPc inventario = new InventarioPc();

        Desktop desktop1 = new Desktop("Intel i7", 1000, 16, "Dell", "XPS", "Windows 11", "Tower", "NVIDIA RTX 3060", "Realtek");
        Desktop desktop2 = new Desktop("AMD Ryzen 5", 512, 8, "HP", "Pavilion", "Windows 10", "MiniTower", "AMD Radeon", "Realtek");
        
        Server server1 = new Server("Intel Xeon", 2000, 64, "IBM", "PowerEdge", "Linux", "Rack", 4, true);
        Server server2 = new Server("AMD EPYC", 4000, 32, "Dell", "R740", "Ubuntu Server", "Rack", 2, false);
        
        Notebook notebook1 = new Notebook("Intel i5", 512, 8, "Lenovo", "ThinkPad", "Windows 11", 1.5, 14.0, true, true, 2);
        Notebook notebook2 = new Notebook("Intel i3", 256, 4, "Acer", "Aspire", "Windows 10", 2.2, 15.6, false, false, 0);
        Notebook notebook3 = new Notebook("Apple M1", 512, 16, "Apple", "MacBook Air", "macOS", 1.2, 13.3, true, true, 1);
        
        Palmare palmare1 = new Palmare("ARM", 64, 2, "Samsung", "Galaxy Tab", "Android", 0.5, true, true, "microSD");
        Palmare palmare2 = new Palmare("ARM", 32, 1, "Amazon", "Fire", "Android", 0.4, false, false, "microSD");

        inventario.aggiungiPC(desktop1);
        inventario.aggiungiPC(desktop2);
        inventario.aggiungiPC(server1);
        inventario.aggiungiPC(server2);
        inventario.aggiungiPC(notebook1);
        inventario.aggiungiPC(notebook2);
        inventario.aggiungiPC(notebook3);
        inventario.aggiungiPC(palmare1);
        inventario.aggiungiPC(palmare2);

        System.out.println("=== PC con piu RAM ===");
        Pc pcMaxRam = inventario.trovaPCConPiuRAM();
        if (pcMaxRam != null) {
            System.out.println(pcMaxRam.toString());
        }
        System.out.println();

        System.out.println("=== Media RAM ===");
        double mediaRam = inventario.calcolaMediaRAM();
        System.out.println(String.format("%.2f GB", mediaRam));
        System.out.println();

        System.out.println("=== Numero portatili con WiFi ===");
        int portatiliWifi = inventario.contaPortatiliConWifi();
        System.out.println(portatiliWifi);
        System.out.println();

        System.out.println("=== Numero server con RAID ===");
        int serverRaid = inventario.contaServerConRaid();
        System.out.println(serverRaid);
        System.out.println();

        System.out.println("=== Notebook piu leggero ===");
        Notebook notebookLeggero = inventario.trovaNotebookPiuLeggero();
        if (notebookLeggero != null) {
            System.out.println(notebookLeggero.toString());
        }
        System.out.println();

        System.out.println("=== PC marca Dell ===");
        List<Pc> pcDell = inventario.cercaPerMarca("Dell");
        for (int i = 0; i < pcDell.size(); i++) {
            System.out.println(pcDell.get(i).toString());
        }
        System.out.println();

        System.out.println("=== PC con Windows 11 ===");
        List<Pc> pcWindows11 = inventario.cercaPerSistemaOperativo("Windows 11");
        for (int i = 0; i < pcWindows11.size(); i++) {
            System.out.println(pcWindows11.get(i).toString());
        }
        System.out.println();

        System.out.println("=== Portatili sotto 2kg con WiFi ===");
        List<Pc> portatiliLeggeri = inventario.cercaPortatili(2.0, true);
        for (int i = 0; i < portatiliLeggeri.size(); i++) {
            System.out.println(portatiliLeggeri.get(i).toString());
        }
        System.out.println();

        System.out.println("=== Portatili sotto 1kg senza filtro WiFi ===");
        List<Pc> portatiliMoltoLeggeri = inventario.cercaPortatili(1.0, false);
        for (int i = 0; i < portatiliMoltoLeggeri.size(); i++) {
            System.out.println(portatiliMoltoLeggeri.get(i).toString());
        }
        System.out.println();

        System.out.println("=== Test rimozione PC ===");
        boolean rimosso = inventario.rimuoviPC(desktop2);
        System.out.println(String.format("Desktop2 rimosso: %s", rimosso ? "Si" : "No"));
        System.out.println();

        System.out.println("=== Test equals ===");
        Desktop desktop3 = new Desktop("Intel i7", 1000, 16, "Dell", "XPS", "Windows 11", "Tower", "NVIDIA RTX 3060", "Realtek");
        System.out.println(String.format("desktop1 equals desktop3: %s", desktop1.equals(desktop3) ? "Si" : "No"));
        System.out.println(String.format("desktop1 equals notebook1: %s", desktop1.equals(notebook1) ? "Si" : "No"));
    }
}
