package UI;

import Beans.IngredientBean;
import Beans.RawBean;
import Beans.RecipeBean;
import Beans.SalesBean;
import Beans.TransactionBean;
import DAO.Implementation.IngredientDAOImplementation;
import DAO.Implementation.RawDAOImplementation;
import DAO.Implementation.RecipeDAOImplementation;
import DAO.Implementation.SalesDAOImplementation;
import DAO.Implementation.TransactionDAOImplementation;
import DAO.Interface.IngredientDAOInterface;
import DAO.Interface.RawDAOInterface;
import DAO.Interface.RecipeDAOInterface;
import DAO.Interface.SalesDAOInterface;
import DAO.Interface.TransactionDAOInterface;
import java.awt.Color;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
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
import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.COPY_OR_MOVE;
import static javax.swing.TransferHandler.MOVE;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
    private RawDAOInterface rmImp = new RawDAOImplementation();
    private TransactionDAOInterface tclmp = new TransactionDAOImplementation();
    private RecipeDAOInterface rcImp = new RecipeDAOImplementation();
    private IngredientDAOInterface inImp = new IngredientDAOImplementation();
    private SalesDAOInterface tcImp = new SalesDAOImplementation();

    // ARRAYLISTS
    ArrayList<TransactionBean> aTransact;
    ArrayList<RawBean> aRaw;
    private ArrayList<RecipeBean> avRecipes;

    // OTHERS
    private EODTab main;
    private String date;
    private float totalActual = 0;
    private float totalDelivery = 0;
    private float totalUsed = 0;
    private float totalTransfer = 0;
    private float totalWastage = 0;
    private float totalSales = 0;
    private float totalComp = 0;
    public ArrayList<record> oldA = new ArrayList<record>();

    
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
        materialsErrorLabel.setVisible(false);
        deliveryErrorLabel.setVisible(false);
        
        errorLabel.setVisible(false);
        prepareTable();
        checkDate();
        date = getDateXML();
        
        //disable submit
        if(getValueXML("Sales").equals("0")){
            submitSales.setVisible(false);
            errorLabel.setText("SALES REPORT HAS ALREADY BEEN SUBMITTED FOR TODAY (" + getDateXML() + ")");
        }
        
        
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
        actualSubmit = new javax.swing.JButton();
        actualErrorLabel = new javax.swing.JLabel();
        actualTotalLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        submitSales = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable();
        errorLabel = new javax.swing.JLabel();
        salesTotalLabel = new javax.swing.JLabel();
        complimentTotalLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rmTable = new javax.swing.JTable();
        utwSubmit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        materialsErrorLabel = new javax.swing.JLabel();
        usedTotalLabel = new javax.swing.JLabel();
        transferTotalLabel = new javax.swing.JLabel();
        wastageTotalLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        deliveryTable = new javax.swing.JTable();
        deliverySubmit = new javax.swing.JButton();
        deliveryErrorLabel = new javax.swing.JLabel();
        deliveryTotalLabel = new javax.swing.JLabel();
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
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class
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
        jScrollPane4.setViewportView(inputTable);

        actualSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/SubmitBtn.png"))); // NOI18N
        actualSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualSubmitActionPerformed(evt);
            }
        });

        actualErrorLabel.setForeground(new java.awt.Color(204, 0, 1));
        actualErrorLabel.setText("ERROR: Please input valid number.");

        actualTotalLabel.setText("Total: 0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(actualSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(actualErrorLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(actualTotalLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(actualTotalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(actualErrorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actualSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );

        jTabbedPane1.addTab("ACTUAL COUNT", jPanel3);

        submitSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/SubmitBtn.png"))); // NOI18N
        submitSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitSalesActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Quicksand Light", 2, 14)); // NOI18N
        jLabel14.setText("Drag and drop to re-arrange recipes");

        recipeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        recipeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recipeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(recipeTable);

        errorLabel.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel.setText("ERROR: Please input valid number.");

        salesTotalLabel.setText("Sales Total: 0");

        complimentTotalLabel.setText("Compliment Total: 0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(errorLabel)
                                .addGap(90, 90, 90)
                                .addComponent(submitSales, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(salesTotalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(complimentTotalLabel)
                        .addGap(101, 101, 101))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salesTotalLabel)
                    .addComponent(complimentTotalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitSales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel))
                .addContainerGap())
        );

        jTabbedPane1.addTab("SALES", jPanel4);

        rmTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Quantity in Stock", "Used", "Transferred", "Wastage"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
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

        utwSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/SubmitBtn.png"))); // NOI18N
        utwSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utwSubmitActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Quicksand Light", 0, 14)); // NOI18N
        jLabel6.setText("USED/TRANSFERRED/WASTED MATERIALS");

        materialsErrorLabel.setForeground(new java.awt.Color(204, 0, 1));
        materialsErrorLabel.setText("ERROR: Please input valid number.");

        usedTotalLabel.setText("Used Total: 0");

        transferTotalLabel.setText("Transferred Total: 0");

        wastageTotalLabel.setText("Wastage Total: 0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(materialsErrorLabel)
                                .addGap(90, 90, 90))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(usedTotalLabel)
                                .addGap(135, 135, 135)
                                .addComponent(transferTotalLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wastageTotalLabel)
                            .addComponent(utwSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usedTotalLabel)
                    .addComponent(transferTotalLabel)
                    .addComponent(wastageTotalLabel))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(utwSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(materialsErrorLabel))
                .addContainerGap())
        );

        jTabbedPane1.addTab("MATERIALS", jPanel5);

        jLabel3.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jLabel3.setText("Raw Materials");

        deliveryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
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

        deliveryErrorLabel.setForeground(new java.awt.Color(204, 0, 1));
        deliveryErrorLabel.setText("ERROR: Please input valid number.");

        deliveryTotalLabel.setText("Total: 0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deliveryErrorLabel)
                        .addGap(89, 89, 89)
                        .addComponent(deliverySubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 461, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(deliveryTotalLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(deliveryTotalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deliverySubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deliveryErrorLabel))
                .addContainerGap())
        );

        jTabbedPane1.addTab("DELIVERY", jPanel2);

        newdayTable.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
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
                .addContainerGap(134, Short.MAX_VALUE))
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
            rm.
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

    private void submitSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSalesActionPerformed
        int rcount = recipeTable.getRowCount();
        int i, j;

        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this recipe?", "Confirm Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            for (i = 0; i < rcount; i++) {
                SalesBean sbean = new SalesBean();
                SalesBean cbean = new SalesBean();
                float total = 0;
                float d;
                float a;
                ArrayList<IngredientBean> ingredients = new ArrayList<IngredientBean>();
                int rID = Integer.parseInt(recipeTable.getModel().getValueAt(i, 0).toString());
                float sales = Float.parseFloat(recipeTable.getModel().getValueAt(i, 2).toString());
                float compliment = Float.parseFloat(recipeTable.getModel().getValueAt(i, 3).toString());

                RecipeBean rbean = rcImp.getRecipeBean(rID);

                //add sales
                sbean.setOrder(i + 1);
                sbean.setType("sales");
                tcImp.addSales(sbean, rbean, sales);

                //add compliment
                cbean.setOrder(i + 1);
                cbean.setType("complimentary");
                tcImp.addSales(cbean, rbean, compliment, date);

                //update rm stocks
                total = sales + compliment;
                ingredients = rbean.getIngredients();
                for (j = 0; j < ingredients.size(); j++) {
                    d = 0;
                    a = 0;
                    RawBean rwbean = new RawBean();
                    rwbean = ingredients.get(j).getRaw();
                    a = rwbean.getStock(); //original stock
                    d = ingredients.get(j).getAmount() * total; //to be deducted
                    a -= d;
                    rwbean.setStock(a);
                    rmImp.editRaw(rwbean);
                }

            }
            /*if (inputLockDown()) {
                submitSales.setVisible(false);
            }*/
            //this.setVisible(false);
            //main.setVisible(true);

        } else {
            return;
        }
    }//GEN-LAST:event_submitSalesActionPerformed

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
            String curDate = dateFormat.format(d);
            Calendar cal1 = Calendar.getInstance();
            cal1.add(Calendar.DATE, +1);
            String nextDate = dateFormat.format(cal1.getTime());

            if (getDateXML().equals(curDate)) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you're done for the day?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    nextDay(nextDate);
                    JOptionPane.showMessageDialog(null, "Tomorrow's date is " + nextDate, "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (!getDateXML().equals(nextDate) && !getDateXML().equals(curDate)) {
                nextDay(curDate);
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
            int rows = inputTable.getRowCount();
            int r = 0, index = 0;

            for (r = 0; r < rows; r++) {

                if (inputTable.getValueAt(r, 3).toString().isEmpty() || Math.signum(Float.parseFloat(inputTable.getValueAt(r, 3).toString())) == -1) {
                    submit = false;
                }

            }

            if (submit) {

                for (r = 0; r < rows; r++) {

                    int ID = Integer.parseInt(inputTable.getValueAt(r, 0).toString());
                    RawBean raw = rmImp.getRaw(ID);
                    float newRaw = Float.parseFloat(inputTable.getValueAt(r, 2).toString()) + Float.parseFloat(inputTable.getValueAt(r, 3).toString());
                    raw.setStock(newRaw);
                    rmImp.editRaw(raw);

                }

                /*
                 if(inputLockDown()){
                 actualSubmit.setVisible(false);
                 main.setNextDayBtn();
                 }*/
                JOptionPane.showMessageDialog(null, "Submission was successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                makeActualTable();
            } else {

                actualErrorLabel.setVisible(true);

            }
        } else {

            return;
        }

    }//GEN-LAST:event_actualSubmitActionPerformed

    private void utwSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utwSubmitActionPerformed
        // TODO add your handling code here:

        if (JOptionPane.showConfirmDialog(null, "Are you sure that you want to submit? You may only submit once a day.", "Confirm Submit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            boolean submit = true;
            int rows = rmTable.getRowCount();
            int r = 0, index = 0;

            while (r < rows) {

                for (int d = 3; d <= 5; d++) {

                    if (rmTable.getValueAt(r, d).toString().isEmpty() || Math.signum(Float.parseFloat(rmTable.getValueAt(r, d).toString())) == -1) {
                        submit = false;
                    }

                }

                r++;

            }

            if (submit) {

                for (int a = 0; a < rows; a++) {

                    for (int b = 3; b <= 5; b++) {

                        RawBean raw = new RawBean();

                        String name = rmTable.getValueAt(a, 1).toString(); // raw material name
                        float q = Float.parseFloat(rmTable.getValueAt(a, b).toString());
                        String type = new String();

                        if (b == 3) {
                            type = "used";
                        } else if (b == 4) {
                            type = "transfer";
                        } else if (b == 5) {
                            type = "wastage";
                        }

                        // REDUCE FROM RAW TABLE
                        float s = rmImp.getStock(type);
                        float deduct = s - q;
                        rmImp.updateStock(name, deduct);

                        // ADD TRANSACTION
                        TransactionBean t = new TransactionBean();
                        t.setType(type);
                        int id = Integer.parseInt(rmTable.getValueAt(a, 0).toString());
                        raw.setRawID(id);
                        tclmp.addTransaction(t, raw, q);
                    }
                }
                /*if(inputLockDown()){
                 utwSubmit.setVisible(false);
                 }*/
                JOptionPane.showMessageDialog(null, "Submission was successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                makeRMTable();
            } else {

                materialsErrorLabel.setVisible(true);
            }
        } else {

            return;
        }

    }//GEN-LAST:event_utwSubmitActionPerformed

    private void deliverySubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliverySubmitActionPerformed
        // TODO add your handling code here:

        if (JOptionPane.showConfirmDialog(null, "Are you sure that you want to submit? You may only submit once a day.", "Confirm Submit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            boolean submit = true;
            int rows = inputTable.getRowCount();
            int c, r = 0;

            for (r = 0; r < rows; r++) {

                if (deliveryTable.getValueAt(r, 3).toString().isEmpty() || Math.signum(Float.parseFloat(deliveryTable.getValueAt(r, 3).toString())) == -1) {
                    submit = false;
                }

            }

            if (submit) {

                for (c = 0; c < rows; c++) {

                    int ID = Integer.parseInt(deliveryTable.getValueAt(c, 0).toString());
                    RawBean raw = rmImp.getRaw(ID);
                    raw.setStock(Float.parseFloat(deliveryTable.getValueAt(c, 3).toString()));
                    rmImp.editRaw(raw);
                }

                JOptionPane.showMessageDialog(null, "Submission was successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                makeDeliveryTable();

            } else {

                deliveryErrorLabel.setVisible(true);
            
            }

        } else {

            return;
            
        }


    }//GEN-LAST:event_deliverySubmitActionPerformed

    private void recipeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recipeTableMouseClicked
        try {
            int rselect = recipeTable.getSelectedRow();

            //recipeIDLabel.setText(String.valueOf(r.getRecipeID()));
            //CategoryBean ct = (CategoryBean)categoryBox.getSelectedItem();
            //System.out.println("SELECTED " + ct.getCategoryID());
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_recipeTableMouseClicked

    /**
     * < -- CLARK'S FUNCTIONS START -- > *
     */
    public DefaultTableModel initializeTable() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Status");
        return defaultTableModel;
    }

    public void ViewAllStatus() {
        DefaultTableModel defaultModel = initializeTable();
        String eodList[] = new String[4];
        String text = "";
        eodList[0] = "Actual";
        eodList[1] = "Sales";
        eodList[2] = "Materials";
        eodList[3] = "Delivery";

        for (int i = 0; i < eodList.length; i++) {
            if (getValueXML(eodList[i]).equals("1")) {
                text = "Submitted";
            } else {
                text = "Not yet submitted";
            }
            defaultModel.addRow(new Object[]{eodList[i], text});
        }

        newdayTable.setModel(defaultModel);
    }

    private void nextDay(String curDate) {
        try {
            String filepath = "btf.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            doc.getElementsByTagName("Delivery").item(0).setTextContent("0");
            doc.getElementsByTagName("Materials").item(0).setTextContent("0");
            doc.getElementsByTagName("Sales").item(0).setTextContent("0");
            doc.getElementsByTagName("Actual").item(0).setTextContent("0");

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

            BtnNewDay.setEnabled(false);
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
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = new Date();
            String curDate = dateFormat.format(d);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, +1);
            String nextDate = dateFormat.format(cal.getTime());

            String actual = getValueXML("Actual");

            if (getDateXML().equals(curDate)) {
                if (actual.equals("0")) {
                    BtnNewDay.setVisible(false);
                } else if (actual.equals("1")) {
                    BtnNewDay.setVisible(true);
                }
            } else if (getDateXML().equals(nextDate)) {
                BtnNewDay.setVisible(false);
            }
        } catch (Exception e) {
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
    
    public class record {
        
        public String type;
        public int row;
        public float x;
        
        public record() {}
        
        public record(String newType, int newRow, int oldValue) {
            type = newType;
            row = newRow;
            x = oldValue;
        }
        
        public String getType() {
            return type;
        }
        
        public int getRow() {
            return row;
        }
        
        public float getX() {
            return x;
        }
        
        public void setType(String newType) {
            this.type = newType;
        }
        
        public void setRow(int newRow) {
            this.row = newRow;
        }
        
        public void setX(float oldValue) {
            this.x = oldValue;
        }
        
        public float findOld(String newType, int newRow) {
            
            for (record d : oldA) {
                
                if(d.getRow() == newRow && d.getType() == newType)
                    return d.getX();
            }
            return 0;
        }
        
        public void replaceOld(String newType, int newRow, float newVal) {
            
            for (record d : oldA) {
                
                if(d.getRow() == newRow && d.getType() == newType)
                    d.setX(newVal);
            }
            
        }
        
    }
    
    public class checkActual implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent tme) {
            
            int row = tme.getFirstRow();
            int column = tme.getColumn();
            DefaultTableModel model = (DefaultTableModel)tme.getSource();
            Object data = model.getValueAt(row, column);
            
            if(previouslyChanged("actual", row)) {
                record old = new record();
                totalActual = totalActual - old.findOld("actual",row);
                totalActual = totalActual + Float.parseFloat(model.getValueAt(row, column).toString());
                getActualTotal(totalActual);
                old.replaceOld("actual", row, Float.parseFloat(model.getValueAt(row, column).toString()));
            }
            else {
                record old = new record();
                old.setType("actual");
                old.setRow(row);
                old.setX(Float.parseFloat(model.getValueAt(row, column).toString()));
                oldA.add(old);
                totalActual = totalActual + Float.parseFloat(model.getValueAt(row, column).toString());
                getActualTotal(totalActual);
            }
            

        }
        
    }
    
    public void getActualTotal(float add) {
        
        this.actualTotalLabel.setText("Total: " + add);
        
    }
    
    public class checkMaterials implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent tme) {
            String u = "used";
            String w = "waste";
            String t = "transfer";
            int row = tme.getFirstRow();
            int column = tme.getColumn();
            DefaultTableModel model = (DefaultTableModel)tme.getSource();
            Object data = model.getValueAt(row, column);
            if (column == 3) {
                
                if(previouslyChanged(u, row)) {
                    record old = new record();
                    totalUsed = totalUsed - old.findOld(u,row);
                    totalUsed = totalUsed + Float.parseFloat(model.getValueAt(row, column).toString());
                    getMaterialsTotal(totalUsed,column);
                    old.replaceOld(u, row, Float.parseFloat(model.getValueAt(row, column).toString()));
                }
                else {
                    record old = new record();
                    old.setType(u);
                    old.setRow(row);
                    old.setX(Float.parseFloat(model.getValueAt(row, column).toString()));
                    oldA.add(old);
                    totalUsed = totalUsed + Float.parseFloat(model.getValueAt(row, column).toString());
                    getMaterialsTotal(totalUsed, column);
                }
            }
                
            else if (column == 4) {
                
                if(previouslyChanged(t, row)) {
                    record old = new record();
                    totalTransfer = totalTransfer - old.findOld(t,row);
                    totalTransfer = totalTransfer + Float.parseFloat(model.getValueAt(row, column).toString());
                    getMaterialsTotal(totalTransfer,column);
                    old.replaceOld(t, row, Float.parseFloat(model.getValueAt(row, column).toString()));
                }
                else {
                    record old = new record();
                    old.setType(t);
                    old.setRow(row);
                    old.setX(Float.parseFloat(model.getValueAt(row, column).toString()));
                    oldA.add(old);
                    totalTransfer = totalTransfer + Float.parseFloat(model.getValueAt(row, column).toString());
                    getMaterialsTotal(totalTransfer, column);
                }
                
            }
            else if(column == 5) {
                
                if(previouslyChanged(w, row)) {
                    record old = new record();
                    totalWastage = totalWastage - old.findOld(w,row);
                    totalWastage = totalWastage + Float.parseFloat(model.getValueAt(row, column).toString());
                    getMaterialsTotal(totalWastage,column);
                    old.replaceOld(w, row, Float.parseFloat(model.getValueAt(row, column).toString()));
                }
                else {
                    record old = new record();
                    old.setType(w);
                    old.setRow(row);
                    old.setX(Float.parseFloat(model.getValueAt(row, column).toString()));
                    oldA.add(old);
                    totalWastage = totalWastage + Float.parseFloat(model.getValueAt(row, column).toString());
                    getMaterialsTotal(totalWastage, column);
                }
                
            }
            
        }
        
    }
    
    public void getMaterialsTotal(float add, int type) {
        if (type == 3)
            this.usedTotalLabel.setText("Used Total: " + add);
        else if (type == 4)
            this.transferTotalLabel.setText("Transferred Total: " + add);
        else if (type == 5)
            this.wastageTotalLabel.setText("Wastage Total: " + add);
    }
    
    public class checkDelivery implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent tme) {
            String t = "delivery";
            int row = tme.getFirstRow();
            int column = tme.getColumn();
            DefaultTableModel model = (DefaultTableModel)tme.getSource();
            Object data = model.getValueAt(row, column);
            
            if(previouslyChanged(t, row)) {
                record old = new record();
                totalDelivery = totalDelivery - old.findOld(t,row);
                totalDelivery = totalDelivery + Float.parseFloat(model.getValueAt(row, column).toString());
                getDeliveryTotal(totalDelivery);
                old.replaceOld(t, row, Float.parseFloat(model.getValueAt(row, column).toString()));
            }
            else {
                record old = new record();
                old.setType(t);
                old.setRow(row);
                old.setX(Float.parseFloat(model.getValueAt(row, column).toString()));
                oldA.add(old);
                totalDelivery = totalDelivery + Float.parseFloat(model.getValueAt(row, column).toString());
                getDeliveryTotal(totalDelivery);
            }
        }
        
    }
    
    public void getDeliveryTotal(float add) {
        
        this.deliveryTotalLabel.setText("Total: " + add);
        
    }
    
    public class checkSales implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent tme) {
            String s = "sales";
            String comp = "compliment";
            int row = tme.getFirstRow();
            int column = tme.getColumn();
            DefaultTableModel model = (DefaultTableModel)tme.getSource();
            Object data = model.getValueAt(row, column);
            if (column == 2) {
                
                if(previouslyChanged(s, row)) {
                    record old = new record();
                    totalSales = totalSales - old.findOld(s,row);
                    totalSales = totalSales + Float.parseFloat(model.getValueAt(row, column).toString());
                    getSalesTotal(totalSales,column);
                    old.replaceOld(s, row, Float.parseFloat(model.getValueAt(row, column).toString()));
                }
                else {
                    record old = new record();
                    old.setType(s);
                    old.setRow(row);
                    old.setX(Float.parseFloat(model.getValueAt(row, column).toString()));
                    oldA.add(old);
                    totalSales = totalSales + Float.parseFloat(model.getValueAt(row, column).toString());
                    getSalesTotal(totalSales, column);
                }
                
            }
                
            else if (column == 3) {
                
                if(previouslyChanged(comp, row)) {
                    record old = new record();
                    totalComp = totalComp - old.findOld(comp,row);
                    totalComp = totalComp + Float.parseFloat(model.getValueAt(row, column).toString());
                    getSalesTotal(totalComp,column);
                    old.replaceOld(comp, row, Float.parseFloat(model.getValueAt(row, column).toString()));
                }
                else {
                    record old = new record();
                    old.setType(comp);
                    old.setRow(row);
                    old.setX(Float.parseFloat(model.getValueAt(row, column).toString()));
                    oldA.add(old);
                    totalComp = totalComp + Float.parseFloat(model.getValueAt(row, column).toString());
                    getSalesTotal(totalComp, column);
                }
                
            }
            
        }
        
    }
    
    public void getSalesTotal(float add, int type) {
        if (type == 2)
            this.salesTotalLabel.setText("Sales Total: " + add);
        else if (type == 3)
            this.complimentTotalLabel.setText("Complimentary Total: " + add);
        
    }
    
    public boolean previouslyChanged(String t, int c) {
        
        if (oldA.isEmpty())
            return false;
        else {
            
            for (record d : oldA) {
                
                if(d.getType() == t && d.getRow() == c)
                    return true;
            }
            
        }
        return false;
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

    private boolean isNumber(String s) {
        try {

            Float.parseFloat(s);
            return true;

        } catch (Exception e) {

            return false;

        }
    }

    // ----------------- ACTUAL TAB START
    public void makeActualTable() {
        aTransact = new ArrayList<>();
        aRaw = new ArrayList<>();
        aRaw = rmImp.getAllRaw();
        String cols[] = {"ID", "Name", "Quantity in Stock", "Actual Count"};
        DefaultTableModel actualTable = new DefaultTableModel(cols, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1 || column == 2) {
                    return false;
                } else {
                    return true;
                }
            }

        };
        
        for (RawBean raw : aRaw) {

            Object[] data = {raw.getRawID(), raw.getRaw(), raw.getStock(), "0"};
            actualTable.addRow(data);
            inputTable.setModel(actualTable);
            adjustTable(inputTable);
        }
        inputTable.getColumnModel().getColumn(0).setMinWidth(0);
        inputTable.getColumnModel().getColumn(0).setMaxWidth(0);
        inputTable.setColumnSelectionAllowed(true);
        inputTable.setRowSelectionAllowed(true);
        inputTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
        DefaultCellEditor deditor = new myChecker(new JTextField(), actualErrorLabel);
        inputTable.setDefaultEditor(Object.class, deditor);
        deditor.setClickCountToStart(1);
        actualTable.addTableModelListener(new checkActual());
    
    }

    // ------------------- ACTUAL TAB END
    
    // -------------- MATERIALS TAB START
    public void makeRMTable() {

        aRaw = rmImp.getAllRaw();
        String cols[] = {"ID", "Name", "Quantity in Stock", "Used", "Transferred", "Wastage"};
        // MAKE CERTAIN COLUMNS NOT EDITABLE!!!!!
        DefaultTableModel actualTable = new DefaultTableModel(cols, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1 || column == 2) {
                    return false;
                } else {
                    return true;
                }
            }

        };

        for (RawBean raw : aRaw) {

            Object[] data = {raw.getRawID(), raw.getRaw(), raw.getStock(), "0", "0", "0"};
            actualTable.addRow(data);
            rmTable.setModel(actualTable);
            adjustTable(rmTable);
            
        }
		
        rmTable.getColumnModel().getColumn(0).setMinWidth(0);
        rmTable.getColumnModel().getColumn(0).setMaxWidth(0);
	rmTable.setColumnSelectionAllowed(true);
        rmTable.setRowSelectionAllowed(true);
        rmTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
        DefaultCellEditor deditor = new myChecker(new JTextField(), materialsErrorLabel);
        rmTable.setDefaultEditor(Object.class, deditor);
        deditor.setClickCountToStart(1);
        actualTable.addTableModelListener(new checkMaterials());
    }

    // ---------------- MATERIALS TAB END
    
    // --------------- DELIVERY TAB START
    public void makeDeliveryTable() {
        aRaw = new ArrayList<RawBean>();

        aRaw = rmImp.getAllRaw();
        String cols[] = {"ID", "Name", "Quantity in Stock", "Delivered Amount"};
        DefaultTableModel allRaw = new DefaultTableModel(cols, 0) {
        
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1 || column == 2) {
                    return false;
                } else {
                    return true;
                }
            }

        };

        for (RawBean raw : aRaw) {

            Object[] data = {raw.getRawID(), raw.getRaw(), raw.getStock(), "0"};
            allRaw.addRow(data);
            deliveryTable.setModel(allRaw);
            adjustTable(deliveryTable);

        }

        deliveryTable.getColumnModel().getColumn(0).setMinWidth(0);
        deliveryTable.getColumnModel().getColumn(0).setMaxWidth(0);
        deliveryTable.setColumnSelectionAllowed(true);
        deliveryTable.setRowSelectionAllowed(true);
        deliveryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        DefaultCellEditor deditor = new myChecker(new JTextField(), deliveryErrorLabel);
        deliveryTable.setDefaultEditor(Object.class, deditor);
        deditor.setClickCountToStart(1);
        allRaw.addTableModelListener(new checkDelivery());
    }

    // ----------------- DELIVERY TAB END
    /**
     * < -- KIM'S FUNCTIONS END -- > *
     */
    /**
     * * <--- JANE CODE START ---> **
     */
    
    public void prepareTable() {
        avRecipes = new ArrayList<RecipeBean>();

        String rCategory = null;
        int i, j;

        avRecipes = rcImp.getRecipeByStatus("available");

        String cols[] = {"Recipe ID", "Recipe", "Sales", "Compliment"};
        DefaultTableModel recipeModel = new DefaultTableModel(cols, 0);
        //System.out.println(avRecipes.get(1).getRecipe());

        for (RecipeBean r : avRecipes) {
            Object[] data = {r.getRecipeID(), r.getRecipe(), "0", "0"};
            recipeModel.addRow(data);
        }

        recipeTable.setModel(recipeModel);
        recipeTable.getColumnModel().getColumn(0).setMinWidth(0);
        recipeTable.getColumnModel().getColumn(0).setMaxWidth(0);

        recipeTable.setDragEnabled(true);
        recipeTable.setTransferHandler(new TableTransferHandler());
        adjustTable(recipeTable);

        /**
         * * <--- KIM PLS NOTE: THIS HOW TO APPLY THE MYCHECKER TO YOUR TABLE..
         * errorLabel = JLabel for displaying error ---> **
         */
        /* KAHIT ONE ERROR LABEL NA LANG THAT SAYS: ERROR: Please enter valid number. */
        DefaultCellEditor deditor = new myChecker(new JTextField(), errorLabel);
        recipeTable.setDefaultEditor(Object.class, deditor);
        /**
         * * <--- KIM PLS NOTE ENDS HERE ---> **
         */
        /* ONE CLICK EDIT */
        deditor.setClickCountToStart(1);
        recipeModel.addTableModelListener(new checkSales());
    }
    
    /**
     * <--- KIM PLS NOTE: COPY THIS WHOLE THING FOR THE ERROR CHECKING ---> **
     */
    private static class myChecker extends DefaultCellEditor {

        private static final Border red = new LineBorder(Color.red);
        private static final Border black = new LineBorder(Color.black);
        private JTextField textField;
        private JLabel eLabel;

        public myChecker(JTextField textField, JLabel e) {
            super(textField);
            this.textField = textField;
            this.textField.setHorizontalAlignment(JTextField.RIGHT);
            eLabel = e;
        }

        @Override
        public boolean stopCellEditing() {
            try {
                float v = Float.parseFloat(textField.getText());
                if (v < 0) {
                    throw new NumberFormatException();
                }
                textField.setText(String.format("%.02f", v));
                eLabel.setText("ERROR: Required field. Please input valid number.");
                eLabel.setVisible(false);
            } catch (NumberFormatException e) {
                textField.setBorder(red);
                eLabel.setText("ERROR: Required field. Please input valid number.");
                eLabel.setVisible(true);
                return false;
            }
            return super.stopCellEditing();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table,
                Object value, boolean isSelected, int row, int column) {
            textField.setBorder(black);
            return super.getTableCellEditorComponent(
                    table, value, isSelected, row, column);
        }

    }

    /**
     * <--- KIM PLS NOTE: COPY THIS WHOLE THING FOR THE ERROR CHECKING ---> **
     */
    
    abstract class StringTransferHandler extends TransferHandler {

        protected abstract String exportString(JComponent c);

        protected abstract void importString(JComponent c, String str);

        protected abstract void cleanup(JComponent c, boolean remove);

        protected Transferable createTransferable(JComponent c) {
            return new StringSelection(exportString(c));
        }

        public int getSourceActions(JComponent c) {
            return COPY_OR_MOVE;
        }

        public boolean importData(JComponent c, Transferable t) {
            if (canImport(c, t.getTransferDataFlavors())) {
                try {
                    String str = (String) t
                            .getTransferData(DataFlavor.stringFlavor);
                    importString(c, str);
                    return true;
                } catch (UnsupportedFlavorException ufe) {
                } catch (IOException ioe) {
                }
            }

            return false;
        }

        protected void exportDone(JComponent c, Transferable data, int action) {
            cleanup(c, action == MOVE);
        }

        public boolean canImport(JComponent c, DataFlavor[] flavors) {
            for (int i = 0; i < flavors.length; i++) {
                if (DataFlavor.stringFlavor.equals(flavors[i])) {
                    return true;
                }
            }
            return false;
        }
    }

    /*
     * TableTransferHandler.java is used by the 1.4 ExtendedDnDDemo.java example.
     */
    class TableTransferHandler extends StringTransferHandler {

        private int[] rows = null;

        private int addIndex = -1; //Location where items were added

        private int addCount = 0; //Number of items added.

        protected String exportString(JComponent c) {
            //System.out.println("export");
            JTable table = (JTable) c;
            rows = table.getSelectedRows();
            int colCount = table.getColumnCount();

            StringBuffer buff = new StringBuffer();

            for (int i = 0; i < rows.length; i++) {
                for (int j = 0; j < colCount; j++) {
                    Object val = table.getValueAt(rows[i], j);
                    buff.append(val == null ? "" : val.toString());
                    if (j != colCount - 1) {
                        buff.append(",");
                    }
                }
                if (i != rows.length - 1) {
                    buff.append("\n");
                }
            }
            System.out.println(rows[0]);

            return buff.toString();
        }

        protected void importString(JComponent c, String str) {
            //System.out.println("import");
            JTable target = (JTable) c;
            DefaultTableModel model = (DefaultTableModel) target.getModel();
            int index = target.getSelectedRow();

            //Prevent the user from dropping data back on itself.
            //For example, if the user is moving rows #4,#5,#6 and #7 and
            //attempts to insert the rows after row #5, this would
            //be problematic when removing the original rows.
            //So this is not allowed.
            if (rows != null && index >= rows[0] - 1
                    && index <= rows[rows.length - 1] & rows.length != 1) {
                int x = rows[0] - 1;
                int y = rows[rows.length - 1];
                /*System.out.println("index (target row) = " + index);
                 System.out.println("rows[0] (source row) = " + rows[0]);
                 System.out.println("x = " + x);
                 System.out.println("y = " + y);
                 System.out.println("NOT ALLOWED");*/
                System.out.println();
                rows = null;
                return;
            }

            int max = model.getRowCount();
            if (index < 0) {
                index = max;
            } else {
                index++;
                if (index > max) {
                    index = max;
                }
            }
            addIndex = index;
            //System.out.println(index);
            String[] values = str.split("\n");
            addCount = values.length;
            int colCount = target.getColumnCount();
            for (int i = 0; i < values.length && i < colCount; i++) {
                model.insertRow(index++, values[i].split(","));

            }
        }

        protected void cleanup(JComponent c, boolean remove) {

            //System.out.println("clean");
            JTable source = (JTable) c;
            if (remove && rows != null) {
                DefaultTableModel model = (DefaultTableModel) source.getModel();

                //If we are moving items around in the same table, we
                //need to adjust the rows accordingly, since those
                //after the insertion point have moved.
                if (addCount > 0) {
                    for (int i = 0; i < rows.length; i++) {
                        if (rows[i] >= addIndex) {
                            rows[i] += addCount;
                        }
                    }
                }

                for (int i = rows.length - 1; i >= 0; i--) {
                    model.removeRow(rows[i]);

                }

            }
            rows = null;
            addCount = 0;
            addIndex = -1;
        }
    }
    
    /**
     * * <--- JANE CODE END ---> **
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
    private javax.swing.JLabel actualErrorLabel;
    private javax.swing.JButton actualSubmit;
    private javax.swing.JLabel actualTotalLabel;
    private javax.swing.JLabel complimentTotalLabel;
    private javax.swing.JLabel deliveryErrorLabel;
    private javax.swing.JButton deliverySubmit;
    private javax.swing.JTable deliveryTable;
    private javax.swing.JLabel deliveryTotalLabel;
    private javax.swing.JLabel errorLabel;
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
    private javax.swing.JLabel materialsErrorLabel;
    private javax.swing.JTable newdayTable;
    private javax.swing.JTable recipeTable;
    private javax.swing.JTable rmTable;
    private javax.swing.JLabel salesTotalLabel;
    private javax.swing.JButton submitSales;
    private javax.swing.JLabel transferTotalLabel;
    private javax.swing.JLabel usedTotalLabel;
    private javax.swing.JButton utwSubmit;
    private javax.swing.JLabel wastageTotalLabel;
    // End of variables declaration//GEN-END:variables
}
