package Request;

import objectsVerbindung.RequestTransport;
import objectsVerbindung.Connection;
import objectsVerbindung.Section;
import objectsVerbindung.Stop;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

public class TransportRequest {
    private RequestTransport aufruf;
    private String from;
    private String to;
    private String departure;
    private String arrival;
    private String duration;
    private ArrayList<String> stopList = new ArrayList<>();

    public void doRequest(String from, String to){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://transport.opendata.ch/v1/connections?from=" + from + "&to=" + to);

        aufruf = target.request(MediaType.APPLICATION_JSON).get(RequestTransport.class);
        abfuellen();
    }

    public void abfuellen(){

        from = aufruf.getConnections()[1].getFrom().getStation().getName();
        to = aufruf.getConnections()[1].getTo().getStation().getName();
        departure = aufruf.getConnections()[1].getFrom().getDeparture();
        arrival = aufruf.getConnections()[1].getTo().getArrival();
        duration = aufruf.getConnections()[1].getDuration();

        for (Section section: aufruf.getConnections()[1].getSections()) {
            for (Stop stop: section.getJourney().getPassList()) {
                stopList.add(stop.getStation().getName());
            }
        }
    }

    public RequestTransport getAufruf() {
        return aufruf;
    }

    public void setAufruf(RequestTransport aufruf) {
        this.aufruf = aufruf;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ArrayList<String> getStopList() {
        return stopList;
    }

    public void setStopList(ArrayList<String> stopList) {
        this.stopList = stopList;
    }
}
