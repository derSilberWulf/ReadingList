package readinglist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Vincent Yahna
 * June 2, 2017
 * This project allows a user to keep an offline reading list for books read, 
 * movies watched, etc. It uses SQLite for the database to keep things simple.
 */
public class ReadingList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
        //TO DO: check if tables exist
        Connection c = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:test.db");
          createDatabase(c);

          c.close();
        } catch ( SQLException e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        
        
    }
    
    /**
     * Run all the create statements to create the database.
     * @param c the connection to the database
     */
    public static void createDatabase(Connection c) throws SQLException, FileNotFoundException, IOException{
          Statement stmt = c.createStatement();
          String sql = getFileContents("..//create_tables.sql");
          stmt.executeUpdate(sql);
      
          stmt.close();
    }
    
     /**
     * Gets the contents of a file and puts it into a string
     * The file should be a small file so that it is okay to have it in memory
     * @param path the path to the file
     * @throws FileNotFoundException
     * @throws IOException
     * @return a string of the contents of the file
     */
    public static String getFileContents(String path) throws FileNotFoundException, IOException{
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        String str = new String(data, "UTF-8");
        return str;
    }

}
