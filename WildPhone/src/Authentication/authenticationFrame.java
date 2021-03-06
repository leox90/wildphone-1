package Authentication;

import HomeUser.HomeUser;
import javax.swing.JOptionPane;
import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;


public class authenticationFrame extends javax.swing.JFrame {

    /** Creates new form authenticationFrame */
    public authenticationFrame() {
        
        initComponents();        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        usernameField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        pswLabel = new javax.swing.JLabel();
        pswField = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginButton.setText("Accedi");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setText("Registrati");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        usernameLabel.setText("Username:");

        pswLabel.setText("Password:");

        jMenu1.setText("File");

        exit.setText("Esci");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(loginButton)
                        .addGap(36, 36, 36)
                        .addComponent(registerButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pswLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pswField)
                            .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pswField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(pswLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton)
                    .addComponent(loginButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        
        String username;
        String psw;
        
        username = usernameField.getText();
        psw = String.copyValueOf(pswField.getPassword());
        
        if((username.compareTo("") != 0) && (psw.compareTo("") != 0)){
            
            try{
                
                login(username,psw);
            
            }
            catch(XMPPException ex){
                JOptionPane.showMessageDialog(null, "Errore di connessione: " + ex.getMessage(), "WildPhone", JOptionPane.ERROR_MESSAGE);
            }
            catch(InterruptedException ex){
                JOptionPane.showMessageDialog(null, "Errore: " + ex.getMessage(), "WildPhone", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        String username;
        String psw;
        
        username = usernameField.getText();
        psw = String.copyValueOf(pswField.getPassword());

        if((username.compareTo("") != 0) && (psw.compareTo("") != 0)){
            try{
                this.xmppConnection = new XMPPConnection(server);
                this.xmppConnection.connect();
                AccountManager accManager = this.xmppConnection.getAccountManager();
                accManager.createAccount(username, psw);
                JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo!!\nAdesso puoi utilizzare le credenziali scelte per accedere a WildPhone.", "WildPhone", JOptionPane.INFORMATION_MESSAGE);
                }
            catch(XMPPException ex){
                JOptionPane.showMessageDialog(null, "Errore durante la registrazione: " + ex, "WildPhone", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

   
    private void login(String username,String psw) throws XMPPException, InterruptedException{
        try{
            this.xmppConnection = new XMPPConnection(server);
            this.xmppConnection.connect();
            this.xmppConnection.login(username, psw);
            new HomeUser(this.xmppConnection).setVisible(true);
            this.dispose();
        }
        catch(XMPPException ex){
            
            JOptionPane.showMessageDialog(null, "Autenticazione fallita: " + ex.getMessage(), "WildPhone", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(authenticationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(authenticationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(authenticationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(authenticationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new authenticationFrame().setVisible(true);
            }
        });
    }
    
    private final String server = "10.155.235.100"; //localhost; 172.17.117.201 10.42.0.255



    private Connection xmppConnection;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField pswField;
    private javax.swing.JLabel pswLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
