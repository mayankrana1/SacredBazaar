
import java.sql.Connection;
import java.sql.Date;
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
public class PurchaseDatabase 
{
    
    public static void insertIntoDatabase(String username) throws SQLException{
        
        productModel model;
        try {
           Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database"); 
            PreparedStatement ps ;
            ps = connection.prepareStatement("SELECT username,productId,quantity,price from carttable WHERE username=?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            
       //     Date date = new Date();
            
            while(rs.next()){
                
                int productId=rs.getInt("productId");
                ps = connection.prepareStatement("INSERT INTO purchasetable (username,productId, quantity,dateOfPurchase,price) VALUES(?,?,?,?,?)");
                ps.setString(1, username);
                ps.setInt(2,productId);
                ps.setInt(3,rs.getInt("quantity"));
                ps.setString(4,"huku");
                ps.setInt(5,rs.getInt("price"));
                
             
                ps.executeUpdate();
                
 
  

                }

            
            connection.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     }
    
    public static ArrayList<productModel> getPurchaseInformation(String username){
        ArrayList<productModel> list = new ArrayList<>();
        try {
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database"); 
            PreparedStatement ps ;
            ps = connection.prepareStatement("SELECT username,productId,quantity from purchasetable WHERE username=?");
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
    
}
