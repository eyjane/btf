/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

/**
 *
 * @author Evy
 */
public class EditRecipe extends javax.swing.JFrame {

    /**
     * Creates new form EditRecipe
     */
    public EditRecipe() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        actualLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        costField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();
        categoryBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        ingredientsTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        editIngredient = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        nameError = new javax.swing.JLabel();
        errorLabel2 = new javax.swing.JLabel();
        inError = new javax.swing.JLabel();
        errorLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Edit Recipe");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 47));

        jLabel2.setText("Name: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        actualLabel.setText("0.00");
        jPanel1.add(actualLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 100, -1));

        jLabel4.setText("Stock:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel5.setText("Category: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel6.setText("Ingredients:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 255, -1));
        jPanel1.add(costField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 84, -1));
        jPanel1.add(stockField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 84, -1));

        categoryBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBoxActionPerformed(evt);
            }
        });
        jPanel1.add(categoryBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 179, -1));

        ingredientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ingredientsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingredientsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ingredientsTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 460, 108));

        editIngredient.setText("Edit Ingredients");
        editIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editIngredientActionPerformed(evt);
            }
        });
        jPanel1.add(editIngredient, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, -1, -1));

        nameError.setForeground(new java.awt.Color(255, 0, 51));
        nameError.setText("ERROR: Required field.");
        jPanel1.add(nameError, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        errorLabel2.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel2.setText("ERROR: Required field. Please input valid number.");
        jPanel1.add(errorLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        inError.setForeground(new java.awt.Color(255, 0, 51));
        inError.setText("ERROR: Recipe must have at least one ingredient.");
        jPanel1.add(inError, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        errorLabel4.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel4.setText("ERROR: Required field. Please input valid number.");
        jPanel1.add(errorLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        jLabel7.setText("Cost: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel8.setText("Actual Price:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jButton1.setText("BACK");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, -1, -1));

        jButton2.setText("Save");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, -1, -1));

        recipeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        recipeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recipeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(recipeTable);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel9.setText("Choose a recipe to edit here");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void categoryBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBoxActionPerformed

    private void ingredientsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingredientsTableMouseClicked

    }//GEN-LAST:event_ingredientsTableMouseClicked

    private void editIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editIngredientActionPerformed
        int nrow = ingredientsTable.getRowCount();
        //System.out.println(nrow);

        int i;
        int rid;

/*        aIngredient = new ArrayList<IngredientBean>();
        if (nrow != 0) {
            for (i = 0; i < nrow; i++) {
                IngredientBean ibean = new IngredientBean();
                RawBean rbean = new RawBean();
                rid = Integer.parseInt(ingredientsTable.getModel().getValueAt(i, 0).toString());
                rbean = rawImp.getRaw(rid);
                ibean.setRaw(rbean);
                ibean.setAmount(Float.parseFloat(ingredientsTable.getModel().getValueAt(i, 2).toString()));
                aIngredient.add(ibean);
            }
        }

        try {
            AddIngredient = new addIngredient(this, aIngredient);
            AddIngredient.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
*/
    }//GEN-LAST:event_editIngredientActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
//        rcman.setVisible(true);
//        this.setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed

    private void recipeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recipeTableMouseClicked
 /*       ArrayList<CategoryBean> aCategory = catImp.getAllCategory();
        try {
            int rselect = recipeTable.getSelectedRow();
            int rID = Integer.parseInt(recipeTable.getModel().getValueAt(rselect, 0).toString());
            RecipeBean r = rcImp.getRecipeBean(rID);
            //recipeIDLabel.setText(String.valueOf(r.getRecipeID()));
            //    nameField.setText(r.getRecipe());
            //    costField.setText(String.format("%.2f", r.getCost()));
            //    actualLabel.setText(String.format("%.2f", r.getActualPrice()));

            for (CategoryBean c : aCategory) {
                //        categoryBox.addItem(c);
                if (c.getCategoryID() == r.getCategory()) {
                    //            categoryBox.setSelectedIndex(categoryBox.getItemCount() - 1);
                }
            }
            //CategoryBean ct = (CategoryBean)categoryBox.getSelectedItem();
            //System.out.println("SELECTED " + ct.getCategoryID());

            String cols[] = {"Raw ID", "Ingredient", "Quantity", "Unit of Measurement"};
            DefaultTableModel model = new DefaultTableModel(cols, 0);

            for (IngredientBean rw : r.getIngredients()) {
                RawBean rwm = rw.getRaw();
                Object[] i = {rwm.getRawID(), rwm.getRaw(), String.format("%.2f", rw.getAmount()), rwm.getUom()};
                model.addRow(i);
            }

            //     ingredientsTable.setModel(model);
            //   ingredientsTable.getColumnModel().getColumn(0).setMinWidth(0);
            //   ingredientsTable.getColumnModel().getColumn(0).setMaxWidth(0);

            // adjustTable(ingredientsTable);
        } catch (Exception e) {
            System.out.println(e);
        }
*/
    }//GEN-LAST:event_recipeTableMouseClicked

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
            java.util.logging.Logger.getLogger(EditRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditRecipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actualLabel;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox categoryBox;
    private javax.swing.JTextField costField;
    private javax.swing.JButton editIngredient;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JLabel errorLabel4;
    private javax.swing.JLabel inError;
    private javax.swing.JTable ingredientsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameError;
    private javax.swing.JTextField nameField;
    private javax.swing.JTable recipeTable;
    private javax.swing.JTextField stockField;
    // End of variables declaration//GEN-END:variables
}
