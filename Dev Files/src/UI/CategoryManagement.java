package UI;

import Beans.CategoryBean;
import Beans.RecipeBean;
import DAO.Implementation.CategoryDAOImplementation;
import DAO.Interface.CategoryDAOInterface;
import DAO.Implementation.RecipeDAOImplementation;
import DAO.Interface.RecipeDAOInterface;
import java.awt.Component;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author clarkabalos
 */
public class CategoryManagement extends javax.swing.JFrame {
        private CategoryDAOInterface ctImp;
        private RecipeDAOInterface rcImp;
        private DefaultTableModel defaultModel;
    
    //<--- CLARK'S CODE STARTS HERE --->
    public CategoryManagement() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        rcImp = new RecipeDAOImplementation();
        ctImp = new CategoryDAOImplementation();
<<<<<<< HEAD
        ViewAllCategories();
=======
        selectedCat = new CategoryBean();
        selectedRC = new RecipeBean();
/*        errorLabel1.setVisible(false);
        errorLabel2.setVisible(false);
        btnUpdateCategory.setEnabled(false);
        btnAddRecipe.setEnabled(false);
        btnDeleteRecipe.setEnabled(false);
 */       ViewAllCategories();
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
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
       defaultModel = initializeTableModel();
       CategoryBean c;
       for (int i = 0; i < ctImp.getAllCategory().size(); i++) {
            c = ctImp.getAllCategory().get(i);
            defaultModel.addRow(new Object[] {c.getCategoryID(), c.getCategory()});
       }
<<<<<<< HEAD
       categoryTable.setModel(defaultModel);
       categoryTable.getColumnModel().getColumn(0).setMinWidth(0);
       categoryTable.getColumnModel().getColumn(0).setMaxWidth(0);
       adjustTable(categoryTable);
    }
=======
 /*      categoryTable.setModel(defaultModel);
       categoryTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            try {
            DefaultTableModel defaultTableModel = (DefaultTableModel) categoryTable.getModel();
            if (categoryTable.getSelectedRow() >= 0) {
                categoryIDField.setText(defaultTableModel.getValueAt(categoryTable.getSelectedRow(), 0).toString());
                categoryNameField.setText((String) defaultTableModel.getValueAt(categoryTable.getSelectedRow(), 1));
                selectedCat = ctImp.getCategory((int) (defaultTableModel.getValueAt(categoryTable.getSelectedRow(), 0)));
                btnUpdateCategory.setEnabled(true);
                btnAddRecipe.setEnabled(true);
                btnAddCategory.setEnabled(false);    
                if(selectedCat.getCategoryID() == 1) 
                    btnDeleteRecipe.setEnabled(false);
                else
                    btnDeleteRecipe.setEnabled(true);            
                ViewAllRecipes(selectedCat);
            } else 
                    selectedCat = null;
            } catch (Exception err) {
                err.printStackTrace();
            } 
        }
       });
            */
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
   /*    recipeTable.setModel(defaultModel);
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
       */
    }
    
    public boolean authenticateCategory(){
        boolean flag = true;
        selectedCat = new CategoryBean();
  /*      if(categoryNameField.getText().equals("")) {
            errorLabel1.setVisible(true);
            flag = false;
        }
        else {
            selectedCat.setCategory(categoryNameField.getText());
            errorLabel1.setVisible(false);
            errorLabel2.setVisible(false);
            for(int i = 0; i < ctImp.getAllCategory().size(); i++){
                if(categoryNameField.getText().equalsIgnoreCase(ctImp.getAllCategory().get(i).getCategory())) {
                    errorLabel1.setVisible(true);
                    errorLabel2.setVisible(true);
                    flag = false;
                } 
            }
        }*/
        return flag;
    }
    
    public void clearText(){
 /*       categoryNameField.setText("");
        categoryIDField.setText("");
        errorLabel1.setVisible(false);
        errorLabel2.setVisible(false);
        btnUpdateCategory.setEnabled(false);
        btnAddCategory.setEnabled(true);
        btnAddRecipe.setEnabled(false);
        btnDeleteRecipe.setEnabled(false);
        recipeTable.setModel(initializeRecipeTable());
  */  }
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
    
    public DefaultTableModel getCMTable(){
        return defaultModel;
    }
    
<<<<<<< HEAD
    public void deleteCategory(int c[]){
        TableModel model = categoryTable.getModel();
        DefaultTableModel table = (DefaultTableModel) model;
        
        for(int i = 0; i < c.length; i++){
            int rID = Integer.parseInt(categoryTable.getModel().getValueAt(c[i], 0).toString());
            CategoryBean category = ctImp.getCategory(rID);
            if(rID != 1) {
                    if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this category?", "Confirm Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                        RecipeBean rc;
                        ArrayList<RecipeBean> temp = rcImp.getRecipeByCategory(category);
                        for (int j = 0; j < temp.size(); j++) {
                            rc = temp.get(j);
                            rc.setCategory(1);
                            rcImp.editRecipe(rc);
                        }
                        ctImp.deleteCategory(category);
                        JOptionPane.showMessageDialog(null, "Successfully deleted the category!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        table.removeRow(c[i]);
                    }
                } else if(rID == 1)
                    JOptionPane.showMessageDialog(null, "You cannot delete the category.", "Try Again", JOptionPane.WARNING_MESSAGE);
        }
        
        categoryTable.setModel(table);
        categoryTable.getColumnModel().getColumn(0).setMinWidth(0);
        categoryTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
=======
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
    //<--- CLARK'S CODE ENDS HERE --->
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
<<<<<<< HEAD
        btnAddCategory = new javax.swing.JButton();
        btnEditCategory = new javax.swing.JButton();
        btnDeleteCategory = new javax.swing.JButton();
=======
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
        jLabel9 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(703, 473));
        jPanel1.setRequestFocusEnabled(false);

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
        jScrollPane1.setViewportView(categoryTable);
<<<<<<< HEAD
        categoryTable.getColumnModel().getColumn(0).setResizable(false);

        btnAddCategory.setText("Add A Category");
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        btnEditCategory.setText("Edit A Category");
        btnEditCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCategoryActionPerformed(evt);
            }
        });

        btnDeleteCategory.setText("Delete This Category");
        btnDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCategoryActionPerformed(evt);
            }
        });
=======
        if (categoryTable.getColumnModel().getColumnCount() > 0) {
            categoryTable.getColumnModel().getColumn(0).setResizable(false);
            categoryTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton1.setText("Add A Category");

        jButton2.setText("Edit A Category");

        jButton3.setText("Delete This Category");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel9.setText("CATEGORY");
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel9.setText("CATEGORY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
                    .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 30, Short.MAX_VALUE))
=======
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 326, Short.MAX_VALUE))
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
<<<<<<< HEAD
                        .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
                        .addGap(0, 132, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            }catch(Exception e){
                e.printStackTrace();
            }
    }//GEN-LAST:event_btnBackActionPerformed

<<<<<<< HEAD
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

    private void btnEditCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCategoryActionPerformed
        try {
                EditCategory c = new EditCategory(this);
                c.setVisible(true);
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

    private void btnDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCategoryActionPerformed
        int select[] = categoryTable.getSelectedRows();
        if (select.length > 0) {
            deleteCategory(select);
        } else {
            JOptionPane.showMessageDialog(null, "Please select an entry to delete.", "Blank Form", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteCategoryActionPerformed

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
    
=======
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRecipeB;
    private javax.swing.JButton addRecipeB1;
    private javax.swing.JButton btnBack;
<<<<<<< HEAD
    private javax.swing.JButton btnDeleteCategory;
    private javax.swing.JButton btnEditCategory;
    private javax.swing.JTable categoryTable;
=======
    private javax.swing.JTable categoryTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
