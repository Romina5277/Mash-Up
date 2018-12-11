package viewControlling;

import Request.TransportRequest;
import Request.WitzeRequest;
import dbAufruf.DbConnection;
import objectsDB.Account;
import objectsDB.Stundenplan;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class HomeView implements Serializable {

    private ArrayList<Account> accs;
    private Account acc;

    private ArrayList<Stundenplan> lessons;

    private String witz;

    private String from;
    private String to;
    private String departure;
    private String arrival;
    private String duration;
    private ArrayList<String> stopList = new ArrayList<>();

    public HomeView() {
        // Daten aus der DB
        DbConnection conn = new DbConnection();

            // Account
        conn.connection("account");

        accs = conn.getAccs();
            // Stundenplan
        conn.connection("stundenplan");
        lessons = conn.getLessons();


        //Request: Verbindungen mit der ÖV
        TransportRequest transport = new TransportRequest();
        transport.doRequest();

            //abfüllen
        from = transport.getFrom();
        to = transport.getTo();
        departure = transport.getDeparture();
        arrival = transport.getArrival();
        duration = transport.getDuration();
        stopList = transport.getStopList();


        //Request: Aufmunterung für den Tag
        WitzeRequest witze = new WitzeRequest();
        witz = witze.doRequest();
    }

    public ArrayList<Account> getAccs() {
        return accs;
    }

    public void setAccs(ArrayList<Account> accs) {
        this.accs = accs;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public ArrayList<Stundenplan> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Stundenplan> lessons) {
        this.lessons = lessons;
    }

    public String getWitz() {
        return witz;
    }

    public void setWitz(String witz) {
        this.witz = witz;
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