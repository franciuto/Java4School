import java.util.ArrayList;

public class Treno {
    ArrayList<Vagone> listaVagoni = new ArrayList<>();

    public boolean addVagone(Vagone vagone) {
        return listaVagoni.add(vagone);
    }

    public boolean rimuoviVagone(Vagone vagone) {
        return listaVagoni.remove(vagone);
    }

    public double pesoComplessivo() {
        double peso = 0;
        for (Vagone vagone : listaVagoni) {
            peso += vagone.getPeso();
        }
        return peso;
    }
}   
