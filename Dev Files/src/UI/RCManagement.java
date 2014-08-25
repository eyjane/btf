package UI;

import Beans.CategoryBean;
import Beans.IngredientBean;
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
 * @author Catherine
 */
public class RCManagement extends javax.swing.JFrame {

    private RecipeDAOInterface rcImp = new RecipeDAOImplementation();
    private CategoryDAOInterface catImp = new CategoryDAOImplementation();
    private RawDAOInterface rmImp = new RawDAOImplementation();
    private IngredientDAOInterface inImp = new IngredientDAOImplementation();

    private ArrayList<RecipeBean> avRecipes;
    private ArrayList<CategoryBean> aCategory;

    public RCManagement() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        
        prepareTable();
        
        recipeTable.getTableHeader().setResizingAllowed(false);
        recipeTable.setAutoCreateRowSorter(true);
        
    }

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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        addRecipeB = new javax.swing.JButton();
        editRC = new javax.swing.JButton();
        deleteRecipe = new javax.swing.JButton();
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
        jPanel1.add(ReportsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 239, 60));

        jLabel1.setFont(new java.awt.Font("Quicksand Light", 0, 36)); // NOI18N
        jLabel1.setText("Recipes Management");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(620, 402));

        recipeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(recipeTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 470, 370));

        addRecipeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/AddRCBtn.png"))); // NOI18N
        addRecipeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecipeBActionPerformed(evt);
            }
        });
        jPanel1.add(addRecipeB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 120, 30));

        editRC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/EditRCBtn.png"))); // NOI18N
        editRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRCActionPerformed(evt);
            }
        });
        jPanel1.add(editRC, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 120, 30));

        deleteRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/DeleteBtn.png"))); // NOI18N
        deleteRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRecipeActionPerformed(evt);
            }
        });
        jPanel1.add(deleteRecipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, 120, 30));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Background3.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            Logger.getLogger(CGManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CGManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CGManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CGManagement.class.getName()).log(Level.SEVERE, null, ex);
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
        return;
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

    private void editRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRCActionPerformed
        try {
            EditRC editRC = new EditRC();
            editRC.setVisible(true);
            dispose();
        } catch (Exception e) {
            return;
        }
    }//GEN-LAST:event_editRCActionPerformed

    private void deleteRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRecipeActionPerformed
        int rselect = recipeTable.getSelectedRow();
        if (rselect != -1) {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this recipe?", "Confirm Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                deleteRecipe(rselect);
            }
        } else {
            return;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_deleteRecipeActionPerformed

    private void addRecipeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecipeBActionPerformed
        try {
            AddRC addRC = new AddRC();
            addRC.setVisible(true);
            dispose();
        } catch (Exception e) {
            return;
        }
    }//GEN-LAST:event_addRecipeBActionPerformed

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

    /**
     * * <--- JANE CODE STARTS ---> **
     */
    private void deleteRecipe(int r) {
        int rID = Integer.parseInt(recipeTable.getModel().getValueAt(r, 0).toString());
        RecipeBean drecipe = rcImp.getRecipeBean(rID);

        if (rcImp.deleteRecipe(drecipe)) {
            JOptionPane.showMessageDialog(null, "Recipe successfully deleted!");
            TableModel model = recipeTable.getModel();
            DefaultTableModel rmodel = (DefaultTableModel) model;

            rmodel.removeRow(r);
            recipeTable.setModel(rmodel);

            prepareTable();
        }
    }

    public void prepareTable() {
        avRecipes = new ArrayList<RecipeBean>();
        aCategory = new ArrayList<CategoryBean>();

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

            Object[] data = {r.getRecipeID(), r.getRecipe(), String.format("%.2f", r.computeStock()), String.format("%.2f", r.getActualPrice()), String.format("%.2f", r.getCost()), rCategory};
            recipeModel.addRow(data);
        }

        recipeTable.setModel(recipeModel);
        recipeTable.getColumnModel().getColumn(0).setMinWidth(0);
        recipeTable.getColumnModel().getColumn(0).setMaxWidth(0);

        adjustTable(recipeTable);

        String icols[] = {"Raw ID", "Ingredient", "Quantity", "Unit of Measurement"};
        DefaultTableModel model = new DefaultTableModel(icols, 0);

    }

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
    /**
     * * <--- JANE CODE ENDS ---> **
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton CategoriesBtn;
    private javax.swing.JButton EODBtn;
    private javax.swing.JButton InventoryBtn;
    private javax.swing.JButton RMBtn;
    private javax.swing.JButton RecipesBtn;
    private javax.swing.JButton ReportsBtn;
    private javax.swing.JButton addRecipeB;
    private javax.swing.JButton deleteRecipe;
    private javax.swing.JButton editRC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable recipeTable;
    // End of variables declaration//GEN-END:variables
}
