/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mayank
 */
public class productModel {
    
    private String name;
    private int price;
    private int quantity;
    private String brand;
    private String description;
    private String imagePath;
    private String category;
    private int productId;
    private double offers;
    private String dateOfManufacture;

    public productModel(String name,int price, int quantity, String brand, String category,String description, String imagePath,int productId,double offers,String dateOfManufacture) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.category=category;
        this.description = description;
        this.imagePath = imagePath;
        this.productId=productId;
        this.offers=offers;
        this.dateOfManufacture=dateOfManufacture;
    }

    public String getName() {
        return name;
    }
    public int getProductId() {
        return productId;
    }
    public String getDateOfManufacture() {
        return dateOfManufacture;
    }
    
    public double getOffers()
    {
        return offers;
    }

    public void setName(String name) {
        this.name=name;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category=category;
    }

    public void setQuantity(int qty) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setMimage(String mimage) {
        this.imagePath = imagePath;
    }
    
}