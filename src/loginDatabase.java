
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
public class loginDatabase 
{
    

    public static int insertIntoDatabase(String name,String email,String username,String password,String mobile,String path){
        try {
           // Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database");

            PreparedStatement ps = connection.prepareStatement("INSERT INTO logintable(name,email,username,"
                    + "password,mobile,path) VALUES(?,?,?,?,?,?)");
            
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setString(5, mobile);
            ps.setString(6, path);
            if(ps.executeUpdate()==1)
            {
                JOptionPane.showMessageDialog(null, "Entry successful!");
            }
            connection.close();
            
            
        } catch (SQLException ex) {
           
            System.out.println(ex.getMessage());
            return 0;
    }
    return 1;
    }
    
    public static int checkForUser(String username,String password) throws SQLException
    {
        try
        {
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database");
            
             PreparedStatement queryStatement=connection.prepareStatement("SELECT COUNT(*) FROM logintable WHERE username=? AND password=?");
             queryStatement.setString(1, username);
             queryStatement.setString(2, password);
             ResultSet rs=queryStatement.executeQuery();
             int count=0;
             while (rs.next()) {
                ++count;
            }
             if(count==1)
             {
                 return 1;
             }
             else
             {
                 return 0;
             }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
    }
        return 0;
    
    }
    
    public static ClientModel getUserInformation(String username){
           ArrayList <ClientModel> userInformationArrayList=new ArrayList<>();
           ClientModel clientModel = null;
        try {
                Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database"); 
                PreparedStatement ps ;
                ps = connection.prepareStatement("SELECT name,username,password,email,mobile,path,totalItemPurchased,electronicsItemPurchased,furnitureItemPurchased,clothingItemPurchased,vehiclesItemPurchased,booksItemPurchased,totalAmountSpend FROM logintable WHERE username=?");
                ps.setString(1,username);
                ResultSet rs = ps.executeQuery();
            
            
                while(rs.next()){
                    clientModel = new ClientModel(rs.getString("name"),rs.getString("username"),
                        rs.getString("password"),rs.getString("email"),rs.getString("mobile"),rs.getString("path"),
                        rs.getInt("totalItemPurchased"),rs.getInt("electronicsItemPurchased"),rs.getInt("furnitureItemPurchased"),rs.getInt("clothingItemPurchased"),rs.getInt("vehiclesItemPurchased"),rs.getInt("booksItemPurchased"),rs.getInt("totalAmountSpend"));
                

            }
            connection.close();

            } 
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return clientModel;
    }
    
    
    
    
      public static ArrayList<ClientModel> getAllUserInformation(){
           ArrayList <ClientModel> userInformationArrayList=new ArrayList<>();
        try {
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sacreddatabase", "database", "database"); 
            PreparedStatement ps ;
                ps = connection.prepareStatement("SELECT name,username,password,email,mobile,path,totalItemPurchased,electronicsItemPurchased,furnitureItemPurchased,clothingItemPurchased,vehiclesItemPurchased,booksItemPurchased,totalAmountSpend FROM logintable");
            ResultSet rs = ps.executeQuery();
            
            ClientModel clientModel;
            
            while(rs.next()){
                clientModel = new ClientModel(rs.getString("name"),rs.getString("username"),
                        rs.getString("password"),rs.getString("email"),rs.getString("mobile"),rs.getString("path"),
                        rs.getInt("totalItemPurchased"),rs.getInt("electronicsItemPurchased"),rs.getInt("furnitureItemPurchased"),rs.getInt("clothingItemPurchased"),rs.getInt("vehiclesItemPurchased"),rs.getInt("booksItemPurchased"),rs.getInt("totalAmountSpend"));
                
                userInformationArrayList.add(clientModel);

            }
            connection.close();

        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return userInformationArrayList;
}
}
