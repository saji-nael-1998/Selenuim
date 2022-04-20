package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private Connection conn;
    private  DBConnection() throws SQLException {
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/assignguru","root","12345");
    }
    public static DBConnection getInstance(){
        try {
            if (instance==null){
                instance=new DBConnection();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
       return instance;
    }

    public Connection getConn() {
        return conn;
    }
}
