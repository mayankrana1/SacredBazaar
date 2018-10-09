
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class itemDatabase {
    
    public static void insertIntoDatabase(String name,int price,int quantity,String brand,String category,String description,String path,int productId,double offers,String dateOfManufacture){
        try {
           // Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database");

         
            PreparedStatement ps = connection.prepareStatement("INSERT INTO itemTable(name,price, quantity,"
                    + "brand,category,description,path,productId,offers,dateOfManufacture) VALUES(?,?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setInt(3, quantity);
            ps.setString(4, brand);
            ps.setString(5, category);
            ps.setString(6, description);
            ps.setString(7, path);
            ps.setInt(8,productId);
            ps.setDouble(9,offers);
            ps.setString(10,dateOfManufacture);
            if(ps.executeUpdate()==1)
                JOptionPane.showMessageDialog(null, "Entry successful!");
            connection.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
    }
    
    }
      
    public static int getProductId(String name)
    {
        try
        {
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database");
            int productId = 0;
             PreparedStatement queryStatement=connection.prepareStatement("SELECT * FROM itemtable WHERE name=?");
             queryStatement.setString(1,name);
             ResultSet rs=queryStatement.executeQuery();
             int count=0;
             while (rs.next()) {
                 productId=rs.getInt("productId");
                ++count;
            }
             if(count==1)
             {
                 return productId;
             }
             else
             {
                queryStatement=connection.prepareStatement("SELECT * FROM itemtable");
                rs=queryStatement.executeQuery();
                while (rs.next()) {
                    productId=rs.getInt("productId");
                }
                return productId+1;
             }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
    }
        return 0;
    }
    
    
    public static void updateItemDatabaseByProductId(String name,int price,int quantity,String brand,String category,String description,String path,int productId,double offers,String dateOfManufacture){
        try {
           // Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database");

         
            PreparedStatement ps = connection.prepareStatement("UPDATE itemtable SET name=?,price=?,quantity=?,brand=?,category=?,description=?,path=?,offers=?,dateOfManufacture=? WHERE productId=?");
            
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setInt(3, quantity);
            ps.setString(4, brand);
            ps.setString(5, category);
            ps.setString(6, description);
            ps.setString(7, path);
            ps.setDouble(8,offers);
            ps.setString(9,dateOfManufacture);
            ps.setInt(10,productId);
            if(ps.executeUpdate()==1)
            connection.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()+"1");
    }
    
    }
    
    public static void updateItemDatabase(String username) throws SQLException{
        Connection  connection = null;
         try {
             System.out.println(1);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database"); 
            PreparedStatement ps3=connection.prepareStatement("SELECT * FROM carttable WHERE username=?");
            ps3.setString(1,username);
            ResultSet rs2=ps3.executeQuery();
            System.out.println(2);
            while(rs2.next())
            {
                int productId=rs2.getInt("productId");
                int quantity=rs2.getInt("quantity");
                PreparedStatement ps2=connection.prepareStatement("SELECT * FROM itemtable WHERE productId=?");
                PreparedStatement ps = connection.prepareStatement("UPDATE itemtable SET quantity=? WHERE productId=?");
                ps2.setInt(1,productId);
                ResultSet rs=ps2.executeQuery();
                rs.beforeFirst();
                rs.next();
                System.out.println(rs.getInt("quantity")-quantity);
                ps.setInt(1,rs.getInt("quantity")-quantity);
                ps.setInt(2, productId);
                if(ps.executeUpdate()==0)
                    JOptionPane.showMessageDialog(null, "Entry does not exist!");
                else if(ps.executeUpdate()==1 ){
                continue;
                }
            }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage()+"uhiyg8ug");

        }
         connection.close();
    }
    
    
    
    public static ArrayList<productModel> getSelectedProduct(String category){
        ArrayList<productModel> list = new ArrayList<>();
        try {
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database"); 
            PreparedStatement ps ;
            if(category.equals("Electronics"))
            {
                ps = connection.prepareStatement("SELECT name, price, quantity,brand,category,description, path,productId,offers,dateOfManufacture FROM itemTable WHERE category=? OR category=? OR category=?");
                ps.setString(1,"Mobile");
                ps.setString(2,"Laptop");
                ps.setString(3,"Tv");
                
            }
            else
            {
                System.out.println("clothing");
                ps = connection.prepareStatement("SELECT name, price, quantity,brand,category,description, path,productId,offers,dateOfManufacture FROM itemTable WHERE category=?");
                ps.setString(1,category);
            }
            ResultSet rs = ps.executeQuery();
            
            productModel pl;
            
            while(rs.next()){
                pl = new productModel(rs.getString("name"),rs.getInt("price"),
                        rs.getInt("quantity"),rs.getString("brand"),rs.getString("category"),rs.getString("description"),
                        rs.getString("path"),rs.getInt("productId"),rs.getDouble("offers"),rs.getString("dateOfManufacture"));
                
                list.add(pl);

            }
            connection.close();

        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public static ArrayList<productModel> getAllProductInformation(){
        ArrayList<productModel> list = new ArrayList<>();
        try {
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database"); 
            PreparedStatement ps ;
            ps = connection.prepareStatement("SELECT name, price, quantity,brand,category,description, path,productId,offers,dateOfManufacture FROM itemTable ORDER BY ?");
            ps.setString(1,"productId");
            ResultSet rs = ps.executeQuery();
            
            productModel pl;
            
            while(rs.next()){
                pl = new productModel(rs.getString("name"),rs.getInt("price"),
                        rs.getInt("quantity"),rs.getString("brand"),rs.getString("category"),rs.getString("description"),
                        rs.getString("path"),rs.getInt("productId"),rs.getDouble("offers"),rs.getString("dateOfManufacture"));
                
                list.add(pl);

            }
            connection.close();

        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public static productModel getItemInformationByProductId(int productId)
    {
        productModel model = null;
        
        try {
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database"); 
            PreparedStatement ps ;
            ps = connection.prepareStatement("SELECT name, price, quantity,brand,category,description, path,productId,offers,dateOfManufacture FROM itemtable WHERE productId=?");
            ps.setString(1,"productId");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                model = new productModel(rs.getString("name"),rs.getInt("price"),
                        rs.getInt("quantity"),rs.getString("brand"),rs.getString("category"),rs.getString("description"),
                        rs.getString("path"),rs.getInt("productId"),rs.getDouble("offers"),rs.getString("dateOfManufacture"));
                

            }
            connection.close();

        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return model;
    }
    
    
    public static ArrayList<productModel> getProductInformationByOffers()
    {
        
        ArrayList<productModel> list = new ArrayList<>();
        
        productModel model = null;
        
        try {
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database"); 
            PreparedStatement ps ;
            ps = connection.prepareStatement("SELECT name, price, quantity,brand,category,description, path,productId,offers,dateOfManufacture FROM itemtable ORDER BY offers DESC");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                model = new productModel(rs.getString("name"),rs.getInt("price"),
                        rs.getInt("quantity"),rs.getString("brand"),rs.getString("category"),rs.getString("description"),
                        rs.getString("path"),rs.getInt("productId"),rs.getDouble("offers"),rs.getString("dateOfManufacture"));
                
                list.add(model);

            }
            
            connection.close();

        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return list;
    }
    
}
