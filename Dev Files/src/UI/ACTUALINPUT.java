package UI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.TransactionBean;
import Beans.RawBean;
import DAO.Implementation.TransactionDAOImplementation;
import DAO.Interface.TransactionDAOInterface;
import DAO.Implementation.RawDAOImplementation;
import DAO.Interface.RawDAOInterface;
import java.awt.Component;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import javax.swing.JOptionPane;

/**
 *
 * @author Kim
 */
public class ACTUALINPUT extends javax.swing.JFrame {
    
    TransactionDAOInterface tclmp = new TransactionDAOImplementation();
    ArrayList<TransactionBean> aTransact;
    RawDAOInterface rmImp = new RawDAOImplementation();
    ArrayList<RawBean> aRaw;
    EODTab main; 
    /**
     * Creates new form ACTUALINPUT
     */
    public ACTUALINPUT(EODTab t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        main = t;
        checkDate();
        errorLabel1.setVisible(false);
        errorLabel2.setVisible(false);
        abortedLabel.setVisible(false);
        successLabel.setVisible(false);
        displayTable();
    }

    /*
     *  <!-- KIM CODE START -->
     */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        inputTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        errorLabel1 = new javax.swing.JLabel();
        errorLabel2 = new javax.swing.JLabel();
        abortedLabel = new javax.swing.JLabel();
        successLabel = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(956, 555));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("INPUT ACTUAL COUNT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jDialog1.setType(java.awt.Window.Type.POPUP);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("INPUT ACTUAL COUNT");

        inputTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Quantity in Stock", "Actual Count"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inputTable.getTableHeader().setReorderingAllowed(false);
        inputTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(inputTable);
        inputTable.getColumnModel().getColumn(0).setResizable(false);
        inputTable.getColumnModel().getColumn(0).setPreferredWidth(0);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 91, -1, 157));

        jLabel5.setText("Actual Count Input");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(631, 43, -1, -1));
        jLabel5.setText("Raw Materials");

        submitBtn.setText("SUBMIT");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 276, -1, -1));

        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 276, -1, -1));

        errorLabel1.setForeground(new java.awt.Color(255, 0, 1));
        errorLabel1.setText("Submission Failed. Please check that all inputs are positive numbers");

        errorLabel2.setForeground(new java.awt.Color(255, 0, 1));
        errorLabel2.setText("and that no fields are empty.");

        abortedLabel.setText("Submission aborted. No changes were made.");

        successLabel.setText("Success! Count has been updated.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(submitBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(errorLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(errorLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(abortedLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(successLabel)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(errorLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel2)
                .addGap(18, 18, 18)
                .addComponent(abortedLabel)
                .addGap(18, 18, 18)
                .addComponent(successLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(backBtn))
                .addGap(35, 35, 35))
        );


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here

        //JFrame frame = new JFrame("");
        //int ans = JOptionPane.showConfirmDialog(rootPane, frame, "Are you sure that you want to submit? You may only submit once a day.", JOptionPane.YES_NO_OPTION);
        
        if (JOptionPane.showConfirmDialog(null, "Are you sure that you want to submit? You may only submit once a day.", "Confirm Submit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        
        boolean submit = true;
        
            // VALIDATE INPUT
            int rows = inputTable.getRowCount();
            int c = 0;
            
            for (c = 0; c < rows && submit; c++) {
             
                if(inputTable.getValueAt(c,3).toString().isEmpty() || Math.signum(Float.parseFloat(inputTable.getValueAt(c,3).toString())) == -1) {
                        submit = false;
                        System.out.println("error");
                        errorLabel1.setVisible(true);
                        errorLabel2.setVisible(true);
                    }
                
            }
            
        
        if (submit) {
            
            for (c = 0; c < rows; c++) {
            
                int ID = Integer.parseInt(inputTable.getValueAt(c, 0).toString());
                RawBean r = rmImp.getRaw(ID);
                r.setStock(Float.parseFloat(inputTable.getValueAt(c, 3).toString()));
                rmImp.editRaw(r);
                
            }
            
            if(inputLockDown()){
            submitBtn.setVisible(false);
            //main.setNextDayBtn();
            }
            successLabel.setVisible(false);
            displayTable();
        }
        else {
           errorLabel1.setVisible(true);
           errorLabel2.setVisible(true);
                    
        }
      }
        else {
             abortedLabel.setVisible(true);
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
       main.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    /*** <--- CLARK'S CODE STARTS HERE ---> ***/
    
    public boolean inputLockDown(){
        boolean flag = false;
        
        try {
            String filepath = "btf.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);
            
            String actual = doc.getElementsByTagName("actual").item(0).getTextContent();
            //System.out.println(sales);
                if(actual.equals("0"))
                    doc.getElementsByTagName("actual").item(0).setTextContent("1");
                else if(actual.equals("1")) {
                    doc.getElementsByTagName("actual").item(0).setTextContent("2");
                    flag = true;
                }
                else if(actual.equals("2")) {
                    flag = true;
                    return flag;
                }
                
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
                        
        } catch (Exception e) {
             e.printStackTrace();
        } 
        
        return flag;
    }
    
    public void checkDate() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = new Date();
            String curDate = dateFormat.format(d) ;
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, +1);
            String nextDate = dateFormat.format(cal.getTime());

            String actual = main.getValueXML("actual");

            if(main.getDateXML().equals(curDate)) {
                if(actual.equals("0") || actual.equals("1")) {
                    submitBtn.setVisible(true);
                } else if(actual.equals("2")) {
                    submitBtn.setVisible(false);
                }
            } else if(main.getDateXML().equals(nextDate)) {
                submitBtn.setVisible(false);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    /*** <--- CLARK'S CODE ENDS HERE ---> ***/
    

    private void inputTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputTableMouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_inputTableMouseClicked
    /*
     *  check if number!
     */

    private boolean isNumber(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /*
     *  TABLE SET UP
     */
    
    public void displayTable() {
        aTransact = new ArrayList<>();
        aRaw = new ArrayList<>();
        
        /*
         *  FOR CURRENT TABLE
         */
        
        aRaw = rmImp.getAllRaw();
        String cols[] = {"ID","Name", "Quantity in Stock", "Actual Count"};
        inputTable.getColumnModel().getColumn(0).setMinWidth(0);
        inputTable.getColumnModel().getColumn(0).setMaxWidth(0);
        
        /*
         * FOR ACTUAL INPUT TABLE
         */
        
        DefaultTableModel actualTable = new DefaultTableModel(cols,0);
        
        for (RawBean raw : aRaw) {
            
            Object[] data = {raw.getRawID(), raw.getRaw(), raw.getStock(), ""};
            actualTable.addRow(data);
            inputTable.setModel(actualTable);
            inputTable.getColumnModel().getColumn(0).setMinWidth(0);
            inputTable.getColumnModel().getColumn(0).setMaxWidth(0);
            adjustTable(inputTable);
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
    
    /*
     *  <!-- KIM CODE END -->
     */
    
    /**
     * @param args the command line arguments
     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ACTUALINPUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ACTUALINPUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ACTUALINPUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ACTUALINPUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new ACTUALINPUT().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ACTUALINPUT.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(ACTUALINPUT.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ACTUALINPUT.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(ACTUALINPUT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abortedLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JTable inputTable;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel successLabel;
    // End of variables declaration//GEN-END:variables
}