// rappresenta un incantesimo lanciabile da un mago
public class Spell {
    public enum Tipo {
        ATTACCO,
        CURA
    }
    private String nome;
    private int costoMana;
    private int valoreBase;
    private Tipo tipo;

    public Spell(String nome, int costoMana, int valoreBase, Tipo tipo) {
        this.nome = nome;
        this.costoMana = costoMana;
        this.valoreBase = valoreBase;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getCostoMana() {
        return costoMana;
    }

    public int getValoreBase() {
        return valoreBase;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nome;
    }
}
