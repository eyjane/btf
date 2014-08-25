package UI;

import Beans.CategoryBean;
import Beans.RecipeBean;
import DAO.Implementation.CategoryDAOImplementation;
import DAO.Implementation.RecipeDAOImplementation;
import DAO.Interface.CategoryDAOInterface;
import DAO.Interface.RecipeDAOInterface;
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
public class EditCG extends javax.swing.JFrame {
    private CategoryDAOInterface ctImp = new CategoryDAOImplementation();
    private RecipeDAOInterface rcImp = new RecipeDAOImplementation();
    private ArrayList<RecipeBean> catRecipes = new ArrayList<RecipeBean>();
    private CGManagement cm;
    private CategoryBean cat;
    private AddRCtoCG rc;

    //<--- CLARK'S CODE STARTS HERE --->
    
    public EditCG(CGManagement c) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        cm = c;
        disableFields();
        prepareTable();
        errorLabel1.setVisible(false);
        errorLabel2.setVisible(false);
        errorLabel3.setVisible(false);
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
                enableFields();
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
        //if (select <= 0) {
            //JOptionPane.showMessageDialog(null, "Please select an entry to delete.", "Blank Form", JOptionPane.WARNING_MESSAGE);
            //nameField.setText("");
            //flag = false;
            
       // } else{
            if(nameField.getText().equals("")) {
                errorLabel1.setVisible(true);
                errorLabel2.setVisible(false);
                errorLabel3.setVisible(true);
                flag = false;
            }
            else {
                cat.setCategory(nameField.getText());
                errorLabel1.setVisible(false);
                errorLabel2.setVisible(false);
                errorLabel3.setVisible(false);
                for(int i = 0; i < c.size(); i++){
                    if(nameField.getText().equalsIgnoreCase(c.get(i).getCategory()) && cat.getCategoryID() != c.get(i).getCategoryID()) {
                        errorLabel2.setVisible(true);
                        flag = false;
                    } 
                }
            }
        //}
        return flag;
    }
    
    public void disableFields() {
        nameField.setEditable(false);
        EditRecipesBtn.setEnabled(false);
    }
    
    public void enableFields() {
        nameField.setEditable(true);
        EditRecipesBtn.setEnabled(true);
    }
    
    public CategoryBean getCategory(){
        return cat;
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
        categoryTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        SaveCGBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        errorLabel2 = new javax.swing.JLabel();
        errorLabel3 = new javax.swing.JLabel();
        errorLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        EditRecipesBtn = new javax.swing.JButton();
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
        EODBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EODBtnActionPerformed(evt);
            }
        });
        jPanel1.add(EODBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 239, 60));

        ReportsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Reports Btn.png"))); // NOI18N
        ReportsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportsBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ReportsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 239, 60));

        jScrollPane1.setFont(new java.awt.Font("Quicksand Light", 0, 12)); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(620, 402));

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
        jScrollPane1.setViewportView(categoryTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 600, 160));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Category Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Quicksand Light", 0, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel3.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel2.setText("Name:");

        nameField.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameFieldKeyReleased(evt);
            }
        });

        SaveCGBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/SaveBtn.png"))); // NOI18N
        SaveCGBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveCGBtnActionPerformed(evt);
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

        errorLabel3.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        errorLabel3.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel3.setText("*ERROR: Required field");

        errorLabel1.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        errorLabel1.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel1.setText("*");

        jLabel3.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel3.setText("Recipes:");

        recipeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Cost", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(recipeTable);

        EditRecipesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/EditRCBtn.png"))); // NOI18N
        EditRecipesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditRecipesBtnActionPerformed(evt);
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
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(EditRecipesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SaveCGBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(errorLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditRecipesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(errorLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SaveCGBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 600, 270));

        jLabel1.setFont(new java.awt.Font("Quicksand Light", 0, 36)); // NOI18N
        jLabel1.setText("Categories Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Background4.png"))); // NOI18N
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

    private void EditRecipesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditRecipesBtnActionPerformed
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
            rc = new AddRCtoCG(this, a);
            rc.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_EditRecipesBtnActionPerformed

    private void SaveCGBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveCGBtnActionPerformed
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
    }//GEN-LAST:event_SaveCGBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        cm.setVisible(true);
        dispose();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyReleased
        authenticateCategory();
    }//GEN-LAST:event_nameFieldKeyReleased

    private void ReportsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportsBtnActionPerformed
        try {
            ReportsTab rt = new ReportsTab();
            rt.setVisible(true);
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
    }//GEN-LAST:event_ReportsBtnActionPerformed

    private void EODBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EODBtnActionPerformed
        try {
            EODTab et = new EODTab();
            et.setVisible(true);
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
    }//GEN-LAST:event_EODBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton CategoriesBtn;
    private javax.swing.JButton EODBtn;
    private javax.swing.JButton EditRecipesBtn;
    private javax.swing.JButton InventoryBtn;
    private javax.swing.JButton RMBtn;
    private javax.swing.JButton RecipesBtn;
    private javax.swing.JButton ReportsBtn;
    private javax.swing.JButton SaveCGBtn;
    private javax.swing.JTable categoryTable;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JLabel errorLabel3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTable recipeTable;
    // End of variables declaration//GEN-END:variables
}