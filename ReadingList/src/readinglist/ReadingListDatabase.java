/*
 * 
 */
package readinglist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *  Encapsulates the SQL database and contains methods for accessing and writing
 *  to it
 */
public class ReadingListDatabase {
    
    private Connection databaseConnection;
    /**
     * Connects to the database and instantiates a ReadingListDatabase object
     * @throws ClassNotFoundException
     * @throws SQLException (shouldn't happen just from instantiating)
     */
    public ReadingListDatabase() throws ClassNotFoundException, SQLException{
        //connect to database
        Class.forName("org.sqlite.JDBC");
        this.databaseConnection = DriverManager.getConnection("jdbc:sqlite:reading_list.db");
    }
    /**
     * @return String array of all the tables names in this database
     * @throws SQLException
     */
    public String[] availableTables() throws SQLException{
          Statement stmt = this.databaseConnection.createStatement();
          String sql = "SELECT name FROM sqlite_master WHERE type='table' ORDER BY name;";
          ResultSet rs = stmt.executeQuery(sql);
          ArrayList<String> result = new ArrayList<>();
          while(rs.next()){
              result.add(rs.getString("name"));
          }
          return result.toArray(new String[result.size()]);
          
      
        // stub 
        //return new String[] {"Authors","Works","Series","Franchises"};
    }
    
    /**
     * Adds an author to the authors table
     * @throws SQLException
     */
    public void addAuthor(String first_name, String last_name, String notes) throws SQLException{
        PreparedStatement ps = 
                this.databaseConnection.prepareStatement("INSERT INTO authors(first_name, last_name, notes) VALUES(?,?,?)");
        ps.setString(1, first_name);
        ps.setString(2, last_name);
        ps.setString(3, notes);
        ps.executeUpdate();
    }
    /**
     * Forces database to disconnect. Object should not be used afterwards.
     * @throws SQLException
     */
    public void disconnect() throws SQLException{
        this.databaseConnection.close();
    }
    
    
}
