package UI;

import Beans.RawBean;
import DAO.Implementation.RawDAOImplementation;
import DAO.Interface.RawDAOInterface;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clarkabalos
 */
public class RMManagement extends javax.swing.JFrame {
    private RawDAOInterface rmImp = new RawDAOImplementation();
    private RawBean selectedRaw = new RawBean();
    private RawBean editRaw = new RawBean();

    //<--- CLARK'S CODE STARTS HERE --->
    public RMManagement() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        errorLabel.setVisible(false);
        errorLabel1.setVisible(false);
        errorLabel2.setVisible(false);
        errorLabel3.setVisible(false);
        errorLabel4.setVisible(false);
        errorLabel5.setVisible(false);
        btnSave.setEnabled(false);
        ViewAllRM();
    }
    
    public DefaultTableModel initializeTable(){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Price");
        defaultTableModel.addColumn("Stock");
        defaultTableModel.addColumn("Critical");
        defaultTableModel.addColumn("Status");
        defaultTableModel.addColumn("UOM");
        return defaultTableModel;
    }
    
    public void ViewAllRM(){
       DefaultTableModel defaultModel = initializeTable();
       RawBean r;
       for (int i = 0; i < rmImp.getRawByStatus("available").size(); i++) {
            r = rmImp.getRawByStatus("available").get(i);
            defaultModel.addRow(new Object[] {r.getRawID(), r.getRaw(), r.getPrice(), r.getStock(), r.getCritical(), r.getRmstatus(), r.getUom()});
       }
       rmTable.setModel(defaultModel);
       rmTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            try {
            clearText();
            DefaultTableModel defaultTableModel = (DefaultTableModel) rmTable.getModel();
            if (rmTable.getSelectedRow() >= 0) {
                idField.setText(defaultTableModel.getValueAt(rmTable.getSelectedRow(), 0).toString());
                nameField.setText((String) defaultTableModel.getValueAt(rmTable.getSelectedRow(), 1));
                priceField.setText(defaultTableModel.getValueAt(rmTable.getSelectedRow(), 2).toString());
                stockField.setText(defaultTableModel.getValueAt(rmTable.getSelectedRow(), 3).toString());
                criticalField.setText(defaultTableModel.getValueAt(rmTable.getSelectedRow(), 4).toString());
                uomField.setText((String) defaultTableModel.getValueAt(rmTable.getSelectedRow(), 6));
                selectedRaw = rmImp.getRaw((int) defaultTableModel.getValueAt(rmTable.getSelectedRow(), 0));
                btnSave.setEnabled(true);
                btnAdd.setEnabled(false);
            } else {
                selectedRaw = null;
                btnSave.setEnabled(false);
              }
            } catch (Exception err) {
                err.printStackTrace();
            } 
        }
       });
    }
    
    public void clearText(){
        nameField.setText("");
        idField.setText("");
        priceField.setText("");
        stockField.setText("");
        criticalField.setText("");
        uomField.setText("");
        errorLabel.setVisible(false);
        errorLabel1.setVisible(false);
        errorLabel2.setVisible(false);
        errorLabel3.setVisible(false);
        errorLabel4.setVisible(false);
        errorLabel5.setVisible(false);
        btnSave.setEnabled(false);
        btnAdd.setEnabled(true);
    }
    
    public boolean authenticateRM(){
        boolean flag = true;
        editRaw = new RawBean();
        int count = 0;
        
        if(nameField.getText().equals("")) {
            errorLabel1.setVisible(true);
            flag = false;
        }
        else {
            errorLabel.setVisible(false);
            editRaw.setRaw(nameField.getText());
            for(int i = 0; i < rmImp.getRawByStatus("available").size(); i++){
                if(nameField.getText().equalsIgnoreCase(rmImp.getAllRaw().get(i).getRaw()) && 
                        Integer.parseInt(idField.getText()) != rmImp.getAllRaw().get(i).getRawID()) {
                     errorLabel1.setVisible(true);
                     errorLabel.setVisible(true);
                     flag = false;
                }
            }
        }
        if(!priceField.getText().equals("") && isNumber(priceField.getText())) {
            if(Float.parseFloat(priceField.getText()) > 0) {
                errorLabel2.setVisible(false);
                editRaw.setPrice(Float.parseFloat(priceField.getText()));
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
                editRaw.setStock(Float.parseFloat(stockField.getText()));
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
                editRaw.setCritical(Float.parseFloat(criticalField.getText()));
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
        if(uomField.getText().equals("")) {
            errorLabel5.setVisible(true);
            flag = false;
        }
        else {
            errorLabel5.setVisible(false);
            editRaw.setUom(uomField.getText());
        }
        editRaw.setRmstatus("available");
        return flag;
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rmTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
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
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(620, 402));

        rmTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Stock", "Critical", "Status", "UOM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rmTable);
        rmTable.getColumnModel().getColumn(0).setResizable(false);
        rmTable.getColumnModel().getColumn(1).setResizable(false);
        rmTable.getColumnModel().getColumn(2).setResizable(false);
        rmTable.getColumnModel().getColumn(3).setResizable(false);
        rmTable.getColumnModel().getColumn(4).setResizable(false);
        rmTable.getColumnModel().getColumn(5).setResizable(false);
        rmTable.getColumnModel().getColumn(6).setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Raw Material Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 153)));
        jPanel2.setMinimumSize(new java.awt.Dimension(620, 236));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel2.setText("Name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 56, -1, -1));

        jLabel3.setText("Price:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 82, -1, -1));

        jLabel4.setText("Stock:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 108, -1, -1));

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
        jPanel2.add(stockField, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 105, 109, -1));

        btnSave.setText("Update");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 195, -1, -1));

        jLabel10.setText("Critical:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 134, -1, -1));

        jLabel12.setText("Unit of Measurement:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));
        jPanel2.add(criticalField, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 131, 109, -1));
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

        btnAdd.setLabel("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 195, -1, -1));

        btnDelete.setLabel("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 195, -1, -1));

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 195, -1, -1));

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel9.setText("RAW MATERIALS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBack)
                        .addComponent(jLabel9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addGap(151, 151, 151))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
         if(authenticateRM()) {
            try{
                rmImp.addRaw(editRaw);
                ViewAllRM();
                clearText();
            } catch(Exception err){
                err.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if(selectedRaw != null){
                if(!idField.getText().equals("")) {
                    if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this raw material?", "Confirm Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                            rmImp.deleteRaw(selectedRaw);
                            ViewAllRM();
                    }
                    clearText();
                } 
            } else
                JOptionPane.showMessageDialog(null, "Please select an entry to delete.", "Blank Form", JOptionPane.WARNING_MESSAGE);
        }   catch (Exception err) {
            err.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if(!idField.getText().equals("")) {
                if(authenticateRM()) {
                    editRaw.setRawID(Integer.parseInt(idField.getText()));
                    rmImp.editRaw(editRaw);
                    ViewAllRM();
                    clearText();
                } 
            } else
                JOptionPane.showMessageDialog(null, "Please select and entry to update.", "Blank Form", JOptionPane.WARNING_MESSAGE);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try {
                EODTab e = new EODTab();
                e.setVisible(true);
                dispose();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearText();
    }//GEN-LAST:event_btnClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField criticalField;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JLabel errorLabel3;
    private javax.swing.JLabel errorLabel4;
    private javax.swing.JLabel errorLabel5;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JTable rmTable;
    private javax.swing.JTextField stockField;
    private javax.swing.JTextField uomField;
    // End of variables declaration//GEN-END:variables
}
