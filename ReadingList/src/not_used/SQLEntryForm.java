/*
 * Template to make forms to for entering new SQL table columns
 * Intended to be subclassed
 */

package not_used;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import layout.SpringUtilities;

/**
 *
 * @author Alexander Yahna
 */
public class SQLEntryForm extends JFrame {

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 300;
    
    private JPanel centerPanel;
    private JLabel instructions;
    private JButton submit; // user presses to submit entry
    private JButton back; // allow user to go back to previous menu JFrame
   
    
    SQLEntryForm(){
    super();        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setLayout(new BorderLayout());
        
        
        submit = new JButton("Submit");
        back = new JButton("Back");
        
        // create 3 Panels to organize content in JFrame with BorderLayout
        centerPanel = new JPanel(new SpringLayout());
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        // instructions go at top of GUI and submit button goes at bottom
        instructions = new JLabel();
        northPanel.add(instructions);
        southPanel.add(submit);
        southPanel.add(back);
        
  

        // add panels
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(new JScrollPane(centerPanel), BorderLayout.CENTER);
    }
    
    /**
     * Add inputs such as JTextFields and labels for the input to the CenterPanel
     * of the GUI
     * @param labels String array of labels
     * @param inputs JComponent array of input fields
     */
    public void labelInputs(String[] labels, JComponent[] inputs){
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
    }
    
    /**
     * Set the text instructions at the top of the Panel
     * @param text 
     */
    public void setInstructions(String text){
        instructions.setText(text);
    }
    
    
    /**
     * Test class
     * @param args 
     */
    public static void main(String[] args){
        SQLEntryForm a = new SQLEntryForm();
        a.setVisible(true);
    }
}
