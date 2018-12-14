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
    // Abfüller
        // Account
    private ArrayList<Account> accs;
    private Account acc = new Account();
        // Stundenplan
    private ArrayList<Stundenplan> lessons;
    private ArrayList<Stundenplan> donnerstag = new ArrayList<>();
    private int donnerstagCode = 4;
        // TransportRequest
    private String from;
    private String to;
    private String departure;
    private String arrival;
    private String duration;
    private ArrayList<String> stopList = new ArrayList<>();

    /*
     * @author: Romina Ferrario
     *
     * Abfüllen der Daten aus der Datenbank
     *
     * parameter: none
     * return: none
     *
     */
    public HomeView() {
        // Daten aus der DB
        DbConnection conn = new DbConnection();

            // Account
        conn.connection("account");
        accs = conn.getAccs();

            // Stundenplan
        conn.connection("stundenplan");
        lessons = conn.getLessons();
    }

    /*
     * @author: Romina Ferrario
     *
     * Angemeldeten Account finden und dessen Daten abspeichern
     *
     * parameter: String
     *              username
     * return: none
     *
     */
    public void findAcc(String username){
        for (Account account : accs) {
            if (account.getUsername().equals(username)){
                acc = account;
            }
        }
    }

    /*
     * @author: Romina Ferrario
     *
     * Schultag heraussuchen (1-7 = Montag - Sonntag)
     *
     * parameter: none
     * return: String
     *           day
     *
     */
    public String getDay(){

        for (Stundenplan lesson : lessons){
            if (lesson.getDayInt() == donnerstagCode){
                return lesson.getDayString();
            }
        }

        return "Keine Ahnung";
    }

    public void findLessons(){
        boolean exist = false;
        for (Stundenplan lesson : lessons) {
            if (lesson.getUser_id() == acc.getUser_id()
                    && lesson.getDayInt() == donnerstagCode){
                for (Stundenplan unterricht : donnerstag) {
                    if (lesson.getStart_time() == unterricht.getStart_time()){
                        exist = true;
                    }
                }

                if(!exist){
                    donnerstag.add(lesson);
                }

                exist = false;
            }
        }
    }

    public void findConnection(){
        //Request: Verbindungen mit der ÖV
        TransportRequest transport = new TransportRequest();
        transport.doRequest(acc.getWohnort(), acc.getSchulort());

        //abfüllen
        from = transport.getFrom();
        to = transport.getTo();
        departure = transport.getDeparture();
        arrival = transport.getArrival();
        duration = transport.getDuration();
        stopList = transport.getStopList();
    }

    public ArrayList<Account> getAccs() {
        return accs;
    }

    public void setAccs(ArrayList<Account> accs) {
        this.accs = accs;
    }

    public ArrayList<Stundenplan> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Stundenplan> lessons) {
        this.lessons = lessons;
    }

    public String getWitz() {
        WitzeRequest witze = new WitzeRequest();
        return witze.doRequest();
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

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public ArrayList<Stundenplan> getDonnerstag() {
        return donnerstag;
    }

    public void setDonnerstag(ArrayList<Stundenplan> donnerstag) {
        this.donnerstag = donnerstag;
    }

    public int getDonnerstagCode() {
        return donnerstagCode;
    }

    public void setDonnerstagCode(int donnerstagCode) {
        this.donnerstagCode = donnerstagCode;
    }
}