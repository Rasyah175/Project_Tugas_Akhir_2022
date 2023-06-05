package Singletondatabase;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class DatabaseConnection {
    private static Connection con = null;
    static{
        String url = "jdbc:mysql://localhost:3306/penelitian";
        String user = "root";
        String pass = "";
        try {
            con = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
    return con;
    }

}
