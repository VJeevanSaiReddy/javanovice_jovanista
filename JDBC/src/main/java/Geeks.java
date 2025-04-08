//Java program to connect to MySQL and insert a record
import java.sql.*;

public class Geeks {
    public static void main(String[] args) {
        // Database URL (Replace IP and database name if needed)
        String url = "jdbc:mysql://localhost:3306/db1";

        // MySQL credentials (Replace with your own username & password)
        String username = "dev";
        String password = "Visweish@03";

        // SQL query to insert data into the 'students' table
        String query = "INSERT INTO students (id, name) VALUES (112, 'vishnu')";

        // Establish JDBC Connection
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to MySQL server successfully!");

            // Create a Statement
            Statement statement = connection.createStatement();

            // Execute the query
            int count = statement.executeUpdate(query);
            System.out.println("Number of rows affected: " + count);

            // Close the resources
            statement.close();
            connection.close();
            System.out.println("Connection closed.");
        }
        catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            e.printStackTrace(); // Debugging output
        }
        catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace(); // Debugging output
        }
    }
}