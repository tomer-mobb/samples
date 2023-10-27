import java.sql.*;

public class SQLInjectionExample {
    public static void main(String[] args) throws SQLException {
        String userInputA = args[1];
        String userInputB = args[2];
        String query0 = "SELECT * FROM users WHERE username = '" + userInputA + "';";
        String query1 = "SELECT * FROM users WHERE password = '" + userInputB + "';";

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

        Statement stmt = con.createStatement();
        stmt.executeQuery(query0);
        stmt.executeQuery(query1);
    }
}
