package Request;

import objectsVerbindung.Aufruf;
import objectsVerbindung.PassList;
import objectsVerbindung.Stationboard;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

public class StationboardRequest {
    private Aufruf aufrufe;
    private String from;
    private String to;
    private String departure;
    private String arrival;
    private ArrayList<String> stopList = new ArrayList<>();

    public void doRequest(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://transport.opendata.ch/v1/stationboard?station=Winterthur&limit=1");

        aufrufe = target.request(MediaType.APPLICATION_JSON).get(Aufruf.class);
        abfuellen();
    }

    public void abfuellen(){

        for (Stationboard stationboard: aufrufe.getStationboard()) {
            from = stationboard.getStop().getStation().getName();
            departure = stationboard.getStop().getDeparture();
            to = stationboard.getTo();

            for (PassList pass: stationboard.getPassList()) {
                arrival = pass.getArrival();
                stopList.add(pass.getStation().getName());
            }
        }

        doAusgabe();
    }

    public void doAusgabe(){

        System.out.println("--------------------------------------------------");
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Departure: " + departure);
        System.out.println("Arrival: " + arrival);

        for (String stop: stopList) {
            System.out.println("Stop in: " + stop);
        }

        System.out.println();
        System.out.println("--------------------------------------------------");
        
    }
}
