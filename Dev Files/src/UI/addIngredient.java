/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Beans.CategoryBean;
import Beans.IngredientBean;
import Beans.RawBean;
import Beans.RecipeBean;
import DAO.Implementation.RawDAOImplementation;
import DAO.Interface.RawDAOInterface;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author Catherine
 */
public class addIngredient extends javax.swing.JFrame {

    private RawDAOInterface rwImp = new RawDAOImplementation();
    
    private AddRC ar;
    private EditRC rcm;
    
    private ArrayList<IngredientBean> ai;
    

    /**
     * Creates new form AddIngredient
     */
    public addIngredient() {
        initComponents();
        prepareTable();
    }
    
    public addIngredient(AddRC a, ArrayList<IngredientBean> i, String r) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        errorLabel.setVisible(false);
        errorLabel1.setVisible(false);
        this.ar = a;
        this.ai = i;
        prepareTable();
        recipeLabel.setText(r);
        //System.out.println("Opened from addrecipe");
    }

    public addIngredient(EditRC r, ArrayList<IngredientBean> i, String rn) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        errorLabel.setVisible(false);
        errorLabel1.setVisible(false);
        this.rcm = r;
        this.ai = i;
        prepareTable();
        recipeLabel.setText(rn);
       // System.out.println("Opened from rcmanagement");
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
        saveButton = new javax.swing.JButton();
        recipeLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rawTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        editField = new javax.swing.JTextField();
        editQuantity = new javax.swing.JButton();
        deleteIngredient = new javax.swing.JButton();
        errorLabel1 = new javax.swing.JLabel();
        addRaw = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ingredientTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jLabel7 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/SaveBtn.png"))); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 520, -1, -1));

        recipeLabel.setFont(new java.awt.Font("Quicksand Light", 0, 36)); // NOI18N
        recipeLabel.setForeground(new java.awt.Color(51, 51, 51));
        recipeLabel.setText("<RECIPE NAME>");
        jPanel1.add(recipeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/ingred_tab.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 240, 60));

        jLabel3.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jLabel3.setText("Raw Materials");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        rawTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Title 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rawTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 590, 140));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingredient Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Quicksand Light", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel4.setText("Name:");

        nameLabel.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel6.setText("Quantity:");

        editField.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        editField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFieldActionPerformed(evt);
            }
        });

        editQuantity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/EditBtn.png"))); // NOI18N
        editQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editQuantityActionPerformed(evt);
            }
        });

        deleteIngredient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/RemoveBtn.png"))); // NOI18N
        deleteIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteIngredientActionPerformed(evt);
            }
        });

        errorLabel1.setFont(new java.awt.Font("Quicksand Light", 0, 12)); // NOI18N
        errorLabel1.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel1.setText("ERROR: Please input valid number.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(editQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(deleteIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editField, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 64, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorLabel1)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(editField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 290, 170));

        addRaw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/addBtn.png"))); // NOI18N
        addRaw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRawActionPerformed(evt);
            }
        });
        jPanel1.add(addRaw, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 120, 30));

        ingredientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ingredientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingredientTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ingredientTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 290, 190));

        jLabel7.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jLabel7.setText("Ingredients");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/BackBtn.png"))); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 530, 120, 30));

        jLabel8.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel8.setText("Quantity:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 245, -1, -1));

        quantityField.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });
        jPanel1.add(quantityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 138, -1));

        errorLabel.setFont(new java.awt.Font("Quicksand Light", 0, 12)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel.setText("ERROR: Please input valid number.");
        jPanel1.add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Background.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editFieldActionPerformed

    private void addRawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRawActionPerformed
        String quantity = quantityField.getText().toString();
        if (rawTable.getSelectedRow() < 0) {
            return;
        }
        if (isNumber(quantity) && Float.parseFloat(quantity) > 0) {
            int rselect = rawTable.getSelectedRow();
            addIngredient(rselect, Float.parseFloat(quantity));
            quantityField.setText("");
            errorLabel.setVisible(false);
        } else {
            errorLabel.setVisible(true);
        }
    }//GEN-LAST:event_addRawActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        int nrow = ingredientTable.getRowCount();
        
        //System.out.println(nrow);
        int i;
        int rid;

        ai.clear();
        for (i = 0; i < nrow; i++) {
            IngredientBean ibean = new IngredientBean();
            RawBean rbean = new RawBean();

            rid = Integer.parseInt(ingredientTable.getModel().getValueAt(i, 0).toString());
            rbean = rwImp.getRaw(rid);
            ibean.setRaw(rbean);
            ibean.setAmount(Float.parseFloat(ingredientTable.getModel().getValueAt(i, 2).toString()));
            ai.add(ibean);
        }

        
        if (ar != null) {
            ar.setVisible(true);
            ar.prepareCombo();
            ar.computeActual();
            if(nrow == 0){
                ar.inErrorV(true);
            }else{
                ar.inErrorV(false);
            }
        } else {
            rcm.setVisible(true);
            rcm.reloadIngredients(ai);
            rcm.computeActual(ai);
            if(nrow == 0){
                rcm.inErrorV(true);
            }else{
                rcm.inErrorV(false);
            }
        }
        dispose();

    }//GEN-LAST:event_saveButtonActionPerformed

    private void ingredientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingredientTableMouseClicked
        try {
            int iselect = ingredientTable.getSelectedRow();
            int inID = Integer.parseInt(ingredientTable.getModel().getValueAt(iselect, 0).toString());
            RawBean r = rwImp.getRaw(inID);
            //recipeIDLabel.setText(String.valueOf(r.getRecipeID()));
            nameLabel.setText(r.getRaw());
            editField.setText(ingredientTable.getModel().getValueAt(iselect, 2).toString());

        } catch (Exception e) {
            System.out.println(e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ingredientTableMouseClicked

    private void editQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editQuantityActionPerformed
        String quantity = editField.getText().toString();
        if (ingredientTable.getSelectedRow() < 0) {
            return;
        }
        if (isNumber(quantity) && Float.parseFloat(quantity) > 0) {
            int rselect = ingredientTable.getSelectedRow();
            editQuantity(rselect, Float.parseFloat(quantity));
            errorLabel1.setVisible(false);
        } else {
            errorLabel1.setVisible(true);
        }
    }//GEN-LAST:event_editQuantityActionPerformed

    private void deleteIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteIngredientActionPerformed
        int rselect = ingredientTable.getSelectedRow();
        if (rselect < 0) {
            return;
        } else {
            deleteIngredient(rselect);
        }
    }//GEN-LAST:event_deleteIngredientActionPerformed

    /**
     * * <--- JANE CODE START ---> **
     */
    private void editQuantity(int r, float q) {
        ingredientTable.getModel().setValueAt(q, r, 2);
    }

    //add Ingredient
    private void addIngredient(int r, float q) {
        int rID = Integer.parseInt(rawTable.getModel().getValueAt(r, 0).toString());
        RawBean rm = rwImp.getRaw(rID);

        Object[] ingredient = {rm.getRawID(), rm.getRaw(), String.format("%.2f", q), rm.getUom(), String.format("%.2f", rm.getPrice() * q)};

        TableModel model = rawTable.getModel();
        TableModel inmodel = ingredientTable.getModel();
        DefaultTableModel imodel = (DefaultTableModel) model;
        DefaultTableModel ingmodel = (DefaultTableModel) inmodel;
        //add to ingredientTable
        ingmodel.addRow(ingredient);
        ingredientTable.setModel(ingmodel);
        //remove from rawTable
        imodel.removeRow(r);
        rawTable.setModel(imodel);

    }

    //delete ingredient
    private void deleteIngredient(int r) {
        int rID = Integer.parseInt(ingredientTable.getModel().getValueAt(r, 0).toString());
        RawBean rm = rwImp.getRaw(rID);

        Object[] raw = {rm.getRawID(), rm.getRaw()};

        TableModel model = rawTable.getModel();
        TableModel imodel = ingredientTable.getModel();
        DefaultTableModel rmodel = (DefaultTableModel) model;
        DefaultTableModel ingmodel = (DefaultTableModel) imodel;

        //add to rawTable
        rmodel.addRow(raw);
        rawTable.setModel(rmodel);
        //remove from ingredientTable
        ingmodel.removeRow(r);
        ingredientTable.setModel(ingmodel);
    }

    //check if number
    private boolean isNumber(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //prepare rawTable
    private void prepareTable() {
        String cols[] = {"Raw ID", "Raw Material", "UOM", "Price"};
        ArrayList<RawBean> avRaw = rwImp.getRawByStatus("available");
        DefaultTableModel rawModel = new DefaultTableModel(cols, 0);

        for (RawBean rm : avRaw) {
            Object[] raw = {rm.getRawID(), rm.getRaw(), rm.getUom(), String.format("%.2f", rm.getPrice())};
            boolean skip = false;
            for (IngredientBean ibean2 : ai) {
                if (rm.getRawID() == ibean2.getRaw().getRawID()) {
                    skip = true;
                    break;
                }
            }
            if (!skip) {
                rawModel.addRow(raw);
            }
        }

        rawTable.setModel(rawModel);
        rawTable.getColumnModel().getColumn(0).setMinWidth(0);
        rawTable.getColumnModel().getColumn(0).setMaxWidth(0);
        adjustTable(rawTable);

        //ingredient Tab
        String cols2[] = {"Raw ID", "Raw Material", "Quantity", "UOM", "Total Price"};
        DefaultTableModel ingredientModel = new DefaultTableModel(cols2, 0);

        for (IngredientBean ibean : ai) {
            Object[] ingredient = {ibean.getRaw().getRawID(), ibean.getRaw().getRaw(), String.format("%.2f", ibean.getAmount()), ibean.getRaw().getUom(), String.format("%.2f", ibean.getRaw().getPrice() * ibean.getAmount())};
            ingredientModel.addRow(ingredient);
        }
        ingredientTable.setModel(ingredientModel);
        ingredientTable.getColumnModel().getColumn(0).setMinWidth(0);
        ingredientTable.getColumnModel().getColumn(0).setMaxWidth(0);
        adjustTable(ingredientTable);
    }

    /* ADJUST TABLE TO MAX WIDTH*/
    private void adjustTable(JTable table) {
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
     * * <--- JANE CODE END ---> **
     */
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
            java.util.logging.Logger.getLogger(addIngredient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addIngredient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addIngredient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addIngredient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new addIngredient().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton addRaw;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteIngredient;
    private javax.swing.JTextField editField;
    private javax.swing.JButton editQuantity;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JTable ingredientTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField quantityField;
    private javax.swing.JTable rawTable;
    private javax.swing.JLabel recipeLabel;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
