public class Orario {
    private int hours;
    private int minutes;
    private int seconds;

    // Constructors
    public Orario(int hours, int minutes, int seconds) {
        if ((hours >= 0 && hours <= 23) && (minutes >= 0 && minutes <= 59) && (seconds >= 0 && seconds <= 59)) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        } else {
            this.hours = 00;
            this.minutes = 00;
            this.seconds = 00;
        }
    }

    public Orario() {
        this.hours = 00;
        this.minutes = 00;
        this.seconds = 00;
    }

    // Getters
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    // Setters
    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;

    }

    // Methods
    public void timeHandle() {
        while (seconds >= 60) {
            seconds -= 60;
            minutes += 1;
        }
        while (minutes >= 60) {
            minutes -= 60;
            hours += 1;
        }
        while (hours >= 24) {
            hours -= 24;
        }
    }

    public void tic() {
        seconds += 1;
        timeHandle();
    }

    public void aggiungiMinuti(int m) {
        minutes += m;
        timeHandle();
    }

    public boolean sameAs(Orario t) {
        if (this == t) {
            return true;
        } else {return false;}
    }

    public String show() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
