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

    public void createTable(String dbname,String user,String pass, String table_name) {
        Connection conn = connect_to_db(dbname,user,pass);
        Statement statement;
        try {
            // Creating an Table with Serial (Serial auto incrementation)
            String query = "CREATE TABLE " + table_name +
                    "(id SERIAL PRIMARY KEY,"+
                    "function varchar(50) NOT NULL,"+
                    "firstNumber INT NOT NULL,"+
                    "secondNumber INT NOT NULL,"+
                    "result INT NOT NULL)";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            conn.close();
            System.out.println("Table created");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    public void insert_row(String dbname,String user,String pass,String table_name,String function,int firstNumber,int secondNumber,int result){
        Connection conn = connect_to_db(dbname,user,pass);

        try{
            conn.setAutoCommit(false);
            String sql = "INSERT INTO " +table_name+ " (function,firstNumber,secondNumber,result) "+
                    "VALUES" +"('"+function+"',"+firstNumber+","+secondNumber+","+result+");";

            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            conn.commit();
            conn.close();
            System.out.println("Daten hinzugefuegt");
        }catch (Exception e){
            System.out.println("Error");
        }

    }

}
