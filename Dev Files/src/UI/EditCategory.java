/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

<<<<<<< HEAD
import Beans.CategoryBean;
import Beans.RecipeBean;
import DAO.Implementation.CategoryDAOImplementation;
import DAO.Implementation.RecipeDAOImplementation;
import DAO.Interface.CategoryDAOInterface;
import DAO.Interface.RecipeDAOInterface;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
=======
package UI;
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b

/**
 *
 * @author Evy
 */
public class EditCategory extends javax.swing.JFrame {
<<<<<<< HEAD
    private CategoryDAOInterface ctImp = new CategoryDAOImplementation();
    private RecipeDAOInterface rcImp = new RecipeDAOImplementation();
    private ArrayList<RecipeBean> catRecipes = new ArrayList<RecipeBean>();
    private CategoryManagement cm;
    private CategoryBean cat;
    private RCpopup rc;

    //<--- CLARK'S CODE STARTS HERE --->
    
    public EditCategory(CategoryManagement c) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        cm = c;
        prepareTable();
        errorLabel.setVisible(false);
        errorLabel1.setVisible(false);
        cat = null;
    }
    
    public DefaultTableModel initializeRecipeTable(){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Cost");
        defaultTableModel.addColumn("Stock");
        defaultTableModel.addColumn("Status");
        return defaultTableModel;
    }
    
    public void ViewAllRecipes(ArrayList<RecipeBean> rb){
       DefaultTableModel defaultModel = initializeRecipeTable();
       catRecipes = rb;
       for (int i = 0; i < catRecipes.size(); i++) {
           if(catRecipes.get(i).getRcstatus().equalsIgnoreCase("available")) {
               defaultModel.addRow(new Object[] {catRecipes.get(i).getRecipeID(), catRecipes.get(i).getRecipe(),               
               catRecipes.get(i).getCost(), catRecipes.get(i).computeStock(), catRecipes.get(i).getRcstatus()});
           }
       }
       recipeTable.setModel(defaultModel);
       recipeTable.getColumnModel().getColumn(0).setMinWidth(0);
       recipeTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
    public void prepareTable(){
        categoryTable.setModel(cm.getCMTable());
        categoryTable.getColumnModel().getColumn(0).setMinWidth(0);
        categoryTable.getColumnModel().getColumn(0).setMaxWidth(0);
        
        categoryTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            try {
            DefaultTableModel defaultTableModel = (DefaultTableModel) categoryTable.getModel();
            if (categoryTable.getSelectedRow() >= 0) { 
                cat = ctImp.getCategory((int) defaultTableModel.getValueAt(categoryTable.getSelectedRow(), 0));
                cat.setaRecipes(rcImp.getRecipeByCategory(cat));
                nameField.setText(cat.getCategory());
                ViewAllRecipes(cat.getaRecipes());
            } else {
                cat = null;
              }
            } catch (Exception err) {
                err.printStackTrace();
            } 
        }
       });
    }
    
    public boolean authenticateCategory(){
        boolean flag = true;
        ArrayList<CategoryBean> c = ctImp.getAllCategory();
        int select = categoryTable.getSelectedRow();
        if (select <= 0) {
            JOptionPane.showMessageDialog(null, "Please select an entry to delete.", "Blank Form", JOptionPane.WARNING_MESSAGE);
            flag = false;
        } else{
            if(nameField.getText().equals("")) {
                errorLabel.setVisible(true);
                flag = false;
            }
            else {
                cat.setCategory(nameField.getText());
                errorLabel.setVisible(false);
                errorLabel1.setVisible(false);
                for(int i = 0; i < c.size(); i++){
                    if(nameField.getText().equalsIgnoreCase(c.get(i).getCategory()) && cat.getCategoryID() != c.get(i).getCategoryID()) {
                        errorLabel.setVisible(true);
                        errorLabel1.setVisible(true);
                        flag = false;
                    } 
                }
            }
        }
        return flag;
=======

    /**
     * Creates new form EditCategory
     */
    public EditCategory() {
        initComponents();
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        categoryIDField = new javax.swing.JTextField();
        categoryNameField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable();
        btnAddRecipe = new javax.swing.JButton();
        btnDeleteRecipe = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        errorLabel1 = new javax.swing.JLabel();
<<<<<<< HEAD
        saveCategory = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();

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
        jScrollPane1.setViewportView(jTable1);
=======
        errorLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(956, 555));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel10.setText("EDIT CATEGORY");

        jButton1.setText("BACK");

<<<<<<< HEAD
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Name: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 38, -1, -1));

        jLabel6.setText("Recipes:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameFieldKeyReleased(evt);
            }
        });
        jPanel1.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 35, 225, -1));

        errorLabel.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel.setText("ERROR: Required field.");
        jPanel1.add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 38, -1, -1));
=======
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Category Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 102, 102)));
        jPanel2.setPreferredSize(new java.awt.Dimension(956, 555));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("ID:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, -1, -1));

        jLabel3.setText("Name:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, -1, -1));

        jLabel4.setText("RECIPES");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        categoryIDField.setEditable(false);
        jPanel2.add(categoryIDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 27, 125, -1));
        jPanel2.add(categoryNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 65, 125, -1));
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b

        recipeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Cost", "Stock", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
<<<<<<< HEAD
        jScrollPane2.setViewportView(recipeTable);
        recipeTable.getColumnModel().getColumn(0).setResizable(false);
        recipeTable.getColumnModel().getColumn(1).setResizable(false);
        recipeTable.getColumnModel().getColumn(2).setResizable(false);
        recipeTable.getColumnModel().getColumn(3).setResizable(false);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 93, 476, 108));

        editRecipes.setText("Edit Recipes");
        editRecipes.addActionListener(new java.awt.event.ActionListener() {
=======
        recipeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(recipeTable);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 534, 220));

        btnAddRecipe.setText("Add");
        btnAddRecipe.addActionListener(new java.awt.event.ActionListener() {
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecipeActionPerformed(evt);
            }
        });
<<<<<<< HEAD
        jPanel1.add(editRecipes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 207, -1, -1));

        errorLabel1.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel1.setText("Duplicate name.");
        jPanel1.add(errorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 38, -1, -1));

        saveCategory.setText("Save Category");
        saveCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCategoryActionPerformed(evt);
            }
        });
        jPanel1.add(saveCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 241, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 510, 290));

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
=======
        jPanel2.add(btnAddRecipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, -1));

        btnDeleteRecipe.setText("Delete");
        btnDeleteRecipe.addActionListener(new java.awt.event.ActionListener() {
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRecipeActionPerformed(evt);
            }
        });
<<<<<<< HEAD
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel9.setText("Choose a category here");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));
=======
        jPanel2.add(btnDeleteRecipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        errorLabel1.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel1.setText("ERROR: Required field.");
        jPanel2.add(errorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 68, -1, -1));

        errorLabel2.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel2.setText("Duplicate name exists.");
        jPanel2.add(errorLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 68, -1, -1));

        jButton2.setText("Save");
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel9.setText("Choose a category here");
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b

        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
<<<<<<< HEAD
                "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        categoryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(categoryTable);
        categoryTable.getColumnModel().getColumn(0).setResizable(false);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 350, 260));

=======
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        categoryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(categoryTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(78, Short.MAX_VALUE))
        );

>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRecipeActionPerformed
        /*        if(selectedCat != null){
            try {
                RCpopup rcp = new RCpopup(this);
                rcp.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a category first.", "Blank Form", JOptionPane.WARNING_MESSAGE);
        }
        */
    }//GEN-LAST:event_btnAddRecipeActionPerformed

<<<<<<< HEAD
        try {
            rc = new RCpopup(this, a);
            rc.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_editRecipesActionPerformed

    private void saveCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCategoryActionPerformed
        if(authenticateCategory()){
            try{
                ctImp.editCategory(cat);
                
                for (RecipeBean recipe : catRecipes) {
                    recipe.setCategory(cat.getCategoryID());
                    rcImp.editRecipe(recipe);
                }
                
                ArrayList<RecipeBean> a = cat.getaRecipes();
                for(int i = 0; i < a.size(); i++){
                    boolean flag = false;
                    for(int j = 0; j < catRecipes.size(); j++){
                        if(a.get(i).getRecipe().equals(catRecipes.get(j).getRecipe()))
                            flag = true;
                    }
                    if(flag == false){
                        a.get(i).setCategory(1);
                        rcImp.editRecipe(a.get(i));
                    }
                }
                
                JOptionPane.showMessageDialog(null, "Successfully edited the category!", "Success", JOptionPane.INFORMATION_MESSAGE);
                cm.setVisible(true);
                cm.ViewAllCategories();
                dispose();
            } catch(Exception err){
                err.printStackTrace();
=======
    private void btnDeleteRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRecipeActionPerformed
        /*        try {
            if(selectedRC != null) {
                if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this recipe?", "Confirm Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    selectedRC.setCategory(1);
                    rcImp.editRecipe(selectedRC);
                    ViewAllRecipes(selectedCat);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select an entry to delete.", "Blank Form", JOptionPane.WARNING_MESSAGE);
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
        */
    }//GEN-LAST:event_btnDeleteRecipeActionPerformed

<<<<<<< HEAD
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        cm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyReleased
        authenticateCategory();
    }//GEN-LAST:event_nameFieldKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JTable categoryTable;
    private javax.swing.JButton editRecipes;
    private javax.swing.JLabel errorLabel;
=======
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        //        clearText();
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(EditCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRecipe;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDeleteRecipe;
    private javax.swing.JTextField categoryIDField;
    private javax.swing.JTextField categoryNameField;
    private javax.swing.JTable categoryTable;
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
<<<<<<< HEAD
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
=======
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
    private javax.swing.JTable recipeTable;
    // End of variables declaration//GEN-END:variables
}
