
package customers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class DB_customers {
    String conString = "jdbc:mysql://localhost:3306/product_list";
    String username = "root";
    String password = "";
    
    
    
    //INSERT 
    public Boolean add (String firmaadi, String adres, Object ulke, String telefon, String email, Object musteridurumu)
    {
        //SQL statement
        String sqlQuery="INSERT INTO musteriler (firmaadi, adres, ulke, telefon, email, musteridurumu) VALUES ('"+firmaadi+"', '"+adres+"',  '"+ulke+"','"+telefon+"','"+email+"','"+musteridurumu+"')";
        
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
        
        dm.addColumn("Müşteri Kodu");
        dm.addColumn("Firma Adı");
        dm.addColumn("Yükleme Adresi");
        dm.addColumn("Ülke");
        dm.addColumn("Telefon");
        dm.addColumn("Email");
        dm.addColumn("Müşteri Durumu");
        
        
        //SQL STATEMENT
        String sqlQuery="SELECT * FROM musteriler";
        
        try 
        {
            Connection con = DriverManager.getConnection(conString,username,password);
            
            //PREPARE STATEMENT
            
            Statement s=con.prepareStatement(sqlQuery);
            ResultSet rs = s.executeQuery(sqlQuery);
            while (rs.next()) {
                //get values
                String musterikodu=rs.getString(1);
                String firmaadi=rs.getString(2);
                String adres=rs.getString(3);
                Object ulke=rs.getObject(4);
                String telefon=rs.getString(5);
                String email=rs.getString(6);
                Object musteridurumu=rs.getObject(7);
              
                
         
                dm.addRow(new Object[]{musterikodu, firmaadi,  adres, ulke, telefon, email, musteridurumu });

            } 
            return dm;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    //UPDATE DATA
    
    public Boolean update (String musterikodu, String firmaadi, String adres, Object ulke, String telefon, String email, Object musteridurumu)
    {
        //SQL 
        
        String sqlQuery="UPDATE musteriler SET firmaadi= '"+firmaadi+"',  adres = '"+adres+"',  ulke='"+ulke+"',  telefon='"+telefon+"',  email='"+email+"',  musteridurumu='"+musteridurumu+"'";
        
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
    
    public Boolean delete (String musterikodu) 
    {
        String sqlQuery="DELETE FROM musteriler WHERE musterikodu='"+musterikodu+"'";
        
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
