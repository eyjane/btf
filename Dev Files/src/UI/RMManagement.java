package UI;

import Beans.RawBean;
import Beans.RecipeBean;
import DAO.Implementation.RawDAOImplementation;
import DAO.Implementation.RecipeDAOImplementation;
import DAO.Interface.RawDAOInterface;
import DAO.Interface.RecipeDAOInterface;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author clarkabalos
 */
public class RMManagement extends javax.swing.JFrame {
    private RawDAOInterface rmImp = new RawDAOImplementation();
    private RecipeDAOInterface rcImp = new RecipeDAOImplementation();
    private RawBean selectedRaw = null;
    private DefaultTableModel defaultModel;

    //<--- CLARK'S CODE STARTS HERE --->
    public RMManagement() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
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
       RawBean r;
       ArrayList<RawBean> rList = new ArrayList<RawBean>();
       defaultModel = initializeTable();
       rList = rmImp.getRawByStatus("available");
       for (int i = 0; i < rList.size(); i++) {
            r = rList.get(i);
            defaultModel.addRow(new Object[] {r.getRawID(), r.getRaw(), r.getPrice(), r.getStock(), r.getCritical(), r.getRmstatus(), r.getUom()});
       }
       rmTable.setModel(defaultModel);
       rmTable.getColumnModel().getColumn(0).setMinWidth(0);
       rmTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
    public boolean isNumber(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean authenticateDelete(RawBean raw) {
        boolean flag = true;
        ArrayList<RecipeBean> recipeTemp = null;
        recipeTemp = rcImp.getRecipeByRawMaterial(raw);
        if(recipeTemp.size() > 0)
            flag = false;
        return flag;
    }
    
    public void deleteRM(int r[]){
        TableModel model = rmTable.getModel();
        DefaultTableModel table = (DefaultTableModel) model;
        
        for(int i = 0; i < r.length; i++){
            int rID = Integer.parseInt(rmTable.getModel().getValueAt(r[i], 0).toString());
            RawBean raw = rmImp.getRaw(rID);
            if(authenticateDelete(raw)) {
                    if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this raw material?", "Confirm Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                        rmImp.deleteRaw(raw);
                        JOptionPane.showMessageDialog(null, "Successfully deleted the raw material!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        table.removeRow(r[i]);
                    }
                } else
                    JOptionPane.showMessageDialog(null, "You cannot delete a raw material that's in use.", "Try Again", JOptionPane.WARNING_MESSAGE);
        }
        
        rmTable.setModel(table);
        rmTable.getColumnModel().getColumn(0).setMinWidth(0);
        rmTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
    public DefaultTableModel getRMTable(){
        return defaultModel;
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
        jLabel9 = new javax.swing.JLabel();
        btnDeleteRM = new javax.swing.JButton();
        btnAddRM = new javax.swing.JButton();
        btnEditRM = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(956, 555));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(620, 402));

        rmTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Stock", "Critical", "Status", "UOM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 710, 430));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel9.setText("RAW MATERIALS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        btnDeleteRM.setText("Delete This Raw Material");
        btnDeleteRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRMActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteRM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 182, 50));

        btnAddRM.setText("Add A Raw Material");
        btnAddRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRMActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddRM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 182, 50));

        btnEditRM.setText("Edit A Raw Material");
        btnEditRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditRMActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditRM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 182, 50));

        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        try {
            EODTab main = new EODTab();
            main.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_backBtnActionPerformed

    private void btnAddRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRMActionPerformed
        try {
            AddRM r = new AddRM(this);
            r.setVisible(true);
            this.setVisible(false);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddRMActionPerformed

    private void btnEditRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditRMActionPerformed
            try {
                EditRM r = new EditRM(this);
                r.setVisible(true);
                this.setVisible(false);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnEditRMActionPerformed

    private void btnDeleteRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRMActionPerformed
        int select[] = rmTable.getSelectedRows();
        if (select.length > 0) {
            deleteRM(select);
        } else {
            JOptionPane.showMessageDialog(null, "Please select an entry to delete.", "Blank Form", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteRMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton btnAddRM;
    private javax.swing.JButton btnDeleteRM;
    private javax.swing.JButton btnEditRM;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rmTable;
    // End of variables declaration//GEN-END:variables
}
