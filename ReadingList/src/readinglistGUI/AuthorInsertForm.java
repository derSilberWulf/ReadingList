/*
 * An input form for the user to input a new Author into the Authors SQL table
 */

package readinglistGUI;


import javax.swing.*;
/**
 * JFrame that allows a user to enter data and submit it for a new author in 
 * the SQL table authors
 * @author Alexander Yahna
 */
public class AuthorInsertForm extends SQLEntryForm {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 300;
    
    private JTextField firstName;
    private JTextField lastName;
    private JTextArea notes;

    
    
    /**
     * default constructor : sets up form
     */
    public AuthorInsertForm(){
        super();
        this.setTitle("Add new Author to Database");
        
        //initialize fields
        firstName = new JTextField(10);
        firstName.setToolTipText("Enter the author's first name");
        lastName = new JTextField(10);
        notes = new JTextArea(2,2);
        
        
        super.setInstructions("Fill out this form and click 'submit' to add an author to the database");
        // text prompts for user - placed next to input forms
        String[] labels = {"First Name: ", "Last Name : ", "Notes (optional): "};
        JComponent[] inputs = {firstName, lastName, notes};
        super.labelInputs(labels, inputs);

    }
    
    public static void main(String[] args){
        AuthorInsertForm a = new AuthorInsertForm();
        a.setVisible(true);
    }
}


