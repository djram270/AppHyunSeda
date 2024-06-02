package co.unicauca.hyunseda.admin.presentation;

//import co.unicauca.hyunseda.domain.entities.Category;
//import co.unicauca.hyunseda.domain.services.CategoryService;
//import co.unicauca.hyunseda.domain.services.ProductService;
//import co.unicauca.hyunseda.domain.services.ShoppingCartService;
import co.unicauca.hyunseda.admin.domain.services.UserService;
import java.util.ArrayList;
import java.util.List;

/**
        initComponents();
 *
 * @author ACER
 */
public class GUILogin extends javax.swing.JFrame {
    
    //public GUILogin(ProductService productService, CategoryService categoriesRegitered) {
    public GUILogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        UserService.getUserService();
        //this.categoriesRegitered = categoriesRegitered;
        //this.productService = productService;
        //this.categoriesSelected = new ArrayList<>();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAdmin = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Username = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de Sesión");
        setIconImage(getIconImage());
        setSize(new java.awt.Dimension(420, 200));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/usuario.png"))); // NOI18N
        jLabel1.setText("LOGIN");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/android-chrome-192x192.png"))); // NOI18N
        jPanel3.add(jLabel3, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        btnAdmin.setBackground(new java.awt.Color(204, 204, 204));
        btnAdmin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdmin.setText("ADMIN");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdmin);

        jPanel3.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new java.awt.GridLayout(4, 0));

        Username.setText("Username");
        jPanel4.add(Username);
        jPanel4.add(txtUsername);

        jLabel4.setText("Password");
        jPanel4.add(jLabel4);
        jPanel4.add(txtPassword);

        jPanel3.add(jPanel4, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        String password = txtPassword.getText();
        String username = txtUsername.getText();
        
        if (password.isEmpty() || username.isEmpty())
        {
            return;
        }
        
        if (!UserService.getUserService().getUserByPassAndEmail(username, password))
        {
            System.out.println("no se ha encontrado el rol para el usuario con el nombre y contraseña dados");
            return;
        }
        
        GUIAdminMenu instance = new GUIAdminMenu();
        instance.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Username;
    private javax.swing.JButton btnAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
