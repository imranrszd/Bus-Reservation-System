public class DigitalTicket extends Ticket {
    private Date dt;

    public DigitalTicket() {
        super();

    }

    public DigitalTicket(String cn, String cp, int cage, int tt, String d, int snum, int dy, int mon, int yr) {
        super(cn, cp, cage, tt, d, snum);

        dt = new Date(dy, mon, yr);

    }

    public Date getDate() {
        return dt;
    }

    public double calcPrice() {
        double prices = 0.0;
        double discount = 0.0;
        double totalprice = 0.0;
        double cutprice = 5;
        if (super.getCustomer().getCustAge() < 18) {
            discount = 0.95;
        } else if (super.getCustomer().getCustAge() > 50) {
            discount = 0.94;
        } else {
            discount = 1.0;
        }
        if (super.getTravel().getDestination().equalsIgnoreCase("Kelantan")) {
            prices = 45;
        } else if (super.getTravel().getDestination().equalsIgnoreCase("kedah")) {
            prices = 25;
        } else if (super.getTravel().getDestination().equalsIgnoreCase("Penang")) {
            prices = 30;
        } else if (super.getTravel().getDestination().equalsIgnoreCase("Perak")) {
            prices = 40;
        } else if (super.getTravel().getDestination().equalsIgnoreCase("Pahang")) {
            prices = 50;
        } else if (super.getTravel().getDestination().equalsIgnoreCase("Selangor")) {
            prices = 55;
        } else if (super.getTravel().getDestination().equalsIgnoreCase("Melaka")) {
            prices = 60;
        } else {
            prices = 70;
        }

        totalprice = (discount * prices) - cutprice;

        return totalprice;
    }

    public String toString() {
        return super.toString() + "\nDate: " + dt.getDay() + "/" + dt.getMonth() + "/" + dt.getYear();
    }

}
