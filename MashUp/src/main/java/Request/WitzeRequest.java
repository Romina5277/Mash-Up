package Request;

import objectsWitze.RequestWitze;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WitzeRequest {
    private RequestWitze aufruf;
    private String witz;

    public String doRequest(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://api.icndb.com/jokes/random");

        aufruf = target.request(MediaType.APPLICATION_JSON).get(RequestWitze.class);
        witz = aufruf.getValue().getJoke();

        return witz;
    }
}
