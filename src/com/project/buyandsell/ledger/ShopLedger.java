package com.project.buyandsell.ledger;

import com.project.buyandsell.product.Product;
import java.util.ArrayList;
import java.util.Scanner;

public class ShopLedger {
	
	private String name;
    private ArrayList <Product> products = new ArrayList<Product>();
    private double balance = 0;
    
    public ShopLedger(String name) {
    	this.name = name;
    }  
    
    public void addProduct(Product p){
        this.products.add(p);
    }
    
  
    public void buyProduct(int id, int quantity){
    	
    	Product p = products.get(id - 1);
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Enter Buying Price: ");
    	
    	double price = scanner.nextDouble();
    	double buyPriceShouldBe =(p.getBuyingPrice() + price ) / 2;
    	     
        if(balance < quantity * price){
            System.out.println("You are running out of balance!");
        }else{
        	p.setBuyingPrice(buyPriceShouldBe);   	
            p.setQuantity(p.getQuantity() + quantity);
            this.balance -=(quantity * price);
            deleteProduct(id);
            this.products.add(id - 1, p);            
        }
    }
    
    
    public void sellProduct(int id){

    	Product product = products.get(id - 1);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Selling Price: ");
        
        product.setSellingPrice(scanner.nextDouble());
        System.out.print("Enter Selling Quantity: ");
        int quantityToSell = scanner.nextInt();
            
        if(product.getQuantity() < quantityToSell){
        	System.out.println("You are running out of Stock!!!");
        }else{
        	
        	product.setQuantity(product.getQuantity() - quantityToSell);
        	double prft = product.getSellingPrice() - product.getBuyingPrice();
            product.setProfit(prft * quantityToSell);   
            
            this.balance += (product.getSellingPrice() * quantityToSell);
            deleteProduct(id);
            this.products.add(id - 1, product);
        }	 
    }
    
    
    public void deleteProduct(int id){
        products.remove(id - 1);
    }
    
    
    public void showDetails(){    	
        System.out.println("\t Name \tAvailable_Quantity \tProfit");
        int id = 1;
        
        for(Product product: products){
            System.out.println(id + "\t" + product.getName()+ "\t\t " + product.getQuantity() + " \t\t" + product.getProfit());
            id++;
        }   
    }
    
    
    public double getBalance(){
        return balance;
    }
    
    public int getTotalProducts() {
    	return products.size();
    }
}
