public class Software {
    private String title;
    private String author;
    private float version;
    private String os;

    // Constructor
    public Software(String title, String author, float version, String os) {
        this.title = title;
        this.author = author;
        this.version = version;
        this.os = os;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public float getVersion() {
        return version;
    }
    public void setVersion(float version) {
        this.version = version;
    }
    public String getOs() {
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }    
}
