package not_used;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import readinglist.ReadingListDatabase;
import readinglistGUI.LoginForm;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author
 */
public class ReadingListController implements ActionListener {
    
    JFrame currentView;
    ReadingListDatabase model;
    int user;
    boolean userSet;
    
    public ReadingListController(JFrame view, ReadingListDatabase model){
        this.currentView = view;
        this.model = model;
        userSet = false;
    }
    
    public void SetUser(int userID){
        user = userID;
        userSet = true;
    }
    
    /**
     * TODO: Maybe make it throw an exception if userSet is false?
     * @return 
     */
    public int GetUser(){
        return user;
    }
    
        /**
     * Position a JFrame in the middle of the screen and set it to visible
     * @param jf the JFrame
     */
    public static void CenterAndSetVisibleJFrame(JFrame jf){
        jf.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setLocation(dim.width/2- jf.getSize().width/2, dim.height/2 - jf.getSize().height/2);
    }
    
    public void SetViewToLoginForm(){
       currentView.dispose();
       JFrame myWindow = new LoginForm();
       CenterAndSetVisibleJFrame(myWindow);
       //myWindow.setVisible(true);
       
    }
    
    public void SetViewToAddUserUI(){
        currentView.dispose();
        
    }
    
    public void SetViewToAddGameForm(){
        
    }
    
    
    public void SetViewToPlayGameForm(){
        
    }
    
     public void SetViewToReadMangaForm(){
        
    }
     
     public void SetViewToAddMangaForm(){
         
     }
     
     public void SetViewToWatchAnimeForm(){
         
     }
     
     public void SetViewToAddTVShowForm(){
         
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
