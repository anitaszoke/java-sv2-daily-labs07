package day04;

public class Ride {

    private int day;
    private int howMany;
    private int km;

    public Ride(int day, int howMany, int km) {
        this.day = day;
        this.howMany = howMany;
        this.km = km;
    }

    public int getDay() {
        return day;
    }

    public int getHowMany() {
        return howMany;
    }

    public int getKm() {
        return km;
    }
}