/*
 */
package readinglistGUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import readinglist.ReadingListDatabase;
import readinglist.ReadingListDatabase.users_struct;


/**
 *
 * @author VJY
 */
public class Login_form extends javax.swing.JFrame {

    class MyButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //create a new user form
            AddUserUI aui = new AddUserUI();
            Window w = new Window(aui);
            aui.setVisible(true);
            //Window w = SwingUtilities.windowForComponent(aui);
            //System.out.println(w);
            //aui.addButtonListener(new ReloadListener(lf));
            //aui.addContainerListener(new ReloadListener());
            
            //w.addWindowListener(new ReloadListener());
        }
    }
    class LoginButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
     class ReloadListener implements WindowFocusListener{


        @Override
        public void windowGainedFocus(WindowEvent e) {
            //System.out.println("focusing");
            try {
                 fillBox();
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(Login_form.class.getName()).log(Level.SEVERE, null, ex);
             }
        }

        @Override
        public void windowLostFocus(WindowEvent e) {
            //System.out.println("lost focus");
        }
    }
    /**
     * Creates new form Login_form
     */
    public Login_form() {
        initComponents();
        try {
            fillBox();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login_form.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        this.addCreateNewUserButtonListener(new MyButtonListener());
        this.addLoginButtonListener(new LoginButtonListener());
        this.addWindowFocusListener(new ReloadListener());
        this.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2- this.getSize().width/2, dim.height/2 - this.getSize().height/2);
       
    }
    /**
     * Get user data and put this in the combo box
     */
    private void fillBox() throws ClassNotFoundException{
        this.username_combo_box.removeAllItems();
        try {
            //load users and display them
            Iterator<users_struct> i = new ReadingListDatabase().getAllUsers().iterator();
            while(i.hasNext()){
                users_struct item = i.next();
                this.username_combo_box.addItem(new Combo_Box_Item(item.id, item.username));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_form.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(this.username_combo_box.getItemCount() ==0){
            //don't let them login if there are no users
            this.login_button.setEnabled(false);
        }
         else{
             this.login_button.setEnabled(true);
         }
        
    }
    
    

    
    public void addCreateNewUserButtonListener(ActionListener al){
        this.create_new_user_button.addActionListener(al);
    }
    
    public void addLoginButtonListener(ActionListener al){
        this.login_button.addActionListener(al);
    }
    
    /**
     * Get selected username
     * @return String
     */
    public String getUserName(){
        return ((Combo_Box_Item)(this.username_combo_box.getSelectedItem())).label;
    }
    
    /**
     * Get selected user id
     * @return String
     */
    public int getUserId(){
        return ((Combo_Box_Item)(this.username_combo_box.getSelectedItem())).value;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login_button = new javax.swing.JButton();
        username_combo_box = new javax.swing.JComboBox<Combo_Box_Item>();
        create_new_user_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        login_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        login_button.setText("login");

        username_combo_box.setAutoscrolls(true);
        username_combo_box.setName(""); // NOI18N

        create_new_user_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        create_new_user_button.setText("create new user");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(create_new_user_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(login_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(username_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(login_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(create_new_user_button)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create_new_user_button;
    private javax.swing.JButton login_button;
    private javax.swing.JComboBox<Combo_Box_Item> username_combo_box;
    // End of variables declaration//GEN-END:variables
}



