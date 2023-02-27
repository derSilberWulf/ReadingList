/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package readinglistGUI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import readinglist.ReadingListDatabase;

/**
 *
 * @author yahna
 */
public class ChooseTagPanel extends javax.swing.JPanel {

    public static void main(String[] args){
        GUIController.testPanel(new ChooseTagPanel());
    }
    /**
     * Creates new form ChooseTagPanel
     */
    public ChooseTagPanel() {
        initComponents();
        this.setTags();
        this.jList1.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if(super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                }
                else {
                    super.addSelectionInterval(index0, index1);
                }
                fireValueChanged(index0, index1);
            }
        });
    }
    public void reloadTags(){
        setTags();
    }
    private void setTags(){
        try {
            ReadingListDatabase rld = new ReadingListDatabase();
            List<ComboBoxItem> l = rld.getAllTagsForCombo();
            DefaultComboBoxModel<ComboBoxItem> dcbm = new DefaultComboBoxModel<>(l.toArray(new ComboBoxItem[0]));
            this.jList1.setModel(dcbm);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ChooseTagPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectTags(int[] ids){
         //jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
         //we have to convert the database indices into the array's indices
         ListModel<ComboBoxItem> combolist = jList1.getModel();
         int[] selectIds = new int[ids.length];
         int found = 0;
         //ArrayList<Integer> selectIds = new ArrayList<>();
         //List<Integer> listIds = Arrays.asList(ids);
         for(int i = 0; i < combolist.getSize(); i++){
             for(int j=0; j < ids.length; j++){
                 if(combolist.getElementAt(i).value == ids[j]){
                     selectIds[found++] = i;
                 }
             }
         }
         jList1.setSelectedIndices(Arrays.copyOf(selectIds, found));
    }
    
    public int[] getSelectedTags(){
        List<ComboBoxItem> cbl = jList1.getSelectedValuesList();
        int[] a = new int[cbl.size()];
        int i = 0;
        for(ComboBoxItem l : cbl){
            a[i++] = l.value;
        }
        return a;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        jScrollPane1.setViewportView(jList1);

        jButton1.setText("New Tags");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GUIController.testPanel(new CreateTagPanel(this));
        //System.out.println(Arrays.toString(this.getSelectedTags()));
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JList<ComboBoxItem> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
