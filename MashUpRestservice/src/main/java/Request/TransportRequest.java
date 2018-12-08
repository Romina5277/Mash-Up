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

    public void doRequest(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://transport.opendata.ch/v1/connections?from=Gen%C3%A8ve&to=Lausanne");

        aufruf = target.request(MediaType.APPLICATION_JSON).get(RequestTransport.class);
        abfuellen();
    }

    public void abfuellen(){

        for (Connection connection: aufruf.getConnections()) {
            from = connection.getFrom().getStation().getName();
            to = connection.getTo().getStation().getName();
            departure = connection.getFrom().getDeparture();
            arrival = connection.getTo().getArrival();
            duration = connection.getDuration();

            for (Section section: connection.getSections()) {
                for (Stop stop: section.getJourney().getPassList()) {
                    stopList.add(stop.getStation().getName());
                }
            }
            doAusgabe();
        }
    }

    public void doAusgabe(){

        System.out.println("--------------------------------------------------");
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Departure: " + departure);
        System.out.println("Arrival: " + arrival);
        System.out.println("Duration: " + duration);

        for (String stop: stopList) {
            if (stop != null){
                System.out.println("Stop in: " + stop);
            }
        }

        System.out.println();
        System.out.println("--------------------------------------------------");

        stopList = new ArrayList<>();
    }
}
