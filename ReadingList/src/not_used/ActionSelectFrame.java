/*
 * Menu for the user to select which table from their database they want and 
 * what they want to do with it - will load other menus after the user selects
 * what they want to do
 */

package not_used;

import java.awt.*;
import javax.swing.*;

/**
 *
 * Graphical Menu for the user to select which table from their database they  
 * want and what they want to do with it
 * @author Alexander Yahna
 */
public class ActionSelectFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;
    private static final String[] ACTIONS = {"Insert","View","Modify"};
    private JList<String> tables;  // list of tables from the database to be retrieved with SQL 
    private JList<String> actions;  // what to do to the table: will include options like view and insert
    
    
    private JButton enter; // user presses to finalize selection

    /**
     * Default constructor
     */
    public ActionSelectFrame(){
        super("Reading List Database");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setLayout(new BorderLayout());
        
        // set up two JLists to hold tables and actions for user to select
        tables = new JList<>();
        //String[] tableArray = this.getAvailableTables();
        tables.setVisibleRowCount(5);
        tables.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        actions = new JList<>(ACTIONS);
        actions.setVisibleRowCount(5);
        
        enter = new JButton("Enter");
        
        // create 3 JPanels to organize content in JFrame with BorderLayout
        JPanel centerPanel = new JPanel(new GridLayout(2,2,5,5));
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        // ScrollPanes for the JLists so they are scrollable
        JScrollPane tablesScrollPane = new JScrollPane(tables);
        JScrollPane actionsScrollPane = new JScrollPane(actions);
        
        centerPanel.add(new JLabel("Tables:"));
        centerPanel.add(new JLabel("Actions:"));
        centerPanel.add(tablesScrollPane);
        
        centerPanel.add(actionsScrollPane);
        southPanel.add(enter);
        northPanel.add(new JLabel("Select a database table and what you want to do with it: "));
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(northPanel, BorderLayout.NORTH);
        
        
        
        
    }
    
    /**
     * test program
     * @param args the command line variable
     */
    public static void main(String[] args){
        ActionSelectFrame f = new ActionSelectFrame();
        f.setVisible(true);
        
    }

    /**
     * Access the database to see the available tables to view/modify
     * @return String list of table names
     */
    private String[] getAvailableTables() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
