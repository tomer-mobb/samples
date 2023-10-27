import java.sql.*;

public class SQLInjectionExample {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db");
        String userInputA = args[1];
        String fields = "*";
        String table = "users";
        String order = "ORDER BY id ASC";
        //bad query on purpose, just to test the question mark counting logic
        String query = "SELECT ???" + fields + " FROM " + table + " WHERE username = '" + userInputA + "' " + order + ";";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.executeQuery();
    }
}
