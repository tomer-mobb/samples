import java.sql.*;

public class SQLInjectionExample {
    public static void main(String[] args) throws SQLException {
        String userInputA = args[1];
        String userInputB = args[2];

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
        Statement stmt = con.createStatement();

        String query0 = "SELECT * FROM users WHERE username = '" + userInputA + "';";
        stmt.executeQuery(query0);

        String query1 = "SELECT * FROM users WHERE password = '" + userInputB + "';";
        stmt.executeQuery(query1);
    }
}
