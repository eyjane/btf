package UI;

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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clarkabalos
 */
public class EditCategory extends javax.swing.JFrame {
    private CategoryDAOInterface ctImp = new CategoryDAOImplementation();
    private RecipeDAOInterface rcImp = new RecipeDAOImplementation();
    private ArrayList<RecipeBean> r = new ArrayList();
    private CategoryBean cat;
    private RCpopup rc;
    private CategoryManagement cm;

    //<--- CLARK'S CODE STARTS HERE --->
    
    public EditCategory(CategoryManagement c) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        cm = c;
        initComponents();
        cat = cm.getCategory();
        nameField.setText(cat.getCategory());
        errorLabel.setVisible(false);
        errorLabel1.setVisible(false);
        ViewAllRecipes(cat.getaRecipes());
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
       r = rb;
       for (int i = 0; i < r.size(); i++) {
           if(r.get(i).getRcstatus().equalsIgnoreCase("available")) {
               defaultModel.addRow(new Object[] {r.get(i).getRecipeID(), r.get(i).getRecipe(),               
               r.get(i).getCost(), r.get(i).getStock(), r.get(i).getRcstatus()});
           }
       }
       recipeTable.setModel(defaultModel);
    }
    
    public boolean authenticateCategory(){
        boolean flag = true;
        ArrayList<CategoryBean> c = ctImp.getAllCategory();
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
        return flag;
    }
    
    public CategoryBean getCategory(){
        return cat;
    }
    
    //<--- CLARK'S CODE ENDS HERE --->
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        editRecipes = new javax.swing.JButton();
        errorLabel1 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        saveCategory = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Edit Category");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 47));

        nameLabel.setText(" ");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 243, 0, -1));

        jLabel2.setText("Name: ");

        jLabel6.setText("Recipes:");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        errorLabel.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel.setText("ERROR: Required field.");

        recipeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Cost", "Stock", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        recipeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recipeTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(recipeTable);
        recipeTable.getColumnModel().getColumn(0).setResizable(false);
        recipeTable.getColumnModel().getColumn(1).setResizable(false);
        recipeTable.getColumnModel().getColumn(2).setResizable(false);
        recipeTable.getColumnModel().getColumn(3).setResizable(false);
        recipeTable.getColumnModel().getColumn(4).setResizable(false);

        editRecipes.setText("Edit Recipes");
        editRecipes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRecipesActionPerformed(evt);
            }
        });

        errorLabel1.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel1.setText("Duplicate name.");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        saveCategory.setText("Save Category");
        saveCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorLabel1)))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(saveCategory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editRecipes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel)
                    .addComponent(errorLabel1))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editRecipes)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(saveCategory))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 510, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void editRecipesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRecipesActionPerformed
        int nrow = recipeTable.getRowCount();
        int rid;
        
        ArrayList<RecipeBean> a = new ArrayList<RecipeBean>();
        if (nrow != 0) {
            for (int i = 0; i < nrow; i++) {
                RecipeBean rbean = new RecipeBean();
                rid = Integer.parseInt(recipeTable.getModel().getValueAt(i, 0).toString());
                rbean = rcImp.getRecipeBean(rid);
                a.add(rbean);
            }
        }

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
                /*for (RecipeBean recipe : cat.getaRecipes()) {
                    recipe.setCategory(1);
                    rcImp.editRecipe(recipe);
                }*/
                
                for (RecipeBean recipe : r) {
                    recipe.setCategory(cat.getCategoryID());
                    rcImp.editRecipe(recipe);
                }
                
                ArrayList<RecipeBean> a = cat.getaRecipes();
                for(int i = 0; i < a.size(); i++){
                    boolean flag = false;
                    for(int j = 0; j < r.size(); j++){
                        if(a.get(i).getRecipe().equals(r.get(j).getRecipe()))
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
                cm.setCategoryField(cat.getCategory());
                cm.ViewAllRecipes(cat);
                dispose();
            } catch(Exception err){
                err.printStackTrace();
            }
        }
    }//GEN-LAST:event_saveCategoryActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        cm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void recipeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recipeTableMouseClicked

    }//GEN-LAST:event_recipeTableMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton editRecipes;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable recipeTable;
    private javax.swing.JButton saveCategory;
    // End of variables declaration//GEN-END:variables
}
