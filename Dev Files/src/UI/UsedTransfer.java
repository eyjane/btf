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
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
        String cols[] = {"ID", "Name", "Quantity", "Used", "Transferred", "Wastage"};
        DefaultTableModel actualTable = new DefaultTableModel(cols,0);
        
        for (RawBean raw : aRaw) {
            
            Object[] data = {raw.getRawID(), raw.getRaw(), raw.getStock(), "0.00", "0.00", "0.00"};
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
        errorLabel.setVisible(false);
        abortedLabel.setVisible(false);
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
        errorLabel = new javax.swing.JLabel();
        abortedLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Used Materials");

        rmTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Quantity in Stock", "Used", "Transferred", "Wastage"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rmTable.setColumnSelectionAllowed(true);
        rmTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rmTable.setDragEnabled(true);
        rmTable.getTableHeader().setReorderingAllowed(false);
        rmTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rmTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rmTable);
        rmTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        rmTable.getColumnModel().getColumn(0).setMinWidth(0);
        rmTable.getColumnModel().getColumn(0).setMaxWidth(0);

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

        errorLabel.setForeground(new java.awt.Color(255, 0, 1));
        errorLabel.setText("Submission Failed. Please check that all inputs are positive numbers and that no fields are empty.");

        abortedLabel.setText("Submission aborted. No changes were made.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(backBtn)
                                .addGap(18, 18, 18)
                                .addComponent(submitUsed))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(errorLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(abortedLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(errorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(abortedLabel)
                .addGap(37, 37, 37)
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
        
        JFrame frame = new JFrame("");
        int ans = JOptionPane.showConfirmDialog(rootPane, frame, "Are you sure that you want to submit? You may only submit once a day.", JOptionPane.YES_NO_OPTION);
        
        if (ans == JOptionPane.YES_OPTION) {
        
        boolean submit = true;
        
            // VALIDATE INPUT
            int rows = rmTable.getRowCount();
            int c = 0;
        
            while(c < rows && submit) {
            
                for (int d = 3; d <= 5 && submit; d++) {
                
                    if(rmTable.getValueAt(c,d).toString().isEmpty() || Math.signum(Float.parseFloat(rmTable.getValueAt(c,d).toString())) == -1) {
                        submit = false;
                    }
                
                }
                c++;
            
            }
            
            if(submit) {
            
                for(int a = 0; a < rows; a++) {
            
                    for (int b = 3; b <= 5; b++) {
                    
                        RawBean r = new RawBean();
                    
                        String name = rmTable.getValueAt(a, 0).toString(); // raw material name
                        float q = Float.parseFloat(rmTable.getValueAt(a,b).toString());
                        String type = new String();
                        
                        if(b == 3) {
                            type = "used";
                        }
                        else if (b == 4) {
                            type = "transfer";
                        }
                        else if(b == 5) {
                            type = "wastage";
                        }
            
                        // REDUCE FROM RAW TABLE
            
                        float s = rmImp.getStock(type);
                        float deduct = s - q;
                        rmImp.updateStock(name, deduct);
            
                        // ADD TRANSACTION
                        TransactionBean t = new TransactionBean();
                        t.setType(type);
                        int id = Integer.parseInt(rmTable.getValueAt(c, 0).toString());
                        r.setRawID(id);
                        tclmp.addTransaction(t, r, q);
                    }
                }
            
            }
            else {
                
                errorLabel.setVisible(true);
            }
        }
        else if (ans == JOptionPane.NO_OPTION) {
            
            abortedLabel.setVisible(true);
        }
        
    }//GEN-LAST:event_submitUsedActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        main.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void rmTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rmTableMouseClicked
        
        
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
    private javax.swing.JLabel abortedLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rmTable;
    private javax.swing.JButton submitUsed;
    // End of variables declaration//GEN-END:variables
}