public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
        day = 0;
        month = 0;
        year = 0;

    }

    public Date(int dy, int mon, int yr) {
        day = dy;
        month = mon;
        year = yr;

    }

    public void setDay(int dy) {
        day = dy;
    }

    public void setMonth(int mon) {
        month = mon;
    }

    public void setYear(int yr) {
        year = yr;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

}
