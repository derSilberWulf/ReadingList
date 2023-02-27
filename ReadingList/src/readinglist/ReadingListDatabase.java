/*
 * 
 */
package readinglist;

import DatabaseStructure.Author;
import DatabaseStructure.Tag;
import not_used.ReadingListModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import readinglistGUI.ComboBoxItem;

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
          
      
    }
    
    /**
     * Adds an author to the authors table
     * @param first_name string
     * @param last_name string
     * @param notes string
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
    
    public int addAuthor(Author a) throws SQLException{
        PreparedStatement ps = 
                this.databaseConnection.prepareStatement("INSERT INTO authors(first_name, last_name, notes) VALUES(?,?,?)");
        ps.setString(1, a.first_name);
        ps.setString(2, a.last_name);
        ps.setString(3, a.notes);
        //return ps.executeUpdate();
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        assert(rs.next());
        return rs.getInt(1);        
    }
    
    
    /**
     * Add an author to the database table?? Or it's a helper method and should be private maybe?
     * @param first first name of author
     * @param last last name of author
     * @param notes misc notes about author
     * @return the int ID of the added author in the author table
     * @throws SQLException 
     */
    public int addAuthor2(String first, String last, String notes) throws SQLException{
        Author a = new Author();
        a.first_name = first;
        a.last_name = last;
        a.notes = notes;
        return addAuthor(a);
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
    //TO DO Change this so it just uses ComboBoxItem and that new method I just made
    //NOTE: CHange "username as name"
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
        //note: was using prepareCall instead of prepareStatement, which caused error
        PreparedStatement ps = 
                this.databaseConnection.prepareStatement("SELECT id, first_name, last_name, notes FROM authors WHERE id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return rs;    
    }
    
    /**
     * Get all authors
     * @return ResultSet with all author data where rows contain id (int) and name(string)
     * @throws SQLException 
     */
    public ResultSet getAllAuthors() throws SQLException{
        //ResultSet rs =
        //     this.databaseConnection.createStatement().executeQuery("SELECT id, first_name, last_name FROM authors");
        PreparedStatement ps = 
                this.databaseConnection.prepareStatement("SELECT id, first_name || \" \" || last_name as name, notes FROM authors");
        ResultSet rs = ps.executeQuery();
        
        return rs;
    }
    
    public ResultSet getAllAuthorsWithAllFields() throws SQLException{
        PreparedStatement ps = 
                this.databaseConnection.prepareStatement("SELECT id, first_name, last_name, notes FROM authors");
        ResultSet rs = ps.executeQuery();
        
        return rs;
    }
    
    /**
     * 
     * @return a result statement containing all of the roles table
     * @throws SQLException 
     */
    public ResultSet getAllRoles() throws SQLException{
        PreparedStatement ps =
                this.databaseConnection.prepareStatement("SELECT id, name, notes FROM roles ORDER BY name");
        return ps.executeQuery();
    }
    
    public ArrayList<ComboBoxItem> getAllTagsForCombo() throws SQLException{
        PreparedStatement ps =
                this.databaseConnection.prepareStatement("SELECT id, name FROM tags ORDER BY name");
        return getListPairs(ps.executeQuery());
    }
    
    public int createTag(String name, String description) throws SQLException{
        PreparedStatement ps = 
        this.databaseConnection.prepareStatement("INSERT INTO tags(name, description) VALUES(?,?)");
        ps.setString(1, name);
        ps.setString(2, description);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        return rs.getInt(1); 
    }
    
    /**
     * Create tags in the database from a list of Tag objects and also assign those
     * Tag objects their ID from the database
     * @param tags List of Tag objects
     * @throws SQLException 
     */
    public void createTags(List<Tag> tags) throws SQLException{
        PreparedStatement ps = 
        this.databaseConnection.prepareStatement("INSERT INTO tags(name, description) VALUES(?,?)");
        for(Tag tag: tags){
            ps.setString(1, tag.name);
            ps.setString(2, tag.description);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            tag.id = rs.getInt(1);
        }
    }
    
    /**
     * Takes a resultSet and puts ids and names together in a list
     * Assumes the table uses id and name
     * @param rs a ResultSet from a query
     * @return an ArrayList of ComboBoxItems
     * @throws java.sql.SQLException
     */
    public ArrayList<ComboBoxItem> getListPairs(ResultSet rs) throws SQLException{
        ArrayList<ComboBoxItem> result = new ArrayList<>();
          while(rs.next()){
              
              int id = rs.getInt("id");
              String name = rs.getString("name");
              ComboBoxItem item = new ComboBoxItem(id, name);
              result.add(item);
          }
          return result;
    }
    
    public int createPublisher(String name) throws SQLException{
        PreparedStatement ps = 
        this.databaseConnection.prepareStatement("INSERT INTO publishers(name) VALUES(?)");
        ps.setString(1, name);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        return rs.getInt(1); 
    }
    
    public ArrayList<ComboBoxItem> getAllPublishersForCombo() throws SQLException{
        PreparedStatement ps =
                this.databaseConnection.prepareStatement("SELECT id, name FROM publishers ORDER BY name");
        return getListPairs(ps.executeQuery());
    }
    
    public ArrayList<ComboBoxItem> getAllFranchisesForCombo() throws SQLException{
        PreparedStatement ps =
                this.databaseConnection.prepareStatement("SELECT id, title as name FROM franchises ORDER BY name");
        return getListPairs(ps.executeQuery());
    }
    
    public int createFranchise(String name, String description) throws SQLException{
        PreparedStatement ps = 
        this.databaseConnection.prepareStatement("INSERT INTO franchises(title, description) VALUES(?, ?)");
        ps.setString(1, name);
        ps.setString(2, description);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        return rs.getInt(1); 
    }
    
    public int createSeries(String title, String subtitle, String description, boolean isOngoing, String notes) throws SQLException{
        PreparedStatement ps = 
        this.databaseConnection.prepareStatement("INSERT INTO series(title, subtitle, description, ongoing, notes) VALUES(?, ?, ?, ?, ?)");
        ps.setString(1, title);
        ps.setString(2, subtitle);
        ps.setString(3, description);
        ps.setBoolean(4, isOngoing);
        ps.setString(5, notes);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        return rs.getInt(1); 
    }
    
    public int createWork(String title, String subtitle, int volume, String summary, String notes, boolean ownCopy, int mediaType) throws SQLException{
        PreparedStatement ps = 
        this.databaseConnection.prepareStatement("INSERT INTO works(title, subtitle, volume, summary, notes, own_copy, media_type_id) VALUES(?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, title);
        ps.setString(2, subtitle);
        ps.setInt(3, volume);
        ps.setString(4, summary);
        ps.setString(5, notes);
        ps.setBoolean(6, ownCopy);
        ps.setInt(7, mediaType);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        return rs.getInt(1); 
    }
    
    public int createMangaWork(String title, String subtitle, int volume, String summary, String notes, boolean ownCopy) throws SQLException{
        PreparedStatement ps = 
        this.databaseConnection.prepareStatement("SELECT id FROM media_types WHERE name=\"Manga\""); //cache the value to avoid unnecessary queries
        ResultSet rs = ps.executeQuery();
        int manga = rs.getInt("id");
        return createWork(title, subtitle, volume, summary, notes, ownCopy, manga); 
    }
    
    public int createLinkWorkSeries(int series, int work) throws SQLException{
        PreparedStatement ps = 
        this.databaseConnection.prepareStatement("INSERT INTO lk_series_works(series_id, work_id) VALUES(?, ?)");
        ps.setInt(1, series);
        ps.setInt(2, work);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        return rs.getInt(1); 
    }
    public int createLinkAuthorWork(int work, int author, int role, String notes) throws SQLException{
        PreparedStatement ps = 
        this.databaseConnection.prepareStatement("INSERT INTO lk_authors_works(work_id, author_id, role_id, notes) VALUES(?, ?, ?, ?)");
        ps.setInt(1, work);
        ps.setInt(2, author);
        ps.setInt(3, role);
        ps.setString(4, notes);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        return rs.getInt(1); 
    }
    
    public int createLinkSeriesFranchise(int series, int franchise) throws SQLException{
        PreparedStatement ps = 
        this.databaseConnection.prepareStatement("INSERT INTO lk_series_franchises(series_id, franchise_id) VALUES(?, ?)");
        ps.setInt(1, series);
        ps.setInt(2, franchise);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        return rs.getInt(1); 
    }
    public int createLinkWorksPublisher(int work, int publisher) throws SQLException{
        PreparedStatement ps = 
        this.databaseConnection.prepareStatement("INSERT INTO lk_publishers_works(work_id, publisher_id) VALUES(?, ?)");
        ps.setInt(1, work);
        ps.setInt(2, publisher);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        return rs.getInt(1); 
    }
    
    public int createLinkTagWork(int work, int tag) throws SQLException{
        PreparedStatement ps = 
        this.databaseConnection.prepareStatement("INSERT INTO lk_tags_works(work_id, tag_id) VALUES(?, ?)");
        ps.setInt(1, work);
        ps.setInt(2, tag);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        return rs.getInt(1); 
    }
    
    /**
     * Forces database to disconnect. Object should not be used afterwards.
     * @throws SQLException
     */
    public void disconnect() throws SQLException{
        this.databaseConnection.close();
    }
    
    
     /**
     * Get a list of tables in the database without any link tables (denoted by
     * starting with "lk" in this database). Also removes the SQLite sqlite_sequence
     * table
     * This method is a hack that might not be useful if not used with SQLite
     * @return array of strings naming tables
     */
    public String[] getTrimmedTableList(){
        String[] tables = {};
        try {
            tables = this.availableTables();
        } catch (SQLException ex) {
            Logger.getLogger(ReadingListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> tableList = new ArrayList<>();
        Collections.addAll(tableList, tables);

        tableList.remove("sqlite_sequence");

        Iterator<String> itr = tableList.iterator();
        String s;
        while(itr.hasNext()){
            s = itr.next();
            if(s.startsWith("lk")){
                itr.remove();
            }
        }
        return tableList.toArray(new String[tableList.size()]);
    }
    
    
}
