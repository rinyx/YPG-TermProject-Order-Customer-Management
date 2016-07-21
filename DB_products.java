
package products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class DB_products {
    
    String conString = "jdbc:mysql://localhost:3306/product_list";
    String username = "root";
    String password = "";


   //INSERT 
    public Boolean add (String stokadi, Object stoktipi, String etkenmadde, Object unit, Object form, Object mense, Object uretici, String barkod, String stok, String blokaj, String fiyat)
    {
        //SQL statement
        String sqlQuery="INSERT INTO urunler (stokadi, stoktipi, etkenmadde, unit, form, mense, uretici, barkod, stok, blokaj, fiyat) VALUES ('"+stokadi+"', '"+stoktipi+"',  '"+etkenmadde+"','"+unit+"','"+form+"','"+mense+"','"+uretici+"','"+barkod+"','"+stok+"','"+blokaj+"','"+fiyat+"')";
        
        try {
            
            //GET CONNECTION
            Connection con = DriverManager.getConnection(conString,username,password);
            
            //Prepare Statement
            Statement s=con.prepareStatement(sqlQuery);
            s.execute(sqlQuery);
            return true;
        
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
        return false;
    }
    
    
     //RETRIEVE DATA
    
    public DefaultTableModel getData()
    {
        DefaultTableModel dm= new DefaultTableModel();
        dm.addColumn("Stok Kodu");
        dm.addColumn("Stok Adi");
        dm.addColumn("Stok Tipi");
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
        String sqlQuery="SELECT * FROM urunler";
        
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
    
    //UPDATE DATA
    
    public Boolean update (String stokkodu, String stokadi, Object stoktipi, String etkenmadde, Object unit, Object form, Object mense, Object uretici, String barkod, String stok, String blokaj, String fiyat)
    {
        //SQL 
        
        String sqlQuery="UPDATE urunler SET stokadi= '"+stokadi+"',  stoktipi = '"+stoktipi+"',  etkenmadde='"+etkenmadde+"', unit='"+unit+"',  form='"+form+"',  mense='"+mense+"', uretici='"+uretici+"', barkod='"+barkod+"',  stok='"+stok+"', blokaj='"+blokaj+"', fiyat='"+fiyat+"' WHERE stokkodu ='"+stokkodu+"'";
        
        try 
        {
            //GET CONNECTION
            Connection con = DriverManager.getConnection(conString,username,password);
            
            //Statement
            Statement s=con.prepareStatement(sqlQuery);
            s.execute(sqlQuery);
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
     //DELETE DATABASE
    
    public Boolean delete (String stokkodu) 
    {
        String sqlQuery="DELETE FROM urunler WHERE stokkodu='"+stokkodu+"'";
        
        try 
        {
            // GET CONNECTED
            Connection con = DriverManager.getConnection(conString,username,password);
            Statement s=con.prepareStatement(sqlQuery);
            s.execute(sqlQuery);
            return true;
            
        }catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
    }


    
}
