
package products;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class List_products extends javax.swing.JFrame {
    
    String conString = "jdbc:mysql://localhost:3306/product_list";
    String username = "root";
    String password = "";
    
    public List_products() {
        initComponents();
    }

    private void refresh() {
        
        TableProducts.setModel(getProducts());
    }
    
    public DefaultTableModel getProducts()
    {
        DefaultTableModel dm= new DefaultTableModel();
        dm.addColumn("Stok Kodu");
        dm.addColumn("Stok Adi");
        dm.addColumn("Etken Madde");
        dm.addColumn("Unit");
        dm.addColumn("Form");
        dm.addColumn("Mense");
        dm.addColumn("Uretici");
        dm.addColumn("Barkod");
        dm.addColumn("Stok");
        dm.addColumn("Blokaj");
        dm.addColumn("Fiyat");
        
        //SQL STATEMENT
        String sqlQuery="SELECT * FROM urunler where stokkodu like '"+searchProducts.getText()+"%'";
        
        try 
        {
            Connection con = DriverManager.getConnection(conString,username,password);
            
            //PREPARE STATEMENT
            
            Statement s=con.prepareStatement(sqlQuery);
            ResultSet rs = s.executeQuery(sqlQuery);
            while (rs.next()) {
                //get values
                String stokkodu=rs.getString(1);
                String stokadi=rs.getString(2);
                Object stoktipi=rs.getObject(3);
                String etkenmadde=rs.getString(4);
                String unit=rs.getString(5);
                Object form=rs.getObject(6);
                Object mense=rs.getObject(7);
                Object uretici=rs.getObject(8);
                String barkod=rs.getString(9);
                String stok=rs.getString(10);
                String blokaj=rs.getString(11);
                String fiyat=rs.getString(12);
              
               dm.addRow(new Object[]{stokkodu, stokadi, stoktipi, etkenmadde, unit, form, mense, uretici, barkod, stok, blokaj, fiyat });
            } 
            return dm;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public void retrieve() {
        DefaultTableModel dm = new DB_products().getData();
        TableProducts.setModel(dm);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProducts = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchProducts = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableProducts);

        jLabel1.setText("search producst :");

        searchProducts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchProductsKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(searchProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductsMouseClicked

        String stokkodu = TableProducts.getValueAt(TableProducts.getSelectedRow(), 0).toString();
        offers.GUI_offer.productsTxt.setText(stokkodu);
        setVisible(false);
    }//GEN-LAST:event_TableProductsMouseClicked

    private void searchProductsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProductsKeyReleased
        String sqlQuery="SELECT * FROM urunler where stokadi like '"+searchProducts.getText()+"%'";
        try
        {
            //GET CONNECTION
            Connection con = DriverManager.getConnection(conString,username,password);

            //Statement
            Statement s=con.prepareStatement(sqlQuery);
            s.execute(sqlQuery);
            refresh();
        }catch (Exception ex) {
            ex.printStackTrace();

        }

    }//GEN-LAST:event_searchProductsKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        List_products frame= new List_products();
        frame.retrieve();
        frame.getProducts();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List_products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableProducts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchProducts;
    // End of variables declaration//GEN-END:variables
}
