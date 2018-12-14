package dbAufruf;

import objectsDB.Account;
import objectsDB.Stundenplan;

import java.sql.*;
import java.util.ArrayList;

public class DbConnection {

    private ArrayList<Account> accs = new ArrayList<>();
    private ArrayList<Stundenplan> lessons = new ArrayList<>();

    public void connection(String table){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mash-up","root", "");
            System.out.println("Database is connected!");

            String query = "SELECT * FROM " + table;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            switch (table){
                case "account":
                    while (rs.next()){
                        accs.add(new Account(rs.getInt("user_id"), rs.getString("username"), rs.getString("e_mail"),
                                                 rs.getString("password"), rs.getString("wohnort"), rs.getString("schulort")));
                    }
                    break;
                case "stundenplan":
                    while (rs.next()){
                        lessons.add(new Stundenplan(rs.getInt("user_id"), rs.getInt("day"),
                                                        rs.getTime("start_time"), rs.getString("lesson")));
                    }
                    break;
                default:
                    System.out.println("Diese Tabelle ist nicht vorhanden!");
                    break;
            }
            connection.close();
        } catch (SQLException e){
            System.out.println("SQLException: " + e);
        } catch (Exception e){
            System.out.println("Do not connect to DB - Error: " + e);
        }
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
}
