
package offers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class DB_offer {
    String conString = "jdbc:mysql://localhost:3306/product_list";
    String username = "root";
    String password = "";
    
    
   //INSERT 
    public Boolean add (String stokkodu, String musterikodu, String tarih, String miyad, String kur, String adet)
    {
        //SQL statement
        String sqlQuery="INSERT INTO offers (stokkodu, musterikodu, tarih, miyad, kur, adet) VALUES ('"+stokkodu+"', '"+musterikodu+"',  '"+tarih+"','"+miyad+"','"+kur+"','"+adet+"')";
        
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
        dm.addColumn("Fiyat");
        dm.addColumn("Adet");
        dm.addColumn("Miyad");
        
        
        //SQL STATEMENT
        String sqlQuery="SELECT  stokkodu, stokadi, stoktipi, etkenmadde, unit, form, mense, uretici, fiyat FROM urunler";
        
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
                String fiyat=rs.getString(9);
                
                
                dm.addRow(new Object[]{stokkodu, stokadi, stoktipi, etkenmadde, unit, form, mense, uretici, fiyat});

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