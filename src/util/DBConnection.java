package util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/gymdb";
    private static final String USER = "root";
    private static final String PASS = "Sowmiya@30";

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
        return conn;
    }
}


//cd "C:\Program Files\MySQL\MySQL Server 8.0\bin
//mysqld --console --datadir="C:\ProgramData\MySQL\MySQL Server 8.0\Data"
