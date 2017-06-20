/*
 * An input form for the user to input a new Author into the Authors SQL table
 */

package readinglistGUI;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import layout.SpringUtilities; 
/**
 * JFrame that allows a user to enter data and submit it for a new author in 
 * the SQL table authors
 * @author Alexander Yahna
 */
public class AuthorInsertForm extends JFrame {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 300;
    
    private JTextField firstName;
    private JTextField lastName;
    private JTextArea notes;
    private JButton submit; // user presses to submit entry
    private JButton back; // allow user to go back to previous menu JFrame
    
    
    /**
     * default constructor : sets up form
     */
    public AuthorInsertForm(){
        super("Add new Author to Database");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setLayout(new BorderLayout());
        
        //initialize fields
        firstName = new JTextField(10);
        firstName.setToolTipText("Enter the author's first name");
        lastName = new JTextField(10);
        notes = new JTextArea(2,2);
        
        submit = new JButton("Submit");
        back = new JButton("Back");
        
        // create 3 Panels to organize content in JFrame with BorderLayout
        JPanel centerPanel = new JPanel(new SpringLayout());
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        // instructions go at top of GUI and submit button goes at bottom
        northPanel.add(new JLabel("Fill out this form and click 'submit' to add an author to the database"));
        southPanel.add(submit);
        southPanel.add(back);
        
        // text prompts for user - placed next to input forms
        String[] labels = {"First Name: ", "Last Name : ", "Notes (optional): "};
        JComponent[] inputs = {firstName, lastName, notes};
        
        // setup prompt/input area with SpringLayout
        for(int i = 0; i < labels.length; ++i){
            JLabel label = new JLabel(labels[i], JLabel.TRAILING);
            centerPanel.add(label);
            label.setLabelFor(inputs[i]);
            centerPanel.add(inputs[i]);
        }
        
        // Lay out the panel
        SpringUtilities.makeCompactGrid(centerPanel,
                                        labels.length , 2, //rows, columns
                                        6,6,   //initX, initY
                                        10,10);   //xPad, yPad
        
        // add panels
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(new JScrollPane(centerPanel), BorderLayout.CENTER);
    }
    
    public static void main(String[] args){
        AuthorInsertForm a = new AuthorInsertForm();
        a.setVisible(true);
    }
}


