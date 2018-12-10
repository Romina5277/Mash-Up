package dbAufruf;

import java.sql.*;

public class DbConnection {
    public static void connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mash-up","root", "");
            System.out.println("Database is connected!");

            String query = "SELECT * FROM account";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int columns = rs.getMetaData().getColumnCount();

            System.out.println("Anzahl Spalten = " + columns);

            System.out.println("Alle Daten aus Account:");
            System.out.println();

            for (int i = 1; i <= columns; i++){
                System.out.print(rs.getMetaData().getColumnLabel(i) + "\t\t");
            }

            System.out.println();
            System.out.println();

            while (rs.next()){
                for (int i = 1; i <= columns; i++){
                    System.out.print(rs.getString(i) + "\t\t");
                }
                System.out.println();
            }

            connection.close();
        } catch (SQLException e){
            System.out.println("SQLException: " + e);
        } catch (Exception e){
            System.out.println("Do not connect to DB - Error: " + e);
        }
    }
}
