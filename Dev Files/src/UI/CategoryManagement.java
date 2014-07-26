package UI;

import Beans.CategoryBean;
import Beans.RecipeBean;
import DAO.Implementation.CategoryDAOImplementation;
import DAO.Interface.CategoryDAOInterface;
import DAO.Implementation.RecipeDAOImplementation;
import DAO.Interface.RecipeDAOInterface;
import java.sql.SQLException;
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
 * @author clarkabalos
 */
public class CategoryManagement extends javax.swing.JFrame {
        private CategoryDAOInterface ctImp;
        private RecipeDAOInterface rcImp;
        private CategoryBean selectedCat;
        private RecipeBean selectedRC;
    
    //<--- CLARK'S CODE STARTS HERE --->
    public CategoryManagement() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        rcImp = new RecipeDAOImplementation();
        ctImp = new CategoryDAOImplementation();
        selectedCat = new CategoryBean();
        selectedRC = new RecipeBean();
        ViewAllCategories();
    }
    
    public DefaultTableModel initializeTableModel() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Name");
        return defaultTableModel;
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
    
    public void ViewAllCategories(){
       DefaultTableModel defaultModel = initializeTableModel();
       CategoryBean c;
       for (int i = 0; i < ctImp.getAllCategory().size(); i++) {
            c = ctImp.getAllCategory().get(i);
            defaultModel.addRow(new Object[] {c.getCategoryID(), c.getCategory()});
       }
       categoryTable.setModel(defaultModel);
       categoryTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            try {
            DefaultTableModel defaultTableModel = (DefaultTableModel) categoryTable.getModel();
            if (categoryTable.getSelectedRow() >= 0) {
                categoryIDField.setText(defaultTableModel.getValueAt(categoryTable.getSelectedRow(), 0).toString());
                categoryNameField.setText((String) defaultTableModel.getValueAt(categoryTable.getSelectedRow(), 1));
                selectedCat = ctImp.getCategory((int) (defaultTableModel.getValueAt(categoryTable.getSelectedRow(), 0)));         
                ViewAllRecipes(selectedCat);
            } else 
                    selectedCat = null;
            } catch (Exception err) {
                err.printStackTrace();
            } 
        }
       });
    }
    
    public void ViewAllRecipes(CategoryBean c){
       DefaultTableModel defaultModel = initializeRecipeTable();
       c.setaRecipes(rcImp.getRecipeByCategory(c));
       for (int i = 0; i < c.getaRecipes().size(); i++) {
           if(c.getaRecipes().get(i).getRcstatus().equalsIgnoreCase("available")) {
               defaultModel.addRow(new Object[] {c.getaRecipes().get(i).getRecipeID(), c.getaRecipes().get(i).getRecipe(),               
               c.getaRecipes().get(i).getCost(), c.getaRecipes().get(i).getStock(), c.getaRecipes().get(i).getRcstatus()});
           }
       }
       recipeTable.setModel(defaultModel);
       recipeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            try {
            DefaultTableModel defaultTableModel = (DefaultTableModel) recipeTable.getModel();
            if (recipeTable.getSelectedRow() >= 0) {
                selectedRC = rcImp.getRecipeBean((int) defaultTableModel.getValueAt(recipeTable.getSelectedRow(), 0));
            } else
                selectedRC = null;
            } catch (Exception err) {
                err.printStackTrace();
            } 
        }
       });
    }
   
    public void clearText(){
        categoryNameField.setText("");
        categoryIDField.setText("");
        recipeTable.setModel(initializeRecipeTable());
    }
    
    public CategoryBean getCategory(){
        return selectedCat;
    }
    
    public void setCategoryField(CategoryBean cat){
        categoryIDField.setText(Integer.toString(cat.getCategoryID()));
        categoryNameField.setText(cat.getCategory());
    }
    
    //<--- CLARK'S CODE ENDS HERE --->
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        categoryIDField = new javax.swing.JTextField();
        categoryNameField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable();
        btnAddCategory = new javax.swing.JButton();
        btnDeleteCategory = new javax.swing.JButton();
        btnEditCategory = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(703, 473));
        jPanel1.setRequestFocusEnabled(false);

        jLabel1.setText("Category Table");

        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
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
        if (categoryTable.getColumnModel().getColumnCount() > 0) {
            categoryTable.getColumnModel().getColumn(0).setResizable(false);
            categoryTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Category"));
        jPanel2.setPreferredSize(new java.awt.Dimension(703, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("ID:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, -1, -1));

        jLabel3.setText("Name:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, -1, -1));

        jLabel4.setText("RECIPES");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        categoryIDField.setEditable(false);
        jPanel2.add(categoryIDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 27, 200, -1));

        categoryNameField.setEditable(false);
        jPanel2.add(categoryNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 65, 200, -1));

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
        recipeTable.setToolTipText("");
        recipeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(recipeTable);
        if (recipeTable.getColumnModel().getColumnCount() > 0) {
            recipeTable.getColumnModel().getColumn(0).setResizable(false);
            recipeTable.getColumnModel().getColumn(1).setResizable(false);
            recipeTable.getColumnModel().getColumn(2).setResizable(false);
            recipeTable.getColumnModel().getColumn(3).setResizable(false);
            recipeTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 50, 580, 130));

        btnAddCategory.setText("Add Category");
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        btnDeleteCategory.setText("Delete Category");
        btnDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCategoryActionPerformed(evt);
            }
        });

        btnEditCategory.setText("Edit Category");
        btnEditCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAddCategory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditCategory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteCategory)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteCategory)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddCategory)
                        .addComponent(btnEditCategory)))
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        try {
            AddCategory ac = new AddCategory(this);
            ac.setVisible(true);
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
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void btnDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCategoryActionPerformed
        try {
            if(selectedCat != null){
                if(!categoryIDField.getText().equals("") && !categoryIDField.getText().equals("1")) {
                    ViewAllRecipes(selectedCat);
                    if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this category?", "Confirm Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                        RecipeBean rc;
                        for (int i = 0; i < rcImp.getRecipeByCategory(selectedCat).size(); i++) {
                            rc = rcImp.getRecipeByCategory(selectedCat).get(i);
                            rc.setCategory(1);
                            rcImp.editRecipe(rc);
                        }
                        ctImp.deleteCategory(selectedCat);
                        JOptionPane.showMessageDialog(null, "Successfully deleted the category!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        ViewAllCategories();
                    }
                    clearText();
                } else if(categoryIDField.getText().equals("1"))
                    JOptionPane.showMessageDialog(null, "You cannot delete the category.", "Try Again", JOptionPane.WARNING_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, "Please select an entry to delete.", "Blank Form", JOptionPane.WARNING_MESSAGE);
        }   catch (Exception err) {
            err.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteCategoryActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try {
                EODTab e = new EODTab();
                e.setVisible(true);
                dispose();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnEditCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCategoryActionPerformed
        try {
            EditCategory ec = new EditCategory(this);
            ec.setVisible(true);
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
    }//GEN-LAST:event_btnEditCategoryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteCategory;
    private javax.swing.JButton btnEditCategory;
    private javax.swing.JTextField categoryIDField;
    private javax.swing.JTextField categoryNameField;
    private javax.swing.JTable categoryTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable recipeTable;
    // End of variables declaration//GEN-END:variables
}
