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
import java.util.HashSet;
import javax.persistence.Tuple;

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
        //To do: put prepared statements as fields for reuse
        PreparedStatement ps = 
                this.databaseConnection.prepareStatement("INSERT INTO authors(first_name, last_name, notes) VALUES(?,?,?)");
        ps.setString(1, first_name);
        ps.setString(2, last_name);
        ps.setString(3, notes);
        ps.executeUpdate();
    }
    
    /**
     * Create a new user in the database
     * @param name the user's name
     */
    public void addUser(String name) throws SQLException{
        PreparedStatement ps = 
                this.databaseConnection.prepareStatement("INSERT INTO users(username) VALUES(?)");
        ps.setString(1, name);
        ps.executeUpdate();
                
    }
    public class users_struct{public int id; public String username;}
    public ArrayList<users_struct> getAllUsers() throws SQLException{
        Statement stmt = this.databaseConnection.createStatement();
          String sql = "SELECT id, username FROM users ORDER BY username;";
          ResultSet rs = stmt.executeQuery(sql);
          
          ArrayList<users_struct> result = new ArrayList<>();
          while(rs.next()){
              users_struct us = new users_struct();
              us.id = rs.getInt("id");
              us.username = rs.getString("username");
              result.add(us);
          }
          return result;
    }
    
    /**
     * 
     * @param id the id of the author wanted
     * @return a result set with only one row
     * @throws SQLException 
     */
    public ResultSet getAuthorById(int id) throws SQLException{
        PreparedStatement ps = 
                this.databaseConnection.prepareCall("SELECT id, first_name, last_name FROM authors WHERE id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return rs;
        
    }
    
    /**
     * Forces database to disconnect. Object should not be used afterwards.
     * @throws SQLException
     */
    public void disconnect() throws SQLException{
        this.databaseConnection.close();
    }
    
    
}
