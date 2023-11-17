public class Customer {
    private String custName;
    private int custAge;
    private String custPhone;

    public Customer() {
        custName = "";
        custAge = 0;
        custPhone = "";

    }

    public Customer(String cn, String cp, int cage) {

        custName = cn;
        custPhone = cp;
        custAge = cage;

    }

    public void setCustName(String cn) {
        custName = cn;
    }

    public void setCustAge(int cage) {
        custAge = cage;
    }

    public void CustPhone(String cp) {
        custPhone = cp;
    }

    public String getCustName() {
        return custName;
    }

    public int getCustAge() {
        return custAge;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public String toString() {
        return "\nCustomer name: " + custName + "\nCustomer Age: " + custAge + "\nCustomer number phone: " + custPhone;
    }
}
