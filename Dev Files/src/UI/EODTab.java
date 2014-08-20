package UI;

import Beans.RawBean;
import Beans.TransactionBean;
import DAO.Implementation.RawDAOImplementation;
import DAO.Implementation.TransactionDAOImplementation;
import DAO.Interface.RawDAOInterface;
import DAO.Interface.TransactionDAOInterface;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;

/**
 *
 * @author Catherine
 */
public class EODTab extends javax.swing.JFrame {
    
    // INTERFACE + IMPLEMENTATION
    RawDAOInterface rmImp = new RawDAOImplementation();
    TransactionDAOInterface tclmp = new TransactionDAOImplementation();
    
    // ARRAYLISTS
    ArrayList<TransactionBean> aTransact;
    ArrayList<RawBean> aRaw;
    
    // OTHERS
    EODTab main; 
    int[] rowEdit;
    
    public EODTab() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        ViewAllStatus();
        checkDate();
        makeActualTable();
        makeRMTable();
        makeDeliveryTable();
        actualErrorLabel.setVisible(false);
        actualSuccessLabel.setVisible(false);
        actualAbortedLabel.setVisible(false);
        materialsErrorLabel.setVisible(false);
        materialsSuccessLabel.setVisible(false);
        materialsAbortedLabel.setVisible(false);
        deliveryErrorLabel.setVisible(false);
        deliverySuccessLabel.setVisible(false);
        deliveryAbortedLabel.setVisible(false);
        BtnNewDay.setVisible(false);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        inputTable = new javax.swing.JTable();
        actualSuccessLabel = new javax.swing.JLabel();
        actualSubmit = new javax.swing.JButton();
        actualErrorLabel = new javax.swing.JLabel();
        actualAbortedLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        enterSales1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rmTable = new javax.swing.JTable();
        utwSubmit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        materialsErrorLabel = new javax.swing.JLabel();
        materialsSuccessLabel = new javax.swing.JLabel();
        materialsAbortedLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        deliveryTable = new javax.swing.JTable();
        deliverySubmit = new javax.swing.JButton();
        deliverySuccessLabel = new javax.swing.JLabel();
        deliveryAbortedLabel = new javax.swing.JLabel();
        deliveryErrorLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        newdayTable = new javax.swing.JTable();
        BtnNewDay = new javax.swing.JButton();
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
        ReportsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportsBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ReportsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 239, 60));

        jLabel1.setFont(new java.awt.Font("Quicksand Light", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("End-of-Day");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jTabbedPane1.setForeground(new java.awt.Color(255, 0, 204));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N

        inputTable.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        inputTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Status", "ID", "Name", "Quantity in Stock", "Actual Count"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(inputTable);
        inputTable.getColumnModel().getColumn(0).setResizable(false);

        actualSuccessLabel.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        actualSuccessLabel.setText("SUBMISSION WAS SUCCESSFUL.");

        actualSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/SubmitBtn.png"))); // NOI18N
        actualSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualSubmitActionPerformed(evt);
            }
        });

        actualErrorLabel.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        actualErrorLabel.setForeground(new java.awt.Color(255, 0, 1));
        actualErrorLabel.setText("ERROR: All fields must be filled and all inputs must be a positive number.");

        actualAbortedLabel.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        actualAbortedLabel.setText("SUBMISSION WAS ABORTED.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(actualErrorLabel)
                            .addComponent(actualSuccessLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(actualAbortedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(actualSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(actualErrorLabel)
                .addGap(13, 13, 13)
                .addComponent(actualSuccessLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actualAbortedLabel)
                    .addComponent(actualSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
        );

        jTabbedPane1.addTab("ACTUAL COUNT", jPanel3);

        enterSales1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/SubmitBtn.png"))); // NOI18N
        enterSales1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterSales1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Quicksand Light", 2, 14)); // NOI18N
        jLabel14.setText("Drag and drop to re-arrange recipes");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Recipe", "Sales", "Compliment"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(enterSales1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(enterSales1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("SALES", jPanel4);

        rmTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Status", "Name", "Quantity in Stock", "Used", "Transferred", "Wastage"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rmTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rmTable.setDragEnabled(true);
        rmTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(rmTable);
        rmTable.getColumnModel().getColumn(0).setResizable(false);

        utwSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/SubmitBtn.png"))); // NOI18N
        utwSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utwSubmitActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel6.setText("USED/TRANSFERRED/WASTED MATERIALS");

        materialsErrorLabel.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        materialsErrorLabel.setForeground(new java.awt.Color(255, 0, 1));
        materialsErrorLabel.setText("ERROR: All fields must be filled and all inputs must be a positive number.");

        materialsSuccessLabel.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        materialsSuccessLabel.setText("SUBMISSION WAS SUCCESSFUL.");

        materialsAbortedLabel.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        materialsAbortedLabel.setText("SUBMISSION WAS ABORTED.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(materialsAbortedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(utwSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(materialsErrorLabel)
                            .addComponent(jLabel6)
                            .addComponent(materialsSuccessLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(materialsErrorLabel)
                .addGap(7, 7, 7)
                .addComponent(materialsSuccessLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(utwSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(materialsAbortedLabel))
                .addContainerGap())
        );

        jTabbedPane1.addTab("MATERIALS", jPanel5);

        jLabel3.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jLabel3.setText("Raw Materials");

        deliveryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(deliveryTable);

        deliverySubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/RestockBtn.png"))); // NOI18N
        deliverySubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliverySubmitActionPerformed(evt);
            }
        });

        deliverySuccessLabel.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        deliverySuccessLabel.setText("SUBMISSION WAS SUCCESSFUL.");

        deliveryAbortedLabel.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        deliveryAbortedLabel.setText("SUBMISSION WAS ABORTED.");

        deliveryErrorLabel.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        deliveryErrorLabel.setForeground(new java.awt.Color(255, 0, 1));
        deliveryErrorLabel.setText("ERROR: All fields must be filled and all inputs must be a positive number.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(deliveryAbortedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deliverySubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(deliverySuccessLabel)
                            .addComponent(deliveryErrorLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deliveryErrorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deliverySuccessLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(deliverySubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(deliveryAbortedLabel)
                        .addGap(24, 24, 24))))
        );

        jTabbedPane1.addTab("DELIVERY", jPanel2);

        newdayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(newdayTable);

        BtnNewDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/NewDayBtn.png"))); // NOI18N
        BtnNewDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNewDayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnNewDay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnNewDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("NEW DAY", jPanel6);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 600, 410));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Background5.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            Logger.getLogger(InventoryTab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(InventoryTab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(InventoryTab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(InventoryTab.class.getName()).log(Level.SEVERE, null, ex);
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

    private void enterSales1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterSales1ActionPerformed
                if(getValueXML("Sales").equals("0")){
                    setValueXML("Sales");
                    //enterSales1.setVisible(false);
                    ViewAllStatus();
                    //BtnNewDay.setEnabled(true);
                }
    }//GEN-LAST:event_enterSales1ActionPerformed

    private void EODBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EODBtnActionPerformed
        // TODO add your handling code here:
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

    private void BtnNewDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNewDayActionPerformed
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
                        ViewAllStatus();
                        JOptionPane.showMessageDialog(null, "Tomorrow's date is " + nextDate, "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if(!getDateXML().equals(nextDate) && !getDateXML().equals(curDate)) {
                nextDay(curDate);
                ViewAllStatus();
                JOptionPane.showMessageDialog(null, "New date is " + curDate, "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }//GEN-LAST:event_BtnNewDayActionPerformed

    private void actualSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualSubmitActionPerformed
        // ------------ SUBMIT ACTUAL INPUT
    
        if (JOptionPane.showConfirmDialog(null, "Are you sure that you want to submit? You may only submit once a day.", "Confirm Submit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        
            boolean submit = true;
            boolean red = false;
            int rows = inputTable.getRowCount();
            int r = 0, index = 0;
            rowEdit = new int[rmTable.getRowCount()];
		
            for (r = 0; r < rows; r++) {
                
                if(inputTable.getValueAt(r,4).toString().isEmpty() || Math.signum(Float.parseFloat(inputTable.getValueAt(r,4).toString())) == -1) {
                        submit = false;
                        red = true;
                        inputTable.setValueAt(0, r, 0);
                }
                
		if (red) {
                    rowEdit[index] = r;
                    index++;
                    red = false;
                }		
            
            }
            
        
            if (submit) {
            
                for (r = 0; r < rows; r++) {
            
                    int ID = Integer.parseInt(inputTable.getValueAt(r, 1).toString());
                    RawBean raw = rmImp.getRaw(ID);
                    raw.setStock(Float.parseFloat(inputTable.getValueAt(r, 4).toString()));
                    rmImp.editRaw(raw);
                
                }
            
                
                if(getValueXML("Actual").equals("0")){
                    setValueXML("Actual");
                    actualSubmit.setVisible(false);
                    ViewAllStatus();
                    BtnNewDay.setVisible(true);
                }
                
                actualSuccessLabel.setVisible(false);
                makeActualTable();
            }
            else {
		
		for (int row = 0; row < inputTable.getRowCount(); row++) {
                    
                    for (int col = 0; col < inputTable.getColumnCount(); col++) {
                        
                        inputTable.getColumnModel().getColumn(col).setCellRenderer(new errorRenderer());
                        
                    }
                
                }
			
                actualErrorLabel.setVisible(true);
                    
            }
        }
        else {
            
            actualAbortedLabel.setVisible(true);
        }
        
    }//GEN-LAST:event_actualSubmitActionPerformed

    private void utwSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utwSubmitActionPerformed
        // TODO add your handling code here:
        
        if (JOptionPane.showConfirmDialog(null, "Are you sure that you want to submit? You may only submit once a day.", "Confirm Submit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        
            boolean submit = true;
            boolean red = false;
            int rows = rmTable.getRowCount();
            int r = 0, index = 0;
            rowEdit = new int[rmTable.getRowCount()];
            
            while(r < rows) {
            
                for (int d = 4; d <= 6; d++) {
                
                    if(rmTable.getValueAt(r,d).toString().isEmpty() || Math.signum(Float.parseFloat(rmTable.getValueAt(r,d).toString())) == -1) {
                        submit = false;
                        red = true;
                        rmTable.setValueAt(0,r,0);
                        System.out.println("Error at row " + r);
                    }
                    
                }
                if(red) {
                    rowEdit[index] = r;
                    //System.out.println(rowEdit[index] + " / " + r);
                    index++;
                    red = false;
                }
                
                r++;
            
            }
            
            if(submit) {
            
                for(int a = 0; a < rows; a++) {
            
                    for (int b = 4; b <= 6; b++) {
                    
                        RawBean raw = new RawBean();
                    
                        String name = rmTable.getValueAt(a, 0).toString(); // raw material name
                        float q = Float.parseFloat(rmTable.getValueAt(a,b).toString());
                        String type = new String();
                        
                        if(b == 4) {
                            type = "used";
                        }
                        else if (b == 5) {
                            type = "transfer";
                        }
                        else if(b == 6) {
                            type = "wastage";
                        }
            
                        // REDUCE FROM RAW TABLE
            
                        float s = rmImp.getStock(type);
                        float deduct = s - q;
                        rmImp.updateStock(name, deduct);
            
                        // ADD TRANSACTION
                        TransactionBean t = new TransactionBean();
                        t.setType(type);
                        int id = Integer.parseInt(rmTable.getValueAt(a, 1).toString());
                        raw.setRawID(id);
                        tclmp.addTransaction(t, raw, q);
                    }
                }
                if(getValueXML("Materials").equals("0")){
                    setValueXML("Materials");
                    //utwSubmit.setVisible(false);
                    ViewAllStatus();
                    //BtnNewDay.setEnabled(true);
                }
                
                materialsSuccessLabel.setVisible(true);
                makeRMTable();
            }
            else {
               
                for (int row = 0; row < rmTable.getRowCount(); row++) {
                
                    for (int col = 0; col <= 6; col++) {
                        
                            rmTable.getColumnModel().getColumn(col).setCellRenderer(new errorRenderer());
                            
                    }
                    
                }
                
                materialsErrorLabel.setVisible(true);
            }
        }
        else {
            
            materialsAbortedLabel.setVisible(true);
        }
        
    }//GEN-LAST:event_utwSubmitActionPerformed

    private void deliverySubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliverySubmitActionPerformed
        // TODO add your handling code here:
        
        if (JOptionPane.showConfirmDialog(null, "Are you sure that you want to submit? You may only submit once a day.", "Confirm Submit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        
            boolean submit = true;
            boolean red = false;
            int rows = inputTable.getRowCount();
            int c, r = 0, index = 0;
            rowEdit = new int[rmTable.getRowCount()];
        
            for (r = 0; r < rows; r++) {
             
                if(deliveryTable.getValueAt(r,4).toString().isEmpty() || Math.signum(Float.parseFloat(deliveryTable.getValueAt(r,4).toString())) == -1) {
                        submit = false;
                        red = true;
                        deliveryTable.setValueAt(0,r,0);
		}
				
		if(red) {
                    rowEdit[index] = r;
                    index++;
                    red = false;
                }
                
            }
            
            if (submit) {
            
                for (c = 0; c < rows; c++) {
                
                    int ID = Integer.parseInt(deliveryTable.getValueAt(c, 1).toString());
                    RawBean raw = rmImp.getRaw(ID);
                    raw.setStock(Float.parseFloat(deliveryTable.getValueAt(c, 4).toString()));
                    rmImp.editRaw(raw);
                }
                if(getValueXML("Delivery").equals("0")){
                    setValueXML("Delivery");
                    //deliverySubmit.setVisible(false);
                    ViewAllStatus();
                    //BtnNewDay.setEnabled(true);
                }
                
                deliverySuccessLabel.setVisible(true);
                makeDeliveryTable();
            
            }
            else {
		
        	for (int row = 0; row < deliveryTable.getRowCount(); row++) {
                
                    for (int col = 0; col < deliveryTable.getColumnCount(); col++) {
                        
                        deliveryTable.getColumnModel().getColumn(col).setCellRenderer(new errorRenderer());
                            
                    }
                    
                }
			
                deliveryErrorLabel.setVisible(true);
            }
        
        }
        else {
            
            deliveryAbortedLabel.setVisible(true);
     
        }
            
        
    }//GEN-LAST:event_deliverySubmitActionPerformed

    /**
     * < -- CLARK'S FUNCTIONS START -- > *
     */
    public DefaultTableModel initializeTable(){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Status");
        return defaultTableModel;
    }
    
    public void ViewAllStatus(){
       DefaultTableModel defaultModel = initializeTable();
       String eodList[] = new String[4];
       JButton buttonList[] = new JButton[4];
       String text = "";
       eodList[0] = "Actual";
       eodList[1] = "Sales";
       eodList[2] = "Materials";
       eodList[3] = "Delivery";
       buttonList[0] = actualSubmit;
       buttonList[1] = enterSales1;
       buttonList[2] = utwSubmit;
       buttonList[3] = deliverySubmit;
       
       for (int i = 0; i < eodList.length; i++) {
            if(getValueXML(eodList[i]).equals("1")) {
                 text = "Submitted";
                 buttonList[i].setVisible(false);
            } else {
                text = "Not yet submitted";
                buttonList[i].setVisible(true);
            }
            defaultModel.addRow(new Object[] {eodList[i], text});
       }
       
       newdayTable.setModel(defaultModel);
    }
    
    private void nextDay(String curDate) {
        try {
            String filepath = "btf.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);
            
            doc.getElementsByTagName("date").item(0).setTextContent(curDate);
            doc.getElementsByTagName("Delivery").item(0).setTextContent("0");
            doc.getElementsByTagName("Materials").item(0).setTextContent("0");
            doc.getElementsByTagName("Sales").item(0).setTextContent("0");
            doc.getElementsByTagName("Actual").item(0).setTextContent("0");
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
            
            BtnNewDay.setVisible(false);
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
    
    public void setValueXML(String x) {
        try {
            String filepath = "btf.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);
            
            doc.getElementsByTagName(x).item(0).setTextContent("1");
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);            
        } catch (Exception e) {
             e.printStackTrace();
        } 
    }
    
    public void checkDate() {
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = new Date();
            String curDate = dateFormat.format(d) ;
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, +1);
            String nextDate = dateFormat.format(cal.getTime());

            String actual = getValueXML("Actual");

            if(getDateXML().equals(curDate)) {
                if(actual.equals("0")) {
                    BtnNewDay.setVisible(false);
                } else if(actual.equals("1")) {
                    BtnNewDay.setVisible(true);
                }
            } else if(getDateXML().equals(nextDate)) {
                BtnNewDay.setVisible(false);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setNextDayBtn() {
        BtnNewDay.setVisible(true);
    }
    
    /**
     * < -- CLARK'S FUNCTIONS END -- > *
     */
    
    /**
     * < -- KIM'S FUNCTIONS START -- > *
     */
    
    // ------------------- GENERIC CODES
    
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
    
    private boolean isNumber(String s) {
        try {
            
            Float.parseFloat(s);
            return true;
        
        } catch (Exception e) {
            
            return false;
        
        }
    }
    
    public class errorRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (toEdit(row) && Integer.parseInt(table.getValueAt(row, 0).toString()) == 0) {
                
                c.setForeground(Color.red);
                
            }
            else {
                
                c.setForeground(Color.BLACK);
                
            }
            
            return c;
            
        }
        
    }
    
    // CHECK IF ROW INDEX IS IN LIST OF ROW#S WITH ERRORS
    private boolean toEdit(int x) {
        
        boolean edit;
        for (int c = 0; c < rowEdit.length; c++) {
            
            if (x == rowEdit[c]) {
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    // ----------------- ACTUAL TAB START
    
    public void makeActualTable() {
        aTransact = new ArrayList<>();
        aRaw = new ArrayList<>();
        aRaw = rmImp.getAllRaw();
        String cols[] = {"Status", "ID","Name", "Quantity in Stock", "Actual Count"};
        DefaultTableModel actualTable = new DefaultTableModel(cols,0) {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0 || column == 1 || column == 2 || column == 3)
                    return false;
                else
                    return true;
            }
            
        };
        
        for (RawBean raw : aRaw) {
            
            Object[] data = {1, raw.getRawID(), raw.getRaw(), raw.getStock(), ""};
            actualTable.addRow(data);
            inputTable.setModel(actualTable);
            inputTable.getColumnModel().getColumn(0).setMinWidth(0);
            inputTable.getColumnModel().getColumn(0).setMaxWidth(0);
            inputTable.getColumnModel().getColumn(1).setMinWidth(0);
            inputTable.getColumnModel().getColumn(1).setMaxWidth(0);
            adjustTable(inputTable);
        }
        
    }
    
    // ------------------- ACTUAL TAB END
    
    // -------------- MATERIALS TAB START
    
    public void makeRMTable() {
        
        aRaw = rmImp.getAllRaw();
        String cols[] = {"Status", "ID", "Name", "Quantity in Stock", "Used", "Transferred", "Wastage"};
        // MAKE CERTAIN COLUMNS NOT EDITABLE!!!!!
        DefaultTableModel actualTable = new DefaultTableModel(cols,0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0 || column == 1 || column == 2 || column == 3)
                    return false;
                else
                    return true;
            }

            
        };

        for (RawBean raw : aRaw) {
            
            Object[] data = {1,raw.getRawID(), raw.getRaw(), raw.getStock(), "0.00", "0.00", "0.00"};
            actualTable.addRow(data);
            rmTable.setModel(actualTable);
            adjustTable(rmTable);
            // HIDE COLUMNS
            rmTable.getColumnModel().getColumn(0).setMinWidth(0);
            rmTable.getColumnModel().getColumn(0).setMaxWidth(0);
            rmTable.getColumnModel().getColumn(1).setMinWidth(0);
            rmTable.getColumnModel().getColumn(1).setMaxWidth(0);
        
        }
        
    }
    
    // ---------------- MATERIALS TAB END
    
    // --------------- DELIVERY TAB START
    
    public void makeDeliveryTable() {
        aRaw = new ArrayList<RawBean>();
        
        aRaw = rmImp.getAllRaw();
        String cols[] = {"Status","ID","Name", "Quantity in Stock", "Delivered Amount"};
        DefaultTableModel allRaw = new DefaultTableModel(cols, 0) {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0 || column == 1 || column == 2 || column == 3)
                    return false;
                else
                    return true;
            }
            
        };
        
        
        for (RawBean raw : aRaw) {
            
            Object[] data = {1,raw.getRawID(), raw.getRaw(), raw.getStock(), "0.00"};
            allRaw.addRow(data);
            deliveryTable.setModel(allRaw);
            adjustTable(deliveryTable);
            deliveryTable.getColumnModel().getColumn(0).setMinWidth(0);
            deliveryTable.getColumnModel().getColumn(0).setMaxWidth(0);
        
        }
        
        deliveryTable.setColumnSelectionAllowed(true);
        deliveryTable.setRowSelectionAllowed(true);
        deliveryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
    
    // ----------------- DELIVERY TAB END
    
    /**
     * < -- KIM'S FUNCTIONS END -- > *
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton BtnNewDay;
    private javax.swing.JButton CategoriesBtn;
    private javax.swing.JButton EODBtn;
    private javax.swing.JButton InventoryBtn;
    private javax.swing.JButton RMBtn;
    private javax.swing.JButton RecipesBtn;
    private javax.swing.JButton ReportsBtn;
    private javax.swing.JLabel actualAbortedLabel;
    private javax.swing.JLabel actualErrorLabel;
    private javax.swing.JButton actualSubmit;
    private javax.swing.JLabel actualSuccessLabel;
    private javax.swing.JLabel deliveryAbortedLabel;
    private javax.swing.JLabel deliveryErrorLabel;
    private javax.swing.JButton deliverySubmit;
    private javax.swing.JLabel deliverySuccessLabel;
    private javax.swing.JTable deliveryTable;
    private javax.swing.JButton enterSales1;
    private javax.swing.JTable inputTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel materialsAbortedLabel;
    private javax.swing.JLabel materialsErrorLabel;
    private javax.swing.JLabel materialsSuccessLabel;
    private javax.swing.JTable newdayTable;
    private javax.swing.JTable rmTable;
    private javax.swing.JButton utwSubmit;
    // End of variables declaration//GEN-END:variables
}
