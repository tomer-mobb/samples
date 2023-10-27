import java.sql.*;

public class SQLInjectionExample {
    public static void main(String[] args) throws SQLException {
        String userInputA = args[1];

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

        String query = "SELECT * FROM users WHERE username = '" + userInputA + "';";
        Statement stmt = con.createStatement();
        stmt.addBatch(query);
        stmt.executeBatch();

    }
}
