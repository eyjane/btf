/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import Beans.IngredientBean;
import Beans.RecipeBean;
import Beans.SalesBean;
import DAO.Implementation.SalesDAOImplementation;
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
/**
 *
 * @author Evy
 */
public class GrossIncome extends javax.swing.JFrame {

    ArrayList<RecipeBean> aSales = new ArrayList<RecipeBean>();
    SalesDAOInterface sImp = new SalesDAOImplementation();
    
    /**
     * Creates new form GrossIncome
     */
    public GrossIncome() {
        initComponents();
        GITable();
        expTable();
        netTable();
        makeGIChart();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grossIncomeTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        expensesTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        netIncomeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanelChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel3.setText("Gross Income");

        grossIncomeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Recipe", "Gross Income"
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

        jButton1.setText("BACK");

        expensesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Recipe", "Expenses"
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

        netIncomeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Recipe", "Net Income"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(netIncomeTable);

        jLabel1.setText("Gross Income");

        jLabel2.setText("Expenses");

        jLabel4.setText("Net Income");

        javax.swing.GroupLayout jPanelChartLayout = new javax.swing.GroupLayout(jPanelChart);
        jPanelChart.setLayout(jPanelChartLayout);
        jPanelChartLayout.setHorizontalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelChartLayout.setVerticalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel1)
                .addGap(251, 251, 251)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(180, 180, 180))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_formWindowActivated

    /*
     *  <!-- KIM CODE STARTS HERE -->
     */
   
    public void GITable() {
       RecipeBean r = new RecipeBean(); 
       DateFormat t = new SimpleDateFormat("yyyy-MM-dd");
       Date todayDate = new Date();
       String today = t.format(todayDate);
       
       aSales = sImp.getAllSales(today);
       String cols[] = {"Name", "Gross Income"};
       DefaultTableModel actualTable = new DefaultTableModel(cols,0);
        
       for(RecipeBean sale : aSales) {
           
           r.setRecipeID(sale.getRecipeID());
           Object[] data = {sale.getRecipe(), sImp.sumSalesByRecipeByDay(r, today)};
           actualTable.addRow(data);
           grossIncomeTable.setModel(actualTable);
           adjustTable(grossIncomeTable);
       }
      
    }
    
    public void expTable() {
        
       RecipeBean r = new RecipeBean(); 
       DateFormat t = new SimpleDateFormat("yyyy-MM-dd");
       Date todayDate = new Date();
       String today = t.format(todayDate);
       
       aSales = sImp.getAllSales(today);
       String cols[] = {"Name", "Expenses"};
       DefaultTableModel actualTable = new DefaultTableModel(cols,0);
        
       for(RecipeBean sale : aSales) {
           
           r.setRecipeID(sale.getRecipeID());
           Object[] data = {sale.getRecipe(), sImp.sumExpensesByRecipeByDay(r, today)};
           actualTable.addRow(data);
           expensesTable.setModel(actualTable);
           adjustTable(expensesTable);
       }
        
    }
    
    public void netTable() {
       
        RecipeBean r = new RecipeBean(); 
       DateFormat t = new SimpleDateFormat("yyyy-MM-dd");
       Date todayDate = new Date();
       String today = t.format(todayDate);
       
       aSales = sImp.getAllSales(today);
       String cols[] = {"Name", "Net Income"};
       DefaultTableModel actualTable = new DefaultTableModel(cols,0);
        
       for(RecipeBean sale : aSales) {
           
           r.setRecipeID(sale.getRecipeID());
           Object[] data = {sale.getRecipe(), sImp.sumSalesByRecipeByDay(r, today) - sImp.sumExpensesByRecipeByDay(r, today)};
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
        ChartPanel chartPanel = new ChartPanel(grossChart);
        jPanelChart.setLayout(new BorderLayout());
        jPanelChart.add(chartPanel, BorderLayout.NORTH);
       
        JFrame frame = new JFrame();
        frame.add(jPanelChart);
        frame.pack();
        frame.setVisible(true);
        
    }
    
    public void makeExpChart() {
        
        DefaultPieDataset objDataset = new DefaultPieDataset();
        int rows = expensesTable.getRowCount();
        
        for (int c = 0; c < rows; c++) {
            
            objDataset.setValue(expensesTable.getValueAt(c, 0).toString(), Float.parseFloat(expensesTable.getValueAt(c, 1).toString())); // retrieve table contents and add to data set
            
        }
        
        JFreeChart expChart = ChartFactory.createPieChart("Gross Income", objDataset, true, true, false); // makes chart
        ChartPanel chartPanel = new ChartPanel(expChart);
        jPanelChart.setLayout(new BorderLayout());
        jPanelChart.add(chartPanel, BorderLayout.NORTH);
       
        JFrame frame = new JFrame();
        frame.add(jPanelChart);
        frame.pack();
        frame.setVisible(true);
        
    }
    
    public void makeNetChart() {
        
        DefaultPieDataset objDataset = new DefaultPieDataset();
        int rows = netIncomeTable.getRowCount();
        
        for (int c = 0; c < rows; c++) {
            
            objDataset.setValue(netIncomeTable.getValueAt(c, 0).toString(), Float.parseFloat(netIncomeTable.getValueAt(c, 1).toString())); // retrieve table contents and add to data set
            
        }
        
        JFreeChart netChart = ChartFactory.createPieChart("Gross Income", objDataset, true, true, false); // makes chart
        ChartPanel chartPanel = new ChartPanel(netChart);
        jPanelChart.setLayout(new BorderLayout());
        jPanelChart.add(chartPanel, BorderLayout.NORTH);
       
        JFrame frame = new JFrame();
        frame.add(jPanelChart);
        frame.pack();
        frame.setVisible(true);
        
    }
    
    /*
     *  <!-- KIM CODE ENDS HERE --> 
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
            java.util.logging.Logger.getLogger(GrossIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrossIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrossIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrossIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GrossIncome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable expensesTable;
    private javax.swing.JTable grossIncomeTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelChart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable netIncomeTable;
    // End of variables declaration//GEN-END:variables
}
