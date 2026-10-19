package veiculoslucaserick.Model;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static int PORT = 3307;
    private static final String USER = "root";
    private static String PASSWORD = "1234";

    private static String getHostName() throws Exception {
        return InetAddress.getLocalHost().getHostName();
    }

    public DatabaseConnection() {
        /*try {
            if (getHostName().equals("DESKTOP-R2NKPHM")) {
                this.PORT = 3306;
                this.PASSWORD = "root";
            }
        } catch (Exception e) {
            e.printStackTrace();
        };*/
    }

    public Connection Connect() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:" + PORT
                + "/veiculoslucaserickdatabase";

        Connection conn = DriverManager.getConnection(url, USER, PASSWORD);

        System.out.println("MySQL conectado com sucesso!");

        return conn;
    }
}
