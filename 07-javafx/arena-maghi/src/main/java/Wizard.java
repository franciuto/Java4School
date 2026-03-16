import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// rappresenta un combattente nell'arena
public class Wizard {
    private String nome;
    private String alias;
    private int hp, hpMax;
    private int mana, manaMax;
    private int potenzaMagica;
    private int difesa;
    private int velocita;
    private List<Spell> spellBook;

    public Wizard(String nome, String alias) {
        this.nome = nome;
        this.alias = alias;
        this.spellBook = new ArrayList<>();

        // valori random controllati
        Random rnd = new Random();
        this.hpMax = 40 + rnd.nextInt(21); // 40-60
        this.hp = hpMax;
        this.manaMax = 20 + rnd.nextInt(21); // 20-40
        this.mana = manaMax;
        this.potenzaMagica = 5 + rnd.nextInt(6); // 5-10
        this.difesa = 3 + rnd.nextInt(6); // 3-8
        this.velocita = 1 + rnd.nextInt(10); // 1-10
    }

    // controlla se il mago e' ancora vivo
    public boolean isAlive() {
        return hp > 0;
    }

    // sottrae danno dagli hp, minimo 0
    public void takeDamage(int danno) {
        hp = Math.max(0, hp - danno);
    }

    // cura il mago senza superare hpMax
    public void heal(int quantita) {
        hp = Math.min(hpMax, hp + quantita);
    }

    // controlla se ha abbastanza mana per lanciare l'incantesimo
    public boolean canCast(Spell s) {
        return mana >= s.getCostoMana();
    }

    // lancia un incantesimo su un bersaglio
    public String cast(Spell s, Wizard target) {
        if (!isAlive())
            return nome + " e sconfitto e non puo agire";
        if (!canCast(s))
            return nome + " non ha abbastanza mana per " + s.getNome();

        // riduce il mana
        mana -= s.getCostoMana();

        if (s.getTipo() == Spell.Tipo.ATTACCO) {
            // danno = valore base + potenza magica - difesa bersaglio (minimo 1)
            int danno = Math.max(1, s.getValoreBase() + potenzaMagica - target.getDifesa());
            target.takeDamage(danno);
            return nome + " lancia " + s.getNome() + " su " + target.getNome()
                    + " - Danno " + danno + " - HP " + target.getNome() + " " + target.getHp();
        } else {
            // cura se stesso
            int prima = hp;
            heal(s.getValoreBase());
            int curato = hp - prima;
            return nome + " usa " + s.getNome() + " - Cura " + curato + " HP - HP " + hp;
        }
    }

    // riposa e recupera 5 mana
    public String rest() {
        int prima = mana;
        mana = Math.min(manaMax, mana + 5);
        int recuperato = mana - prima;
        return nome + " riposa e recupera " + recuperato + " mana - Mana " + mana;
    }

    // recupera mana di una quantita specifica
    public void regenMana(int quantita) {
        mana = Math.min(manaMax, mana + quantita);
    }

    public void addSpell(Spell s) {
        spellBook.add(s);
    }

    // getter
    public String getNome() {
        return nome;
    }

    public String getAlias() {
        return alias;
    }

    public int getHp() {
        return hp;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getMana() {
        return mana;
    }

    public int getManaMax() {
        return manaMax;
    }

    public int getPotenzaMagica() {
        return potenzaMagica;
    }

    public int getDifesa() {
        return difesa;
    }

    public int getVelocita() {
        return velocita;
    }

    public List<Spell> getSpellBook() {
        return spellBook;
    }

    // restituisce gli incantesimi che il mago puo' lanciare
    public List<Spell> getCastableSpells() {
        List<Spell> castable = new ArrayList<>();
        for (Spell s : spellBook) {
            if (canCast(s))
                castable.add(s);
        }
        return castable;
    }

    @Override
    public String toString() {
        return nome + " (" + alias + ") - HP: " + hp + "/" + hpMax
                + " | Mana: " + mana + "/" + manaMax
                + " | Pot: " + potenzaMagica + " | Dif: " + difesa + " | Vel: " + velocita;
    }
}
