// Methods and constructors

public class Studente {
    public String name;
    public String surname;
    public String classe;
    public int age;

    // 1st constructor
    public Studente() {
        this.name = "null";
        this.surname = "null";
        this.classe = "null";
        this.age = 0;
    }

    // Constructor method with parameters
    public Studente(String name, String surname, int age, String classe) {
        this.name = name;
        this.surname = surname;
        this.classe = classe;
        this.age = age;
    }

    public Studente(String name) {
        this.name = name;
    }

    // Common method
    public boolean isMaggiorenne() {
        boolean maggiorenne;
        if (age >= 18) {
            maggiorenne = true;
        } else {
            maggiorenne = false;
        }
        return maggiorenne;
    }

    public static void main(String[] args) {
        Studente studente1 = new Studente(); // Instanza una classe con metodo costruttore 1
        Studente studente2 = new Studente("Francesco", "Fontanesi", 17, "4c inf");

        studente1.age = 17;
        System.out.println(studente1.name + studente1.surname + studente1.age + studente1.classe);
        System.out.println(studente2.name + studente2.surname + studente2.age + studente2.classe);
        System.out.println(studente1.isMaggiorenne());
        studente1.age = 20;
        System.out.println(studente1.isMaggiorenne());

        System.out.println(studente2.age);
    }
}