/*
 * 
 */
package readinglist;

/**
 *  Encapsulates the SQL database and contains methods for accessing and writing
 *  to it
 */
public class ReadingListDatabase {
    
    /**
     * 
     */
    public ReadingListDatabase(){
        // stub: connect to database
    }
    /**
     * @return String array of all the tables names in this database
     */
    String[] availableTables(){
        // stub 
        return new String[] {"Authors","Works","Series","Franchises"};
    }
    
    
}
