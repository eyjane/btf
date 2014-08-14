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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clarkabalos
 */
public class EditCategory extends javax.swing.JFrame {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Edit Category");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 47));

        nameLabel.setText(" ");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 243, 0, -1));

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
        jScrollPane2.setViewportView(recipeTable);
        recipeTable.getColumnModel().getColumn(0).setResizable(false);
        recipeTable.getColumnModel().getColumn(1).setResizable(false);
        recipeTable.getColumnModel().getColumn(2).setResizable(false);
        recipeTable.getColumnModel().getColumn(3).setResizable(false);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 93, 476, 108));

        editRecipes.setText("Edit Recipes");
        editRecipes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRecipesActionPerformed(evt);
            }
        });
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
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel9.setText("Choose a category here");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
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
            }
        }
    }//GEN-LAST:event_saveCategoryActionPerformed

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
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable recipeTable;
    private javax.swing.JButton saveCategory;
    // End of variables declaration//GEN-END:variables
}
