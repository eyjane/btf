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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;

/**
 *
 * @author Evy
 */
public class EODTab extends javax.swing.JFrame {

    RecipeDAOInterface rcImp = new RecipeDAOImplementation();
    IngredientDAOInterface inImp = new IngredientDAOImplementation();
    RawDAOInterface rwImp = new RawDAOImplementation();

    /**
     * Creates new form EODTab
     */
    public EODTab() throws ClassNotFoundException, InstantiationException, UnsupportedLookAndFeelException, IllegalAccessException {

        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        prepareTable();
        checkDate();
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
        InventoryTab = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jScrollPane3 = new javax.swing.JScrollPane();
        rawTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rcMgt = new javax.swing.JButton();
        rmMgt1 = new javax.swing.JButton();
        cMgt2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        salesBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        actualBtn1 = new javax.swing.JButton();
        UTWbtn1 = new javax.swing.JButton();
        nextDayBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        btnExportStock = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(null);

        recipeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        recipeTable.setName("Recipe Stock"); // NOI18N
        jScrollPane2.setViewportView(recipeTable);

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(170, 50, 454, 110);

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
        rawTable.setName("Recipe Stock"); // NOI18N
        jScrollPane3.setViewportView(rawTable);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(170, 260, 454, 110);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("RECIPE STOCK");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(167, 16, 178, 30);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setText("RAW MATERIAL STOCK");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(170, 220, 286, 30);

        rcMgt.setText("Recipe Management");
        rcMgt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcMgtActionPerformed(evt);
            }
        });
        jPanel5.add(rcMgt);
        rcMgt.setBounds(0, 20, 160, 50);

        rmMgt1.setText("Manage Raw Materials");
        rmMgt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmMgt1ActionPerformed(evt);
            }
        });
        jPanel5.add(rmMgt1);
        rmMgt1.setBounds(0, 90, 160, 50);

        cMgt2.setText("Category Management");
        cMgt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cMgt2ActionPerformed(evt);
            }
        });
        jPanel5.add(cMgt2);
        cMgt2.setBounds(0, 160, 160, 50);

        InventoryTab.addTab("INVENTORY", jPanel5);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(null);

        salesBtn.setText("SALES");
        salesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesBtnActionPerformed(evt);
            }
        });
        jPanel6.add(salesBtn);
        salesBtn.setBounds(0, 160, 160, 50);

        jButton2.setText("DELIVERY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);
        jButton2.setBounds(0, 20, 160, 50);

        actualBtn1.setText("INPUT RAW MATERIAL COUNT");
        actualBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualBtnActionPerformed(evt);
            }
        });
        jPanel6.add(actualBtn1);
        actualBtn1.setBounds(0, 90, 160, 50);

        UTWbtn1.setText("USED/TRANSFERED AND WASTAGES");
        UTWbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UTWbtnActionPerformed(evt);
            }
        });
        jPanel6.add(UTWbtn1);
        UTWbtn1.setBounds(0, 230, 160, 50);

        nextDayBtn.setText("NEXT DAY");
        jPanel6.add(nextDayBtn);
        nextDayBtn.setBounds(0, 300, 160, 50);
        nextDayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextDayBtnActionPerformed(evt);
            }
        });

        InventoryTab.addTab("EOD", jPanel6);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        jButton7.setText("Expenses");
        jPanel3.add(jButton7);
        jButton7.setBounds(0, 30, 160, 50);

        jButton8.setText("Gross Income");
        jPanel3.add(jButton8);
        jButton8.setBounds(0, 100, 160, 50);

        jButton9.setText("Net Income");
        jPanel3.add(jButton9);
        jButton9.setBounds(0, 170, 160, 50);

        btnExportStock.setText("Export Stock");
        btnExportStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportStockActionPerformed(evt);
            }
        });
        jPanel3.add(btnExportStock);
        btnExportStock.setBounds(0, 310, 160, 50);

        jButton1.setText("Variance");
        jPanel3.add(jButton1);
        jButton1.setBounds(0, 240, 160, 50);

        InventoryTab.addTab("REPORT", jPanel3);

        jPanel1.add(InventoryTab);
        InventoryTab.setBounds(0, 130, 840, 480);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Background.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 0, 960, 710);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rcMgtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcMgtActionPerformed
        this.setVisible(false);
        try {
            RCManagement rcmgt = new RCManagement();
            rcmgt.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_rcMgtActionPerformed

    private void rmMgt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmMgt1ActionPerformed
        try {
            RMManagement rm = new RMManagement();
            rm.setVisible(true);
            dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rmMgt1ActionPerformed

    private void cMgt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cMgt2ActionPerformed
        try {
            CategoryManagement ct = new CategoryManagement();
            ct.setVisible(true);
            dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cMgt2ActionPerformed

    private void salesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesBtnActionPerformed
        this.setVisible(false);
        try {
            SALES saleswindow = new SALES(this, getDateXML());
            saleswindow.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_salesBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        // DELIVERY
        this.setVisible(false);
        try {
            DELIVERY deliveryWindow = new DELIVERY(this);
            deliveryWindow.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void actualBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualBtnActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        try {
            ACTUALINPUT actualWindow = new ACTUALINPUT(this);
            actualWindow.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_actualBtnActionPerformed

    private void UTWbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UTWbtnActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        try {
            UsedTransfer usedWindow = new UsedTransfer(this);
            usedWindow.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_UTWbtnActionPerformed

    private void btnExportStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportStockActionPerformed
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = new Date();
            String path = dateFormat.format(d) + " btf stocks.xlsx" ;

            ArrayList<JTable> tables = new ArrayList<JTable>();
            tables.add(rawTable);
            tables.add(recipeTable);
            exportToExcel(tables, path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportStockActionPerformed


    private void nextDayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UTWbtn1ActionPerformed
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = new Date();
            String curDate = dateFormat.format(d) ;
            Calendar cal1 = Calendar.getInstance();
            cal1.add(Calendar.DATE, +1);
            String nextDate = dateFormat.format(cal1.getTime());
        
            if(getDateXML().equals(curDate)) {
                if(JOptionPane.showConfirmDialog(null, "Are you sure you're done for the day?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                        nextDay(nextDate);
                        JOptionPane.showMessageDialog(null, "Tomorrow's date is " + nextDate, "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if(!getDateXML().equals(nextDate) && !getDateXML().equals(curDate)) {
                nextDay(curDate);
                JOptionPane.showMessageDialog(null, "New date is " + curDate, "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }//GEN-LAST:event_UTWbtn1ActionPerformed
    /**
     * < -- CLARK'S FUNCTIONS START -- > *
     */
    
    private void nextDay(String curDate) {
        try {
            String filepath = "btf.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);
                       
            doc.getElementsByTagName("delivery").item(0).setTextContent("0");
            doc.getElementsByTagName("used").item(0).setTextContent("0");
            doc.getElementsByTagName("sales").item(0).setTextContent("0");
            doc.getElementsByTagName("actual").item(0).setTextContent("0");
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
            
            nextDayBtn.setEnabled(false);
        } catch (Exception e) {
             e.printStackTrace();
        } 
    }
    
    public String getDateXML() {
        String date = ""; 
        try {
            String filepath = "btf.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);
            
            date = doc.getElementsByTagName("date").item(0).getTextContent();
                        
        } catch (Exception e) {
             e.printStackTrace();
        } 
        return date;
    }
    
    public String getValueXML(String x) {
        String value = ""; 
        try {
            String filepath = "btf.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);
            
            value = doc.getElementsByTagName(x).item(0).getTextContent();
                        
        } catch (Exception e) {
             e.printStackTrace();
        } 
        return value;
    }
    
    public void checkDate() {
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = new Date();
            String curDate = dateFormat.format(d) ;
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, +1);
            String nextDate = dateFormat.format(cal.getTime());

            String sales = getValueXML("sales");

            if(getDateXML().equals(curDate)) {
                if(sales.equals("0") || sales.equals("1")) {
                    nextDayBtn.setVisible(false);
                } else if(sales.equals("2")) {
                    nextDayBtn.setVisible(true);
                }
            } else if(getDateXML().equals(nextDate)) {
                nextDayBtn.setVisible(false);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setNextDayBtn() {
        nextDayBtn.setVisible(true);
    }
    
    private void exportToExcel(ArrayList<JTable> tables, String path) throws FileNotFoundException, IOException {
        new WorkbookFactory();
        Workbook wb = new XSSFWorkbook(); //Excel workbook
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setColor(HSSFColor.RED.index);
        style.setFont(font);
        for(int i = 0; i < tables.size(); i++){
            JTable table = tables.get(i);
            Sheet sheet = wb.createSheet(table.getName()); //WorkSheet
            sheet.setColumnWidth(0, 15000);
            Row row = sheet.createRow(2); //Row created at line 3
            TableModel model = table.getModel(); //Table model

            Row headerRow = sheet.createRow(0); //Create row at line 0
            for(int headings = 0; headings < model.getColumnCount(); headings++){ //For each column
                headerRow.createCell(headings).setCellValue(model.getColumnName(headings));//Write column name
            }

            for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
                for(int cols = 0; cols < table.getColumnCount(); cols++){ //For each table column
                    String text = model.getValueAt(rows, cols).toString();
                    Cell cell = row.createCell(cols); //create cell
                    if(checkHTML(text)){
                        cell.setCellStyle(style);
                        text = parseHTML(text);
                    }
                    cell.setCellValue(text); //Write value
                }
                //Set the row to the next one in the sequence 
                row = sheet.createRow((rows + 3)); 
            }
        }
        //wb.setSheetName(wb.getSheetIndex(sheet), "Raw Materials");
        try{
            File file = new File(path);
            if(!file.exists()) {
                file.createNewFile();
            } 
            FileOutputStream fileOut =  new FileOutputStream(file, false);
            wb.write(fileOut);//Save the file     
            fileOut.close();
            System.out.println("SUCCESS");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public boolean checkHTML(String str){
        boolean hasHTML = false;
        if(str.contains("<html>")){
            hasHTML = true;
        }
        return hasHTML;
    }
    
    public String parseHTML(String str){
        String temp = "";
        temp = str.replace("<html><p style = 'color:red'><b>", "");
        System.out.println(temp);
        temp = temp.replace("</b></p></html>", "");
        System.out.println(temp);
        return temp;
    }
    /**
     * < -- CLARK'S FUNCTIONS END -- > *
     */
    
    /**
     * < -- JANERYS FUNCTIONS START -- > *
     */
    /* Prepare Table */
    private void prepareTable() {

        ArrayList<RecipeBean> avRecipes = new ArrayList<RecipeBean>();
        ArrayList<RawBean> avRaw = new ArrayList<RawBean>();
        int i, j;

        // recipe Stocks
        String cols[] = {"Name", "Stock"};
        DefaultTableModel recipeModel = new DefaultTableModel(cols, 0);
        avRecipes = rcImp.getRecipeByStatus("available");

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

        // raw material stock
        DefaultTableModel rawModel = new DefaultTableModel(cols, 0);
        avRaw = rwImp.getRawByStatus("available");

        if (avRaw != null) {
            for (i = 0; i < avRaw.size(); i++) {
                RawBean rm = avRaw.get(i);
                String color = "black";
                
                
                if (rm.isCritical()) {
                    color = "red";
                }else if(rm.isMedium()){
                    color = "orange";
                }else{
                    color = "green";
                }
                
                String shtml = "<html><p style=color:" + color + ">";
                String ehtml = "</p></html>";
                Object[] raw = {shtml + rm.getRaw() + ehtml, shtml + String.format("%.2f", rm.getStock()) + ehtml};
                rawModel.addRow(raw);
            }
        }

        rawTable.setModel(rawModel);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        rawTable.getColumn("Stock").setCellRenderer(rightRenderer);
        recipeTable.getColumn("Stock").setCellRenderer(rightRenderer);
        recipeTable.setRowSelectionAllowed(true);
        //System.out.println(recipeTable.getRowSelectionAllowed());
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
            java.util.logging.Logger.getLogger(EODTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EODTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EODTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EODTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EODTab().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(EODTab.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane InventoryTab;
    private javax.swing.JButton UTWbtn1;
    private javax.swing.JButton actualBtn1;
    private javax.swing.JButton btnExportStock;
    private javax.swing.JButton cMgt2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton nextDayBtn;
    private javax.swing.JTable rawTable;
    private javax.swing.JButton rcMgt;
    private javax.swing.JTable recipeTable;
    private javax.swing.JButton rmMgt1;
    private javax.swing.JButton salesBtn;
    // End of variables declaration//GEN-END:variables

    
}