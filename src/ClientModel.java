/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mayank
 */
public class ClientModel 
{
    private String username;
    private String  name;
    private String password;
    private String email;
    private String mobile;
    private String imagePath;
    private int totalItemPurchased;
    private int electronicsItemPurchased;
    private int furnitureItemPurchased;
    private int clothingItemPurchased;
    private int vehiclesItemPurchased;
    private int booksItemPurchased;
    private int otherItemPurchased;
    private int totalAmountSpend;

    public ClientModel(String name,String username, String password, String email, String mobile,String imagePath, int totalItemPurchased,int electronicsItemPurchased,int furnitureItemPurchased,int clothingItemPurchased,int vehiclesItemPurchased,int booksItemPurchased,int totalAmountSpend) {
        this.name = name;
        this.username=username;
        this.password=password;
        this.email=email;
        this.mobile=mobile;
        this.imagePath=imagePath;
        this.totalItemPurchased=totalItemPurchased;
        this.electronicsItemPurchased=electronicsItemPurchased;
        this.furnitureItemPurchased=furnitureItemPurchased;
        this.clothingItemPurchased=clothingItemPurchased;
        this.vehiclesItemPurchased=vehiclesItemPurchased;
        this.booksItemPurchased=booksItemPurchased;
        this.totalAmountSpend=totalAmountSpend;
    }

    public String getName() {
        return name;
    }
    
    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public String getImagePath() {
        return imagePath;
    }
    
    public int getTotalItemPurchased() {
        return totalItemPurchased;
    }
    
    public int getElectronicsItemPurchased() {
        return electronicsItemPurchased;
    }
    
    public int getClothingItemPurchased() {
        return clothingItemPurchased;
    }
    
    public int getFurnitureItemPurchased() {
        return furnitureItemPurchased;
    }
    
    public int getBooksItemPurchased() {
        return booksItemPurchased;
    }
    
    public int getVehiclesItemPurchased() {
        return vehiclesItemPurchased;
    }
    
    public int getTotalAmountSpend() {
        return totalAmountSpend;
    }
}
