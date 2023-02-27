/*
 * The model for the GUI : handles user actions in GUI such as clicking
 * a submit button
 */

package not_used;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import readinglist.ReadingListDatabase;

/**
 *
 * @author Alexander Yahna
 */
public class ReadingListModel {
    private ReadingListDatabase database; // accessor for class representing database
    
    public ReadingListModel(){
        try {
            database = new ReadingListDatabase();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReadingListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Getter for database
     * @return ReadingListDatabase with connection to SQLite database
     */
    public ReadingListDatabase getDatabase(){
        return database;
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
            tables = database.availableTables();
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
