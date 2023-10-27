import java.sql.*;

public class SQLInjectionExample {
    public static void main(String[] args) throws SQLException {
        String userInputA = args[1];

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

        String query = "SELECT * FROM users WHERE username = '" + userInputA + "';";
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }
    }
}
