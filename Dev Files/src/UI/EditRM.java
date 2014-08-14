<<<<<<< HEAD
package UI;

import Beans.RawBean;
import DAO.Implementation.RawDAOImplementation;
import DAO.Interface.RawDAOInterface;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b

/**
 *
 * @author Evy
 */
public class EditRM extends javax.swing.JFrame {
<<<<<<< HEAD
    private RawDAOInterface rwImp = new RawDAOImplementation();
    private RawBean raw;
    private RMManagement rm;
   
    //<--- CLARK'S CODE STARTS HERE --->
    
    public EditRM(RMManagement r) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        rm = r;
        initComponents();
        errorLabel.setVisible(false);
        errorLabel1.setVisible(false);
        errorLabel2.setVisible(false);
        errorLabel3.setVisible(false);
        errorLabel4.setVisible(false);
        errorLabel5.setVisible(false);
        prepareTable();
    }
    
    public void prepareTable(){
        rmTable.setModel(rm.getRMTable());
        rmTable.getColumnModel().getColumn(0).setMinWidth(0);
        rmTable.getColumnModel().getColumn(0).setMaxWidth(0);
        
        rmTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            try {
            DefaultTableModel defaultTableModel = (DefaultTableModel) rmTable.getModel();
            if (rmTable.getSelectedRow() >= 0) { 
                raw = rwImp.getRaw((int) defaultTableModel.getValueAt(rmTable.getSelectedRow(), 0));
                setFields(raw);
            } else {
                raw = null;
              }
            } catch (Exception err) {
                err.printStackTrace();
            } 
        }
       });
    }
    
   /*public boolean authenticateRM(){
        boolean flag = true;
        
        if(nameField.getText().equals("")) {
            errorLabel.setVisible(true);
            flag = false;
        }
        else {
            errorLabel.setVisible(false);
            errorLabel1.setVisible(false);
            raw.setRaw(nameField.getText());
            ArrayList<RawBean> rList = new ArrayList<RawBean>();
            rList = rwImp.getRawByStatus("available");
            for(int i = 0; i < rList.size(); i++){
                if(nameField.getText().equalsIgnoreCase(rList.get(i).getRaw())
                        && raw.getRawID() != rList.get(i).getRawID()) {
                     errorLabel1.setVisible(true);
                     errorLabel.setVisible(true);
                     flag = false;
                }
            }
        }
        if(!priceField.getText().equals("") && isNumber(priceField.getText())) {
            if(Float.parseFloat(priceField.getText()) > 0) {
                errorLabel2.setVisible(false);
                raw.setPrice(Float.parseFloat(priceField.getText()));
            }
            else {
                errorLabel2.setVisible(true);
                flag = false;
            }
        }
        else {
            errorLabel2.setVisible(true);
            flag = false;
        }
        if(!stockField.getText().equals("") && isNumber(stockField.getText())) {
            if(Float.parseFloat(stockField.getText()) > 0) {
                errorLabel3.setVisible(false);
                raw.setStock(Float.parseFloat(stockField.getText()));
            }
            else {
                errorLabel3.setVisible(true);
                flag = false;
            }
        }
        else {
            errorLabel3.setVisible(true);
            flag = false;
        }
        if(!criticalField.getText().equals("") && isNumber(criticalField.getText())) {
            if(Float.parseFloat(criticalField.getText()) > 0) {
                errorLabel4.setVisible(false);
                raw.setCritical(Float.parseFloat(criticalField.getText()));
            }
            else {
                errorLabel4.setVisible(true);
                flag = false;
            }
        }
        else {
            errorLabel4.setVisible(true);
            flag = false;
        }
        if(uomField.getText().equals("") || isNumber(uomField.getText())) {
            errorLabel5.setVisible(true);
            flag = false;
        }
        else {
            errorLabel5.setVisible(false);
            raw.setUom(uomField.getText());
        }
        raw.setRmstatus("available");
        return flag;
    } */
    
   public void setFields(RawBean r){
        nameField.setText(r.getRaw());
        priceField.setText(Float.toString(r.getPrice()));
        stockField.setText(Float.toString(r.getStock()));
        criticalField.setText(Float.toString(r.getCritical()));
        uomField.setText(r.getUom());
    }
   
    public boolean isNumber(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    //<--- CLARK'S CODE ENDS HERE --->

=======

    /**
     * Creates new form EditRM
     */
    public EditRM() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        rmTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jPanel2 = new javax.swing.JPanel();
<<<<<<< HEAD
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
=======
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
        nameField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        criticalField = new javax.swing.JTextField();
        uomField = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();
        errorLabel2 = new javax.swing.JLabel();
        errorLabel3 = new javax.swing.JLabel();
        errorLabel4 = new javax.swing.JLabel();
        errorLabel5 = new javax.swing.JLabel();
        errorLabel1 = new javax.swing.JLabel();
<<<<<<< HEAD
        btnEdit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
=======
        btnClear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(956, 555));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(620, 402));

        rmTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
<<<<<<< HEAD
                "Name", "Price", "Stock", "Critical", "Status", "UOM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
=======
                "ID", "Name", "Price", "Stock", "Critical", "Status", "UOM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
<<<<<<< HEAD
        rmTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(rmTable);
        rmTable.getColumnModel().getColumn(0).setResizable(false);
        rmTable.getColumnModel().getColumn(1).setResizable(false);
        rmTable.getColumnModel().getColumn(2).setResizable(false);
        rmTable.getColumnModel().getColumn(3).setResizable(false);
        rmTable.getColumnModel().getColumn(4).setResizable(false);
=======
        jScrollPane1.setViewportView(rmTable);
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Raw Material Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 153)));
        jPanel2.setMinimumSize(new java.awt.Dimension(620, 236));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

<<<<<<< HEAD
=======
        jLabel1.setText("ID:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
        jLabel2.setText("Name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 56, -1, -1));

        jLabel3.setText("Price:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 82, -1, -1));

        jLabel4.setText("Stock:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 108, -1, -1));

<<<<<<< HEAD
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameFieldKeyReleased(evt);
            }
        });
        jPanel2.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 53, 109, -1));

        priceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                priceFieldKeyReleased(evt);
            }
        });
        jPanel2.add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 79, 109, -1));

        stockField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stockFieldKeyReleased(evt);
            }
        });
=======
        idField.setEditable(false);
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });
        jPanel2.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 27, 109, -1));

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        jPanel2.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 53, 109, -1));
        jPanel2.add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 79, 109, -1));
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
        jPanel2.add(stockField, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 105, 109, -1));

        jLabel10.setText("Critical:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 134, -1, -1));

        jLabel12.setText("Unit of Measurement:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));
<<<<<<< HEAD

        criticalField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                criticalFieldKeyReleased(evt);
            }
        });
        jPanel2.add(criticalField, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 131, 109, -1));

        uomField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                uomFieldKeyReleased(evt);
            }
        });
=======
        jPanel2.add(criticalField, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 131, 109, -1));
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
        jPanel2.add(uomField, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 157, 79, -1));

        errorLabel.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel.setText("Duplicate name exists.");
        jPanel2.add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 56, -1, -1));

        errorLabel2.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel2.setText("ERROR: Required field. Please input valid number.");
        jPanel2.add(errorLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 82, -1, -1));

        errorLabel3.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel3.setText("ERROR: Required field. Please input valid number.");
        jPanel2.add(errorLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 108, -1, -1));

        errorLabel4.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel4.setText("ERROR: Required field. Please input valid number.");
        jPanel2.add(errorLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 134, -1, -1));

        errorLabel5.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel5.setText("ERROR: Required field.");
        jPanel2.add(errorLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 160, -1, -1));

        errorLabel1.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel1.setText("ERROR: Required field.");
        jPanel2.add(errorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 56, -1, -1));

<<<<<<< HEAD
        btnEdit.setText("Edit Raw Material");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel2.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, -1));

        btnBack.setText("Back");
=======
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jButton1.setText("Save");
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel9.setText("RAW MATERIALS");

        btnBack.setText("BACK");
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
<<<<<<< HEAD
        jPanel2.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel9.setText("RAW MATERIALS");
=======
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
<<<<<<< HEAD
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
=======
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack))
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< HEAD
                .addGap(69, 69, 69))
=======
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addGap(35, 35, 35))
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

<<<<<<< HEAD
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        rm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(raw != null){
                try{
                    raw.setRmstatus("available");
                    rwImp.editRaw(raw);
                    JOptionPane.showMessageDialog(null, "Raw material successfully edited!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    rm.setVisible(true);
                    rm.ViewAllRM();
                    //rm.setFields(raw);
                    dispose();
                } catch(Exception err){
                    err.printStackTrace();
                }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyReleased
        int select = rmTable.getSelectedRow();
        if (select <= 0) {
            JOptionPane.showMessageDialog(null, "Please select an entry to delete.", "Blank Form", JOptionPane.WARNING_MESSAGE);
        } else{
            if(nameField.getText().equals("")) {
                errorLabel.setVisible(true);
            }
            else {
                errorLabel.setVisible(false);
                errorLabel1.setVisible(false);
                raw.setRaw(nameField.getText());
                ArrayList<RawBean> rList = new ArrayList<RawBean>();
                rList = rwImp.getRawByStatus("available");
                for(int i = 0; i < rList.size(); i++){
                    if(nameField.getText().equalsIgnoreCase(rList.get(i).getRaw())
                            && raw.getRawID() != rList.get(i).getRawID()) {
                         errorLabel1.setVisible(true);
                         errorLabel.setVisible(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_nameFieldKeyReleased

    private void priceFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceFieldKeyReleased
        int select = rmTable.getSelectedRow();
        if (select <= 0) {
            JOptionPane.showMessageDialog(null, "Please select an entry to delete.", "Blank Form", JOptionPane.WARNING_MESSAGE);
        } else{
            if(!priceField.getText().equals("") && isNumber(priceField.getText())) {
                if(Float.parseFloat(priceField.getText()) > 0) {
                    errorLabel2.setVisible(false);
                    raw.setPrice(Float.parseFloat(priceField.getText()));
                }
                else {
                    errorLabel2.setVisible(true);
                }
            }
            else {
                errorLabel2.setVisible(true);
            }
        }
    }//GEN-LAST:event_priceFieldKeyReleased

    private void stockFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockFieldKeyReleased
        int select = rmTable.getSelectedRow();
        if (select <= 0) {
            JOptionPane.showMessageDialog(null, "Please select an entry to delete.", "Blank Form", JOptionPane.WARNING_MESSAGE);
        } else{
            if(!stockField.getText().equals("") && isNumber(stockField.getText())) {
                if(Float.parseFloat(stockField.getText()) > 0) {
                    errorLabel3.setVisible(false);
                    raw.setStock(Float.parseFloat(stockField.getText()));
                }
                else {
                    errorLabel3.setVisible(true);
                }
            }
            else {
                errorLabel3.setVisible(true);
            }
        }
    }//GEN-LAST:event_stockFieldKeyReleased

    private void criticalFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_criticalFieldKeyReleased
        int select = rmTable.getSelectedRow();
        if (select <= 0) {
            JOptionPane.showMessageDialog(null, "Please select an entry to delete.", "Blank Form", JOptionPane.WARNING_MESSAGE);
        } else{
            if(!criticalField.getText().equals("") && isNumber(criticalField.getText())) {
                if(Float.parseFloat(criticalField.getText()) > 0) {
                    errorLabel4.setVisible(false);
                    raw.setCritical(Float.parseFloat(criticalField.getText()));
                }
                else {
                    errorLabel4.setVisible(true);
                }
            }
            else {
                errorLabel4.setVisible(true);
            }
        }
    }//GEN-LAST:event_criticalFieldKeyReleased

    private void uomFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uomFieldKeyReleased
        int select = rmTable.getSelectedRow();
        if (select <= 0) {
            JOptionPane.showMessageDialog(null, "Please select an entry to delete.", "Blank Form", JOptionPane.WARNING_MESSAGE);
        } else{
            if(uomField.getText().equals("") || isNumber(uomField.getText())) {
                errorLabel5.setVisible(true);
            }
            else {
                errorLabel5.setVisible(false);
                raw.setUom(uomField.getText());
            }
        }
    }//GEN-LAST:event_uomFieldKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
=======
    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // clearText();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
     
           
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(EditRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditRM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
    private javax.swing.JTextField criticalField;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JLabel errorLabel3;
    private javax.swing.JLabel errorLabel4;
    private javax.swing.JLabel errorLabel5;
<<<<<<< HEAD
=======
    private javax.swing.JTextField idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JTable rmTable;
    private javax.swing.JTextField stockField;
    private javax.swing.JTextField uomField;
    // End of variables declaration//GEN-END:variables
}
