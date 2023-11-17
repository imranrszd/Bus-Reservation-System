public class Travel {
    private String destination;
    private int seatNum;

    public Travel() {
        destination = "";
        seatNum = 0;
    }

    public Travel(String d, int snum) {
        destination = d;
        seatNum = snum;

    }

    public void setDestination(String d) {
        destination = d;
    }

    public void setSeatNum(int snum) {
        seatNum = snum;
    }

    public String getDestination() {
        return destination;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public String toString() {
        return "\nDestination: " + destination + "\nSeat number: " + seatNum;
    }
}
