package Request;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class WetterRequest {

    public void doRequest(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("");

        // = target.request(MediaType.APPLICATION_JSON).get(xxx.class);
        abfuellen();
    }

    public void abfuellen(){



        doAusgabe();
    }

    public void doAusgabe(){

        System.out.println("--------------------------------------------------");

        System.out.println();
        System.out.println("--------------------------------------------------");

    }
}
