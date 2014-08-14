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
 * @author Catherine
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        newPasswordField = new javax.swing.JPasswordField();
        retypePasswordField = new javax.swing.JPasswordField();
        errorLabel2 = new javax.swing.JLabel();
        errorLabel1 = new javax.swing.JLabel();
        btnCreatePassword = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("New Password:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Re-type Password:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Create Password.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 60));

        newPasswordField.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jPanel1.add(newPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 260, -1));

        retypePasswordField.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jPanel1.add(retypePasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 260, -1));

        errorLabel2.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        errorLabel2.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel2.setText("ERROR: Passwords did not match");
        jPanel1.add(errorLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, -1));

        errorLabel1.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        errorLabel1.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel1.setText("ERROR: Required field");
        jPanel1.add(errorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        btnCreatePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/CreateBtn.png"))); // NOI18N
        btnCreatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePasswordActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreatePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 120, 30));

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
                actual.appendChild(doc.createTextNode("0"));
                inputlockdown.appendChild(actual);
                
                Element delivery = doc.createElement("delivery");
                delivery.appendChild(doc.createTextNode("0"));
                inputlockdown.appendChild(delivery);
                
                Element used = doc.createElement("used");
                used.appendChild(doc.createTextNode("0"));
                inputlockdown.appendChild(used);
                
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
            }catch(Exception e){
                e.printStackTrace();
            }
         } 
    }//GEN-LAST:event_btnCreatePasswordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton btnCreatePassword;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JLabel errorLabel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JPasswordField retypePasswordField;
    // End of variables declaration//GEN-END:variables
}
