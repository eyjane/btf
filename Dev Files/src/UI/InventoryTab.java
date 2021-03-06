package UI;

import Beans.IngredientBean;
import Beans.RawBean;
import Beans.RecipeBean;
import DAO.Implementation.IngredientDAOImplementation;
import DAO.Implementation.RawDAOImplementation;
import DAO.Implementation.RecipeDAOImplementation;
import DAO.Interface.IngredientDAOInterface;
import DAO.Interface.RawDAOInterface;
import DAO.Interface.RecipeDAOInterface;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author Catherine
 */
public class InventoryTab extends javax.swing.JFrame {

    RecipeDAOInterface rcImp = new RecipeDAOImplementation();
    IngredientDAOInterface inImp = new IngredientDAOImplementation();
    RawDAOInterface rwImp = new RawDAOImplementation();
    
    int count = 0;
    int count_n = 0;

    public InventoryTab() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        prepareTable();

        recipeTable.getTableHeader().setResizingAllowed(false);
        rawTable.getTableHeader().setResizingAllowed(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rawTable = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int r, int c){
                return false;
            }

            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);

                //  Color row based on a cell value
                if (!isRowSelected(row)) {
                    c.setBackground(getBackground());
                    int modelRow = convertRowIndexToModel(row);
                    String status = (String) getModel().getValueAt(modelRow, 0);
                    if ("low".equals(status)) {
                        c.setForeground(Color.RED);
                    }
                    else if ("medium".equals(status)) {
                        c.setForeground(Color.ORANGE);
                    }else{
                        c.setForeground(Color.GREEN);
                    }
                }

                return c;
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        InventoryBtn = new javax.swing.JButton();
        RMBtn = new javax.swing.JButton();
        RecipesBtn = new javax.swing.JButton();
        CategoriesBtn = new javax.swing.JButton();
        EODBtn = new javax.swing.JButton();
        ReportsBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rawSearchField = new javax.swing.JTextField();
        recipeSearchField = new javax.swing.JTextField();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rawTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(rawTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 600, 140));

        jLabel2.setFont(new java.awt.Font("Quicksand Light", 1, 20)); // NOI18N
        jLabel2.setText("RECIPE STOCK");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        recipeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(recipeTable);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 600, 140));

        jLabel3.setFont(new java.awt.Font("Quicksand Light", 1, 20)); // NOI18N
        jLabel3.setText("RAW MATERIAL STOCK");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Quicksand Light", 1, 14)); // NOI18N
        jLabel4.setText("LEGEND:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, -1, -1));

        jLabel1.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("LOW STOCK COUNT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, -1, -1));

        jLabel5.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 51));
        jLabel5.setText("CRITICAL STOCK COUNT");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, -1, -1));

        jLabel6.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 0));
        jLabel6.setText("ADEQUATE STOCK COUNT");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, -1, -1));

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

        jLabel9.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel9.setText("Search:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel10.setText("Search:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, -1, -1));

        rawSearchField.setFont(new java.awt.Font("Quicksand Light", 0, 12)); // NOI18N
        rawSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rawSearchFieldKeyReleased(evt);
            }
        });
        jPanel1.add(rawSearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 25, 90, -1));

        recipeSearchField.setFont(new java.awt.Font("Quicksand Light", 0, 12)); // NOI18N
        recipeSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                recipeSearchFieldKeyReleased(evt);
            }
        });
        jPanel1.add(recipeSearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 235, 90, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Background1.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InventoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventoryBtnActionPerformed
        // TODO add your handling code here:
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

    private void rawSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rawSearchFieldKeyReleased
        String raw = rawSearchField.getText().toLowerCase();
        searchRawTable(raw);
    }//GEN-LAST:event_rawSearchFieldKeyReleased

    private void recipeSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recipeSearchFieldKeyReleased
        String recipe = recipeSearchField.getText().toLowerCase();
        searchRecipeTable(recipe);
    }//GEN-LAST:event_recipeSearchFieldKeyReleased
    /**
     * < -- CLARK'S FUNCTIONS START -- > *
     */
    public void searchRawTable(String r) {
        ArrayList<RawBean> avRaw = new ArrayList<RawBean>();
        avRaw = rwImp.getRawByStatus("available");
        int i;
        // raw material stock
        String cols[] = {"Name", "Stock"};
        DefaultTableModel rawModel = new DefaultTableModel(cols, 0);

        if (avRaw != null) {
            for (i = 0; i < avRaw.size(); i++) {
                RawBean rm = avRaw.get(i);

                if (rm.getRaw().toLowerCase().contains(r)) {
                    String color = "black";

                    if (rm.isCritical()) {
                        color = "red";
                    } else if (rm.isMedium()) {
                        color = "orange";
                    } else {
                        color = "green";
                    }

                    String shtml = "<html><p style=color:" + color + ">";
                    String ehtml = "</p></html>";
                    Object[] raw = {shtml + rm.getRaw() + ehtml, shtml + String.format("%.2f", rm.getStock()) + ehtml};
                    rawModel.addRow(raw);
                }
            }
        }

        rawTable.setModel(rawModel);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        rawTable.getColumn("Stock").setCellRenderer(rightRenderer);
    }

    public void searchRecipeTable(String r) {
        ArrayList<RecipeBean> avRecipes = new ArrayList<RecipeBean>();
        avRecipes = rcImp.getRecipeByStatus("available");
        int i, j;
        // raw material stock
        String cols[] = {"Name", "Stock"};
        DefaultTableModel recipeModel = new DefaultTableModel(cols, 0);

        if (avRecipes != null) {
            for (i = 0; i < avRecipes.size(); i++) {
                RecipeBean rc = avRecipes.get(i);
                if (rc.getRecipe().toLowerCase().contains(r)) {
                    ArrayList<IngredientBean> ingredients = new ArrayList<IngredientBean>();
                    ingredients = rc.getIngredients();

                    Object[] rec = {"<html><p style = 'color:red'><b>" + rc.getRecipe() + "</b></p></html>", "<html><p style = 'color:red'><b>" + String.format("%.2f", rc.computeStock()) + "</b></p></html>"};
                    recipeModel.addRow(rec);

                    for (j = 0; j < ingredients.size(); j++) {
                        RawBean raw = ingredients.get(j).getRaw();
                        Object[] rawm = {"     " + ingredients.get(j).getAmount() + " " + raw.getUom() + " of " + raw.getRaw(), String.format("%.2f", raw.getStock())};
                        recipeModel.addRow(rawm);
                    }
                }
            }
        }

        recipeTable.setModel(recipeModel);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        recipeTable.getColumn("Stock").setCellRenderer(rightRenderer);
        recipeTable.setRowSelectionAllowed(true);
    }

    /**
     * < -- CLARK'S FUNCTIONS END -- > *
     */
    /**
     * < -- JANERYS FUNCTIONS START -- > *
     */
    /* Prepare Table */
    private void prepareTable() {
        ArrayList<RawBean> avRaw = new ArrayList<RawBean>();
        int i, j;
         ArrayList<RecipeBean> avRecipes = rcImp.getRecipeByStatus("available");
        
         String col[] = {"Name", "Stock"};
        DefaultTableModel recipeModel = new DefaultTableModel(col, 0);
        recipeTable.setModel(recipeModel);
        
        prepareRecipeTable(avRecipes);
        
        // recipe Stocks
        String cols[] = {"Status", "Name", "Stock"};

        // raw material stock
        DefaultTableModel rawModel = new DefaultTableModel(cols, 0) {
            @Override
            public Class getColumnClass(int col) {
                if (col == 2) {
                    return Float.class;
                } else {
                    return String.class;
                }
            }
        };
        
        avRaw = rwImp.getRawByStatus("available");

        if (avRaw != null) {
            for (i = 0; i < avRaw.size(); i++) {
                RawBean rm = avRaw.get(i);
                String color = "black";

                if (rm.isCritical()) {
                    color = "low";
                } else if (rm.isMedium()) {
                    color = "medium";
                } else {
                    color = "high";
                }

                String shtml = "<html><p style=color:" + color + ">";
                String ehtml = "</p></html>";
                Object[] raw = {color, rm.getRaw(), Float.parseFloat(String.format("%.2f", rm.getStock()))};
                rawModel.addRow(raw);
                //rawTable.setModel(rawModel);
                //rawTable.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer(color));
            }
        }

        rawTable.setModel(rawModel);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        rawTable.getColumn("Stock").setCellRenderer(rightRenderer);
        
        //System.out.println(recipeTable.getRowSelectionAllowed());

        rawTable.setAutoCreateRowSorter(true);
        rawTable.getColumnModel().getColumn(0).setMinWidth(0);
        rawTable.getColumnModel().getColumn(0).setMaxWidth(0);

        //add jtable header listener
        recipeTable.getTableHeader().addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = recipeTable.columnAtPoint(e.getPoint());
               
                ArrayList<RecipeBean> aRecipes = rcImp.getRecipeByStatus("available");
                String name = recipeTable.getColumnName(col);
                //System.out.println("Column index selected " + col + " " + name);
                //System.out.println();
                
                if(name.equals("Stock")){
                    if(count % 2 == 0){
                        sortRecipeByStockDsc(aRecipes);
                       prepareRecipeTable(aRecipes);
                       
                        count++;
                        //System.out.println("INCREMENTING COUNT... NEW COUNT = " + count);
                    }else{
                        sortRecipeByStockAsc(aRecipes);
                       prepareRecipeTable(aRecipes);
                        count++;
                        //System.out.println("INCREMENTING COUNT... NEW COUNT = " + count);
                    }   
                }else{
                    if(count_n % 2 == 0){
                        sortRecipeByNameDsc(aRecipes);
                       prepareRecipeTable(aRecipes);
                        count_n++;
                    }else{
                        sortRecipeByNameAsc(aRecipes);
                        prepareRecipeTable(aRecipes);
                        count_n++;
                    }  
                }
            }
        });
        

    }
    
    public void prepareRecipeTable(ArrayList<RecipeBean> avRecipes){
        int i, j;
        
        DefaultTableModel recipeModel = (DefaultTableModel) recipeTable.getModel();
        recipeModel.setRowCount(0);
        
        if (avRecipes != null) {
            for (i = 0; i < avRecipes.size(); i++) {
                RecipeBean rc = avRecipes.get(i);
                ArrayList<IngredientBean> ingredients = new ArrayList<IngredientBean>();
                ingredients = rc.getIngredients();

                Object[] rec = {"<html><p style = 'color:red'><b>" + rc.getRecipe() + "</b></p></html>", "<html><p style = 'color:red'><b>" + String.format("%.2f", rc.computeStock()) + "</b></p></html>"};
                recipeModel.addRow(rec);

                for (j = 0; j < ingredients.size(); j++) {
                    RawBean raw = ingredients.get(j).getRaw();
                    Object[] rawm = {"     " + ingredients.get(j).getAmount() + " " + raw.getUom() + " of " + raw.getRaw(), String.format("%.2f", raw.getStock())};
                    recipeModel.addRow(rawm);
                }
            }
        }

        recipeTable.setModel(recipeModel);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        recipeTable.getColumn("Stock").setCellRenderer(rightRenderer);
        recipeTable.setRowSelectionAllowed(true);
    }

    //sort recipe
    public ArrayList<RecipeBean> sortRecipeByStockAsc(ArrayList<RecipeBean> r) {
        Collections.sort(r, new ACustomComparator());

        return r;
    }
    
    public ArrayList<RecipeBean> sortRecipeByStockDsc(ArrayList<RecipeBean> r) {
        Collections.sort(r, new BCustomComparator());

        return r;
    }
    
    public ArrayList<RecipeBean> sortRecipeByNameDsc(ArrayList<RecipeBean> r) {
        Collections.sort(r, new CCustomComparator());

        return r;
    }
    public ArrayList<RecipeBean> sortRecipeByNameAsc(ArrayList<RecipeBean> r) {
        Collections.sort(r, new DCustomComparator());

        return r;
    }

    public class ACustomComparator implements Comparator<RecipeBean> {

        @Override
        public int compare(RecipeBean rc1, RecipeBean rc2) {
            return (int) (rc1.computeStock() - rc2.computeStock());
        }
    }
    
    public class BCustomComparator implements Comparator<RecipeBean> {

        @Override
        public int compare(RecipeBean rc1, RecipeBean rc2) {
            return (int) (rc2.computeStock() - rc1.computeStock());
        }
    }
    
    public class CCustomComparator implements Comparator<RecipeBean> {

        @Override
        public int compare(RecipeBean rc1, RecipeBean rc2) {
            return rc1.getRecipe().compareToIgnoreCase(rc2.getRecipe());
        }
    }
    
    public class DCustomComparator implements Comparator<RecipeBean> {

        @Override
        public int compare(RecipeBean rc1, RecipeBean rc2) {
            return rc2.getRecipe().compareToIgnoreCase(rc1.getRecipe());
        }
    }
    

    /**
     * < -- JANERYS FUNCTIONS END -- > *
     */
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
            java.util.logging.Logger.getLogger(InventoryTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InventoryTab().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InventoryTab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(InventoryTab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(InventoryTab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(InventoryTab.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton CategoriesBtn;
    private javax.swing.JButton EODBtn;
    private javax.swing.JButton InventoryBtn;
    private javax.swing.JButton RMBtn;
    private javax.swing.JButton RecipesBtn;
    private javax.swing.JButton ReportsBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField rawSearchField;
    private javax.swing.JTable rawTable;
    private javax.swing.JTextField recipeSearchField;
    private javax.swing.JTable recipeTable;
    // End of variables declaration//GEN-END:variables
}
