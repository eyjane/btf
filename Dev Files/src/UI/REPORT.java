package UI;

import Beans.IngredientBean;
import Beans.RecipeBean;
import Beans.SalesBean;
import DAO.Implementation.SalesDAOImplementation;
import DAO.Implementation.RecipeDAOImplementation;
import DAO.Interface.IngredientDAOInterface;
import DAO.Interface.RecipeDAOInterface;
import DAO.Interface.SalesDAOInterface;
import java.awt.BorderLayout;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Evy
 */
public class REPORT extends javax.swing.JFrame {

    ArrayList<RecipeBean> aSales = new ArrayList<RecipeBean>();
    SalesDAOInterface sImp = new SalesDAOImplementation();
    RecipeDAOInterface rcImp = new RecipeDAOImplementation();
    EODTab main;
    
    /**
     * Creates new form REPORT
     */
    public REPORT(EODTab t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        main = t;
        GITable();
        makeGIChart();
        expTable();
        makeExpChart();
        netTable();
        makeNetChart();
        
    }

    private REPORT() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void GITable() {
       RecipeBean r = new RecipeBean(); 
       /*DateFormat t = new SimpleDateFormat("yyyy-MM-dd");
       Date todayDate = new Date();
       String today = t.format(todayDate);*/
       
       String today = "2014-07-01";
       
       aSales = sImp.getAllSales(today);
       String cols[] = {"Name", "Gross Income"};
       DefaultTableModel actualTable = new DefaultTableModel(cols,0);

       for(RecipeBean sale : aSales) {
           
           r = rcImp.getRecipeBean(sale.getRecipeID());
           Object[] data = {sale.getRecipe(), sImp.getSalesByRecipeByDay(r, today)};
           actualTable.addRow(data);
           grossIncomeTable.setModel(actualTable);
           adjustTable(grossIncomeTable);
       }
      
    }
    
    public void expTable() {
        
       RecipeBean r = new RecipeBean(); 
        /*DateFormat t = new SimpleDateFormat("yyyy-MM-dd");
       Date todayDate = new Date();
       String today = t.format(todayDate);*/
       
       String today = "2014-07-01";
       
       aSales = sImp.getAllSales(today);
       String cols[] = {"Name", "Expenses"};
       DefaultTableModel actualTable = new DefaultTableModel(cols,0);
        
       for(RecipeBean sale : aSales) {
           
           r = rcImp.getRecipeBean(sale.getRecipeID());
           Object[] data = {sale.getRecipe(), sImp.getExpensesByRecipeByDay(r, today)};
           actualTable.addRow(data);
           expensesTable.setModel(actualTable);
           adjustTable(expensesTable);
       }
        
    }
    
    public void netTable() {
       
       RecipeBean r = new RecipeBean(); 
        /*DateFormat t = new SimpleDateFormat("yyyy-MM-dd");
       Date todayDate = new Date();
       String today = t.format(todayDate);*/
       
       String today = "2014-07-01";
       
       aSales = sImp.getAllSales(today);
       String cols[] = {"Name", "Net Income"};
       DefaultTableModel actualTable = new DefaultTableModel(cols,0);
        
       for(RecipeBean sale : aSales) {
           
           r = rcImp.getRecipeBean(sale.getRecipeID());
           Object[] data = {sale.getRecipe(), sImp.getSalesByRecipeByDay(r, today) - sImp.getExpensesByRecipeByDay(r, today)};
           actualTable.addRow(data);
           netIncomeTable.setModel(actualTable);
           adjustTable(netIncomeTable);
       }
        
        
    }
    
    private void adjustTable(JTable table){
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
    
    public void makeGIChart() {
        
        DefaultPieDataset objDataset = new DefaultPieDataset();
        int rows = grossIncomeTable.getRowCount();
        
        for (int c = 0; c < rows; c++) {
            
            objDataset.setValue(grossIncomeTable.getValueAt(c, 0).toString(), Float.parseFloat(grossIncomeTable.getValueAt(c, 1).toString())); // retrieve table contents and add to data set
            
        }
        
        JFreeChart grossChart = ChartFactory.createPieChart("Gross Income", objDataset, true, true, false); // makes chart
        grossPanel.setLayout(new java.awt.BorderLayout());
        ChartPanel chartPanel = new ChartPanel(grossChart);
        grossPanel.add(chartPanel, BorderLayout.CENTER);
        grossPanel.validate();
       
        /*JFrame frame = new JFrame();
        frame.add(jPanelChart);
        frame.pack();
        frame.setVisible(true);*/
        
    }
    
    public void makeExpChart() {
        
        DefaultPieDataset objDataset = new DefaultPieDataset();
        int rows = expensesTable.getRowCount();
        
        for (int c = 0; c < rows; c++) {
            
            objDataset.setValue(expensesTable.getValueAt(c, 0).toString(), Float.parseFloat(expensesTable.getValueAt(c, 1).toString())); // retrieve table contents and add to data set
            
        }
        
        JFreeChart expChart = ChartFactory.createPieChart("Expenses", objDataset, true, true, false); // makes chart
        expensesPanel.setLayout(new java.awt.BorderLayout());
        ChartPanel chartPanel = new ChartPanel(expChart);
        expensesPanel.add(chartPanel, BorderLayout.CENTER);
        expensesPanel.validate();
      
        
    }
    
    public void makeNetChart() {
        
        DefaultPieDataset objDataset = new DefaultPieDataset();
        int rows = netIncomeTable.getRowCount();
        
        for (int c = 0; c < rows; c++) {
            
            objDataset.setValue(netIncomeTable.getValueAt(c, 0).toString(), Float.parseFloat(netIncomeTable.getValueAt(c, 1).toString())); // retrieve table contents and add to data set
            
        }
        
        JFreeChart netChart = ChartFactory.createPieChart("Net Income", objDataset, true, true, false); // makes chart
        netPanel.setLayout(new java.awt.BorderLayout());
        ChartPanel chartPanel = new ChartPanel(netChart);
        netPanel.add(chartPanel, BorderLayout.CENTER);
        netPanel.validate();
       
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
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grossIncomeTable = new javax.swing.JTable();
        grossPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        expensesTable = new javax.swing.JTable();
        expensesPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        netIncomeTable = new javax.swing.JTable();
        netPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grossIncomeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Gross Income"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(grossIncomeTable);

        javax.swing.GroupLayout grossPanelLayout = new javax.swing.GroupLayout(grossPanel);
        grossPanel.setLayout(grossPanelLayout);
        grossPanelLayout.setHorizontalGroup(
            grossPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
        grossPanelLayout.setVerticalGroup(
            grossPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(grossPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grossPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gross", jPanel3);

        expensesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Expenses"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(expensesTable);

        javax.swing.GroupLayout expensesPanelLayout = new javax.swing.GroupLayout(expensesPanel);
        expensesPanel.setLayout(expensesPanelLayout);
        expensesPanelLayout.setHorizontalGroup(
            expensesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
        expensesPanelLayout.setVerticalGroup(
            expensesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(expensesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expensesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Expenses", jPanel4);

        netIncomeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Net Income"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(netIncomeTable);

        javax.swing.GroupLayout netPanelLayout = new javax.swing.GroupLayout(netPanel);
        netPanel.setLayout(netPanelLayout);
        netPanelLayout.setHorizontalGroup(
            netPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
        netPanelLayout.setVerticalGroup(
            netPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(netPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(netPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Net", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Variance", jPanel6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(REPORT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(REPORT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(REPORT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(REPORT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new REPORT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel expensesPanel;
    private javax.swing.JTable expensesTable;
    private javax.swing.JTable grossIncomeTable;
    private javax.swing.JPanel grossPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable netIncomeTable;
    private javax.swing.JPanel netPanel;
    // End of variables declaration//GEN-END:variables
}
