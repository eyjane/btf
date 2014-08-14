package UI;

import Beans.RecipeBean;
import DAO.Implementation.RecipeDAOImplementation;
import DAO.Interface.RecipeDAOInterface;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clarkabalos
 */
public class RCpopup extends javax.swing.JFrame {
<<<<<<< HEAD
    private EditCategory ec;
    private RecipeDAOInterface rcImp;
    private ArrayList<RecipeBean> catRecipes;
    private ArrayList<RecipeBean> allRecipes;
=======
    private RecipeDAOInterface rcImp;
    private CategoryManagement cm;
    private RecipeBean rc;
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
   
    //<--- CLARK'S CODE STARTS HERE --->
    public RCpopup(CategoryManagement c) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
<<<<<<< HEAD
        ec = c;
        catRecipes = rb;
        rcImp = new RecipeDAOImplementation();
        allRecipes = rcImp.getRecipeByStatus("available");
=======
        cm = c;
        rcImp = new RecipeDAOImplementation();
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
        ViewAllRecipes();
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
    
    public void ViewAllRecipes(){
       DefaultTableModel defaultModel = initializeRecipeTable();
<<<<<<< HEAD
       for (int i = 0; i < allRecipes.size(); i++) {
           boolean flag = true;
           for (int j = 0; j < catRecipes.size(); j++) {
               if(allRecipes.get(i).getRecipe().equals(catRecipes.get(j).getRecipe())){
                    flag = false;
               }
           }
           if(flag == true){
                defaultModel.addRow(new Object[] {allRecipes.get(i).getRecipeID(), allRecipes.get(i).getRecipe(),               
                allRecipes.get(i).getCost(), allRecipes.get(i).computeStock(), allRecipes.get(i).getRcstatus()});
           }
=======
       for (int i = 0; i < rcImp.getRecipeByStatus("available").size(); i++) {
            defaultModel.addRow(new Object[] {rcImp.getRecipeByStatus("available").get(i).getRecipeID(), rcImp.getRecipeByStatus("available").get(i).getRecipe(),               
            rcImp.getRecipeByStatus("available").get(i).getCost(), rcImp.getRecipeByStatus("available").get(i).getStock(), rcImp.getRecipeByStatus("available").get(i).getRcstatus()});
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
       }
       recipeTable.setModel(defaultModel);
       recipeTable.getColumnModel().getColumn(0).setMinWidth(0);
       recipeTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
<<<<<<< HEAD
    public void addRecipe(int r[]){
        TableModel model = recipeTable.getModel();
        DefaultTableModel table = (DefaultTableModel) model;
        
        for(int i = 0; i < r.length; i++){
            int rID = Integer.parseInt(recipeTable.getModel().getValueAt(r[i], 0).toString());
            RecipeBean rb = rcImp.getRecipeBean(rID);
            catRecipes.add(rb);
            table.removeRow(r[i]);
        }
        
        recipeTable.setModel(table);
        recipeTable.getColumnModel().getColumn(0).setMinWidth(0);
        recipeTable.getColumnModel().getColumn(0).setMaxWidth(0);
=======
    public RecipeBean getSelectedRecipe(){
        rc = new RecipeBean();
        try {
            DefaultTableModel defaultTableModel = (DefaultTableModel) recipeTable.getModel();
            if (recipeTable.getSelectedRow() >= 0) {
                rc.setRecipeID((int) defaultTableModel.getValueAt(recipeTable.getSelectedRow(), 0));
                rc.setRecipe((String) defaultTableModel.getValueAt(recipeTable.getSelectedRow(), 1));
                rc.setCost((float) defaultTableModel.getValueAt(recipeTable.getSelectedRow(), 2));
                rc.setStock((float) defaultTableModel.getValueAt(recipeTable.getSelectedRow(), 3));
                rc.setRcstatus((String) defaultTableModel.getValueAt(recipeTable.getSelectedRow(), 4));
            } else
                rc = null;
        } catch (Exception err) {
            err.printStackTrace();
        } 
        return rc;
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
    }
    
    //<--- CLARK'S CODE ENDS HERE --->
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable();
        btnAddRecipe = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(956, 224));

        jPanel1.setPreferredSize(new java.awt.Dimension(956, 215));
<<<<<<< HEAD

        jLabel1.setText("Recipe List");

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

=======

        jLabel1.setText("Recipe List");

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

>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        recipeTable.setPreferredSize(new java.awt.Dimension(375, 170));
        jScrollPane1.setViewportView(recipeTable);
<<<<<<< HEAD
        recipeTable.getColumnModel().getColumn(0).setResizable(false);
        recipeTable.getColumnModel().getColumn(1).setResizable(false);
        recipeTable.getColumnModel().getColumn(2).setResizable(false);
        recipeTable.getColumnModel().getColumn(3).setResizable(false);
=======
        if (recipeTable.getColumnModel().getColumnCount() > 0) {
            recipeTable.getColumnModel().getColumn(0).setResizable(false);
            recipeTable.getColumnModel().getColumn(1).setResizable(false);
            recipeTable.getColumnModel().getColumn(2).setResizable(false);
            recipeTable.getColumnModel().getColumn(3).setResizable(false);
            recipeTable.getColumnModel().getColumn(4).setResizable(false);
        }
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b

        btnAddRecipe.setText("Add");
        btnAddRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecipeActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddRecipe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel)
                    .addComponent(btnAddRecipe))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRecipeActionPerformed
<<<<<<< HEAD
        int select[] = recipeTable.getSelectedRows();
        if (select.length > 0) {
            addRecipe(select);
            try{
                ec.setVisible(true);
                ec.ViewAllRecipes(catRecipes);
                dispose();
            }catch(Exception e){
                e.printStackTrace();
            }
        } else {
            return;
        }
    }//GEN-LAST:event_btnAddRecipeActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        ec.setVisible(true);
=======
        getSelectedRecipe().setCategory(cm.getCategory().getCategoryID());
        rcImp.editRecipe(rc);
        cm.ViewAllRecipes(cm.getCategory());
        dispose();
    }//GEN-LAST:event_btnAddRecipeActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
>>>>>>> 48111f9bc2377ab9d7e49c9257c8a6b79128378b
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRecipe;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable recipeTable;
    // End of variables declaration//GEN-END:variables
}
