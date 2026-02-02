public class Cd {
    // String is a class
    public String title;
    public String author;
    // Use primitive types
    public int songs_n;
    public float duration;

    // Constructor with parameters
    public Cd(String title, String author, int songs_n, float duration) {
        this.title = title;
        this.author = author;
        this.songs_n = songs_n;
        this.duration = duration;
    }

    @Override // Annotation to indicate to the compiler that this method overrides a method from the Object class
    public String toString () {
        // i use String.format to use a format string (c style)
        return String.format("Title: %s, Author: %s, Songs: %d, Duration: %.2f minutes", title, author, songs_n, duration);
    }

    /*  Method: compareData
        Input: float duration
        Return: (bool) true if obj duration is bigger than input float, else instead
    */
    public boolean compareData(float duration){
        if (this.duration > duration) {
            return true;
        } else {
            return false;
        }
    } 

    public static void main(String[] args) {
        Cd cd1 = new Cd("La bellavita", "Artie5ive", 18, 54f);
        Cd cd2 = new Cd("SIRIO", "Lazza", 26, 80f);
        Cd cd3 = new Cd("FERITE", "Capo Plaza", 18, 51.22f);

        // Start by assuming cd1 is the longest
        Cd maxCd = cd1;
        // Duration sort
        if(cd2.compareData(maxCd.duration)) {
            maxCd = cd2;
        }
        if(cd3.compareData(maxCd.duration)) {
            maxCd = cd3;
        }

        System.out.println(String.format("Longest CD is %s from %s with %d songs for a total duration of %.2f", maxCd.title, maxCd.author, maxCd.songs_n, maxCd.duration));
        // System.out.println(maxCd.toString()); => or use method
    }
}

