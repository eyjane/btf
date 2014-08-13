package UI;

import Beans.RawBean;
import Beans.RecipeBean;
import DAO.Implementation.RawDAOImplementation;
import DAO.Implementation.RecipeDAOImplementation;
import DAO.Implementation.SalesDAOImplementation;
import DAO.Implementation.TransactionDAOImplementation;
import DAO.Interface.RawDAOInterface;
import DAO.Interface.RecipeDAOInterface;
import DAO.Interface.SalesDAOInterface;
import DAO.Interface.TransactionDAOInterface;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Evy
 */
public class Variance extends javax.swing.JFrame {

    SalesDAOInterface saImp = new SalesDAOImplementation();
    TransactionDAOInterface tcImp = new TransactionDAOImplementation();
    RawDAOInterface rwImp = new RawDAOImplementation();
    RecipeDAOInterface rcImp = new RecipeDAOImplementation();
    
    /**
     * Creates new form Variance
     */
    public Variance() throws ParseException {
        initComponents();
        prepare();
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
        jLabel1 = new javax.swing.JLabel();
        dateCombo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        varianceTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnExportVariance = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(956, 555));

        jLabel1.setText("View:");

        dateCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateComboActionPerformed(evt);
            }
        });

        varianceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Beginning", "Delivery", "Sales", "Wastages", "EOD", "Variance"
            }
        ));
        jScrollPane1.setViewportView(varianceTable);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel2.setText("Variance");

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnExportVariance.setText("Export Variance Report");
        btnExportVariance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportVarianceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportVariance)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(dateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(dateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnExportVariance))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dateComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateComboActionPerformed

    private void btnExportVarianceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportVarianceActionPerformed
      
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = new Date();
            String path = dateFormat.format(d) + " btf reports.xls" ;
            
            DateItem date = (DateItem) dateCombo.getSelectedItem();
            checkExcelExist(varianceTable, path, date.getValue());
    }//GEN-LAST:event_btnExportVarianceActionPerformed

    /**
     * * <--- CLARK'S CODE STARTS HERE ---> **
     */
    
    private void exportToExcel(JTable tables, String path, String date) throws FileNotFoundException, IOException, InvalidFormatException {
        HSSFWorkbook wb;
        HSSFSheet sheet;
        JTable table = tables;
        int c1 = 1;
        int c2 = 8;
        int col = 1;
        
        wb = new HSSFWorkbook();
        sheet = wb.createSheet("Variance"); 
        sheet.setColumnWidth(0, 10000);
        sheet.createFreezePane( 1, 0, 1, 0 );
        
        sheet.addMergedRegion(new CellRangeAddress(0, 0, c1, c2));
        
        CellStyle style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        
        Row header = sheet.createRow(0);
        Cell headerCell = header.createCell(c1);
        headerCell.setCellValue(date);
        headerCell.setCellStyle(style);
        CellUtil.setAlignment(headerCell, wb, CellStyle.ALIGN_CENTER);
        
        Row row = sheet.createRow(3);
        TableModel model = table.getModel();

        Row headerRow = sheet.createRow(1);
        for(int headings = col; headings < model.getColumnCount(); headings++){
            headerRow.createCell(headings + c1 - 2).setCellValue(model.getColumnName(headings));
        }
         
        for(int rows = 0; rows < model.getRowCount(); rows++){ 
            for(int cols = col; cols < table.getColumnCount(); cols++){ 
                sheet.setColumnWidth(cols + c1 - 1, 3000);
                String text = model.getValueAt(rows, cols).toString();
                Cell cell = row.createCell(cols + c1 - 2); 
                cell.setCellValue(text); 
            }
            row = sheet.createRow((rows + 4)); 
        }
        try{
            FileOutputStream fileOut =  new FileOutputStream(path);
            wb.write(fileOut); 
            fileOut.close();
            JOptionPane.showMessageDialog(null, "Successfully exported the report!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void modifyExcel(JTable tables, String path, String date) {
        InputStream inp;
        JTable table = tables;
        try {
            inp = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            int c1 = sheet.getRow(3).getLastCellNum();
            int c2 = c1 + 7;
            Row row = sheet.getRow(3);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, c1, c2));
            
            CellStyle style = wb.createCellStyle();
            style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
            
            Row header = sheet.getRow(0);
            Cell headerCell = header.createCell(c1);
            headerCell.setCellValue(date);
            headerCell.setCellStyle(style);
            CellUtil.setAlignment(headerCell, wb, CellStyle.ALIGN_CENTER);

            TableModel model = table.getModel(); 

            Row headerRow = sheet.getRow(1);
            for(int headings = 2; headings < model.getColumnCount(); headings++){ 
                headerRow.createCell(headings + c1 - 2).setCellValue(model.getColumnName(headings));
            }
            
            for(int rows = 0; rows < model.getRowCount(); rows++){ 
                for(int cols = 2; cols < table.getColumnCount(); cols++){ 
                    sheet.setColumnWidth(cols + c1 - 1, 3000);
                    String text = model.getValueAt(rows, cols).toString();
                    Cell cell = row.createCell(cols + c1 - 2); 
                    cell.setCellValue(text); 
                }
                
                row = sheet.getRow((rows + 4)); 
            }

            FileOutputStream fileOut = new FileOutputStream(path);
            wb.write(fileOut);
            fileOut.close();
            JOptionPane.showMessageDialog(null, "Successfully exported the report!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void checkExcelExist(JTable tables, String path, String date){
        try{
            File file = new File(path);
            if(!file.exists()) {
                exportToExcel(varianceTable, path, date);
            } else {
                modifyExcel(varianceTable, path, date);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * * <--- CLARK'S CODE ENDS HERE ---> **
     */
    /**
     * * <--- JANERYS CODE STARTS HERE ---> **
     */
    
    private void generateReport(String d){
        ArrayList<RawBean> aRaw = tcImp.getAllTRaw(d); //recipes w beginning already set
        String cols[] = {"Raw ID", "Raw Material", "Beginning", "Sales", "Delivery", "Used", "Transfer", "Wastage", "Actual Count", "Variance"};
        DefaultTableModel varianceModel = new DefaultTableModel(cols, 0);
        
        for(RawBean rw: aRaw){
            float sales = computeSales(rw); //!!!
            float delivery = tcImp.getQuantityByDayByRaw(d, "delivery", rw);
            float used = tcImp.getQuantityByDayByRaw(d, "used", rw);
            float transferred = tcImp.getQuantityByDayByRaw(d, "transferred", rw);
            float wastage = tcImp.getQuantityByDayByRaw(d, "delivery", rw);
            float actual = tcImp.getQuantityByDayByRaw(d, "actual", rw);
            float variance = rw.getStock() + delivery - sales - used - transferred - wastage - actual;
            
            Object iRaw[] = {rw.getRawID(), rw.getRaw(), 
                rw.getStock(), 
                String.format("%.2f", sales), 
                String.format("%.2f", delivery), 
                String.format("%.2f", used), 
                String.format("%.2f", transferred), 
                String.format("%.2f", wastage), 
                String.format("%.2f", actual), 
                String.format("%.2f", variance) };
            
            varianceModel.addRow(iRaw);
        }
        
        varianceTable.setModel(varianceModel);
        varianceTable.getColumnModel().getColumn(0).setMinWidth(0);
        varianceTable.getColumnModel().getColumn(0).setMaxWidth(0);
        adjustTable(varianceTable);
        btnExportVariance.setVisible(true);
    }
    
    private float computeSales(RawBean r){
        float total = 0;
        return total;
    }
    private void prepare() throws ParseException {
        //prepare combo
        ArrayList<String> aDates = tcImp.getAllDates(); // dates format: yyyy-mm-dd

        for (String d : aDates) {
            //convert to word date
            DateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dformat.parse(d);
            DateFormat wformat = new SimpleDateFormat("MMMMM d, yyyy");
            String dateWord = wformat.format(date);
            DateItem dItem = new DateItem(d, dateWord);

            dateCombo.addItem(dItem);
        }

        dateCombo.addItemListener(new ItemChangeListener());
        btnExportVariance.setVisible(false);
        //prepare table
        
        
        DateItem dSelected = (DateItem) dateCombo.getSelectedItem();
        generateReport(dSelected.getValue());
    }

    class ItemChangeListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                DateItem item = (DateItem) event.getItem();
                
                //JOptionPane.showMessageDialog(null, item.getValue());
               //JOptionPane.showMessageDialog(null, "Day before: " + tcImp.getDayBefore(item.getValue())); day before to get beginning
                
                /*enter to code to generate report */
                generateReport(item.getValue());
            }
        }
    }

    public class DateItem {

        private String value;
        private String label;

        public DateItem(String value, String label) {
            this.value = value;
            this.label = label;
        }

        public String getValue() {
            return this.value;
        }

        public String getLabel() {
            return this.label;
        }

        @Override
        public String toString() {
            return label;
        }
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
     * * <--- JANERYS CODE ENDS HERE ---> **
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
            java.util.logging.Logger.getLogger(Variance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Variance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Variance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Variance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Variance().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(Variance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportVariance;
    private javax.swing.JComboBox dateCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable varianceTable;
    // End of variables declaration//GEN-END:variables
}
