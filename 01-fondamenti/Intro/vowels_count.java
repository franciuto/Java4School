public class vowels_count {

    public static void main (String[] args) {
        char[] random_letters = {'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd',' ', 'f', 'i', 'r', 's',' ', 't', 't', 'r', 'y'};
        int[] vowels = {0,0,0,0,0};

        for (char c : random_letters) {
            switch (Character.toLowerCase(c)) { // Uso una classe Wrapper che "trasforma" un tipo primitivo in un oggetto in modo da potergli applicare il .tolowercase
                case 'a':
                    vowels[0]++; 
                    break;
                case 'e':
                    vowels[1]++;
                    break;
                case 'i':
                    vowels[2]++;
                    break;
                case 'o':
                    vowels[3]++;
                    break;
                case 'u':
                    vowels[4]++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Numero di a: " + vowels[0]);
        System.out.println("Numero di e: " + vowels[1]);
        System.out.println("Numero di i: " + vowels[2]);
        System.out.println("Numero di o: " + vowels[3]);
        System.out.println("Numero di u: " + vowels[4]);
    }
}