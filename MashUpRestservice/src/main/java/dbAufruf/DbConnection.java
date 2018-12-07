package dbAufruf;

import java.sql.DriverManager;
import java.sql.Connection;
import  java.sql.SQLException;

public class DbConnection {
    public static void connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mash-up","root", "");
            System.out.println("Database is connected!");




            connection.close();
        } catch (SQLException e){
            System.out.println("SQLException: " + e);
        } catch (Exception e){
            System.out.println("Do not connect to DB - Error: " + e);
        }
    }
}
