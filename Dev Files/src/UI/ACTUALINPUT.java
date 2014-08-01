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
 * @author Kim
 */
public class ACTUALINPUT extends javax.swing.JFrame {
    
    TransactionDAOInterface tclmp = new TransactionDAOImplementation();
    ArrayList<TransactionBean> aTransact;
    RawDAOInterface rmImp = new RawDAOImplementation();
    ArrayList<RawBean> aRaw;
    EODTab main; 
    /**
     * Creates new form ACTUALINPUT
     */
    public ACTUALINPUT(EODTab t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        main = t;
        transactTable();
    }

    /*
     *  <!-- KIM CODE START -->
     */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        currentInventory = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        inputActual = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        updateActual = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        errorBox = new javax.swing.JTextArea();
        backBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(956, 555));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("INPUT ACTUAL COUNT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        currentInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Quantity in Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        currentInventory.setName(""); // NOI18N
        jScrollPane1.setViewportView(currentInventory);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 91, 462, 157));

        jLabel4.setText("Current Raw Material Inventory");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 43, -1, -1));

        inputActual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Quantity in Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(inputActual);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 91, -1, 157));

        jLabel5.setText("Actual Count Input");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(631, 43, -1, -1));

        updateActual.setText("SUBMIT");
        updateActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActualActionPerformed(evt);
            }
        });
        jPanel1.add(updateActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 276, -1, -1));

        errorBox.setEditable(false);
        errorBox.setColumns(20);
        errorBox.setRows(5);
        jScrollPane3.setViewportView(errorBox);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 330, 198));

        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 276, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 0, 1));
        jLabel2.setText("ERRORS:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, -1, -1));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActualActionPerformed
        // TODO add your handling code here

        boolean submit = true;

        int rows = inputActual.getRowCount();
        int c = 0;

        for (c = 0; c < rows; c++) {

            if(inputActual.getValueAt(c,2).toString().isEmpty()) {

                submit = false;
                errorBox.append("Empty: Row #" + c+1 + "\n");
            }

        }
        
        if (submit) {
            TransactionBean t = new TransactionBean();
            RawBean r = new RawBean();
            float q; // QUANTITY
            
            errorBox.append("No errors found.");
            
            for (c = 0; c < rows; c++) {

                r.setRawID(Integer.parseInt(inputActual.getValueAt(c, 0).toString()));
                q = Float.parseFloat(inputActual.getValueAt(c, 2).toString());
                tclmp.actualInput(t, r, q);
            }

        }

    }//GEN-LAST:event_updateActualActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
       main.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

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
    
    /*
     *  TABLE SET UP
     */
    
    public void transactTable() {
        aTransact = new ArrayList<>();
        aRaw = new ArrayList<>();
        
        /*
         *  FOR CURRENT TABLE
         */
        
        aRaw = rmImp.getAllRaw();
        String cols[] = {"ID", "Name", "Quantity in Stock"};
        
        DefaultTableModel currentTable = new DefaultTableModel(cols, 0);
        
        for (RawBean raw : aRaw) {
            
            Object[] data = {raw.getRawID(), raw.getRaw(), raw.getStock()};
            currentTable.addRow(data);
            currentInventory.setModel(currentTable);
            adjustTable(currentInventory);
        }
        
        /*
         * FOR ACTUAL INPUT TABLE
         */
        
        DefaultTableModel actualTable = new DefaultTableModel(cols,0);
        
        for (RawBean raw : aRaw) {
            
            Object[] data = {raw.getRawID(), raw.getRaw(), null};
            actualTable.addRow(data);
            inputActual.setModel(actualTable);
            adjustTable(inputActual);
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
    
    /*
     *  <!-- KIM CODE END -->
     */
    
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
            java.util.logging.Logger.getLogger(ACTUALINPUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ACTUALINPUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ACTUALINPUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ACTUALINPUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new ACTUALINPUT().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ACTUALINPUT.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(ACTUALINPUT.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ACTUALINPUT.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(ACTUALINPUT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTable currentInventory;
    private javax.swing.JTextArea errorBox;
    private javax.swing.JTable inputActual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton updateActual;
    // End of variables declaration//GEN-END:variables
}
