public class MezzoDiSoccorso implements Volante, Nuotante, Trasportatore, Motorizzato {
    
    public int capacità;
    
    public MezzoDiSoccorso(int capacità) {
        this.capacità = capacità;
    }

    @Override
    public void nuota() {
        System.out.println("sto nuotando");    
    }

    @Override
    public void vola() {
        System.out.println("sto volando");
    }

    @Override
    public void trasporta() {
        System.out.println("sto trasportando");
    }

    @Override
    public void motore() {
        System.out.println("sto motorizzando");
    }

    public int getCapacità() {
        return capacità;
    }

    public void setCapacità(int capacità) {
        this.capacità = capacità;
    }
}
