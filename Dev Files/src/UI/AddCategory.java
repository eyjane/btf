package UI;

import Beans.CategoryBean;
import DAO.Implementation.CategoryDAOImplementation;
import DAO.Interface.CategoryDAOInterface;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Evy
 */
public class AddCategory extends javax.swing.JFrame {
    private CategoryDAOInterface ctImp = new CategoryDAOImplementation();
    private CategoryManagement cm;
    private CategoryBean cat;

    //<--- CLARK'S CODE STARTS HERE --->
    
    public AddCategory(CategoryManagement c) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        cm = c;
        prepareTable();
        errorLabel1.setVisible(false);
        errorLabel2.setVisible(false);
        
    }
    
    public void prepareTable(){
        categoryTable.setModel(cm.getCMTable());
        categoryTable.getColumnModel().getColumn(0).setMinWidth(0);
        categoryTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
    public boolean authenticateCategory(){
        boolean flag = true;
        ArrayList<CategoryBean> c = ctImp.getAllCategory();
        cat = new CategoryBean();
        if(nameField.getText().equals("")) {
            errorLabel1.setVisible(true);
            flag = false;
        }
        else {
            cat.setCategory(nameField.getText());
            errorLabel1.setVisible(false);
            errorLabel2.setVisible(false);
            for(int i = 0; i < c.size(); i++){
                if(nameField.getText().equalsIgnoreCase(c.get(i).getCategory())) {
                    errorLabel1.setVisible(true);
                    errorLabel2.setVisible(true);
                    flag = false;
                } 
            }
        }
        return flag;
    }
    
    public String getCategory(){
        return nameField.getText();
    }
    
    private boolean isNumber(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    //<--- CLARK'S CODE ENDS HERE --->
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        errorLabel1 = new javax.swing.JLabel();
        btnAddCategory = new javax.swing.JButton();
        errorLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(956, 555));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Category Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 102, 102)));
        jPanel2.setPreferredSize(new java.awt.Dimension(956, 555));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Name:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameFieldKeyReleased(evt);
            }
        });
        jPanel2.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 125, -1));

        errorLabel1.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel1.setText("ERROR: Required field.");
        jPanel2.add(errorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        btnAddCategory.setText("Add Category");
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        errorLabel2.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel2.setText("Duplicate name exists.");
        jPanel2.add(errorLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
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
        categoryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(categoryTable);
        categoryTable.getColumnModel().getColumn(0).setResizable(false);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel9.setText("CATEGORY");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel10.setText("ADD A CATEGORY");

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10)
                    .addComponent(btnBack))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        if(authenticateCategory()){
            try{
                ctImp.addCategory(cat);
                cat.setCategoryID(ctImp.getLatestAddedID());
                
                JOptionPane.showMessageDialog(null, "Successfully added a new category!", "Success", JOptionPane.INFORMATION_MESSAGE);
                cm.setVisible(true);
                cm.ViewAllCategories();
                dispose();
            } catch(Exception err){
                err.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       cm.setVisible(true);
       dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyReleased
        authenticateCategory();
    }//GEN-LAST:event_nameFieldKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnBack;
    private javax.swing.JTable categoryTable;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    // End of variables declaration//GEN-END:variables
}
