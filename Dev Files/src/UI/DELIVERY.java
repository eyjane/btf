package UI;

import Beans.RawBean;
import DAO.Implementation.RawDAOImplementation;
import DAO.Interface.RawDAOInterface;
import java.awt.Component;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Evy
 */
public class DELIVERY extends javax.swing.JFrame {

    /**
     * Creates new form DELIVERY
     */
    
    RawDAOInterface rmImp = new RawDAOImplementation();
    ArrayList<RawBean> aRaw;
    EODTab main;
    
    public DELIVERY(EODTab t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        main = t;
        failLabel1.setVisible(false);
        failLabel2.setVisible(false);
        successLabel.setVisible(false);
        abortLabel.setVisible(false);
        viewRaw();
    }
    /*
     * <!-- KIM CODE START -> *
     */
    public void viewRaw() {
        aRaw = new ArrayList<RawBean>();
        
        aRaw = rmImp.getAllRaw();
        String cols[] = {"ID","Name", "Quantity in Stock", "Delivered Amount"};
        DefaultTableModel allRaw = new DefaultTableModel(cols, 0) {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0 || column == 1 || column == 2)
                    return false;
                else
                    return true;
            }
            
        };
        
        
        for (RawBean raw : aRaw) {
            
            Object[] data = {raw.getRawID(), raw.getRaw(), raw.getStock(), ""};
            allRaw.addRow(data);
            rawTable.setModel(allRaw);
            rawTable.getColumnModel().getColumn(0).setMinWidth(0);
            rawTable.getColumnModel().getColumn(0).setMaxWidth(0);
            adjustTable(rawTable);
        }
        
        rawTable.setColumnSelectionAllowed(true);
        rawTable.setRowSelectionAllowed(true);
        rawTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rawTable = new javax.swing.JTable();
        successLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        failLabel1 = new javax.swing.JLabel();
        failLabel2 = new javax.swing.JLabel();
        abortLabel = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Raw Materials Table");

        rawTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Quantity in Stock", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rawTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rawTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rawTable);
        rawTable.getColumnModel().getColumn(0).setResizable(false);

        successLabel.setText("Delivery information was successfully added.");

        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        submitBtn.setText("SUBMIT");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        failLabel1.setForeground(new java.awt.Color(255, 0, 1));
        failLabel1.setText("Submission Failed. Please check that all inputs are positive numbers");

        failLabel2.setForeground(new java.awt.Color(255, 0, 1));
        failLabel2.setText("and that no fields are empty.");

        abortLabel.setText("Submission aborted. No changes were made.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(195, 195, 195))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(failLabel2)
                                .addGap(144, 144, 144))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(successLabel)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(abortLabel)
                                            .addComponent(backBtn))
                                        .addGap(31, 31, 31)
                                        .addComponent(submitBtn)))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 67, Short.MAX_VALUE)
                .addComponent(failLabel1)
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(failLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(failLabel2)
                .addGap(13, 13, 13)
                .addComponent(abortLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(successLabel)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(submitBtn))
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        
        
        if (JOptionPane.showConfirmDialog(null, "Are you sure that you want to submit? You may only submit once a day.", "Confirm Submit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        
            boolean add = true;
            int rows = rawTable.getRowCount();
            int c = 0;
            
            for (c = 0; c < rows && add; c++) {
             
                if(rawTable.getValueAt(c,3).toString().isEmpty() || Math.signum(Float.parseFloat(rawTable.getValueAt(c,3).toString())) == -1) {
                        add = false;
                        failLabel1.setVisible(true);
                        failLabel2.setVisible(true);
                    }
                
            }
            
        if (add) {
            
           
            for (c = 0; c < rows; c++) {
                
                int ID = Integer.parseInt(rawTable.getValueAt(c, 0).toString());
                RawBean r = rmImp.getRaw(ID);
                r.setStock(Float.parseFloat(rawTable.getValueAt(c, 3).toString()));
                rmImp.editRaw(r);
            }
            
            successLabel.setVisible(true);
            
            // REFRESH TABLE WITH UPDATED VALUES
            viewRaw();
        }
        
        }
        else
            abortLabel.setVisible(true);
        
    }//GEN-LAST:event_submitBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        main.setVisible(true);
        
    }//GEN-LAST:event_backBtnActionPerformed

    private void rawTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rawTableMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_rawTableMouseClicked

    
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
            java.util.logging.Logger.getLogger(DELIVERY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DELIVERY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DELIVERY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DELIVERY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new DELIVERY().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DELIVERY.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(DELIVERY.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(DELIVERY.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(DELIVERY.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abortLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel failLabel1;
    private javax.swing.JLabel failLabel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rawTable;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel successLabel;
    // End of variables declaration//GEN-END:variables
}
