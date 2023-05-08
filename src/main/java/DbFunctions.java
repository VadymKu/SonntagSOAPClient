import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// Zur vereinfachung werden alle DB Funktionien ausgelagert
public class DbFunctions {
    public Connection connect_to_db(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
        return conn;
    }

    public void createTable(Connection conn, String table_name) {
        Statement statement;
        try {
            // Creating an Table with Serial (Serial auto incrementation)
            String query = "create table" + table_name + "(calculations SERIAL,function varchar(50),first_Number ";
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}
