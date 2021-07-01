package com.project.buyandsell.product;

public class Product {
	private String name;
    private double buyingPrice;
    private double sellingPrice;
    private int quantity;
    private double profit = 0;
    
    
    public Product(String name, double buyingPrice, double sellingPrice, int quantity){
        this.name = name;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;     
    }
    
    //getter
    public String getName(){
        return name;
    }
    public double getBuyingPrice(){
        return buyingPrice;
    } 
    public double getSellingPrice(){
         return sellingPrice;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getProfit(){
        return profit;
    }
    

    //setter
    
    public void setName(String name){
        this.name = name;
    }
    public void setBuyingPrice(double buyingPrice){
        this.buyingPrice = buyingPrice;
    }
    public void setSellingPrice(double sellingPrice){
        this.sellingPrice = sellingPrice;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setProfit(double amount){
        this.profit += amount;
    }  
}
