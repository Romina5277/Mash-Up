package objectsVerbindung;

public class Stop {
    private Station station;
    private String arrival;
    private int arrivalTimestamp;
    private String departure;
    private int departureTimestamp;
    private boolean delay;
    private String platform;
    private Prognosis prognosis;
    private String realtimeAvailability;
    private Station location;

    public Station getStation() { return station; }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getArrivalTimestamp() {
        return arrivalTimestamp;
    }

    public void setArrivalTimestamp(int arrivalTimestamp) {
        this.arrivalTimestamp = arrivalTimestamp;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public int getDepartureTimestamp() {
        return departureTimestamp;
    }

    public void setDepartureTimestamp(int departureTimestamp) {
        this.departureTimestamp = departureTimestamp;
    }

    public boolean isDelay() {
        return delay;
    }

    public void setDelay(boolean delay) {
        this.delay = delay;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Prognosis getPrognosis() {
        return prognosis;
    }

    public void setPrognosis(Prognosis prognosis) {
        this.prognosis = prognosis;
    }

    public String getRealtimeAvailability() {
        return realtimeAvailability;
    }

    public void setRealtimeAvailability(String realtimeAvailability) {
        this.realtimeAvailability = realtimeAvailability;
    }

    public Station getLocation() {
        return location;
    }

    public void setLocation(Station location) {
        this.location = location;
    }
}
