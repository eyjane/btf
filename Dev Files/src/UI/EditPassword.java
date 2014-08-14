package UI;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Catherine
 */
public class EditPassword extends javax.swing.JFrame {
private String currentPassword;
    
    //<--- CLARK'S CODE STARTS HERE ---> 
    public EditPassword(String _currentPassword) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        currentPassword = _currentPassword;
    }

    public boolean authenticateCurrentPassword(String _curpassword) {
        boolean flag = false;
        if(currentPassword.equals(_curpassword))
            flag = true;
        return flag;
    }
    
    public boolean authenticateNewPasswords(String _newpassword, String _retype){
        boolean flag = false;
        if(!currentPassword.equals(_newpassword)){
            if(!_newpassword.equals("") || !_retype.equals("")) {
                if(_newpassword.equals(_retype))
                    flag = true;
                else {
                    errorLabel4.setVisible(true);
                }
            } else {
                    errorLabel2.setVisible(true);
                    errorLabel3.setVisible(true);
            }
        } else {
                JOptionPane.showMessageDialog(null, "Your new password cannot be the same as your current password.", "Same Password", JOptionPane.WARNING_MESSAGE);
        }
        return flag;
    }
    
    public void resetFields(){
        curPasswordField.setText("");
        newPasswordField.setText("");
        retypePasswordField.setText("");
    }
    
    //<--- CLARK'S CODE ENDS HERE ---> 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        curPasswordField = new javax.swing.JPasswordField();
        retypePasswordField = new javax.swing.JPasswordField();
        errorLabel4 = new javax.swing.JLabel();
        errorLabel3 = new javax.swing.JLabel();
        errorLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        newPasswordField = new javax.swing.JPasswordField();
        errorLabel2 = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Current Password:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Re-type Password:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/EditPass.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 60));

        curPasswordField.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jPanel1.add(curPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 220, -1));

        retypePasswordField.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jPanel1.add(retypePasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 220, -1));

        errorLabel4.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        errorLabel4.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel4.setText("ERROR: Passwords did not match");
        jPanel1.add(errorLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, -1));

        errorLabel3.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        errorLabel3.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel3.setText("ERROR: Required field");
        jPanel1.add(errorLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, -1, 20));

        errorLabel1.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        errorLabel1.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel1.setText("ERROR: Required field");
        jPanel1.add(errorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("New Password:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        newPasswordField.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jPanel1.add(newPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 220, -1));

        errorLabel2.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        errorLabel2.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel2.setText("ERROR: Required field");
        jPanel1.add(errorLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, 20));

        btnChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/ChangeBtn.png"))); // NOI18N
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });
        jPanel1.add(btnChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 120, 30));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Create Pass BG.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, -1));

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

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        String curpwd = new String(curPasswordField.getPassword());
        String newpwd = new String(newPasswordField.getPassword());
        String retpwd = new String(retypePasswordField.getPassword());
       
        //authenticate password
        if(authenticateCurrentPassword(curpwd) == true){
            if(authenticateNewPasswords(newpwd, retpwd) == true){
                try {
                    String filepath = "btf.xml";
                    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                    Document doc = docBuilder.parse(filepath);
                    doc.getElementsByTagName("loginpwd").item(0).setTextContent(newpwd);
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File(filepath));
                    transformer.transform(source, result);
                    JOptionPane.showMessageDialog(null, "Succesfully changed password!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                        e.printStackTrace();
                } 
                
                try {
                InventoryTab i = new InventoryTab();
                i.setVisible(true);
                dispose();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        } else{
            JOptionPane.showMessageDialog(null, "The password that you have entered is incorrect. "
            + "Please contact the developer in case you forgot your password.", "Incorrect Password", JOptionPane.WARNING_MESSAGE);
            resetFields();
        }
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JPasswordField curPasswordField;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JLabel errorLabel3;
    private javax.swing.JLabel errorLabel4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JPasswordField retypePasswordField;
    // End of variables declaration//GEN-END:variables
}
