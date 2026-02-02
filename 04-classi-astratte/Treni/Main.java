public class Main {
    public static void main(String[] args) {
        Treno treno = new Treno();
        
        VagonePasseggeri vp = new VagonePasseggeri(101, 15000, "TrenItalia", 2018, 'A', 60, 45);
        VagoneMerci vm = new VagoneMerci(201, 12000, "Siemens", 2017, 120.5, 50000, 35000);
        
        treno.addVagone(vp);
        treno.addVagone(vm);
        
        System.out.println("Peso treno: " + treno.pesoComplessivo() + " kg");
    }
}
