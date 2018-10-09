
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mayank
 */
public class CartDatabase {
    
    
     public static void insertIntoDatabase(String username,int productId,int quantity,int price) throws SQLException{
        try {
           // Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database");

            int count=0,productQuantity=0;
            PreparedStatement queryStatement=connection.prepareStatement("SELECT * FROM carttable WHERE username=? AND productId=?");
             queryStatement.setString(1,username);
             queryStatement.setInt(2,productId);
             ResultSet rs=queryStatement.executeQuery();
            while(rs.next())
            {
                productQuantity=rs.getInt("quantity");
                count++;
            }
            if(count==1)
            {
                queryStatement= connection.prepareStatement("UPDATE carttable SET quantity=? WHERE username=? AND productId=?");
                
                queryStatement.setInt(1,productQuantity+quantity);
                queryStatement.setInt(3,productId);
                queryStatement.setString(2, username);
            }
            else
            {
                queryStatement=connection.prepareStatement("INSERT INTO carttable (username,productId, quantity,price) VALUES(?,?,?,?)");
                queryStatement.setString(1, username);
                queryStatement.setInt(2,productId);
                queryStatement.setInt(3, quantity);
                queryStatement.setInt(4, price);
                
            }
            try
                {
                    if(queryStatement.executeUpdate()==1)
                        connection.close();
                }   
                catch (SQLException ex) {
                     System.out.println(ex.getMessage());
                }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     }
     
      public static ArrayList<productModel> getCartInformation(String username){
        ArrayList<productModel> list = new ArrayList<>();
        try {
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database"); 
            PreparedStatement ps ;
            ps = connection.prepareStatement("SELECT username,productId,quantity from carttable WHERE username=?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            
            productModel pl;
            
            while(rs.next()){
                
                int productId=rs.getInt("productId");
                ps = connection.prepareStatement("SELECT name, price, quantity,brand,category,description, path,productId,offers,dateOfManufacture FROM itemtable WHERE productId=?");
                ps.setInt(1, productId);
                
                ResultSet rs2 = ps.executeQuery();
            
 
            
                while(rs2.next()){
                pl = new productModel(rs2.getString("name"),rs2.getInt("price"),
                        rs.getInt("quantity"),rs2.getString("brand"),rs2.getString("category"),rs2.getString("description"),
                        rs2.getString("path"),rs2.getInt("productId"),rs2.getDouble("offers"),rs2.getString("dateOfManufacture"));
                
                list.add(pl);

                }

            }
            connection.close();

        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return list;
    }
            
    public static void deleteAllCartEntry(String username) throws SQLException
    {
        try {
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database"); 
            PreparedStatement ps ;
            ps = connection.prepareStatement("DELETE from carttable WHERE username=?");
            ps.setString(1,username);
            ps.executeUpdate();
            
            connection.close();
            }
            

         catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        
    }
    
    public static void  updateCartDatabase(String username,int productId) throws SQLException
    {
        try {
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database"); 
            PreparedStatement ps ;
            ps = connection.prepareStatement("DELETE from carttable WHERE username=? AND productId=?");
            ps.setString(1,username);
            ps.setInt(2,productId);
            ps.executeUpdate();
            
            connection.close();
            }
            

         catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        
    }
    
}
