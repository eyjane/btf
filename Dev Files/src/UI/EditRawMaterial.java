package UI;

import Beans.RawBean;
import DAO.Implementation.RawDAOImplementation;
import DAO.Interface.RawDAOInterface;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clarkabalos
 */
public class EditRawMaterial extends javax.swing.JFrame {
    private RawDAOInterface rwImp = new RawDAOImplementation();
    private RawBean raw;
    private RMManagement rm;

    //<--- CLARK'S CODE STARTS HERE --->
    
    public EditRawMaterial(RMManagement r) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        rm = r;
        raw = r.getRaw();
        initComponents();
        errorLabel.setVisible(false);
        errorLabel1.setVisible(false);
        errorLabel2.setVisible(false);
        errorLabel3.setVisible(false);
        errorLabel4.setVisible(false);
        errorLabel5.setVisible(false);
        setFields(raw);
    }
    
    public DefaultTableModel initializeRecipeTable(){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Cost");
        defaultTableModel.addColumn("Stock");
        defaultTableModel.addColumn("Status");
        return defaultTableModel;
    }
    
   public boolean authenticateRM(){
        boolean flag = true;
        
        if(nameField.getText().equals("")) {
            errorLabel.setVisible(true);
            flag = false;
        }
        else {
            errorLabel.setVisible(false);
            errorLabel1.setVisible(false);
            raw.setRaw(nameField.getText());
            for(int i = 0; i < rwImp.getRawByStatus("available").size(); i++){
                if(nameField.getText().equalsIgnoreCase(rwImp.getAllRaw().get(i).getRaw())
                        && raw.getRawID() != rwImp.getAllRaw().get(i).getRawID()) {
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
    }
    
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();
        errorLabel1 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        editRawMaterial = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();
        criticalField = new javax.swing.JTextField();
        uomField = new javax.swing.JTextField();
        errorLabel2 = new javax.swing.JLabel();
        errorLabel3 = new javax.swing.JLabel();
        errorLabel4 = new javax.swing.JLabel();
        errorLabel5 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Edit Raw Material");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 47));

        nameLabel.setText(" ");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 243, 0, -1));

        jLabel2.setText("Name: ");

        jLabel6.setText("Price:");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        errorLabel.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel.setText("ERROR: Required field.");

        errorLabel1.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel1.setText("Duplicate name.");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        editRawMaterial.setText("Edit Raw Material");
        editRawMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRawMaterialActionPerformed(evt);
            }
        });

        jLabel7.setText("Stock:");

        jLabel8.setText("Critical:");

        jLabel9.setText("Unit of Measurement:");

        priceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFieldActionPerformed(evt);
            }
        });

        stockField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockFieldActionPerformed(evt);
            }
        });

        criticalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criticalFieldActionPerformed(evt);
            }
        });

        uomField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uomFieldActionPerformed(evt);
            }
        });

        errorLabel2.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel2.setText("ERROR: Required field. Please input valid number.");

        errorLabel3.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel3.setText("ERROR: Required field. Please input valid number.");

        errorLabel4.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel4.setText("ERROR: Required field. Please input valid number.");

        errorLabel5.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel5.setText("ERROR: Required field. Please input valid number.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(200, 200, 200)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorLabel3)
                            .addComponent(errorLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(uomField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorLabel5)
                                .addGap(0, 13, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(editRawMaterial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(criticalField, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(stockField)
                    .addComponent(priceField)
                    .addComponent(nameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(errorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorLabel1))
                    .addComponent(errorLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel)
                    .addComponent(errorLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(stockField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(criticalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(uomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel5))
                .addGap(126, 126, 126))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editRawMaterial)
                    .addComponent(btnCancel))
                .addGap(60, 60, 60))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 510, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void editRawMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRawMaterialActionPerformed
        if(authenticateRM()){
            try{
                rwImp.editRaw(raw);
                JOptionPane.showMessageDialog(null, "Raw material successfully edited!", "Success", JOptionPane.INFORMATION_MESSAGE);
                rm.setVisible(true);
                rm.ViewAllRM();
                rm.setFields(raw);
                dispose();
            } catch(Exception err){
                err.printStackTrace();
            }
        }
    }//GEN-LAST:event_editRawMaterialActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        rm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void priceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFieldActionPerformed

    private void stockFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockFieldActionPerformed

    private void criticalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criticalFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_criticalFieldActionPerformed

    private void uomFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uomFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uomFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JTextField criticalField;
    private javax.swing.JButton editRawMaterial;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JLabel errorLabel3;
    private javax.swing.JLabel errorLabel4;
    private javax.swing.JLabel errorLabel5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField priceField;
    private javax.swing.JTextField stockField;
    private javax.swing.JTextField uomField;
    // End of variables declaration//GEN-END:variables
}
