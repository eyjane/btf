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
 * @author Catherine
 */
public class AddRCtoCG extends javax.swing.JFrame {
    private RecipeDAOInterface rcImp;
    private EditCG ec;
    //private AddCG ac;
    private ArrayList<RecipeBean> ar;
    private ArrayList<RecipeBean> a;
    
    //<--- CLARK'S CODE STARTS HERE --->
    public AddRCtoCG(EditCG c, ArrayList<RecipeBean> rb) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        rcImp = new RecipeDAOImplementation();
        ec = c;
        ar = rb;
        a = rcImp.getRecipeByStatus("available");
        categoryLabel.setText(ec.getCategory().getCategory());
        ViewAllRecipes();
        ViewCatRecipes();
    }
    
    /*public RCpopup(AddCG c, ArrayList<RecipeBean> rb) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
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
    } */
    
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
                a.get(i).getCost(), a.get(i).getRcstatus()});
           }
       }
       recipeTable1.setModel(defaultModel);
       recipeTable1.getColumnModel().getColumn(0).setMinWidth(0);
       recipeTable1.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
    public void ViewCatRecipes(){
        DefaultTableModel defaultModel = initializeRecipeTable();
        for (int i = 0; i < ar.size(); i++) {
            defaultModel.addRow(new Object[] {ar.get(i).getRecipeID(), ar.get(i).getRecipe(),               
            ar.get(i).getCost(), ar.get(i).getRcstatus()});
       }
       recipeTable2.setModel(defaultModel);
       recipeTable2.getColumnModel().getColumn(0).setMinWidth(0);
       recipeTable2.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
    public void addRecipe(int r){
        int rID = Integer.parseInt(recipeTable1.getModel().getValueAt(r, 0).toString());
        RecipeBean rb = rcImp.getRecipeBean(rID);
        ar.add(rb);
        Object[] recipe = {rb.getRecipeID(), rb.getRecipe(), rb.getCost(), rb.getRcstatus()};
        
        TableModel model = recipeTable1.getModel();
        TableModel rmodel = recipeTable2.getModel();
        DefaultTableModel table = (DefaultTableModel) model;
        DefaultTableModel rtable = (DefaultTableModel) rmodel; 
        table.removeRow(r);
        rtable.addRow(recipe);
        recipeTable1.setModel(table);
        recipeTable2.setModel(rtable);
    }
    
    private void deleteRecipe(int r) {
        int rID = Integer.parseInt(recipeTable2.getModel().getValueAt(r, 0).toString());
        RecipeBean rb = rcImp.getRecipeBean(rID);
        ar.remove(rb);
        Object[] recipe = {rb.getRecipeID(), rb.getRecipe(), rb.getCost(), rb.getRcstatus()};

        TableModel model = recipeTable1.getModel();
        TableModel rmodel = recipeTable2.getModel();
        DefaultTableModel table = (DefaultTableModel) model;
        DefaultTableModel rtable = (DefaultTableModel) rmodel;

        table.addRow(recipe);
        recipeTable1.setModel(table);
        rtable.removeRow(r);
        recipeTable2.setModel(rtable);
    }
    
    //<--- CLARK'S CODE ENDS HERE --->

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        categoryLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeTable1 = new javax.swing.JTable();
        AddBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        recipeTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jLabel7 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        RemoveBtn = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        categoryLabel.setFont(new java.awt.Font("Quicksand Light", 0, 36)); // NOI18N
        categoryLabel.setForeground(new java.awt.Color(51, 51, 51));
        categoryLabel.setText("<CATEGORY NAME>");
        jPanel1.add(categoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/recp_tab.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 240, 60));

        jLabel3.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jLabel3.setText("All Recipes");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        recipeTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        recipeTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(recipeTable1);
        recipeTable1.getColumnModel().getColumn(0).setResizable(false);
        recipeTable1.getColumnModel().getColumn(1).setResizable(false);
        recipeTable1.getColumnModel().getColumn(2).setResizable(false);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 590, 140));

        AddBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/addBtn.png"))); // NOI18N
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });
        jPanel1.add(AddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 120, 30));

        recipeTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        recipeTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(recipeTable2);
        recipeTable2.getColumnModel().getColumn(0).setResizable(false);
        recipeTable2.getColumnModel().getColumn(1).setResizable(false);
        recipeTable2.getColumnModel().getColumn(2).setResizable(false);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 590, 150));

        jLabel7.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jLabel7.setText("Recipes in this category");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        BackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/BackBtn.png"))); // NOI18N
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });
        jPanel1.add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 530, 120, 30));

        RemoveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/RemoveBtn.png"))); // NOI18N
        RemoveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveBtnActionPerformed(evt);
            }
        });
        jPanel1.add(RemoveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 460, 120, 30));

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

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        int select = recipeTable1.getSelectedRow();
        if (select < 0) {
            return;
        } else {
            addRecipe(select);
        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        ec.setVisible(true);
        ec.ViewAllRecipes(ar);
        dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    private void RemoveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveBtnActionPerformed
        int select = recipeTable2.getSelectedRow();
        if (select < 0) {
            return;
        } else {
            deleteRecipe(select);
        }
    }//GEN-LAST:event_RemoveBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton BackBtn;
    private javax.swing.JLabel Background;
    private javax.swing.JButton RemoveBtn;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable recipeTable1;
    private javax.swing.JTable recipeTable2;
    // End of variables declaration//GEN-END:variables
}
