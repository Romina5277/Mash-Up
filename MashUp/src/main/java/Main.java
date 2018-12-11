import dbAufruf.DbConnection;

public class Main {
    public static void main(String[] args){
        DbConnection conn = new DbConnection();
        conn.connection();
    }
}
