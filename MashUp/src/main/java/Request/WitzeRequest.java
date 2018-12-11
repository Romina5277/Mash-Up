package Request;

import objectsWitze.RequestWitze;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WitzeRequest {
    private RequestWitze aufruf;
    private String witz;

    public RequestWitze doRequest(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://api.icndb.com/jokes/random");

        aufruf = target.request(MediaType.APPLICATION_JSON).get(RequestWitze.class);
        abfuellen();
        return aufruf;
    }

    public void abfuellen(){
        witz = aufruf.getValue().getJoke();
        doAusgabe();
    }

    public void doAusgabe(){

        System.out.println("--------------------------------------------------");
        System.out.println(witz);
        System.out.println("--------------------------------------------------");

    }
}
