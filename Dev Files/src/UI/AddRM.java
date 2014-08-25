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
 * @author Catherine
 */
public class AddRM extends javax.swing.JFrame {
    private RawDAOInterface rwImp = new RawDAOImplementation();
    private RawBean raw;
    private RMManagement rm;
    
    //<--- CLARK'S CODE STARTS HERE --->
    
    public AddRM(RMManagement r) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        rm = r;
        raw = new RawBean();
        prepareTable();
        errorLabel1.setVisible(false);
        errorLabel2.setVisible(false);
        errorLabel3.setVisible(false);
        errorLabel4.setVisible(false);
        errorLabel5.setVisible(false);
        errorLabel6.setVisible(false);
        errorLabel7.setVisible(false);
        errorLabel8.setVisible(false);
        errorLabel9.setVisible(false);
        errorLabel10.setVisible(false);
    }
   
   public void prepareTable(){
       rmTable.setModel(rm.getRMTable());
       rmTable.getColumnModel().getColumn(0).setMinWidth(0);
       rmTable.getColumnModel().getColumn(0).setMaxWidth(0);
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
    
    public boolean checkError() {
        if(nameField.getText().equals("") || priceField.getText().equals("") || 
                stockField.getText().equals("") || criticalField.getText().equals("") ||
                    uomField.getText().equals(""))
            return false;
        else
            return true;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        rmTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();
        criticalField = new javax.swing.JTextField();
        SaveRMBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        errorLabel2 = new javax.swing.JLabel();
        errorLabel4 = new javax.swing.JLabel();
        errorLabel6 = new javax.swing.JLabel();
        errorLabel10 = new javax.swing.JLabel();
        errorLabel8 = new javax.swing.JLabel();
        errorLabel1 = new javax.swing.JLabel();
        errorLabel3 = new javax.swing.JLabel();
        errorLabel5 = new javax.swing.JLabel();
        errorLabel7 = new javax.swing.JLabel();
        errorLabel9 = new javax.swing.JLabel();
        uomField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jScrollPane1.setFont(new java.awt.Font("Quicksand Light", 0, 12)); // NOI18N
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 600, 160));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Raw Material Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Quicksand Light", 0, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel3.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel3.setText("Price:");

        jLabel4.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel4.setText("Stock:");

        jLabel5.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel5.setText("Critical:");

        jLabel6.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel6.setText("Unit of Measurement:");

        nameField.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameFieldKeyReleased(evt);
            }
        });

        priceField.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        priceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                priceFieldKeyReleased(evt);
            }
        });

        stockField.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        stockField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stockFieldKeyReleased(evt);
            }
        });

        criticalField.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        criticalField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                criticalFieldKeyReleased(evt);
            }
        });

        SaveRMBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/addBtn.png"))); // NOI18N
        SaveRMBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveRMBtnActionPerformed(evt);
            }
        });

        CancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/CancelBtn.png"))); // NOI18N
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        errorLabel2.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        errorLabel2.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel2.setText("Duplicate name exists");

        errorLabel4.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        errorLabel4.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel4.setText("Please input valid number");

        errorLabel6.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        errorLabel6.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel6.setText("Please input valid number");

        errorLabel10.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        errorLabel10.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel10.setText("*ERROR: Required field");

        errorLabel8.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        errorLabel8.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel8.setText("Please input valid number");

        errorLabel1.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        errorLabel1.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel1.setText("*");

        errorLabel3.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        errorLabel3.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel3.setText("*");

        errorLabel5.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        errorLabel5.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel5.setText("*");

        errorLabel7.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        errorLabel7.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel7.setText("*");

        errorLabel9.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        errorLabel9.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel9.setText("*");

        uomField.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        uomField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                uomFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(stockField)
                            .addComponent(priceField)
                            .addComponent(criticalField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(uomField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(errorLabel9)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(errorLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(errorLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(errorLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(errorLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errorLabel2)
                                    .addComponent(errorLabel4)
                                    .addComponent(errorLabel6)
                                    .addComponent(errorLabel8))
                                .addGap(11, 11, 11)))
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SaveRMBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel2)
                    .addComponent(errorLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel4)
                    .addComponent(errorLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(stockField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel6)
                    .addComponent(errorLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(criticalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel8)
                    .addComponent(errorLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(errorLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SaveRMBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 600, 280));

        jLabel1.setFont(new java.awt.Font("Quicksand Light", 0, 36)); // NOI18N
        jLabel1.setText("Raw Materials Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Background2.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InventoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventoryBtnActionPerformed
        try {
            InventoryTab in = new InventoryTab();
            in.setVisible(true);
            dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryTab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(InventoryTab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(InventoryTab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(InventoryTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_InventoryBtnActionPerformed

    private void RMBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RMBtnActionPerformed
        try {
            RMManagement rm = new RMManagement();
            rm.setVisible(true);
            dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RMManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RMManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RMManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RMManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RMBtnActionPerformed

    private void RecipesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecipesBtnActionPerformed
        try {
            RCManagement rc = new RCManagement();
            rc.setVisible(true);
            dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RCManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RCManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RCManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RCManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RecipesBtnActionPerformed

    private void CategoriesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriesBtnActionPerformed
        try {
            CGManagement cg = new CGManagement();
            cg.setVisible(true);
            dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CGManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CGManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CGManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CGManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CategoriesBtnActionPerformed

    private void SaveRMBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveRMBtnActionPerformed
        try{
            raw.setRmstatus("available");
            rwImp.addRaw(raw);
            raw.setRawID(rwImp.getLatestAddedID());
            JOptionPane.showMessageDialog(null, "Raw material successfully added!", "Success", JOptionPane.INFORMATION_MESSAGE);
            rm.setVisible(true);
            rm.ViewAllRM();
            dispose();
        } catch(Exception err){
                err.printStackTrace();
        }
    }//GEN-LAST:event_SaveRMBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
       rm.setVisible(true);
       dispose();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyReleased
        if(nameField.getText().equals("")) {
            errorLabel1.setVisible(true);
            errorLabel2.setVisible(false);
            errorLabel10.setVisible(true);
        }
        else {
            errorLabel1.setVisible(false);
            errorLabel2.setVisible(false);
            
            if(checkError())
                errorLabel10.setVisible(false);
            
            raw.setRaw(nameField.getText());
            ArrayList<RawBean> rList = new ArrayList<RawBean>();
            rList = rwImp.getRawByStatus("available");
            for(int i = 0; i < rList.size(); i++){
                if(nameField.getText().equalsIgnoreCase(rList.get(i).getRaw())) {
                     errorLabel2.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_nameFieldKeyReleased

    private void priceFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceFieldKeyReleased
        if(priceField.getText().equals("")) {
            errorLabel3.setVisible(true);
            errorLabel4.setVisible(false);
            errorLabel10.setVisible(true);
        } else {
            if(isNumber(priceField.getText())) {
                if(Float.parseFloat(priceField.getText()) > 0) {
                    errorLabel3.setVisible(false);
                    errorLabel4.setVisible(false);
                    if(checkError())
                        errorLabel10.setVisible(false);
                    raw.setPrice(Float.parseFloat(priceField.getText()));
                }
            } else {
                errorLabel3.setVisible(false);
                errorLabel4.setVisible(true);
                if(checkError())
                    errorLabel10.setVisible(false);
            }
        }
    }//GEN-LAST:event_priceFieldKeyReleased

    private void stockFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockFieldKeyReleased
        if(stockField.getText().equals("")) {
            errorLabel5.setVisible(true);
            errorLabel6.setVisible(false);
            errorLabel10.setVisible(true);
        } else {
            if(isNumber(stockField.getText())) {
                if(Float.parseFloat(stockField.getText()) > 0) {
                    errorLabel5.setVisible(false);
                    errorLabel6.setVisible(false);
                    if(checkError())
                        errorLabel10.setVisible(false);
                    raw.setStock(Float.parseFloat(stockField.getText()));
                }
            } else {
                errorLabel5.setVisible(false);
                errorLabel6.setVisible(true);
                if(checkError())
                    errorLabel10.setVisible(false);
            }
        }
    }//GEN-LAST:event_stockFieldKeyReleased

    private void criticalFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_criticalFieldKeyReleased
        if(criticalField.getText().equals("")) {
            errorLabel7.setVisible(true);
            errorLabel8.setVisible(false);
            errorLabel10.setVisible(true);
        } else {
            if(isNumber(criticalField.getText())) {
                if(Float.parseFloat(criticalField.getText()) > 0) {
                    errorLabel7.setVisible(false);
                    errorLabel8.setVisible(false);
                    if(checkError())
                        errorLabel10.setVisible(false);
                    raw.setCritical(Float.parseFloat(criticalField.getText()));
                }
            } else {
                errorLabel7.setVisible(false);
                errorLabel8.setVisible(true);
                if(checkError())
                    errorLabel10.setVisible(false);
            }
        }
    }//GEN-LAST:event_criticalFieldKeyReleased

    private void uomFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uomFieldKeyReleased
        if(uomField.getText().equals("")) {
            errorLabel9.setVisible(true);
            errorLabel10.setVisible(true);
        } else {
            raw.setUom(uomField.getText());
            errorLabel9.setVisible(false);
            if(checkError())
                errorLabel10.setVisible(false);
        }
    }//GEN-LAST:event_uomFieldKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton CategoriesBtn;
    private javax.swing.JButton EODBtn;
    private javax.swing.JButton InventoryBtn;
    private javax.swing.JButton RMBtn;
    private javax.swing.JButton RecipesBtn;
    private javax.swing.JButton ReportsBtn;
    private javax.swing.JButton SaveRMBtn;
    private javax.swing.JTextField criticalField;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel errorLabel10;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JLabel errorLabel3;
    private javax.swing.JLabel errorLabel4;
    private javax.swing.JLabel errorLabel5;
    private javax.swing.JLabel errorLabel6;
    private javax.swing.JLabel errorLabel7;
    private javax.swing.JLabel errorLabel8;
    private javax.swing.JLabel errorLabel9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JTable rmTable;
    private javax.swing.JTextField stockField;
    private javax.swing.JTextField uomField;
    // End of variables declaration//GEN-END:variables
}
