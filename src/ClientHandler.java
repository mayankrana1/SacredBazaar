
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.UIManager.get;
import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mayank
 */
class ClientHandler extends Thread  
{ 
    Scanner scn = new Scanner(System.in); 
    private String name; 
    final DataInputStream dis; 
    final DataOutputStream dos; 
    Socket s; 
    boolean isloggedin; 
    String received[]=new String[6];
    
    OutputStream os;
    InputStream is; 
    static int imageNumber=0;
    
    static ClientModel client;
    
    
    public ClientHandler(Socket s, String name, 
                            DataInputStream dis, DataOutputStream dos) throws IOException { 
        this.dis = dis; 
        this.dos = dos; 
        this.name = name; 
        this.s = s; 
        this.isloggedin=true; 
        is = s.getInputStream(); 
        os = s.getOutputStream();
    } 
 
   
    
  
    @Override
    public void run() { 
  
        String recieved;
        int index=0;
        while (true)  
        { 
            try
            { 
                
                recieved=dis.readUTF();
                
                
                System.out.println(recieved);
                switch(recieved)
                {
                    case "login":
                        login();
                        break;
                    case "signup":
                            signUp();
                            break;
                    case  "Electronics":
                            Electronics();
                            break;
                    case  "Furniture":
                            Furniture();
                            break;
                    case  "Clothing":
                            Clothing();
                            break;
                    case  "Vehicles":
                            Vehicles();
                            break;
                    case  "Books":
                            Books();
                            break;
                    case   "GetClientInfo":
                            ClientInformation();
                            break;
                    case   "CurrentOffers":
                            CurrentOffers();
                            break;
                    case    "AddToCart":
                            AddToCart();
                            break;
                     
                    case    "MyCart":
                            MyCart();
                            break;
                            
                    case    "PlaceOrder":
                            Buy();
                            break;
                            
                    case    "MyHistory":
                            MyHistory();
                            break;
                            
                    case    "DeleteCart":
                            DeleteCart();
                            break;
                         
                }
              
            } catch (IOException e) 
            { 
                  
                e.printStackTrace(); 
            } catch (SQLException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            
              
        } 
        /*try
        { 
            // closing resources 
            this.isloggedin=false; 
                    this.s.close();
            this.dis.close(); 
            this.dos.close(); 
              
        }catch(IOException e){ 
            e.printStackTrace(); 
        } */
    } 

       public void readImage() throws IOException
    {
        byte[] imgByteArray = new byte[1000000];
        is.read(imgByteArray);
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgByteArray));
        imageNumber++;
        ImageIO.write(image, "jpg", new File("D:\\image"+Integer.toString(imageNumber)));
        
    }
       
     private void login() throws IOException, SQLException
    {
        String recieved[]=new String[2];
        int index=0;
        
        while(true)
        {
            recieved[index++]=dis.readUTF();
            
            if(index==2)
                break;
            
        }
        int loginCheck=loginDatabase.checkForUser(recieved[0],recieved[1]);
        
        client=loginDatabase.getUserInformation(recieved[0]);
        dos.writeUTF(Integer.toString(loginCheck));
        
        
    }
    
     private void CurrentOffers() throws IOException
     {
                 
         ArrayList <productModel> productArray=itemDatabase.getProductInformationByOffers();
         dos.writeUTF(Integer.toString(productArray.size()));
       for(int i=0;i<productArray.size();i++)
        {
            String name=productArray.get(i).getName();
            String price=Integer.toString(productArray.get(i).getPrice());
            String quantity=Integer.toString(productArray.get(i).getQuantity());
            String brand=productArray.get(i).getBrand();
            String category=productArray.get(i).getCategory();
            String description=productArray.get(i).getDescription();
            String productId=Integer.toString(productArray.get(i).getProductId());
            String offers=Double.toString(productArray.get(i).getOffers());
            String dateOfManufacture=productArray.get(i).getDateOfManufacture();
            String path=productArray.get(i).getImagePath();
            dos.writeUTF(name);
            dos.writeUTF(price);
            dos.writeUTF(quantity);
            dos.writeUTF(brand);
            dos.writeUTF(category);
            dos.writeUTF(description);
            dos.writeUTF(productId);
            dos.writeUTF(offers);
            dos.writeUTF(dateOfManufacture);
            
            String AbsolutePath="C:\\Users\\Mayank\\Desktop\\project\\"+path;
        //    dos.writeUTF(category);
          //  dos.writeUTF(description);
            System.out.println(AbsolutePath);
//            BufferedImage image = ImageIO.read(new File(AbsolutePath));
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ImageIO.write(image, "jpg", byteArrayOutputStream);
//            os.write(byteArrayOutputStream.toByteArray());
//            os.flush();
            
        }
        //dos.writeUTF("false");
     }
    
     private void DeleteCart() throws IOException, SQLException
     {
         String username=dis.readUTF();
         
         int productId=Integer.parseInt(dis.readUTF());
         
         System.out.println(username);
         System.out.println();
         CartDatabase.updateCartDatabase(username,productId);
     }
     
     
     private void signUp() throws IOException, SQLException
    {
        String recieved[]=new String[6];
        int index=0;
        
        while(true)
        {
            recieved[index++]=dis.readUTF();
    //        System.out.println(index-1);
   //         System.out.println(received[index-1]);
            if(index==5)
                break;
            
        }
         readImage(); 
        
        int signUpCheck=loginDatabase.insertIntoDatabase(recieved[0],recieved[1],recieved[2],recieved[3],recieved[4],"D:\\image"+Integer.toString(imageNumber));
        
        dos.writeUTF(Integer.toString(signUpCheck));
    }
     
     
    private void MyHistory() throws IOException
    {
         String username=dis.readUTF();
         ArrayList <productModel> productArray=PurchaseDatabase.getPurchaseInformation(username);
         dos.writeUTF(Integer.toString(productArray.size()));
        for(int i=0;i<productArray.size();i++)
        {
            String name=productArray.get(i).getName();
            String price=Integer.toString(productArray.get(i).getPrice());
            String quantity=Integer.toString(productArray.get(i).getQuantity());
            String brand=productArray.get(i).getBrand();
            String category=productArray.get(i).getCategory();
            String description=productArray.get(i).getDescription();
            String productId=Integer.toString(productArray.get(i).getProductId());
            String offers=Double.toString(productArray.get(i).getOffers());
            String dateOfManufacture=productArray.get(i).getDateOfManufacture();
            String path=productArray.get(i).getImagePath();
            dos.writeUTF(name);
            dos.writeUTF(price);
            dos.writeUTF(quantity);
            dos.writeUTF(brand);
            dos.writeUTF(category);
            dos.writeUTF(description);
            dos.writeUTF(productId);
            dos.writeUTF(offers);
            dos.writeUTF(dateOfManufacture);
            
            String AbsolutePath="C:\\Users\\Mayank\\Desktop\\project\\"+path;
        //    dos.writeUTF(category);
          //  dos.writeUTF(description);
            System.out.println(AbsolutePath);
//            BufferedImage image = ImageIO.read(new File(AbsolutePath));
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ImageIO.write(image, "jpg", byteArrayOutputStream);
//            os.write(byteArrayOutputStream.toByteArray());
//            os.flush();
            
        }
        //dos.writeUTF("false");
    }
      
     private void MyCart() throws IOException
     {
         String username=dis.readUTF();
         ArrayList <productModel> productArray=CartDatabase.getCartInformation(username);
         dos.writeUTF(Integer.toString(productArray.size()));
       for(int i=0;i<productArray.size();i++)
        {
            String name=productArray.get(i).getName();
            String price=Integer.toString(productArray.get(i).getPrice());
            String quantity=Integer.toString(productArray.get(i).getQuantity());
            String brand=productArray.get(i).getBrand();
            String category=productArray.get(i).getCategory();
            String description=productArray.get(i).getDescription();
            String productId=Integer.toString(productArray.get(i).getProductId());
            String offers=Double.toString(productArray.get(i).getOffers());
            String dateOfManufacture=productArray.get(i).getDateOfManufacture();
            String path=productArray.get(i).getImagePath();
            dos.writeUTF(name);
            dos.writeUTF(price);
            dos.writeUTF(quantity);
            dos.writeUTF(brand);
            dos.writeUTF(category);
            dos.writeUTF(description);
            dos.writeUTF(productId);
            dos.writeUTF(offers);
            dos.writeUTF(dateOfManufacture);
            
            String AbsolutePath="C:\\Users\\Mayank\\Desktop\\project\\"+path;
        //    dos.writeUTF(category);
          //  dos.writeUTF(description);
            System.out.println(AbsolutePath);
//            BufferedImage image = ImageIO.read(new File(AbsolutePath));
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ImageIO.write(image, "jpg", byteArrayOutputStream);
//            os.write(byteArrayOutputStream.toByteArray());
//            os.flush();
            
        }
        //dos.writeUTF("false");
     }
    private void Buy() throws IOException, SQLException
    {
        String username=dis.readUTF();
        String name=dis.readUTF();
        String mobileNumber=dis.readUTF();
        String adress=dis.readUTF();
        itemDatabase.updateItemDatabase(username);
        PurchaseDatabase.insertIntoDatabase(username);
       CartDatabase.deleteAllCartEntry(username);
        //dos.writeUTF("false");
    }
    
    private void AddToCart() throws IOException, SQLException 
    {
        int productId=Integer.parseInt(dis.readUTF());
        String username=dis.readUTF();
        int quantity=Integer.parseInt(dis.readUTF());
        int price=Integer.parseInt(dis.readUTF());
        CartDatabase.insertIntoDatabase(username,productId,quantity,price);
    }
      
      
    private void ClientInformation() throws IOException 
    {
        String username=dis.readUTF();
        
        
        dos.writeUTF(client.getName());
        dos.writeUTF(username);
        dos.writeUTF(client.getPassword());
        dos.writeUTF(client.getPassword());
        dos.writeUTF(client.getMobile());
        dos.writeUTF(Integer.toString(client.getTotalItemPurchased()));
        dos.writeUTF(Integer.toString(client.getElectronicsItemPurchased()));
        dos.writeUTF(Integer.toString(client.getFurnitureItemPurchased()));
        dos.writeUTF(Integer.toString(client.getClothingItemPurchased()));
        dos.writeUTF(Integer.toString(client.getVehiclesItemPurchased()));
        dos.writeUTF(Integer.toString(client.getBooksItemPurchased()));
        dos.writeUTF(Integer.toString(client.getTotalAmountSpend()));
    }
      
    private void Books() throws IOException 
    {
         ArrayList <productModel> productArray=itemDatabase.getSelectedProduct("Books");
        dos.writeUTF(Integer.toString(productArray.size()));
        for(int i=0;i<productArray.size();i++)
        {
            String name=productArray.get(i).getName();
            String price=Integer.toString(productArray.get(i).getPrice());
            String quantity=Integer.toString(productArray.get(i).getQuantity());
            String brand=productArray.get(i).getBrand();
            String category=productArray.get(i).getCategory();
            String description=productArray.get(i).getDescription();
            String productId=Integer.toString(productArray.get(i).getProductId());
            String offers=Double.toString(productArray.get(i).getOffers());
            String dateOfManufacture=productArray.get(i).getDateOfManufacture();
            String path=productArray.get(i).getImagePath();
            dos.writeUTF(name);
            dos.writeUTF(price);
            dos.writeUTF(quantity);
            dos.writeUTF(brand);
            dos.writeUTF(category);
            dos.writeUTF(description);
            dos.writeUTF(productId);
            dos.writeUTF(offers);
            dos.writeUTF(dateOfManufacture);
            
            String AbsolutePath="C:\\Users\\Mayank\\Desktop\\project\\"+path;
        //    dos.writeUTF(category);
          //  dos.writeUTF(description);
            System.out.println(AbsolutePath);
//            BufferedImage image = ImageIO.read(new File(AbsolutePath));
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ImageIO.write(image, "jpg", byteArrayOutputStream);
//            os.write(byteArrayOutputStream.toByteArray());
//            os.flush();
            
        }
      //  dos.writeUTF("false");
    }

    private void Vehicles() throws IOException 
    {
         ArrayList <productModel> productArray=itemDatabase.getSelectedProduct("Vehicles");
        dos.writeUTF(Integer.toString(productArray.size()));
       for(int i=0;i<productArray.size();i++)
        {
            String name=productArray.get(i).getName();
            String price=Integer.toString(productArray.get(i).getPrice());
            String quantity=Integer.toString(productArray.get(i).getQuantity());
            String brand=productArray.get(i).getBrand();
            String category=productArray.get(i).getCategory();
            String description=productArray.get(i).getDescription();
            String productId=Integer.toString(productArray.get(i).getProductId());
            String offers=Double.toString(productArray.get(i).getOffers());
            String dateOfManufacture=productArray.get(i).getDateOfManufacture();
            String path=productArray.get(i).getImagePath();
            dos.writeUTF(name);
            dos.writeUTF(price);
            dos.writeUTF(quantity);
            dos.writeUTF(brand);
            dos.writeUTF(category);
            dos.writeUTF(description);
            dos.writeUTF(productId);
            dos.writeUTF(offers);
            dos.writeUTF(dateOfManufacture);
            
            String AbsolutePath="C:\\Users\\Mayank\\Desktop\\project\\"+path;
        //    dos.writeUTF(category);
          //  dos.writeUTF(description);
            System.out.println(AbsolutePath);
//            BufferedImage image = ImageIO.read(new File(AbsolutePath));
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ImageIO.write(image, "jpg", byteArrayOutputStream);
//            os.write(byteArrayOutputStream.toByteArray());
//            os.flush();
            
        }
        //dos.writeUTF("false");
    }

    private void Clothing() throws IOException 
    {
         ArrayList <productModel> productArray=itemDatabase.getSelectedProduct("Clothing");
        dos.writeUTF(Integer.toString(productArray.size()));
        for(int i=0;i<productArray.size();i++)
        {
            String name=productArray.get(i).getName();
            String price=Integer.toString(productArray.get(i).getPrice());
            String quantity=Integer.toString(productArray.get(i).getQuantity());
            String brand=productArray.get(i).getBrand();
            String category=productArray.get(i).getCategory();
            String description=productArray.get(i).getDescription();
            String productId=Integer.toString(productArray.get(i).getProductId());
            String offers=Double.toString(productArray.get(i).getOffers());
            String dateOfManufacture=productArray.get(i).getDateOfManufacture();
            String path=productArray.get(i).getImagePath();
            dos.writeUTF(name);
            dos.writeUTF(price);
            dos.writeUTF(quantity);
            dos.writeUTF(brand);
            dos.writeUTF(category);
            dos.writeUTF(description);
            dos.writeUTF(productId);
            dos.writeUTF(offers);
            dos.writeUTF(dateOfManufacture);
            
            String AbsolutePath="C:\\Users\\Mayank\\Desktop\\project\\"+path;
        //    dos.writeUTF(category);
          //  dos.writeUTF(description);
            System.out.println(AbsolutePath);
//            BufferedImage image = ImageIO.read(new File(AbsolutePath));
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ImageIO.write(image, "jpg", byteArrayOutputStream);
//            os.write(byteArrayOutputStream.toByteArray());
//            os.flush();
            
        }
      //  dos.writeUTF("false");
    }

    private void Furniture() throws IOException 
    {
         ArrayList <productModel> productArray=itemDatabase.getSelectedProduct("Furniture");
        dos.writeUTF(Integer.toString(productArray.size()));
        for(int i=0;i<productArray.size();i++)
        {
            String name=productArray.get(i).getName();
            String price=Integer.toString(productArray.get(i).getPrice());
            String quantity=Integer.toString(productArray.get(i).getQuantity());
            String brand=productArray.get(i).getBrand();
            String category=productArray.get(i).getCategory();
            String description=productArray.get(i).getDescription();
            String productId=Integer.toString(productArray.get(i).getProductId());
            String offers=Double.toString(productArray.get(i).getOffers());
            String dateOfManufacture=productArray.get(i).getDateOfManufacture();
            String path=productArray.get(i).getImagePath();
            dos.writeUTF(name);
            dos.writeUTF(price);
            dos.writeUTF(quantity);
            dos.writeUTF(brand);
            dos.writeUTF(category);
            dos.writeUTF(description);
            dos.writeUTF(productId);
            dos.writeUTF(offers);
            dos.writeUTF(dateOfManufacture);
            
            String AbsolutePath="C:\\Users\\Mayank\\Desktop\\project\\"+path;
        //    dos.writeUTF(category);
          //  dos.writeUTF(description);
            System.out.println(AbsolutePath);
//            BufferedImage image = ImageIO.read(new File(AbsolutePath));
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ImageIO.write(image, "jpg", byteArrayOutputStream);
//            os.write(byteArrayOutputStream.toByteArray());
//            os.flush();
            
        }
       // dos.writeUTF("false");
    }

    private void Electronics() throws IOException 
    {
         ArrayList <productModel> productArray=itemDatabase.getSelectedProduct("Electronics");
        dos.writeUTF(Integer.toString(productArray.size()));
        for(int i=0;i<productArray.size();i++)
        {
            String name=productArray.get(i).getName();
            String price=Integer.toString(productArray.get(i).getPrice());
            String quantity=Integer.toString(productArray.get(i).getQuantity());
            String brand=productArray.get(i).getBrand();
            String category=productArray.get(i).getCategory();
            String description=productArray.get(i).getDescription();
            String productId=Integer.toString(productArray.get(i).getProductId());
            String offers=Double.toString(productArray.get(i).getOffers());
            String dateOfManufacture=productArray.get(i).getDateOfManufacture();
            
            String path=productArray.get(i).getImagePath();
            dos.writeUTF(name);
            dos.writeUTF(price);
            dos.writeUTF(quantity);
            dos.writeUTF(brand);
            dos.writeUTF(category);
            dos.writeUTF(description);
            dos.writeUTF(productId);
            dos.writeUTF(offers);
            dos.writeUTF(dateOfManufacture);
            
            String AbsolutePath="C:\\Users\\Mayank\\Desktop\\project\\"+path;
        //    dos.writeUTF(category);
          //  dos.writeUTF(description);
            System.out.println(AbsolutePath);
//            BufferedImage image = ImageIO.read(new File(AbsolutePath));
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ImageIO.write(image, "jpg", byteArrayOutputStream);
//            os.write(byteArrayOutputStream.toByteArray());
//            os.flush();
            
        }
  
    }

   

    
} 