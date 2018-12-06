package objectsVerbindung;

public class PassList {
    Station station;
    String arrival;
    int arrivalTimestamp;
    String departure;
    int departureTimestamp;
    boolean delay;
    String platform;
    Prognosis prognosis;
    String realtimeAvailability;
    Location location;

    public Station getStation() {
        return station;
    }

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
