import java.sql.*;

public class SQLInjectionExample {
    public static void main(String[] args) throws SQLException {
        String userInputA = args[1];
        Statement stmt = null;
        String userId = null;

        try {
            Connection cxn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
            String query = "SELECT * FROM users WHERE username = '" + userInputA + "' LIMIT 1";
            stmt = cxn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                userId = rs.getString("id");
            }
            cxn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(userId);
    }
}
