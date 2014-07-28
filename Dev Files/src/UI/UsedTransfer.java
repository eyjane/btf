package UI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.TransactionBean;
import Beans.RawBean;
import DAO.Implementation.TransactionDAOImplementation;
import DAO.Interface.TransactionDAOInterface;
import DAO.Implementation.RawDAOImplementation;
import DAO.Interface.RawDAOInterface;
import java.awt.Component;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


/**
 *
 * @author Evy
 */
public class UsedTransfer extends javax.swing.JFrame {

    TransactionDAOInterface tclmp = new TransactionDAOImplementation();
    ArrayList<TransactionBean> aTransact;
    RawDAOInterface rmImp = new RawDAOImplementation();
    ArrayList<RawBean> aRaw;
    EODTab main;
    
    public void transactTable() {
        /*
         * FOR ACTUAL INPUT TABLE
         */
        aRaw = rmImp.getAllRaw();
        String cols[] = {"ID", "Name", "Quantity"};
        DefaultTableModel actualTable = new DefaultTableModel(cols,0);
        
        for (RawBean raw : aRaw) {
            
            Object[] data = {raw.getRawID(), raw.getRaw(), null};
            actualTable.addRow(data);
            rmTable.setModel(actualTable);
            adjustTable(rmTable);
        }
    }
    
    private void adjustTable(JTable table){
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

        //  We've exceeded the maximum width, no need to check other rows
                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            tableColumn.setPreferredWidth(preferredWidth);
        }
    }
    
    /**
     * Creates new form UsedTransfer
     */
    public UsedTransfer(EODTab t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        main = t;
        transactTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rmTable = new javax.swing.JTable();
        submitUsed = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        rmName = new javax.swing.JTextField();
        countLabel = new javax.swing.JLabel();
        rmCount = new javax.swing.JTextField();
        errorName = new javax.swing.JLabel();
        errorCount = new javax.swing.JLabel();
        type = new javax.swing.JComboBox();
        typeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Used Materials");

        rmTable.setColumnSelectionAllowed(true);
        rmTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        rmTable.getTableHeader().setReorderingAllowed(false);
        rmTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rmTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rmTable);
        rmTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        submitUsed.setText("REDUCE");
        submitUsed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitUsedActionPerformed(evt);
            }
        });

        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Reduce Quantity"));
        jPanel2.setToolTipText("");

        nameLabel.setText("Name:");

        countLabel.setText("Amount:");

        errorName.setForeground(new java.awt.Color(255, 0, 1));
        errorName.setText("ERROR: Required Field");

        errorCount.setForeground(new java.awt.Color(255, 0, 1));
        errorCount.setText("ERROR: Required field. Please input valid number.");

        type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Used", "Transferred", "Wastage" }));

        typeLabel.setText("Type:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(countLabel)
                    .addComponent(typeLabel))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rmName)
                    .addComponent(rmCount, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorName)
                    .addComponent(errorCount))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(rmName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorName))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countLabel)
                    .addComponent(rmCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorCount))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLabel))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backBtn)
                        .addGap(18, 18, 18)
                        .addComponent(submitUsed))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitUsed)
                    .addComponent(backBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitUsedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitUsedActionPerformed
        // TODO add your handling code here:
        
        boolean submit = true;

        if(rmName.getText().toString().isEmpty()) {
            
            errorName.setVisible(true);
            submit = false;
        }
        
        if(!rmCount.getText().toString().isEmpty()) {
            
            if(!isNumber(rmCount.getText().toString())) {
            
                errorCount.setVisible(true);
                submit = false;
            
            }
            
        }
        else {
            
           errorCount.setVisible(true);
           submit = false; 
        }
        
        if(submit) {
            RawBean r = new RawBean();
            String st = type.getSelectedItem().toString();
            String name = rmName.getText().toString();
            float q = Float.parseFloat(rmCount.getText().toString());
            
            // REDUCE FROM RAW TABLE
            
            
            float s = rmImp.getStock(st);
            float deduct = s - q;
            rmImp.updateStock(name, deduct);
            
            // ADD TRANSACTION
            TransactionBean t = new TransactionBean();
            t.setType(st);
            int id = rmImp.getIDbyRaw(name);
            r.setRawID(id);
            tclmp.addTransaction(t, r, q);
        }
        
    }//GEN-LAST:event_submitUsedActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        main.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void rmTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rmTableMouseClicked
        // TODO add your handling code here:
        
        int col = rmTable.getSelectedColumn();
        int row = rmTable.getSelectedRow();
        
        String name = rmTable.getValueAt(row, col).toString();
        rmName.setText(name);
        
    }//GEN-LAST:event_rmTableMouseClicked

    /*
     *  check if number!
     */

    private boolean isNumber(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * @param args the command line arguments
     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new UsedTransfer().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UsedTransfer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(UsedTransfer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(UsedTransfer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(UsedTransfer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel countLabel;
    private javax.swing.JLabel errorCount;
    private javax.swing.JLabel errorName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField rmCount;
    private javax.swing.JTextField rmName;
    private javax.swing.JTable rmTable;
    private javax.swing.JButton submitUsed;
    private javax.swing.JComboBox type;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
