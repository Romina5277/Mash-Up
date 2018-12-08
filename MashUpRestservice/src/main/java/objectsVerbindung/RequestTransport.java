package objectsVerbindung;

public class RequestTransport {
    private Connection[] connections;
    private Station from;
    private Station to;
    private Stations stations;

    public Connection[] getConnections() { return connections; }

    public void setConnections(Connection[] connections) { this.connections = connections; }

    public Station getFrom() { return from; }

    public void setFrom(Station from) { this.from = from; }

    public Station getTo() { return to; }

    public void setTo(Station to) { this.to = to; }

    public Stations getStations() { return stations; }

    public void setStations(Stations stations) { this.stations = stations; }
}
