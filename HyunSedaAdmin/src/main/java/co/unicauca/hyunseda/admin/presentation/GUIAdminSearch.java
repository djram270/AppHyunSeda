/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.hyunseda.admin.presentation;



import co.unicauca.hyunseda.admin.access.model.Product;
import co.unicauca.hyunseda.admin.domain.services.ProductService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class GUIAdminSearch extends javax.swing.JDialog {
    private ProductService productService;
    /**
     * Creates new form GUIProductsFind
     */
    public GUIAdminSearch(java.awt.Frame parent, boolean modal,ProductService productService) {
        super(parent, modal);
        initComponents();
        initializeTable();
        this.productService = productService;
        this.setLocationRelativeTo(null); //centrar al ventana
    }
    
    private void initializeTable() {
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Name", "Description", "Price", "Stock"
                }
        ));
    }
    
    private void fillTable(List<Product> listProducts) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

        Object rowData[] = new Object[5];//No columnas
        for (int i = 0; i < listProducts.size(); i++) {
            rowData[0] = listProducts.get(i).getProductId();
            rowData[1] = listProducts.get(i).getName();
            rowData[2] = listProducts.get(i).getDescription();
            rowData[3] = listProducts.get(i).getPrice();
            rowData[4] = listProducts.get(i).getAmount();

            model.addRow(rowData);
        }
    }
    //--------------------------------------------------------------------------Tal vez, solo recibe uno
    private void fillTable(Product product) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

        Object rowData[] = new Object[5];//No columnas
        rowData[0] = product.getProductId();
        rowData[1] = product.getName();
        rowData[2] = product.getDescription();
        rowData[3] = product.getPrice();
        rowData[4] = product.getAmount();
        
        model.addRow(rowData);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectionSearchGroup = new javax.swing.ButtonGroup();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        pnlNorth = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rdoId = new javax.swing.JRadioButton();
        rdoName = new javax.swing.JRadioButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnSearchAll = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Búsqueda de productos");

        pnlCenter.setBackground(new java.awt.Color(102, 102, 102));
        pnlCenter.setLayout(new java.awt.BorderLayout());

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProducts);

        pnlCenter.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlNorth.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar por:");
        pnlNorth.add(jLabel1);

        rdoId.setBackground(new java.awt.Color(102, 102, 102));
        selectionSearchGroup.add(rdoId);
        rdoId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoId.setForeground(new java.awt.Color(255, 255, 255));
        rdoId.setSelected(true);
        rdoId.setText("Id");
        pnlNorth.add(rdoId);

        rdoName.setBackground(new java.awt.Color(102, 102, 102));
        selectionSearchGroup.add(rdoName);
        rdoName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoName.setForeground(new java.awt.Color(255, 255, 255));
        rdoName.setText("Nombre del producto");
        pnlNorth.add(rdoName);

        txtSearch.setName(""); // NOI18N
        txtSearch.setPreferredSize(new java.awt.Dimension(62, 32));
        pnlNorth.add(txtSearch);

        btnSearch.setBackground(new java.awt.Color(204, 204, 204));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/busqueda.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        pnlNorth.add(btnSearch);

        btnSearchAll.setBackground(new java.awt.Color(204, 204, 204));
        btnSearchAll.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearchAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/busqueda.png"))); // NOI18N
        btnSearchAll.setText("Buscar Todos");
        btnSearchAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAllActionPerformed(evt);
            }
        });
        pnlNorth.add(btnSearchAll);

        pnlCenter.add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        btnClose.setBackground(new java.awt.Color(204, 204, 204));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logout_1828427.png"))); // NOI18N
        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAllActionPerformed
        fillTable(productService.getProducts());
    }//GEN-LAST:event_btnSearchAllActionPerformed
 
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        selectionSearchGroup.add(rdoId);
        selectionSearchGroup.add(rdoName);
        if (rdoId.isSelected()) {
            try {
                
                String productId =txtSearch.getText();

                ProductService productService = ProductService.getProductService();
                Product product = productService.getProductById(productId);

                if (product != null) {
                    fillTable(product);
                } else {
                    showMessage("Error", "Producto no encontrado No se encontró ningún producto con el ID proporcionado.");
                }
            } catch (NumberFormatException e) {
                showMessage("Error de entrada", " El ID debe ser un número válido.");
            }
        }
        if (rdoName.isSelected()) {
            fillTable(ProductService.getProductService().getProductsByName(txtSearch.getText()));
        }
    }//GEN-LAST:event_btnSearchActionPerformed
    public static void showMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JRadioButton rdoId;
    private javax.swing.JRadioButton rdoName;
    private javax.swing.ButtonGroup selectionSearchGroup;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}