import Request.TransportRequest;
import objectsDB.Stundenplan;

import java.sql.Time;
import java.util.*;

public class Main {
    private static ArrayList<Stundenplan> stundenplan = new ArrayList<>();

    public static void main(String[] args){
        TransportRequest stationrequest = new TransportRequest();
        stationrequest.doRequest();

        stundenplan.add(new Stundenplan(1, 4, new Time(8,25,0), "Mathematik"));
        stundenplan.add(new Stundenplan(1, 4, new Time(9,15,0), "Mathematik"));
        stundenplan.add(new Stundenplan(1, 4, new Time(10,20,0), "Wirtschaft"));
        stundenplan.add(new Stundenplan(1, 4, new Time(11,10,0), "Wirtschaft"));
        stundenplan.add(new Stundenplan(1, 4, new Time(12,55,0), "Englisch"));
        stundenplan.add(new Stundenplan(1, 4, new Time(13,45,0), "Englisch"));
        stundenplan.add(new Stundenplan(1, 4, new Time(14,35,0), "Allgemeinbildung"));
        stundenplan.add(new Stundenplan(1, 4, new Time(15,35,0), "Allgemeinbildung"));
        stundenplan.add(new Stundenplan(1, 4, new Time(16,25,0), "Allgemeinbildung"));

        //doAusgabeStundenplan(1);
    }

    public static void doAusgabeStundenplan(int user_id){
        System.out.println("-----------------------------------------");
        System.out.println("\t\t\t   Stundenplan:");
        System.out.println("-----------------------------------------");
        System.out.println("------------- \t" + stundenplan.get(0).getDayString() + "\t -------------");
        System.out.println("-----------------------------------------");

        for (Stundenplan stundenplanelement: stundenplan) {
            if (stundenplanelement.getUser_id() == user_id && stundenplan.get(0).getDayInt() == stundenplanelement.getDayInt()){
                System.out.print("| \t" + stundenplanelement.getStart_time() + "\t | \t" + stundenplanelement.getLesson());
                if (stundenplanelement.getLesson().length() > 10){
                    System.out.println("\t |");
                } else {
                    System.out.println("\t\t\t |");
                }
            }
        }

        System.out.println("-----------------------------------------");
    }
}

