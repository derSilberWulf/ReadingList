package readinglist;

import DatabaseStructure.Author;
import DatabaseStructure.SQLTable;
import entities.Authors;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.swing.JFrame;
import not_used.ReadingListController;
import readinglistGUI.AddAuthorPanel;
import readinglistGUI.GUIController;
import static readinglistGUI.GUIController.positionJFrame;
import readinglistGUI.LoginForm;


/**
 * Vincent Yahna
 * June 2, 2017
 * This project allows a user to keep an offline reading list for books read, 
 * movies watched, etc. It uses SQLite for the database to keep things simple.
 * This class is just the entry point (main method) for the program
 */
public class ReadingList {

    /**
     * The main method of the program will just pass control to the 
     * GUIController class for now
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
        
        //GUIController.main(args); 
        ReadingListDatabase model = new ReadingListDatabase();
        JFrame myWindow = new LoginForm();
        positionJFrame(myWindow);
        ReadingListController controller = new ReadingListController(myWindow, model);
        
        /**Connection c = null;
        try {
          boolean fileExists = new File("reading_list.db").exists();
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:reading_list.db");
          if(!fileExists){
              //good enough for now. We assume if the file exists,
              //then the tables have been created.
             createDatabase(c);
          }
          

          c.close();
        } catch ( SQLException e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        */
        
        //testing();
        //testingDBTypes();
        //addTestData();
        //testAddAuthorPanel();
        
        /* Create and display the form */
        /**java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
        */
        
        
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
    
    /**
     * Place for testing some code
     */
    public static void testing(){
        try {
            ReadingListDatabase rld = new ReadingListDatabase();
            String[] tables = rld.availableTables();
            for(int i=0; i<tables.length; i++){
                System.out.println(tables[i]);
            }
            rld.getAllUsers();
            
            rld.addAuthor("Thomas", "Barron", "Notable for writing about Merlin.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadingList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReadingList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void testingDBTypes() throws ClassNotFoundException, SQLException{
        Author a = new Author();
        Field[] f = a.getFields();
        for(int i=0; i < f.length; i++){
            System.out.println(f[i].getName());
        }
        ReadingListDatabase rld = new ReadingListDatabase();
        ResultSet rs = rld.getAllAuthorsWithAllFields();
        a.setVariables(rs);
        System.out.println(a.id + ": " + a.first_name + " " + a.last_name + "\n" + a.notes);
        Authors entityauthors = new Authors();
        //entityauthors.
        
    }
    @PersistenceContext
    private EntityManager em;
    private static EntityManagerFactory emf;
    
    public static void addTestData() throws SQLException{
        
        //This isn't working, so we'll just go back to the DatabaseStructure classes instead
        /*Authors a = new Authors();
        a.setLastName("Barron");
        a.setFirstName("T.A.");
        a.setNotes("Wrote about Merlin a lot");
        //EntityManager em = EntityManagerFactory.createEntityManager();"ReadingListPu"
        //getEntityManager().persist(a);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ReadingListPU");
        EntityManager em = factory.createEntityManager();
       

       
       //EntityManager em  = emf.createEntityManager();
       // EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AuthorsPA");
        //EntityManager entityManager = entityManagerFactory.createEntityManager();*/
    }
    
    public static void testAddAuthorPanel() throws ClassNotFoundException, SQLException{
        //AddAuthorPanel ap = new AddAuthorPanel();
        //GUIController.testPanel(ap);
        ReadingListDatabase rld = new ReadingListDatabase();
        System.out.println(rld.addAuthor2("Gerald", "Ford", "A random name."));
        
    }

}
