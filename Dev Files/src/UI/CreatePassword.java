package UI;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @author clarkabalos
 */
public class CreatePassword extends javax.swing.JFrame {
    
    public CreatePassword() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
        initComponents();
        errorLabel1.setVisible(false);
        errorLabel2.setVisible(false);
    }
    
    public boolean authenticateNewPasswords(String _newpassword, String _retype){
        boolean flag = true;
        if(_newpassword.equals("")) {
            errorLabel1.setVisible(true);
            flag = false;
        } else
            errorLabel1.setVisible(false);
        if(_retype.equals("")) {
            errorLabel2.setVisible(true);
            flag = false;
        } else
            errorLabel2.setVisible(false);
        if(!_newpassword.equals(_retype)){
            errorLabel2.setVisible(true);
            flag = false;
        } else
            errorLabel2.setVisible(false);
        return flag;
    }
    
    public void resetFields(){
        newPasswordField.setText("");
        retypePasswordField.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCreatePassword = new javax.swing.JButton();
        retypePasswordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        errorLabel1 = new javax.swing.JLabel();
        errorLabel2 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCreatePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Create Button.png"))); // NOI18N
        btnCreatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePasswordActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreatePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 70, 30));

        retypePasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retypePasswordFieldActionPerformed(evt);
            }
        });
        jPanel1.add(retypePasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 55, 121, -1));

        newPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPasswordFieldActionPerformed(evt);
            }
        });
        jPanel1.add(newPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 15, 121, -1));

        errorLabel1.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        errorLabel1.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel1.setText("ERROR: Required field.");
        jPanel1.add(errorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 36, -1, -1));

        errorLabel2.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        errorLabel2.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel2.setText("ERROR: Passwords did not match.");
        jPanel1.add(errorLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 72, 155, 20));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Create Password_1.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 150));

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

    private void btnCreatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePasswordActionPerformed
        String newpwd = new String(newPasswordField.getPassword());
        String retpwd = new String(retypePasswordField.getPassword());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String curDate = dateFormat.format(d) ;
        
        //authenticate password
        if(authenticateNewPasswords(newpwd, retpwd) == true){
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = dbf.newDocumentBuilder();

                Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("btf");
                doc.appendChild(rootElement);

                Element login = doc.createElement("loginpwd");
                login.appendChild(doc.createTextNode(newpwd));
                rootElement.appendChild(login);
                
                Element inputlockdown = doc.createElement("inputlockdown");
                rootElement.appendChild(inputlockdown);
                
                Element date = doc.createElement("date");
                date.appendChild(doc.createTextNode(curDate));
                inputlockdown.appendChild(date);
                
                Element sales = doc.createElement("sales");
                sales.appendChild(doc.createTextNode("0"));
                inputlockdown.appendChild(sales);
                
                Element actual = doc.createElement("actual");
                sales.appendChild(doc.createTextNode("0"));
                inputlockdown.appendChild(actual);
                
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("btf.xml"));

                transformer.transform(source, result);
                JOptionPane.showMessageDialog(null, "Succesfully added password!", "Success", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("File saved!");

              } catch(Exception e) {
                    e.printStackTrace();
              }
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
            }catch(Exception e){
                e.printStackTrace();
            }
         } 
    }//GEN-LAST:event_btnCreatePasswordActionPerformed

    private void retypePasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retypePasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retypePasswordFieldActionPerformed

    private void newPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPasswordFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btnCreatePassword;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JPasswordField retypePasswordField;
    // End of variables declaration//GEN-END:variables
}
