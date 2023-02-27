/*
 * Controller for directing flow of GUIs and the program
 * Idea: change this to a static class with some data storage capabilities,
 * such as being able to store the user's id, and thus it would also have methods
 * for initializing the gui components
 */
/**
 * Vincent Yahna
 * yahna.3@wright.edu 
 */
package readinglistGUI;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Vincent Yahna
 */
public class GUIController {
    private static int user_id;
    private static boolean user_set = false;
    /**
     * 
     * @return 
     * @throws java.lang.Exception 
     */
    public static int get_userid() throws Exception{
        if(! user_set){
            throw new IllegalStateException("The User has not been logged in!");
        }
        return user_id;
    }
    /**
     * 
     * @param user_id 
     */
    public static void set_userid(int user_id){
        GUIController.user_id = user_id;
        GUIController.user_set = true;
    }
    
    /**
     * Position a JFrame in the middle of the screen and set it to visible
     * @param jf the JFrame
     */
    public static void positionJFrame(JFrame jf){
        jf.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setLocation(dim.width/2- jf.getSize().width/2, dim.height/2 - jf.getSize().height/2);
    }
    

    
    
    public static void main(String[] args){
        //upon startup, go to login
        //Window myWindow 
        JFrame myWindow = new LoginForm();
        positionJFrame(myWindow);
        
        
        
        //actual flow will have to be done with event listeners

        //we can pass this controller to the login form as a way to communicate
        //whatever the case, have to get the userid from it somehow
        //with user id, go to a gui asking user what they want to do
        
        //from here, there will be options, such as adding new data or viewing data
    }
    
    public static void SwitchToLoginForm(Point location){
        JFrame myWindow = new LoginForm();
        myWindow.setLocation(location);
    }
    
    public static void testPanel(JComponent jp){
        JFrame jf = new JFrame();
        jf.add(jp);
        GUIController.positionJFrame(jf);
        jf.setVisible(true);
        //jf.setSize(new Dimension(jp.getWidth(), jp.getHeight()) );
        jf.pack();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
      /**
     * Picks an item  in a JComboBox based on value
     * @param comboBox
     * @param value 
     */
    public static void setComboBoxSelectedValue(JComboBox<ComboBoxItem> comboBox, int value){
        ComboBoxItem item;
        for (int i = 0; i < comboBox.getItemCount(); i++){
            item = comboBox.getItemAt(i);
            if (item.value == value){
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }
    /**
     * Picks an item in a JComboBox based on label
     * @param comboBox
     * @param label 
     */
    public static  void setComboBoxSelectedValue(JComboBox<ComboBoxItem> comboBox, String label){
        ComboBoxItem item;
        for (int i = 0; i < comboBox.getItemCount(); i++){
            item = comboBox.getItemAt(i);
            if (item.label == null ? label == null : item.label.equals(label)){
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }
}
