public class bus {
    private String Destination;
    private double duration;
    private String busName;

    public bus() {
        Destination = "";
        duration = 0.0;
        busName = "";
    }

    public bus(String ds, double dur, String bn) {
        Destination = ds;
        duration = dur;
        busName = bn;
    }

    public void setDestination(String ds) {
        Destination = ds;
    }

    public void setDuration(double dur) {
        duration = dur;
    }

    public void setBusName(String bn) {
        busName = bn;
    }

    public void setFullBus(String ds, double dur, String bn) {
        Destination = ds;
        duration = dur;
        busName = bn;
    }

    public String getDestination() {
        return Destination;
    }

    public double getDuration() {
        return duration;
    }

    public String getBusName() {
        return busName;
    }
}
