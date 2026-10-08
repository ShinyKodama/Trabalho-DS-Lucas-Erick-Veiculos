package veiculoslucaserick.Model;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static int PORT = 3307;
    private static final String USER = "root";
    private static String PASSWORD = "1234";
    private static final String URL = "jdbc:mysql://localhost:"+String.valueOf(PORT)+"/veiculoslucaserickdatabase";
   
    private static String getHostName() throws Exception { return InetAddress.getLocalHost().getHostName(); }
  
    public DatabaseConnection() {
        try {
            if (getHostName().equals("DESKTOP-R2NKPHM")) {
                this.PORT = 3306;
                this.PASSWORD = "root";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Connection Connect() throws SQLException {
        return DriverManager.getConnection ( this.URL, this.USER, this.PASSWORD );
    }
}
