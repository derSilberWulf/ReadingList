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
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;

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
}
