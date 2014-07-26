package UI;

import Beans.RecipeBean;
import DAO.Implementation.RecipeDAOImplementation;
import DAO.Interface.RecipeDAOInterface;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author clarkabalos
 */
public class RCpopup extends javax.swing.JFrame {
    private RecipeDAOInterface rcImp;
    private EditCategory ec;
    private AddCategory ac;
    private ArrayList<RecipeBean> ar;
    private ArrayList<RecipeBean> a;
   
    //<--- CLARK'S CODE STARTS HERE --->
    public RCpopup(EditCategory c, ArrayList<RecipeBean> rb) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        ec = c;
        rcImp = new RecipeDAOImplementation();
        ar = rb;
        a = rcImp.getRecipeByStatus("available");
        jLabel3.setText("Recipes of category " + ec.getCategory().getCategory() + " :");
        ViewAllRecipes();
        ViewCatRecipes();
    }
    
    public RCpopup(AddCategory c, ArrayList<RecipeBean> rb) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        ac = c;
        ar = rb;
        rcImp = new RecipeDAOImplementation();
        a = rcImp.getRecipeByStatus("available");
        jLabel3.setText("Recipes of category " + c.getCategory() + ":");
        ViewAllRecipes();
        ViewCatRecipes();
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
       for (int i = 0; i < a.size(); i++) {
           boolean flag = true;
           for (int j = 0; j < ar.size(); j++) {
               if(a.get(i).getRecipe().equals(ar.get(j).getRecipe())){
                    flag = false;
               }
           }
           if(flag == true){
                defaultModel.addRow(new Object[] {a.get(i).getRecipeID(), a.get(i).getRecipe(),               
                a.get(i).getCost(), a.get(i).getStock(), a.get(i).getRcstatus()});
           }
       }
       recipeTable.setModel(defaultModel);
    }
    
    public void ViewCatRecipes(){
        DefaultTableModel defaultModel = initializeRecipeTable();
        for (int i = 0; i < ar.size(); i++) {
            defaultModel.addRow(new Object[] {ar.get(i).getRecipeID(), ar.get(i).getRecipe(),               
            ar.get(i).getCost(), ar.get(i).getStock(), ar.get(i).getRcstatus()});
       }
       recipeTable2.setModel(defaultModel);
    }
    
    public void addRecipe(int r){
        int rID = Integer.parseInt(recipeTable.getModel().getValueAt(r, 0).toString());
        RecipeBean rb = rcImp.getRecipeBean(rID);
        ar.add(rb);
        Object[] recipe = {rb.getRecipeID(), rb.getRecipe(), rb.getCost(), rb.getStock(), rb.getRcstatus()};
        
        TableModel model = recipeTable.getModel();
        TableModel rmodel = recipeTable2.getModel();
        DefaultTableModel table = (DefaultTableModel) model;
        DefaultTableModel rtable = (DefaultTableModel) rmodel; 
        table.removeRow(r);
        rtable.addRow(recipe);
        recipeTable.setModel(table);
        recipeTable2.setModel(rtable);
    }
    
    private void deleteRecipe(int r) {
        int rID = Integer.parseInt(recipeTable2.getModel().getValueAt(r, 0).toString());
        RecipeBean rb = rcImp.getRecipeBean(rID);
        ar.remove(rb);
        Object[] recipe = {rb.getRecipeID(), rb.getRecipe(), rb.getCost(), rb.getStock(), rb.getRcstatus()};

        TableModel model = recipeTable.getModel();
        TableModel rmodel = recipeTable2.getModel();
        DefaultTableModel table = (DefaultTableModel) model;
        DefaultTableModel rtable = (DefaultTableModel) rmodel;

        table.addRow(recipe);
        recipeTable.setModel(table);
        rtable.removeRow(r);
        recipeTable2.setModel(rtable);
    }
    
    //<--- CLARK'S CODE ENDS HERE --->
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeTable2 = new javax.swing.JTable();
        btnAddRecipe = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable();
        btnDeleteRecipe = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Edit Recipes");

        recipeTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        recipeTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(recipeTable2);
        recipeTable2.getColumnModel().getColumn(0).setResizable(false);
        recipeTable2.getColumnModel().getColumn(1).setResizable(false);
        recipeTable2.getColumnModel().getColumn(2).setResizable(false);
        recipeTable2.getColumnModel().getColumn(3).setResizable(false);
        recipeTable2.getColumnModel().getColumn(4).setResizable(false);

        btnAddRecipe.setText("Add");
        btnAddRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecipeActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel2.setText("All Available Recipes:");

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
        recipeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(recipeTable);
        recipeTable.getColumnModel().getColumn(0).setResizable(false);
        recipeTable.getColumnModel().getColumn(1).setResizable(false);
        recipeTable.getColumnModel().getColumn(2).setResizable(false);
        recipeTable.getColumnModel().getColumn(3).setResizable(false);
        recipeTable.getColumnModel().getColumn(4).setResizable(false);

        btnDeleteRecipe.setText("Delete");
        btnDeleteRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRecipeActionPerformed(evt);
            }
        });

        jLabel3.setText("Recipes:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAddRecipe)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 225, Short.MAX_VALUE)
                                .addComponent(btnDeleteRecipe)))
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddRecipe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnBack)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteRecipe)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRecipeActionPerformed
        int select = recipeTable.getSelectedRow();
        if (select < 0) {
            return;
        } else {
            addRecipe(select);
        }
    }//GEN-LAST:event_btnAddRecipeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (ac != null) {
            ac.setVisible(true);
        } else {
            ec.setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       int nrow = recipeTable2.getRowCount(); 
        try{
            int rid;
            ar.clear();
            for (int i = 0; i < nrow; i++) {
                RecipeBean rbean = new RecipeBean();
                rid = Integer.parseInt(recipeTable2.getModel().getValueAt(i, 0).toString());
                rbean = rcImp.getRecipeBean(rid);
                ar.add(rbean);
            }
            
            if (ac != null) {
                ac.setVisible(true);
                ac.ViewAllRecipes(ar);
            } else {
                ec.setVisible(true);
                ec.ViewAllRecipes(ar);
            }
            dispose();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRecipeActionPerformed
        int select = recipeTable2.getSelectedRow();
        if (select < 0) {
            return;
        } else {
            deleteRecipe(select);
        }
    }//GEN-LAST:event_btnDeleteRecipeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRecipe;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteRecipe;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable recipeTable;
    private javax.swing.JTable recipeTable2;
    // End of variables declaration//GEN-END:variables
}
