package UI;

import Beans.CategoryBean;
import Beans.IngredientBean;
import Beans.RawBean;
import Beans.RecipeBean;
import DAO.Implementation.CategoryDAOImplementation;
import DAO.Implementation.IngredientDAOImplementation;
import DAO.Implementation.RawDAOImplementation;
import DAO.Implementation.RecipeDAOImplementation;
import DAO.Interface.CategoryDAOInterface;
import DAO.Interface.IngredientDAOInterface;
import DAO.Interface.RawDAOInterface;
import DAO.Interface.RecipeDAOInterface;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Evy
 */
public class RCManagement extends javax.swing.JFrame {

    private RecipeDAOInterface rcImp = new RecipeDAOImplementation();
    private CategoryDAOInterface catImp = new CategoryDAOImplementation();
    private RawDAOInterface rmImp = new RawDAOImplementation();
    private IngredientDAOInterface inImp = new IngredientDAOImplementation();

    private ArrayList<RecipeBean> avRecipes;
    private ArrayList<IngredientBean> avIngredients;
    private ArrayList<CategoryBean> aCategory;

    private addIngredient AddIngredient;
    private AddRecipe addRecipe;
    
    private EODTab main;

    /**
     * Creates new form RCManagement
     */
    public RCManagement(EODTab t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        
        main = t;

        errorLabel.setVisible(false);
        errorLabel2.setVisible(false);
        errorLabel3.setVisible(false);
        prepareTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        addRecipeB = new javax.swing.JButton();
        deleteRecipe = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        costField = new javax.swing.JTextField();
        categoryBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        ingredientsTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        editIngredient = new javax.swing.JButton();
        saveRecipe = new javax.swing.JButton();
        actualLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        errorLabel2 = new javax.swing.JLabel();
        errorLabel3 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        addRecipeB.setLabel("Add");
        addRecipeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecipeBActionPerformed(evt);
            }
        });

        deleteRecipe.setLabel("Delete");
        deleteRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRecipeActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recipe Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 153)));

        jLabel2.setText("Name:");

        jLabel3.setText("Actual Price:");

        jLabel4.setText("Cost:");

        jLabel5.setText("Category:");

        jLabel6.setText("Ingredients:");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        ingredientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "null"
            }
        ));
        ingredientsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingredientsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ingredientsTable);

        editIngredient.setText("Edit Ingredient");
        editIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editIngredientActionPerformed(evt);
            }
        });

        saveRecipe.setText("SAVE");
        saveRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRecipeActionPerformed(evt);
            }
        });

        actualLabel.setText("   ");

        nameLabel.setText("  ");

        errorLabel.setForeground(new java.awt.Color(255, 0, 102));
        errorLabel.setText("ERROR: Required field.");

        errorLabel2.setForeground(new java.awt.Color(255, 0, 102));
        errorLabel2.setText("ERROR: Required field. Please input valid number.");

        errorLabel3.setForeground(new java.awt.Color(255, 0, 102));
        errorLabel3.setText("ERROR: Recipe must have at least one ingredient.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(520, 520, 520))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(editIngredient)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categoryBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(errorLabel))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(actualLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(costField, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(errorLabel2)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(412, 412, 412)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveRecipe)
                .addGap(504, 504, 504))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(nameLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(actualLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editIngredient)
                    .addComponent(errorLabel3))
                .addGap(17, 17, 17)
                .addComponent(saveRecipe))
        );

        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel9.setText("RECIPES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(deleteRecipe))
                    .addComponent(addRecipeB)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(deleteRecipe))
                    .addComponent(addRecipeB)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(backBtn))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        main.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void saveRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRecipeActionPerformed
        boolean edit = true;

        if(recipeTable.getSelectedRow() < 0){
            return;
        }

        //get all ingredients
        int nrow = ingredientsTable.getRowCount();

        int i;
        int rid;

        ArrayList<IngredientBean> aIngredient = new ArrayList<IngredientBean>();
        if (nrow != 0) {
            for (i = 0; i < nrow; i++) {
                IngredientBean ibean = new IngredientBean();
                RawBean rbean = new RawBean();
                rid = Integer.parseInt(ingredientsTable.getModel().getValueAt(i, 0).toString());
                rbean = rmImp.getRaw(rid);
                ibean.setRaw(rbean);
                ibean.setAmount(Float.parseFloat(ingredientsTable.getModel().getValueAt(i, 2).toString()));
                aIngredient.add(ibean);
            }
        }

        if (!nameField.getText().toString().isEmpty()) {
            errorLabel.setVisible(false);
        } else {
            errorLabel.setVisible(true);
            edit = false;
        }

        if (!costField.getText().toString().isEmpty() && isNumber(costField.getText().toString()) && Float.parseFloat(costField.getText().toString()) > 0) {
            errorLabel2.setVisible(false);
        } else {
            errorLabel2.setVisible(true);
            edit = false;
        }

        if (!(aIngredient.isEmpty())) {
            errorLabel3.setVisible(false);

        } else {
            errorLabel3.setVisible(true);
            edit = false;
        }

        if(edit){
            RecipeBean r = new RecipeBean();

            int rID = Integer.parseInt(recipeTable.getModel().getValueAt(recipeTable.getSelectedRow(), 0).toString());
            RecipeBean rtemp = rcImp.getRecipeBean(rID);
            System.out.println("rtemp stock: " + rtemp.getStock());
            r.setRecipeID(rID);
            r.setRecipe(nameField.getText().toString());
            r.setCost(Float.parseFloat(costField.getText().toString()));
            CategoryBean category = (CategoryBean) categoryBox.getSelectedItem();
            r.setCategory(category.getCategoryID());
            r.setRcstatus("available");
            r.setStock(rtemp.getStock());

            if(rcImp.editRecipe(r)){
                for(IngredientBean ibean: aIngredient){
                    inImp.editIngredient(r, ibean);
                }

                prepareTable();
            }
        }
    }//GEN-LAST:event_saveRecipeActionPerformed

    private void editIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editIngredientActionPerformed
        int nrow = ingredientsTable.getRowCount();
        //System.out.println(nrow);
        
        if(recipeTable.getSelectedRow() == -1){
            return;
        }
        int i;
        int rid;

        ArrayList<IngredientBean> aIngredient = new ArrayList<IngredientBean>();

        for (i = 0; i < nrow; i++) {
            IngredientBean ibean = new IngredientBean();
            RawBean rbean = new RawBean();
            rid = Integer.parseInt(ingredientsTable.getModel().getValueAt(i, 0).toString());
            rbean = rmImp.getRaw(rid);
            ibean.setRaw(rbean);
            ibean.setAmount(Float.parseFloat(ingredientsTable.getModel().getValueAt(i, 2).toString()));
            aIngredient.add(ibean);
        }

        try {
            AddIngredient = new addIngredient(this, aIngredient);
            AddIngredient.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_editIngredientActionPerformed

    private void ingredientsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingredientsTableMouseClicked

    }//GEN-LAST:event_ingredientsTableMouseClicked

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void deleteRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRecipeActionPerformed

        int rselect = recipeTable.getSelectedRow();
        if (rselect < 0) {
            return;
        } else {
            deleteRecipe(rselect);
        }
    }//GEN-LAST:event_deleteRecipeActionPerformed

    private void addRecipeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecipeBActionPerformed
        try {
            addRecipe = new AddRecipe(this);
            this.setVisible(false);
            addRecipe.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_addRecipeBActionPerformed

    private void recipeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recipeTableMouseClicked
        ArrayList<CategoryBean> aCategory = catImp.getAllCategory();
        try {
            int rselect = recipeTable.getSelectedRow();
            int rID = Integer.parseInt(recipeTable.getModel().getValueAt(rselect, 0).toString());
            RecipeBean r = rcImp.getRecipeBean(rID);
            //recipeIDLabel.setText(String.valueOf(r.getRecipeID()));
            nameField.setText(r.getRecipe());
            costField.setText(String.format("%.2f", r.getCost()));
            actualLabel.setText(String.format("%.2f", r.getActualPrice()));

            for (CategoryBean c : aCategory) {
                categoryBox.addItem(c);
                if (c.getCategoryID() == r.getCategory()) {
                    categoryBox.setSelectedIndex(categoryBox.getItemCount() - 1);
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

            ingredientsTable.setModel(model);
            ingredientsTable.getColumnModel().getColumn(0).setMinWidth(0);
            ingredientsTable.getColumnModel().getColumn(0).setMaxWidth(0);

            adjustTable(ingredientsTable);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_recipeTableMouseClicked

    /**
     * <--- JANERYS CODE START ---> *
     */
    
    private void deleteRecipe(int r) {
        int rID = Integer.parseInt(recipeTable.getModel().getValueAt(r, 0).toString());
        RecipeBean drecipe = rcImp.getRecipeBean(rID);
        
        if(rcImp.deleteRecipe(drecipe)){
            TableModel model = recipeTable.getModel();
            DefaultTableModel rmodel = (DefaultTableModel) model;
            
            rmodel.removeRow(r);
            recipeTable.setModel(rmodel);
            nameField.setText("");
            costField.setText("");
            categoryBox.setSelectedIndex(0);
            actualLabel.setText("0.00");
            DefaultTableModel iModel = (DefaultTableModel) ingredientsTable.getModel();
            iModel.setRowCount(0);
            prepareTable();
        }
        
        
        
        
    }
    public void computeActual(ArrayList<IngredientBean> aIngredient) {
        RecipeBean rtemp = new RecipeBean();
        rtemp.setIngredients(aIngredient);
        actualLabel.setText(String.format("%.2f", rtemp.getActualPrice()));

    }

    public void reloadIngredients(ArrayList<IngredientBean> aIngredient) {
        String cols[] = {"Raw ID", "Raw Material", "Quantity"};
        DefaultTableModel ingredientModel = new DefaultTableModel(cols, 0);
        ingredientsTable.setModel(ingredientModel);
        ingredientsTable.getColumnModel().getColumn(0).setMinWidth(0);
        ingredientsTable.getColumnModel().getColumn(0).setMaxWidth(0);

        if (aIngredient != null) {
            for (IngredientBean ibean : aIngredient) {
                Object[] ingredient = {ibean.getRaw().getRawID(), ibean.getRaw().getRaw(), ibean.getAmount()};
                ingredientModel.addRow(ingredient);
            }
            ingredientsTable.setModel(ingredientModel);

        } else {
            //System.out.println("aIngredient is null");
        }
    }

    /* PREPARE TABLE */
    public void prepareTable() {
        avRecipes = new ArrayList<RecipeBean>();
        aCategory = new ArrayList<CategoryBean>();
        avIngredients = new ArrayList<IngredientBean>();

        String rCategory = null;
        int i, j;

        aCategory = catImp.getAllCategory();
        avRecipes = rcImp.getRecipeByStatus("available");

        String cols[] = {"Recipe ID", "Recipe", "Stock", "Actual Price", "Cost", "Category"};
        DefaultTableModel recipeModel = new DefaultTableModel(cols, 0);
        //System.out.println(avRecipes.get(1).getRecipe());

        for (RecipeBean r : avRecipes) {

            for (CategoryBean c : aCategory) {
                if (r.getCategory() == c.getCategoryID()) {
                    rCategory = c.getCategory();
                    break;
                }
            }

            Object[] data = {r.getRecipeID(), r.getRecipe(), String.format("%.2f", r.getStock()), String.format("%.2f", r.getActualPrice()), String.format("%.2f", r.getCost()), rCategory};
            recipeModel.addRow(data);
        }

        recipeTable.setModel(recipeModel);
        recipeTable.getColumnModel().getColumn(0).setMinWidth(0);
        recipeTable.getColumnModel().getColumn(0).setMaxWidth(0);

        adjustTable(recipeTable);
        
      String icols[] = {"Raw ID", "Ingredient", "Quantity", "Unit of Measurement"};
      DefaultTableModel model = new DefaultTableModel(icols, 0);

    }

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
    
    private boolean isNumber(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /*** <--- JANERYS CODE ENDS ---> ***/


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actualLabel;
    private javax.swing.JButton addRecipeB;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox categoryBox;
    private javax.swing.JTextField costField;
    private javax.swing.JButton deleteRecipe;
    private javax.swing.JButton editIngredient;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JLabel errorLabel3;
    private javax.swing.JTable ingredientsTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable recipeTable;
    private javax.swing.JButton saveRecipe;
    // End of variables declaration//GEN-END:variables
}
