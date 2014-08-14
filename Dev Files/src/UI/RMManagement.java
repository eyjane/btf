package UI;

import Beans.RawBean;
import DAO.Implementation.IngredientDAOImplementation;
import DAO.Implementation.RawDAOImplementation;
import DAO.Interface.IngredientDAOInterface;
import DAO.Interface.RawDAOInterface;
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
 * @author Catherine
 */
public class RMManagement extends javax.swing.JFrame {
    private RawDAOInterface rmImp = new RawDAOImplementation();
    private IngredientDAOInterface inImp = new IngredientDAOImplementation();
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
    
    public void deleteRM(int r[]){
        TableModel model = rmTable.getModel();
        DefaultTableModel table = (DefaultTableModel) model;
        
        for(int i = 0; i < r.length; i++){
            int rID = Integer.parseInt(rmTable.getModel().getValueAt(r[i], 0).toString());
            RawBean raw = rmImp.getRaw(rID);
            if(!inImp.isIngredient(raw)) {
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
        InventoryBtn = new javax.swing.JButton();
        RMBtn = new javax.swing.JButton();
        RecipesBtn = new javax.swing.JButton();
        CategoriesBtn = new javax.swing.JButton();
        EODBtn = new javax.swing.JButton();
        ReportsBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rmTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        AddRMBtn = new javax.swing.JButton();
        EditRMBtn = new javax.swing.JButton();
        DeleteRMBtn = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InventoryBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Inventory Btn.png"))); // NOI18N
        InventoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventoryBtnActionPerformed(evt);
            }
        });
        jPanel1.add(InventoryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 239, 60));

        RMBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/RM Btn.png"))); // NOI18N
        RMBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RMBtnActionPerformed(evt);
            }
        });
        jPanel1.add(RMBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 239, 60));

        RecipesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Recipes Btn.png"))); // NOI18N
        RecipesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecipesBtnActionPerformed(evt);
            }
        });
        jPanel1.add(RecipesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 239, 60));

        CategoriesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Categories Btn.png"))); // NOI18N
        CategoriesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriesBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CategoriesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 239, 60));

        EODBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/EOD Btn.png"))); // NOI18N
        jPanel1.add(EODBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 239, 60));

        ReportsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Reports Btn.png"))); // NOI18N
        jPanel1.add(ReportsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 239, 60));

        jLabel1.setFont(new java.awt.Font("Quicksand Light", 0, 36)); // NOI18N
        jLabel1.setText("Raw Materials Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 470, 370));

        AddRMBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/addRMBtn.png"))); // NOI18N
        AddRMBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRMBtnActionPerformed(evt);
            }
        });
        jPanel1.add(AddRMBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 120, 30));

        EditRMBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/EditRMBtn.png"))); // NOI18N
        EditRMBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditRMBtnActionPerformed(evt);
            }
        });
        jPanel1.add(EditRMBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 120, 30));

        DeleteRMBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/DeleteBtn.png"))); // NOI18N
        DeleteRMBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRMBtnActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteRMBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, 120, 30));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Background2.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InventoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventoryBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InventoryBtnActionPerformed

    private void RMBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RMBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RMBtnActionPerformed

    private void RecipesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecipesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecipesBtnActionPerformed

    private void CategoriesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoriesBtnActionPerformed

    private void EditRMBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditRMBtnActionPerformed
        try {
                EditRM r = new EditRM(this);
                r.setVisible(true);
                this.setVisible(false);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RMManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(RMManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(RMManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(RMManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EditRMBtnActionPerformed

    private void AddRMBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRMBtnActionPerformed
        try {
            AddRM r = new AddRM(this);
            r.setVisible(true);
            this.setVisible(false);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RMManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RMManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RMManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RMManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddRMBtnActionPerformed

    private void DeleteRMBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRMBtnActionPerformed
        int select[] = rmTable.getSelectedRows();
        if (select.length > 0) {
            deleteRM(select);
        } else {
            JOptionPane.showMessageDialog(null, "Please select an entry to delete.", "Blank Form", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_DeleteRMBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddRMBtn;
    private javax.swing.JLabel Background;
    private javax.swing.JButton CategoriesBtn;
    private javax.swing.JButton DeleteRMBtn;
    private javax.swing.JButton EODBtn;
    private javax.swing.JButton EditRMBtn;
    private javax.swing.JButton InventoryBtn;
    private javax.swing.JButton RMBtn;
    private javax.swing.JButton RecipesBtn;
    private javax.swing.JButton ReportsBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rmTable;
    // End of variables declaration//GEN-END:variables
}
