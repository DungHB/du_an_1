package Service;

import java.sql.*;

public class DbConnect {
    static String url = "jdbc:sqlserver://;serverName=localhost;databaseName=du_an_1;encrypt=true;trustServerCertificate=true";    
    static String username = "sa2";
    static String password = "123";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }
    
    public static void main(String[] args) throws SQLException {
        getConnection();
    }
}
