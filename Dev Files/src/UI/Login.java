package UI;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.swing.JOptionPane;
import DBConnection.DBConnectionFactory;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author clarkabalos
 */
public class Login extends javax.swing.JFrame {
    private String currentPassword;
    private DBConnectionFactory dBConnectionFactory;
    
    public Login() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        
        try {
            File fXmlFile = new File("btf.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            currentPassword = doc.getElementsByTagName("loginpwd").item(0).getTextContent();
            System.out.println("Password : " + currentPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        dBConnectionFactory = DBConnectionFactory.getInstance();
        portNumberField.setText(dBConnectionFactory.getUrl());
        usernameField.setText(dBConnectionFactory.getUsername());
        pwordField.setText(dBConnectionFactory.getPassword());
    }
    
    public boolean authenticate(String _password) {
        boolean flag = false;
        if(currentPassword.equals(_password))
            flag = true;
        return flag;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        passwordField = new javax.swing.JPasswordField();
        portNumberField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        pwordField = new javax.swing.JTextField();
        btnEditPassword = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordFieldKeyReleased(evt);
            }
        });
        jPanel1.add(passwordField);
        passwordField.setBounds(140, 150, 121, 20);
        jPanel1.add(portNumberField);
        portNumberField.setBounds(310, 240, 121, 20);

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(usernameField);
        usernameField.setBounds(310, 270, 121, 20);

        pwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwordFieldActionPerformed(evt);
            }
        });
        jPanel1.add(pwordField);
        pwordField.setBounds(310, 300, 121, 20);

        btnEditPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/change pass btn.png"))); // NOI18N
        btnEditPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditPassword);
        btnEditPassword.setBounds(210, 340, 150, 30);

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/submit btn.png"))); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin);
        btnLogin.setBounds(370, 340, 60, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/login.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 510, 400);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void pwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwordFieldActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String pwd = new String(passwordField.getPassword());
        //authenticate password
        if(authenticate(pwd) == true){
            try {
                EODTab e = new EODTab();
                e.setVisible(true);
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
            //close the user authentication UI
        } else{
            JOptionPane.showMessageDialog(null, "The password that you have entered is incorrect. "
            + "Please contact the developer in case you forgot your password.", "Incorrect Password", JOptionPane.WARNING_MESSAGE);
            passwordField.setText("");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnEditPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPasswordActionPerformed
        try {
            EditPassword ep = new EditPassword(currentPassword);
            ep.setVisible(true);
            dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditPasswordActionPerformed

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                EODTab e = new EODTab();
                e.setVisible(true);
                dispose();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_passwordFieldKeyReleased

    public void LoginUI() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold> */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditPassword;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField portNumberField;
    private javax.swing.JTextField pwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
