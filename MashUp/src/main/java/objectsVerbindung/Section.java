package objectsVerbindung;

public class Section {
    private Journey journey;
    private String walk;
    private Stop departure;
    private Stop arrival;

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public String getWalk() {
        return walk;
    }

    public void setWalk(String walk) {
        this.walk = walk;
    }

    public Stop getDeparture() {
        return departure;
    }

    public void setDeparture(Stop departure) {
        this.departure = departure;
    }

    public Stop getArrival() {
        return arrival;
    }

    public void setArrival(Stop arrival) {
        this.arrival = arrival;
    }
}
